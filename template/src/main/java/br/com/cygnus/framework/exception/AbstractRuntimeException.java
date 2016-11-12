package br.com.cygnus.framework.exception;

/**
 * Classe <tt>AbstractRuntimeException</tt> eh a base de todas as excecoes lancadas pelo framework e aplicacoes perifericas.
 */
public abstract class AbstractRuntimeException extends RuntimeException implements IException {

   /** serialVersionUID. */
   private static final long serialVersionUID = -1163066207473674470L;

   /** Chave da mensagem no arquivo de recursos (mensagens). */
   private String chave = null;

   /**
    * Constructor.
    * 
    * @param message descricao da mensagem de erro.
    * @param chave codigo da mensagem com a excecao lancada.
    */
   public AbstractRuntimeException(String message, String chave) {
      super(message);
      this.chave = chave;
   }

   /**
    * Constructor.
    * 
    * @param cause excecao.
    */
   public AbstractRuntimeException(Throwable cause) {
      super(cause);

   }

   /**
    * Constructor.
    * 
    * @param message descricao da mensagem de erro.
    * @param chave codigo da mensagem com a excecao lancada.
    * @param cause excecao.
    */
   public AbstractRuntimeException(String message, String chave, Throwable cause) {
      super(message, cause);
      this.chave = chave;
   }

   /**
    * @return codigo da mensagem de erro.
    */
   @Override
   public String getChave() {
      return this.chave;
   }

}
