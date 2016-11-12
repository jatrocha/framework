package br.com.cygnus.framework.log;

import org.apache.log4j.Logger;

import br.com.cygnus.framework.AObjetoGenerico;
import br.com.cygnus.framework.template.log.ILog;

/**
 * Controlador generico do Log4J presente em todo o framework e em outras aplicacoes.
 * 
 * @param <T> tipo gererico que derive de {@link Object}
 */
public class Log<T extends Object> extends AObjetoGenerico implements ILog<T> {

   /** Tipo das classe a ser logada. */
   private final Class<T> type;

   /**
    * Construtor default para o singleton.
    * 
    * @param type tipo da classe a ser logada.
    */
   protected Log(Class<T> type) {
      super();
      this.type = type;
   }

   /**
    * Singleton.
    * 
    * @param <A> Classe a ser logada.
    * @param <L> Classe de Log.
    * @param type Tipo da classe a ser logada.
    * @return Instancia da classe.
    */
   @SuppressWarnings("unchecked")
   public static <A extends Object, L extends Log<A>> L get(Class<A> type) {
      return (L) new Log<A>(type);
   }

   /**
    * Log de debug.
    * 
    * @param msg a mensagem a ser logada.
    */
   @Override
   public void debug(String msg) {
      Logger.getLogger(this.getType()).debug(msg);

   }

   /**
    * Log de error.
    * 
    * @param msg a mensagem a ser logada.
    */
   @Override
   public void error(String msg) {
      Logger.getLogger(this.getType()).error(msg);
   }

   /**
    * Log de erro.
    * 
    * @param throwable A excecaoo a ser logada.
    * @param msg a mensagem a ser logada.
    */
   @Override
   public void error(Throwable throwable, String msg) {
      Logger.getLogger(this.getType()).error(msg, throwable);
   }

   /**
    * Log de informacoes.
    * 
    * @param msg a mensagem a ser logada.
    */
   @Override
   public void info(String msg) {
      Logger.getLogger(this.getType()).info(msg);
   }

   /**
    * @return the type.
    */
   protected Class<T> getType() {
      return this.type;
   }

}
