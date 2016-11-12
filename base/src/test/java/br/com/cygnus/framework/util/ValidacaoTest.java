package br.com.cygnus.framework.util;

import static junit.framework.Assert.fail;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import br.com.cygnus.framework.AObjetoGenerico;
import br.com.cygnus.framework.IMensagens;

public class ValidacaoTest extends AObjetoGenerico {

   private static final String TESTE = "teste";
   private Integer integer = null;
   private Object object = null;
   private Character character = null;
   private String string = null;
   private List<Object> list = null;
   private Object[] array = null;
   private Long numeroLongo = null;
   private Double duplaPrecisao = null;
   private Byte numeroByte = null;
   private BigDecimal bigDecimal = null;
   private Short numeroShort = null;

   private final Validacao validacao = Validacao.get();

   @Test
   public void testIsNull() {
      assertTrue(this.validacao.isNull(this.integer));
      assertTrue(this.validacao.isNull(this.object));
      assertTrue(this.validacao.isNull(this.string));
      assertTrue(this.validacao.isNull(this.character));
      assertTrue(this.validacao.isNull(this.list));
      assertTrue(this.validacao.isNull(this.object));
      assertTrue(this.validacao.isNull(this.array));

      this.configuraNotNull();

      assertFalse(this.validacao.isNull(this.integer));
      assertFalse(this.validacao.isNull(this.object));
      assertFalse(this.validacao.isNull(this.string));
      assertFalse(this.validacao.isNull(this.character));
      assertFalse(this.validacao.isNull(this.list));
      assertFalse(this.validacao.isNull(this.object));

   }

   @Test
   public void testIsNotNull() {
      assertFalse(Validacao.get().isNotNull(this.integer));
      assertFalse(Validacao.get().isNotNull(this.object));
      assertFalse(Validacao.get().isNotNull(this.character));
      assertFalse(Validacao.get().isNotNull(this.string));
      assertFalse(Validacao.get().isNotNull(this.list));
      assertFalse(Validacao.get().isNotNull(this.numeroLongo));
      assertFalse(Validacao.get().isNotNull(this.duplaPrecisao));
      assertFalse(Validacao.get().isNotNull(this.numeroByte));
      assertFalse(Validacao.get().isNotNull(this.bigDecimal));
      assertFalse(Validacao.get().isNotNull(this.numeroShort));

      this.configuraNotNull();

      assertTrue(Validacao.get().isNotNull(this.integer));
      assertTrue(Validacao.get().isNotNull(this.object));
      assertTrue(Validacao.get().isNotNull(this.character));
      assertTrue(Validacao.get().isNotNull(this.string));
      assertTrue(Validacao.get().isNotNull(this.list));
      assertTrue(Validacao.get().isNotNull(this.numeroLongo));
      assertTrue(Validacao.get().isNotNull(this.duplaPrecisao));
      assertTrue(Validacao.get().isNotNull(this.numeroByte));
      assertTrue(Validacao.get().isNotNull(this.bigDecimal));
      assertTrue(Validacao.get().isNotNull(this.numeroShort));
   }

   @Test
   public void testIsEmpty() {

      this.configuraNull();

      assertTrue(this.validacao.isEmpty(this.integer));
      assertTrue(this.validacao.isEmpty(this.string));
      assertTrue(this.validacao.isEmpty(this.character));
      assertTrue(this.validacao.isEmpty(this.list));
      assertTrue(this.validacao.isEmpty(this.numeroLongo));
      assertTrue(this.validacao.isEmpty(this.duplaPrecisao));
      assertTrue(this.validacao.isEmpty(this.numeroByte));
      assertTrue(this.validacao.isEmpty(this.bigDecimal));
      assertTrue(this.validacao.isEmpty(this.numeroShort));
      assertTrue(this.validacao.isEmpty(this.array));

      this.configuraNotNull();

      assertFalse(this.validacao.isEmpty(this.integer));
      assertFalse(this.validacao.isEmpty(this.string));
      assertFalse(this.validacao.isEmpty(this.character));
      assertFalse(this.validacao.isEmpty(this.list));
      assertFalse(this.validacao.isEmpty(this.numeroLongo));
      assertFalse(this.validacao.isEmpty(this.duplaPrecisao));
      assertFalse(this.validacao.isEmpty(this.numeroByte));
      assertFalse(this.validacao.isEmpty(this.bigDecimal));
      assertFalse(this.validacao.isEmpty(this.numeroShort));
      assertFalse(this.validacao.isEmpty(this.array));

   }

   @Test
   public void testIsNotEmpty() {

      this.configuraNull();

      assertFalse(this.validacao.isNotEmpty(this.integer));
      assertFalse(this.validacao.isNotEmpty(this.string));
      assertFalse(this.validacao.isNotEmpty(this.character));
      assertFalse(this.validacao.isNotEmpty(this.list));
      assertFalse(this.validacao.isNotEmpty(this.numeroLongo));
      assertFalse(this.validacao.isNotEmpty(this.duplaPrecisao));
      assertFalse(this.validacao.isNotEmpty(this.numeroByte));
      assertFalse(this.validacao.isNotEmpty(this.bigDecimal));
      assertFalse(this.validacao.isNotEmpty(this.numeroShort));

      this.configuraNotNull();

      assertTrue(this.validacao.isNotEmpty(this.integer));
      assertTrue(this.validacao.isNotEmpty(this.string));
      assertTrue(this.validacao.isNotEmpty(this.character));
      assertTrue(this.validacao.isNotEmpty(this.list));
      assertTrue(this.validacao.isNotEmpty(this.numeroLongo));
      assertTrue(this.validacao.isNotEmpty(this.duplaPrecisao));
      assertTrue(this.validacao.isNotEmpty(this.numeroByte));
      assertTrue(this.validacao.isNotEmpty(this.bigDecimal));
      assertTrue(this.validacao.isNotEmpty(this.numeroShort));

   }

   // @Test(expected=IllegalArgumentException.class) -> interessante isso aqui... =]
   @Test
   public void testValidarObrigatorioObjectInvalido() {
      Object obj = null;
      try {
         this.validacao.validarObrigatorio(obj, TESTE);
         fail("Exception não lançada! =/");
      } catch (IllegalArgumentException e) {
         assertEquals(Mensagem.get().getMensagem(IMensagens.FRA016, new String[] { TESTE }), e.getMessage());

      }
   }

   @Test
   public void testValidarObrigatorioObject() {
      try {
         this.validacao.validarObrigatorio(new Object(), TESTE);
      } catch (IllegalArgumentException e) {
         fail("Exception lançada! =/");

      }
   }

   @Test
   public void testValidarObrigatorioStringInvalida() {
      try {
         this.validacao.validarObrigatorio(NULL_STRING, TESTE);
         fail("Exception não lançada! =/");
      } catch (IllegalArgumentException e) {
         assertEquals(Mensagem.get().getMensagem(IMensagens.FRA016, new String[] { TESTE }), e.getMessage());
      }
   }

   @Test
   public void testValidarObrigatorioString() {
      try {
         this.validacao.validarObrigatorio("a", TESTE);
      } catch (IllegalArgumentException e) {
         fail("Exception lançada! =/");
      }
   }

   private void configuraNotNull() {
      this.object = new Object();
      this.array = new Object[] { this.object };
      this.array[0] = this.object;
      this.integer = Integer.valueOf(1);
      this.string = "a";
      this.character = Character.valueOf('a');
      this.list = new ArrayList<Object>(0);
      this.list.add(this.string);

      this.numeroLongo = Long.valueOf(1L);
      this.duplaPrecisao = Double.valueOf(1D);
      this.numeroByte = Byte.valueOf((byte) 1);
      this.bigDecimal = BigDecimal.ONE;
      this.numeroShort = Short.valueOf((short) 1);
   }

   private void configuraNull() {
      this.integer = null;
      this.object = null;
      this.character = null;
      this.string = null;
      this.list = null;
      this.numeroLongo = null;
      this.duplaPrecisao = null;
      this.numeroByte = null;
      this.bigDecimal = null;
      this.numeroShort = null;
      this.object = null;
      this.array = null;
   }

}
