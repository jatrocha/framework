package br.com.cygnus.framework.dao.exception;

import br.com.cygnus.framework.exception.FrameworkException;

/**
 * Classe <tt>DAOException</tt> controla as excecoes genericas do da camada de persistencia.
 */
public class DAOException extends FrameworkException {

   /** serialVersionUID. */
   private static final long serialVersionUID = -1862492478867216288L;

   /**
    * Constructor.
    * 
    * @param chave codigo da mensagem com a excecao lancada.
    * @param cause excecao.
    */
   public DAOException(String chave, Throwable cause) {
      super(chave, cause);
   }

}
