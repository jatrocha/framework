package br.com.cygnus.framework.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import br.com.cygnus.framework.IConstantes;
import br.com.cygnus.framework.IMensagens;

public class MensagemTest {

   private static final String TESTE = "Teste";
   private static final String CHAVE_INVALIDA_DE_VERDADE = "chave invalida de verdade...";
   private static final String MENSAGEM_NAO_FOI_ENCONTRADA = "Mensagem nao foi encontrada no arquivo de propriedades";
   private final String path = IConstantes.ARQUIVO_MENSAGEM_ERRO_PATH;

   @Test
   public void testGetInstanceInvalido() {
      assertNull(Mensagem.get(""));
   }

   @Test
   public void testGetInstanceValido() {
      assertNotNull(Mensagem.get());
      assertNotNull(Mensagem.get(this.path));
   }

   @Test
   public void testGetResourceBundle() {
      Mensagem msg = new Mensagem();
      msg.loadResourceBundle(this.path);
      assertNotNull(msg.getResourceBundle());
   }

   @Test
   public void testGetResourceBundleInvalido() {
      Mensagem msg = new Mensagem();
      msg.loadResourceBundle("");
      assertNull(msg.getResourceBundle());
   }

   @Test
   public void testGetMensagemPelaChave() {
      assertEquals("Erro ao tentar localizar o contexto JNDI", Mensagem.get(this.path).getMensagem(IMensagens.FRA001));
      assertEquals("Erro ao tentar localizar o contexto JNDI", Mensagem.get().getMensagem(IMensagens.FRA001));
   }

   @Test
   public void testGetMensagemPelaChaveInvalido() {
      assertEquals(MENSAGEM_NAO_FOI_ENCONTRADA, Mensagem.get(this.path).getMensagem(CHAVE_INVALIDA_DE_VERDADE));
      assertEquals(MENSAGEM_NAO_FOI_ENCONTRADA, Mensagem.get().getMensagem(CHAVE_INVALIDA_DE_VERDADE));
   }

   @Test
   public void testGetMensagemPelaChaveComComplemento() {
      assertEquals("Erro ao tentar localizar o Data Source \"Teste\"", Mensagem.get(this.path).getMensagem(IMensagens.FRA002, new String[] { TESTE }));
      assertEquals("Erro ao tentar localizar o Data Source \"Teste\"", Mensagem.get().getMensagem(IMensagens.FRA002, new String[] { TESTE }));
      assertEquals("Erros \"Teste\", \"Teste\" e \"Teste\".", Mensagem.get().getMensagem(IMensagens.FRA004, new String[] { TESTE, TESTE, TESTE }));

   }

   @Test
   public void testGetMensagemPelaChaveComComplementoInvalido() {
      assertEquals(MENSAGEM_NAO_FOI_ENCONTRADA, Mensagem.get(this.path).getMensagem(CHAVE_INVALIDA_DE_VERDADE, new String[] { TESTE }));
      assertEquals(MENSAGEM_NAO_FOI_ENCONTRADA, Mensagem.get().getMensagem(CHAVE_INVALIDA_DE_VERDADE, new String[] { TESTE }));
      assertEquals(MENSAGEM_NAO_FOI_ENCONTRADA, Mensagem.get().getMensagem(CHAVE_INVALIDA_DE_VERDADE, new String[] { TESTE, TESTE, TESTE }));
   }
}
