package br.com.cygnus.framework.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import br.com.cygnus.framework.IMensagens;

public class FrameworkExceptionTest {

   @Test
   public void testFrameworkExceptionComThrowableCompleta() {
      FrameworkException erroComThrowableCompleta = new FrameworkException(IMensagens.CODIGO_MENSAGEM_ERRO_GERAL, new FrameworkException(IMensagens.FRA002,
            new String[] { "Teste" }));
      assertEquals("ERRO GERAL", erroComThrowableCompleta.getMessage());
      assertEquals(IMensagens.CODIGO_MENSAGEM_ERRO_GERAL, erroComThrowableCompleta.getChave());
   }

   @Test
   public void testFrameworkExceptionSimples() {
      FrameworkException erroSimples = new FrameworkException(IMensagens.CODIGO_MENSAGEM_ERRO_GERAL);
      assertEquals("ERRO GERAL", erroSimples.getMessage());
      assertEquals(IMensagens.CODIGO_MENSAGEM_ERRO_GERAL, erroSimples.getChave());
   }

   @Test
   public void testFrameworkExceptionComComplemento() {
      FrameworkException erroComComplemento = new FrameworkException(IMensagens.FRA002, new String[] { "Teste" });
      assertEquals("Erro ao tentar localizar o Data Source \"Teste\"", erroComComplemento.getMessage());
      assertEquals(IMensagens.FRA002, erroComComplemento.getChave());
   }

   @Test
   public void testFrameowrkExceptionThrowable() {
      FrameworkException erroComThrowable = new FrameworkException(new FrameworkException(IMensagens.CODIGO_MENSAGEM_ERRO_GERAL));
      assertNotNull(erroComThrowable.getCause());
   }

   @Test
   public void testFrameworkExceptionChaveThrowable() {
      FrameworkException erro = new FrameworkException(IMensagens.CODIGO_MENSAGEM_ERRO_GERAL, new Exception("Erro Geral"));
      assertEquals("ERRO GERAL", erro.getMessage());
   }

}
