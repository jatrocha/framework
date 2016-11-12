package br.com.cygnus.framework.exception;

import br.com.cygnus.framework.IObjetoGenerico;

/**
 * Contrato que define comportamento das Exceptions do framework.
 */
public interface IException extends IObjetoGenerico {

   /**
    * @return codigo da mensagem de erro.
    */
   String getChave();
}
