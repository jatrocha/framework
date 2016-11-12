package br.com.cygnus.framework.util.criptografia;

import junit.framework.Assert;

import org.junit.Test;

import br.com.cygnus.framework.AObjetoGenerico;
import br.com.cygnus.framework.IMensagens;
import br.com.cygnus.framework.exception.FrameworkException;
import br.com.cygnus.framework.util.Mensagem;

import static junit.framework.Assert.fail;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class MD5Test extends AObjetoGenerico {

   private static final String EXCEPTION_ESPERADA = "Exception esperada... =/";
   private static final String EXCEPTION_NAO_ESPERADA = "Exception nao esperada... =/";

   @Test
   public void testCritpografarNullInvalido() {
      try {
         assertNull(MD5.get().criptografar(null));
         fail(EXCEPTION_ESPERADA);
      } catch (final FrameworkException e) {

      } catch (final IllegalArgumentException e) {
         assertEquals(Mensagem.get().getMensagem(IMensagens.FRA016, new String[] { "origem" }), e.getMessage());
      }
   }

   @Test
   public void testCritpografarVazioInvalido() {
      try {
         assertNull(MD5.get().criptografar(NULL_STRING));
         Assert.fail(EXCEPTION_ESPERADA);
      } catch (final FrameworkException e) {

      } catch (final IllegalArgumentException e) {
         assertEquals(Mensagem.get().getMensagem(IMensagens.FRA016, new String[] { "origem" }), e.getMessage());
      }
   }

   @Test
   public void testCritpografar() {
      try {
         assertNotNull(MD5.get().criptografar("asdf123"));
         assertEquals("6572bdaff799084b973320f43f09b363", MD5.get().criptografar("asdf123"));
      } catch (final FrameworkException e) {
         fail(EXCEPTION_NAO_ESPERADA);
      } catch (final IllegalArgumentException e) {
         fail(EXCEPTION_NAO_ESPERADA);
      }
   }

   @Test
   public void testCritpografarInvalido() {
      try {
         MD5.get().setAlgoritmo(NULL_STRING);
         assertNotNull(MD5.get().criptografar("asdf123"));
         Assert.fail(EXCEPTION_ESPERADA);
      } catch (final FrameworkException e) {
         assertEquals(Mensagem.get().getMensagem(IMensagens.FRA023), e.getMessage());
      } catch (final IllegalArgumentException e) {
         fail(EXCEPTION_NAO_ESPERADA);
      } finally {
         MD5.get().setAlgoritmo("MD5");
      }

   }

}
