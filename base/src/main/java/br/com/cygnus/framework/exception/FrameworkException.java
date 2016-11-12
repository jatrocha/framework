package br.com.cygnus.framework.exception;

import br.com.cygnus.framework.util.Mensagem;

/**
 * Classe <tt>FrameworkException</tt> controla as excecoes genericas do framework.
 * 
 * @see br.com.cygnus.framework.exception.AbstractException
 */
public class FrameworkException extends AbstractException {

   /** serialVersionUID. */
   private static final long serialVersionUID = 3750489762398063754L;

   /**
    * Construtor.
    * 
    * @param chave identificador da mensagem no arquivo de recursos.
    */
   public FrameworkException(String chave) {
      super(Mensagem.get().getMensagem(chave), chave);

   }

   /**
    * Construtor.
    * 
    * @param chave codigo da mensagem com a excecao lancada.
    * @param values os valores a serem substituidos na mensagem.
    */
   public FrameworkException(String chave, Object[] values) {
      super(Mensagem.get().getMensagem(chave, values), chave);
   }

   /**
    * Constructor.
    * 
    * @param cause excecao.
    */
   public FrameworkException(Throwable cause) {
      super(cause);
   }

   /**
    * Constructor.
    * 
    * @param chave codigo da mensagem com a excecao lancada.
    * @param cause excecao.
    */
   public FrameworkException(String chave, Throwable cause) {
      super(Mensagem.get().getMensagem(chave), chave, cause);
   }

}
