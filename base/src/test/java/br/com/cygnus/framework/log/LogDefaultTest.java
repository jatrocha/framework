package br.com.cygnus.framework.log;

import org.junit.Test;

import br.com.cygnus.framework.AObjetoGenerico;
import br.com.cygnus.framework.IMensagens;
import br.com.cygnus.framework.exception.FrameworkException;
import br.com.cygnus.framework.template.log.ILog;

public class LogDefaultTest extends AObjetoGenerico {

   private ILog<LogDefaultTest> log = Log.get(LogDefaultTest.class);

   @Test
   public void testLogInfo() {
      this.log.info("info");
   }

   @Test
   public void testLogDebug() {
      this.log.debug("debug?!");
   }

   @Test
   public void testLogError() {
      this.log.error("error?!");
   }

   @Test
   public void testLogErrorComException() {
      this.log.error(new FrameworkException(IMensagens.CODIGO_MENSAGEM_ERRO_GERAL), "exception?!");
   }

}
