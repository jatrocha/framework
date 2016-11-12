package br.com.cygnus.framework.business.converter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.joda.time.DateTime;
import org.junit.Test;

import br.com.cygnus.framework.business.converter.DateTimeToStringConverter;

public class DateTimeToStringConverterTest {

   @Test
   public void naoDeveConverterQuandoDataInvalidaNull() {

      assertNull(new DateTimeToStringConverter().convert(null));
   }

   @Test
   public void deveConverterQuandoDataValida() {

      DateTime source = new DateTime(1980, 1, 1, 0, 0);

      String target = "01/01/1980 00:00:00";

      assertEquals(target, new DateTimeToStringConverter().convert(source));
   }
}
