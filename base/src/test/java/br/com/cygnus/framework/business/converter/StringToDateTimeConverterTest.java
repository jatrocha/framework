package br.com.cygnus.framework.business.converter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.joda.time.DateTime;
import org.junit.Test;

import br.com.cygnus.framework.business.converter.StringToDateTimeConverter;

public class StringToDateTimeConverterTest {

   @Test
   public void naoDeveConverterQuandoDataInvalidaNull() {

      assertNull(new StringToDateTimeConverter().convert(null));
   }

   @Test
   public void naoDeveConverterQuandoDataInvalidaVazia() {

      assertNull(new StringToDateTimeConverter().convert(""));
   }

   @Test(expected = IllegalArgumentException.class)
   public void naoDeveConverterQuandoDataInvalida() {

      new StringToDateTimeConverter().convert("a");
   }

   @Test
   public void deveConverterQuandoDataValida() {

      DateTime target = new DateTime(1980, 1, 1, 0, 0);

      String source = "01/01/1980 00:00:00";

      assertEquals(target, new StringToDateTimeConverter().convert(source));
   }
}
