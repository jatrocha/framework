package br.com.cygnus.framework.template.business.exception;

import br.com.cygnus.framework.exception.AbstractRuntimeException;

/**
 * Defincao dos erros causados durante a conversao de objetos.
 */
public class ConverterException extends AbstractRuntimeException {

   /** serialVersionUID. */
   private static final long serialVersionUID = 4390222946778113191L;

   /**
    * Construtor.
    * 
    * @param message mensagem de erro.
    * @param chave chave no arquivo de recursos.
    */
   public ConverterException(String message, String chave) {
      super(message, chave);
   }

   /**
    * Constructor.
    * 
    * @param cause causa do erro.
    */
   public ConverterException(Throwable cause) {
      super(cause);
   }

   /**
    * Constructor.
    * 
    * @param message mensagem de erro.
    * @param chave chave no arquivo de recursos.
    * @param cause causa do problema.
    */
   public ConverterException(String message, String chave, Throwable cause) {
      super(message, chave, cause);
   }

}
