package br.com.cygnus.framework.exception;

/**
 * Classe <tt>AbstractException</tt> eh a base de todas as excecoes lancadas pelo framework e aplicacoes perifericas.
 */
public abstract class AbstractException extends Exception implements IException {

   /** serialVersionUID. */
   private static final long serialVersionUID = 1032919360509897386L;

   /** Chave da mensagem no arquivo de recursos (mensagens). */
   private String chave = null;

   /**
    * Constructor.
    * 
    * @param message descricao da mensagem de erro.
    * @param chave codigo da mensagem com a excecao lancada.
    */
   public AbstractException(String message, String chave) {
      super(message);
      this.chave = chave;
   }

   /**
    * Constructor.
    * 
    * @param cause excecao.
    */
   public AbstractException(Throwable cause) {
      super(cause);

   }

   /**
    * Constructor.
    * 
    * @param message descricao da mensagem de erro.
    * @param chave codigo da mensagem com a excecao lancada.
    * @param cause excecao lancada.
    */
   public AbstractException(String message, String chave, Throwable cause) {
      super(message, cause);
      this.chave = chave;
   }

   /**
    * Constructor.
    * 
    * @param message Descricao da mensagem de erro.
    * @param cause excecao lancada.
    */
   public AbstractException(String message, Throwable cause) {
      super(message, cause);
   }

   /**
    * @return codigo da mensagem de erro.
    */
   @Override
   public String getChave() {
      return this.chave;
   }

}
