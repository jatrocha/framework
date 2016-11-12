package br.com.cygnus.framework.template.business.exception;

/**
 * Definc‹o dos erros causados durante a construcao de objetos.
 */
public class BuilderException extends AbstractBusinessException {

   /** serialVersionUID. */
   private static final long serialVersionUID = -5298754181581159912L;

   /**
    * Construtor.
    * 
    * @param message mensagem de erro.
    * @param chave chave no arquivo de recursos.
    */
   public BuilderException(String message, String chave) {
      super(message, chave);
   }

   /**
    * Constructor.
    * 
    * @param cause causa do erro.
    */
   public BuilderException(Throwable cause) {
      super(cause);
   }

   /**
    * Constructor.
    * 
    * @param message mensagem de erro.
    * @param chave chave no arquivo de recursos.
    * @param cause causa do problema.
    */
   public BuilderException(String message, String chave, Throwable cause) {
      super(message, chave, cause);
   }

}
