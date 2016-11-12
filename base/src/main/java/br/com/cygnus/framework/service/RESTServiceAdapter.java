package br.com.cygnus.framework.service;

import org.codehaus.jackson.jaxrs.JacksonJsonProvider;

import br.com.cygnus.framework.exception.EngineRuntimeException;
import br.com.cygnus.framework.util.PropertiesUtil;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.client.filter.LoggingFilter;
import com.sun.jersey.api.json.JSONConfiguration;

/**
 * Implementacao padrao do Adaptador de servicos REST.
 */
public abstract class RESTServiceAdapter {

   protected static final int HTTP_CODE_400 = 400;

   private Client client;

   private WebResource resource;

   /**
    * Construtor padrao.
    */
   public RESTServiceAdapter() {

      final ClientConfig clientConfig = new DefaultClientConfig();

      clientConfig.getClasses().add(JacksonJsonProvider.class);

      clientConfig.getProperties().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);

      this.client = Client.create(clientConfig);

      // this.client.setReadTimeout(Integer.valueOf(0));
      //
      // this.client.setConnectTimeout(Integer.valueOf(0));

      this.client.addFilter(new LoggingFilter());
   }

   /**
    * Combina o caminho absoluto da WebResource com o caminho padrao da aplicacao, que pode ser encontrado no arquivo de configuracoes.
    *
    * @param path {@link String} contendo o caminho do metodo desejado.
    * @return {@link WebResource} configurado.
    */
   public WebResource getWebResourceAbsolutePathRESTAPI(String path) {

      if (this.resource != null) {

         return this.resource.path(path);
      }

      return this.getWebResource(PropertiesUtil.getInstance().getString("engine.root.url") + path);
   }

   /**
    * @param url {@link String} url do servico.
    * @return {@link WebResource} configurado
    */
   public WebResource getWebResource(String url) {

      if (this.resource != null) {

         return this.resource.path(url);
      }

      return this.client.resource(url);
   }

   /**
    * @param response {@link ClientResponse} resposta do servico.
    * @param type {@link GenericType} tipo da entidade esperado.
    * @return <T> instanciado com os valores recuperados do servico.
    */
   protected <T> T getResponseData(ClientResponse response, GenericType<T> type) {

      if (this.isValidHttpResponse(response)) {

         if (type == null) {

            return null;
         }

         return response.getEntity(type);
      }

      throw this.createRuntimeException(response);
   }

   /**
    * @param response {@link ClientResponse}.
    */
   protected void getResponseData(ClientResponse response) {

      if (this.isValidHttpResponse(response)) {

         return;
      }

      throw this.createRuntimeException(response);
   }

   private Boolean isValidHttpResponse(ClientResponse response) {

      return response.getStatus() < HTTP_CODE_400;
   }

   /**
    * @param response {@link ClientResponse} resposta do servico.
    * @return {@link EngineRuntimeException} instanciado.
    */
   protected abstract <T extends EngineRuntimeException> T createRuntimeException(ClientResponse response);

   /**
    * @param resource {@link WebResource}.
    */
   public void setWebResource(WebResource resource) {

      this.resource = resource;
   }

   public void setClient(Client client) {

      this.client = client;

   }
}
