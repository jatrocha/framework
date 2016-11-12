package br.com.cygnus.framework.util;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;

import java.math.BigDecimal;

import org.junit.Test;

public class BigDecimalFactoryTest {

   private static final String UM_ZERO_ZERO = "1.00";
   private final BigDecimalFactory factory = BigDecimalFactory.get();

   @Test
   public void testBigDecimalTruncandoStringSeparadorVirgula() {
      BigDecimal bigDecimal = this.factory.duasCasasDecimaisTruncado("1,002");
      assertEquals(new BigDecimal(UM_ZERO_ZERO), bigDecimal);
   }

   @Test
   public void testBigDecimalTruncandoNoveCasasDecimaisBigDecimal() {
      BigDecimal bigDecimal = this.factory.noveCasasDecimaisTruncado(new BigDecimal("1.00062758865943"));
      assertEquals(new BigDecimal("1.000627588"), bigDecimal);
   }

   @Test
   public void testBigDecimalTruncandoNoveCasasDecimais() {
      BigDecimal bigDecimal = this.factory.noveCasasDecimaisTruncado("1.00062758865943");
      assertEquals(new BigDecimal("1.000627588"), bigDecimal);
   }

   @Test
   public void testBigDecimalTruncandoStringSeparadorPontoVirgula() {
      BigDecimal bigDecimal = this.factory.duasCasasDecimaisTruncado("1231,002");
      assertEquals(new BigDecimal("1231.00"), bigDecimal);
   }

   @Test
   public void testBigDecimalTruncando9() {
      BigDecimal bigDecimal = this.factory.duasCasasDecimaisTruncado("1.009");
      assertEquals(new BigDecimal(UM_ZERO_ZERO), bigDecimal);
   }

   @Test
   public void testBigDecimalTruncando5() {
      BigDecimal bigDecimal = this.factory.duasCasasDecimaisTruncado("1.005");
      assertEquals(new BigDecimal(UM_ZERO_ZERO), bigDecimal);
   }

   @Test
   public void testBigDecimalTruncando2() {
      BigDecimal bigDecimal = this.factory.duasCasasDecimaisTruncado("1.002");
      assertEquals(new BigDecimal(UM_ZERO_ZERO), bigDecimal);
   }

   @Test
   public void testBigDecimalTruncandoReal() {
      BigDecimal bigDecimal = this.factory.duasCasasDecimaisTruncado("1002.359");
      assertEquals(new BigDecimal("1002.35"), bigDecimal);
   }

   @Test
   public void testBigDecimalArredondando9() {
      BigDecimal bigDecimal = this.factory.duasCasasDecimaisArredondado("1.009999999");
      assertEquals(new BigDecimal("1.01"), bigDecimal);
   }

   @Test
   public void testBigDecimalArredondando5() {
      BigDecimal bigDecimal = this.factory.duasCasasDecimaisArredondado("1.005");
      assertEquals(new BigDecimal("1.01"), bigDecimal);
   }

   @Test
   public void testBigDecimalArredondando6() {
      BigDecimal bigDecimal = this.factory.duasCasasDecimaisArredondado("1.006");
      assertEquals(new BigDecimal("1.01"), bigDecimal);
   }

   @Test
   public void testBigDecimalArredondando4() {
      BigDecimal bigDecimal = this.factory.duasCasasDecimaisArredondado("1.004");
      assertEquals(new BigDecimal(UM_ZERO_ZERO), bigDecimal);
   }

   @Test
   public void testQuatroCasasDecimaisTruncado() {
      BigDecimal nulo = null;
      assertNull(this.factory.quatroCasasDecimaisTruncado(nulo));
   }

}
