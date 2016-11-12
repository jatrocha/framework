package br.com.cygnus.framework.business.util;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import br.com.cygnus.framework.AObjetoGenerico;
import br.com.cygnus.framework.log.Log;
import br.com.cygnus.framework.template.business.util.IOrdenacao;
import br.com.cygnus.framework.template.log.ILog;

/**
 * Implementacao da funcao de ordenacao.
 * 
 * @param <T> qualquer objeto do framework.
 */
public class Ordenacao<T extends AObjetoGenerico> extends AObjetoGenerico implements IOrdenacao<T> {

   /** serialVersionUID. */
   private static final long serialVersionUID = -9171568695185691341L;

   /** Classe de log. */
   @SuppressWarnings("rawtypes")
   private static final ILog<Ordenacao> LOG = Log.get(Ordenacao.class);

   /** Propriedades do bean. */
   private String[] properties;

   /**
    * Construtor.
    * 
    * @param property nome propriedade a ordenar.
    */
   public Ordenacao(String property) {
      super();
      this.setProperties(new String[] { property });
   }

   /**
    * Construtor.
    * 
    * @param properties array de propriedades a ordenar.
    */
   public Ordenacao(String[] properties) {
      super();
      this.setProperties(properties);
   }

   /**
    * @return Propriedades do bean.
    */
   protected final String[] getProperties() {
      return this.properties;
   }

   /**
    * @param properties Propriedades do bean.
    */
   protected final void setProperties(String[] properties) {
      String[] prop = properties;
      this.properties = prop;
   }

   /**
    * De acordo com o construtor chamado efetua a ordenacao.
    * 
    * @param base objeto base a se comparar.
    * @param comparacao objeto para comprar.
    * 
    * @return o indice para a ordenar.
    */
   @Override
   public int compare(T base, T comparacao) {
      return this.ordenarPorPropriedade(base, comparacao);
   }

   /**
    * Efetua a comparacao para ordenacao alfabetica, a lista de objetos.
    * 
    * @param base objeto base a se comparar.
    * @param comparacao objeto para comprar.
    * @return o indice para a ordenar.
    */
   protected int ordenarPorPropriedade(Object base, Object comparacao) {
      try {
         String propertiesBaseConcatenada = this.getPropertiesConcatenadas(base);
         String propertiesComparacaoConcatenada = this.getPropertiesConcatenadas(comparacao);
         return propertiesBaseConcatenada.compareTo(propertiesComparacaoConcatenada);
      } catch (IllegalAccessException e) {
         LOG.error(e, e.getMessage());
      } catch (InvocationTargetException e) {
         LOG.error(e, e.getMessage());
      } catch (NoSuchMethodException e) {
         LOG.error(e, e.getMessage());
      }
      return NUMERO_INTEIRO_ZERO;
   }

   /**
    * Concatenar propriedades.
    * 
    * @param bean Objeto que contem as propriedades.
    * @return Propriedades concatenadas.
    * @throws IllegalAccessException exception padrao.
    * @throws InvocationTargetException exception padrao.
    * @throws NoSuchMethodException exception padrao.
    */
   protected String getPropertiesConcatenadas(Object bean) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
      StringBuffer value = new StringBuffer(NULL_STRING);
      for (String propertyName : this.getProperties()) {
         String propertyValue = BeanUtils.getProperty(bean, propertyName);
         value.append(propertyValue);
      }
      return value.toString();
   }

}
