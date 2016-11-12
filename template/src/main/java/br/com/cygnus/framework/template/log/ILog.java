package br.com.cygnus.framework.template.log;

import br.com.cygnus.framework.IObjetoGenerico;

/**
 * Classe <tt>ILog</tt> define as operacoes registro de operacoes (LOG).
 * 
 * @param <T> tipo gererico que derive de {@link Object}
 */
public interface ILog<T extends Object> extends IObjetoGenerico {

   /**
    * Log de informacoes.
    * 
    * @param msg A mensagem a ser logada.
    */
   void info(String msg);

   /**
    * Log de debug.
    * 
    * @param msg A mensagem a ser logada.
    */
   void debug(String msg);

   /**
    * Log de erro.
    * 
    * @param msg A mensagem a ser logada.
    */
   void error(String msg);

   /**
    * Log de erro.
    * 
    * @param throwable A excecaoo a ser logada.
    * @param msg A mensagem a ser logada.
    */
   void error(Throwable throwable, String msg);

}
