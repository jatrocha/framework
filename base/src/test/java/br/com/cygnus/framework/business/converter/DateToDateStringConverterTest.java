package br.com.cygnus.framework.business.converter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.joda.time.DateTime;
import org.junit.Test;

import br.com.cygnus.framework.business.converter.DateToDateStringConverter;

public class DateToDateStringConverterTest {

   @Test
   public void naoDeveConverterQuandoDataInvalidaNull() {

      assertNull(new DateToDateStringConverter().convert(null));
   }

   @Test
   public void deveConverterQuandoDataValida() {

      DateTime source = new DateTime(1980, 1, 1, 0, 0);

      String target = "01/01/1980";

      assertEquals(target, new DateToDateStringConverter().convert(source));
   }
}
