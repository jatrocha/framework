package br.com.cygnus.framework.util;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

import br.com.cygnus.framework.AObjetoGenerico;
import br.com.cygnus.framework.IConstantes;
import br.com.cygnus.framework.log.Log;
import br.com.cygnus.framework.template.log.ILog;

/**
 * Classe <tt>Mensagem</tt> recupera as mensagens de um arquivo de propriedades.
 */
public class Mensagem extends AObjetoGenerico {

   /** Erro ao recuperar mensagem do arquivo de recurso. */
   private static final String ERRO_ARQUIVO_NAO_ENCONTRADO = "O arquivo nao foi encontrado.";

   /** Erro de chave invalida ou nao encontrada. */
   private static final String ERRO_MENSAGEM_NAO_ENCONTRADA = "Mensagem nao foi encontrada no arquivo de propriedades";

   /** Arquivo de recursos (mensagens). */
   private ResourceBundle resourceBundle = null;

   private static Mensagem singleton = null;

   /** Instancia da classe de log. */
   private final ILog<Mensagem> log = Log.get(Mensagem.class);

   /**
    * Constructor.
    */
   protected Mensagem() {
      super();
   }

   /**
    * Recupera instancia unica da classe.
    * 
    * @param path caminho para o arquivo de propriedades
    * @return instancia unica da classe.
    */
   public static Mensagem get(String path) {
      if (Validacao.get().isNotEmpty(path)) {
         synchronized (Mensagem.class) {
            singleton = new Mensagem();
            singleton.loadResourceBundle(path);
         }
         return singleton;
      }
      return null;
   }

   /**
    * Recupera instancia unica da classe.
    * 
    * @return Instancia unica da classe.
    */
   public static Mensagem get() {
      synchronized (Mensagem.class) {
         if (singleton == null) {
            singleton = new Mensagem();
            singleton.loadResourceBundle(IConstantes.ARQUIVO_MENSAGEM_ERRO_PATH);
         }
      }
      return singleton;
   }

   /**
    * Carrega o arquivo de mensagens (resource bundle) em memoria.
    * 
    * @param path caminho para o arquivo de mensagens.
    */
   protected void loadResourceBundle(String path) {
      try {
         this.setResourceBundle(ResourceBundle.getBundle(path));
      } catch (MissingResourceException e) {
         this.log.error(ERRO_ARQUIVO_NAO_ENCONTRADO);
      }
   }

   /**
    * Retorna a mensagem de acordo com a chave passada.
    * 
    * @param chave a chave da mensagem.
    * @return String contendo a descricao da mensagem.
    */
   public String getMensagem(String chave) {
      try {
         return this.getResourceBundle().getString(chave);
      } catch (MissingResourceException e) {
         this.log.error(e.getMessage());
      }
      return ERRO_MENSAGEM_NAO_ENCONTRADA;
   }

   /**
    * Insere os valores nos respectivos parametros da mensagem identificada pelo parametro chave, no arquivo mensagens.properties.
    * 
    * @param chave a chave da mensagem.
    * @param valores Os valores a serem substituidos na mensagem.
    * @return String contendo a descricao da mensagem.
    */
   public String getMensagem(String chave, Object[] valores) {
      String retorno = null;
      try {
         Validacao.get().validarObrigatorio(valores, "valores");
         retorno = this.getResourceBundle().getString(chave);
         for (int i = 0; i < valores.length; i++) {
            retorno = retorno.replaceFirst("\\{" + i + "\\}", valores[i].toString());
         }
         return retorno;
      } catch (MissingResourceException e) {
         this.log.error(e.getMessage());
         retorno = ERRO_MENSAGEM_NAO_ENCONTRADA;
      }
      return retorno;
   }

   /**
    * @return arquivo de recursos (mensagens).
    */
   protected ResourceBundle getResourceBundle() {
      return this.resourceBundle;
   }

   /**
    * @param resourceBundle arquivo de recursos (mensagens).
    */
   protected void setResourceBundle(ResourceBundle resourceBundle) {
      this.resourceBundle = resourceBundle;
   }

}
