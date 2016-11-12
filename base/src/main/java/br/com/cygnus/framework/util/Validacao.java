package br.com.cygnus.framework.util;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;

import br.com.cygnus.framework.AObjetoGenerico;
import br.com.cygnus.framework.IMensagens;

/**
 * Classe <tt>Validacao</tt> apresenta funcoes genericas, de uso diario, para solucao dos mais variados problemas de validacao de valores.
 */
public class Validacao extends AObjetoGenerico {

   /** Singleton. */
   private static Validacao singleton = new Validacao();

   /**
    * Construtor padrao.
    */
   protected Validacao() {
      super();
   }

   /**
    * Recupera instancia unica da classe.
    * 
    * @return Instancia unica da classe.
    */
   public static Validacao get() {
      return singleton;
   }

   /**
    * Determina se a instancia do objeto esta nula.
    * 
    * @param instance instancia do objeto a ser verificada.
    * @return True para null, false caso contrario.
    */
   public Boolean isNull(Object instance) {
      if (instance == null) {
         return Boolean.TRUE;
      }
      return Boolean.FALSE;
   }

   /**
    * Determina se a instancia do object nao esta nula.
    * 
    * @param instance instancia do objeto a ser verificada.
    * @return <code>false</code> para null, <code>true</code> caso contrario.
    */
   public Boolean isNotNull(Object instance) {
      return !this.isNull(instance);
   }

   /**
    * Determina se a instancia do objeto esta vazia. Perceba que o objeto pode estar instanciado, todavia, nao ter valor preenchido, como no caso da String que,
    * quando instanciada sem valor, retorna "" (vazia).
    * 
    * @param instance instancia do objeto a ser verificada.
    * @return True para null, false caso contrario.
    */
   public Boolean isEmpty(Collection<?> instance) {
      if (this.isNotNull(instance)) {
         return this.isNullCollection(instance);
      }
      return Boolean.TRUE;
   }

   /**
    * Determina se a instancia do objeto esta preenchida. Perceba que o objeto pode estar instanciado, todavia, nao ter valor preenchido, como no caso da String
    * que, quando instanciada sem valor, retorna "" (vazia).
    * 
    * @param instance instancia do objeto a ser verificada.
    * @return True para preenchida, false caso null.
    */
   public Boolean isNotEmpty(Collection<?> instance) {
      return !this.isEmpty(instance);
   }

   /**
    * Determina se a instancia do objeto esta vazia. Perceba que o objeto pode estar instanciado, todavia, nao ter valor preenchido, como no caso da String que,
    * quando instanciada sem valor, retorna "" (vazia).
    * 
    * @param instance instancia do objeto a ser verificada.
    * @return True para null, false caso contrario.
    */
   public Boolean isEmpty(Object[] instance) {
      if (this.isNotNull(instance)) {
         return this.isNullCollection(instance);
      }
      return Boolean.TRUE;
   }

   /**
    * Determina se a instancia do objeto esta vazia. Perceba que o objeto pode estar instanciado, todavia, nao ter valor preenchido, como no caso da String que,
    * quando instanciada sem valor, retorna "" (vazia).
    * 
    * @param instance instancia do objeto a ser verificada.
    * @return True para null, false caso contrario.
    */
   public Boolean isEmpty(String instance) {
      if (this.isNotNull(instance)) {
         return instance.isEmpty();
      }
      return Boolean.TRUE;
   }

   /**
    * Determina se a instancia do objeto esta preenchida. Perceba que o objeto pode estar instanciado, todavia, nao ter valor preenchido, como no caso da String
    * que, quando instanciada sem valor, retorna "" (vazia).
    * 
    * @param instance instancia do objeto a ser verificada.
    * @return True para preenchida, false caso null.
    */
   public Boolean isNotEmpty(String instance) {
      return !this.isEmpty(instance);
   }

   /**
    * Determina se a instancia do objeto esta vazia. Perceba que o objeto pode estar instanciado, todavia, nao ter valor preenchido, como no caso da String que,
    * quando instanciada sem valor, retorna "" (vazia).
    * 
    * @param instance instancia do objeto a ser verificada.
    * @return True para null, false caso contrario.
    */
   public Boolean isEmpty(Character instance) {
      if (this.isNotNull(instance)) {
         return instance.equals(NULL_CHAR);
      }
      return Boolean.TRUE;
   }

   /**
    * Determina se a instancia do objeto esta preenchida. Perceba que o objeto pode estar instanciado, todavia, nao ter valor preenchido, como no caso da String
    * que, quando instanciada sem valor, retorna "" (vazia).
    * 
    * @param instance instancia do objeto a ser verificada.
    * @return True para preenchida, false caso null.
    */
   public Boolean isNotEmpty(Character instance) {
      return !this.isEmpty(instance);
   }

   /**
    * Determina se a instancia do objeto esta vazia. Perceba que o objeto pode estar instanciado, todavia, nao ter valor preenchido, como no caso da String que,
    * quando instanciada sem valor, retorna "" (vazia).
    * 
    * @param instance instancia do objeto a ser verificada.
    * @return True para null, false caso contrario.
    */
   public Boolean isEmpty(Integer instance) {
      return this.isNullNumeric(instance);
   }

   /**
    * Determina se a instancia do objeto esta preenchida. Perceba que o objeto pode estar instanciado, todavia, nao ter valor preenchido, como no caso da String
    * que, quando instanciada sem valor, retorna "" (vazia).
    * 
    * @param instance instancia do objeto a ser verificada.
    * @return True para preenchida, false caso null.
    */
   public Boolean isNotEmpty(Integer instance) {
      return !this.isEmpty(instance);
   }

   /**
    * Determina se a instancia do objeto esta vazia. Perceba que o objeto pode estar instanciado, todavia, nao ter valor preenchido, como no caso da String que,
    * quando instanciada sem valor, retorna "" (vazia).
    * 
    * @param instance instancia do objeto a ser verificada.
    * @return True para null, false caso contrario.
    */
   public Boolean isEmpty(Long instance) {
      return this.isNullNumeric(instance);
   }

   /**
    * Determina se a instancia do objeto esta preenchida. Perceba que o objeto pode estar instanciado, todavia, nao ter valor preenchido, como no caso da String
    * que, quando instanciada sem valor, retorna "" (vazia).
    * 
    * @param instance instancia do objeto a ser verificada.
    * @return True para preenchida, false caso null.
    */
   public Boolean isNotEmpty(Long instance) {
      return !this.isEmpty(instance);
   }

   /**
    * Determina se a instancia do objeto esta vazia. Perceba que o objeto pode estar instanciado, todavia, nao ter valor preenchido, como no caso da String que,
    * quando instanciada sem valor, retorna "" (vazia).
    * 
    * @param instance instancia do objeto a ser verificada.
    * @return True para null, false caso contrario.
    */
   public Boolean isEmpty(Double instance) {
      return this.isNullNumeric(instance);
   }

   /**
    * Determina se a instancia do objeto esta preenchida. Perceba que o objeto pode estar instanciado, todavia, nao ter valor preenchido, como no caso da String
    * que, quando instanciada sem valor, retorna "" (vazia).
    * 
    * @param instance instancia do objeto a ser verificada.
    * @return True para preenchida, false caso null.
    */
   public Boolean isNotEmpty(Double instance) {
      return !this.isEmpty(instance);
   }

   /**
    * Determina se a instancia do objeto esta vazia. Perceba que o objeto pode estar instanciado, todavia, nao ter valor preenchido, como no caso da String que,
    * quando instanciada sem valor, retorna "" (vazia).
    * 
    * @param instance instancia do objeto a ser verificada.
    * @return True para null, false caso contrario.
    */
   public Boolean isEmpty(Byte instance) {
      return this.isNullNumeric(instance);
   }

   /**
    * Determina se a instancia do objeto esta preenchida. Perceba que o objeto pode estar instanciado, todavia, nao ter valor preenchido, como no caso da String
    * que, quando instanciada sem valor, retorna "" (vazia).
    * 
    * @param instance instancia do objeto a ser verificada.
    * @return True para preenchida, false caso null.
    */
   public Boolean isNotEmpty(Byte instance) {
      return !this.isEmpty(instance);
   }

   /**
    * Determina se a instancia do objeto esta vazia. Perceba que o objeto pode estar instanciado, todavia, nao ter valor preenchido, como no caso da String que,
    * quando instanciada sem valor, retorna "" (vazia).
    * 
    * @param instance instancia do objeto a ser verificada.
    * @return True para null, false caso contrario.
    */
   public Boolean isEmpty(BigDecimal instance) {
      return this.isNullNumeric(instance);
   }

   /**
    * Determina se a instancia do objeto esta preenchida. Perceba que o objeto pode estar instanciado, todavia, nao ter valor preenchido, como no caso da String
    * que, quando instanciada sem valor, retorna "" (vazia).
    * 
    * @param instance instancia do objeto a ser verificada.
    * @return True para preenchida, false caso null.
    */
   public Boolean isNotEmpty(BigDecimal instance) {
      return !this.isEmpty(instance);
   }

   /**
    * Determina se a instancia do objeto esta vazia. Perceba que o objeto pode estar instanciado, todavia, nao ter valor preenchido, como no caso da String que,
    * quando instanciada sem valor, retorna "" (vazia).
    * 
    * @param instance instancia do objeto a ser verificada.
    * @return True para null, false caso contrario.
    */
   public Boolean isEmpty(Short instance) {
      return this.isNullNumeric(instance);
   }

   /**
    * Determina se a instancia do objeto esta preenchida. Perceba que o objeto pode estar instanciado, todavia, nao ter valor preenchido, como no caso da String
    * que, quando instanciada sem valor, retorna "" (vazia).
    * 
    * @param instance instancia do objeto a ser verificada.
    * @return True para preenchida, false caso null.
    */
   public Boolean isNotEmpty(Short instance) {
      return !this.isEmpty(instance);
   }

   /**
    * Valida a obrigatoriedade de um objeto.
    * 
    * @param object Objeto a ser validado
    * @param nome Nome do campo que ira aparecer na mensagens de erro.
    */
   public void validarObrigatorio(Object object, String nome) {
      if (this.isNull(object)) {
         throw new IllegalArgumentException(Mensagem.get().getMensagem(IMensagens.FRA016, new String[] { nome }));
      }
   }

   /**
    * Valida a obrigatoriedade de um objeto.
    * 
    * @param object Objeto a ser validado
    * @param nome Nome do campo que ira aparecer na mensagens de erro.
    */
   public void validarObrigatorio(String object, String nome) {
      if (this.isEmpty(object)) {
         throw new IllegalArgumentException(Mensagem.get().getMensagem(IMensagens.FRA016, new String[] { nome }));
      }
   }

   /**
    * Determina se a instancia do objeto esta vazia.
    * 
    * @param instance instancia do objeto a ser verificada.
    * @return True para null, false caso contrario.
    */
   protected Boolean isNullNumeric(Object instance) {
      if (this.isNotNull(instance)) {
         if (instance instanceof Integer) {
            return ((Integer) instance).equals(WRAPPER_INTEGER_ZERO);
         }

         if (instance instanceof Long) {
            return ((Long) instance).equals(WRAPPER_LONG_ZERO);
         }

         if (instance instanceof Double) {
            return ((Double) instance).equals(WRAPPER_DOUBLE_ZERO);
         }

         if (instance instanceof Byte) {
            return ((Byte) instance).equals(WRAPPER_BYTE_ZERO);
         }

         if (instance instanceof BigDecimal) {
            return ((BigDecimal) instance).equals(BigDecimal.ZERO);
         }

         // TODO Se nao eh nenhuma das anteriores, pelo visto eh object...
         return this.isNull(instance);
      }
      return Boolean.TRUE;
   }

   /**
    * Determina se a instancia do objeto colecao esta vazia.
    * 
    * @param instance instancia do objeto a ser verificada.
    * @return True para null, false caso contrario.
    */
   protected Boolean isNullCollection(Object instance) {
      if (instance instanceof Collection) {
         return ((Collection<?>) instance).isEmpty();
      }
      // Se nao e collection, fatalmente e array.
      return Arrays.asList(instance).isEmpty();
   }

}
