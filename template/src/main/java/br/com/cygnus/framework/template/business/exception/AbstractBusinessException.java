package br.com.cygnus.framework.template.business.exception;

import br.com.cygnus.framework.exception.AbstractException;

/**
 * Definc‹o dos erros de negocio das aplicacoes.
 */
public abstract class AbstractBusinessException extends AbstractException {

   /** serialVersionUID. */
   private static final long serialVersionUID = 5260822373489023503L;

   /**
    * Constructor.
    * 
    * @param message descricao da mensagem de erro.
    * @param chave codigo da mensagem com a excecao lancada.
    */
   public AbstractBusinessException(String message, String chave) {
      super(message, chave);
   }

   /**
    * Constructor.
    * 
    * @param cause excecao.
    */
   public AbstractBusinessException(Throwable cause) {
      super(cause);

   }

   /**
    * Constructor.
    * 
    * @param message Descricao da mensagem de erro.
    * @param chave Codigo da mensagem com a excecao lancada.
    * @param cause Excecao.
    */
   public AbstractBusinessException(String message, String chave, Throwable cause) {
      super(message, chave, cause);
   }

   /**
    * Constructor.
    * 
    * @param message Codigo da mensagem com a excecao lancada.
    * @param cause excecao lancada.
    */
   public AbstractBusinessException(String message, Throwable cause) {
      super(message, cause);
   }

}
