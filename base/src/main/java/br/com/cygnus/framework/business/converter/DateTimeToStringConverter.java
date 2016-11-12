package br.com.cygnus.framework.business.converter;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

import br.com.cygnus.framework.IConstantes;
import br.com.cygnus.framework.template.business.converter.Converter;

/**
 * Utilitario para converter um {@link DateTime} em data no formato {@code dd/MM/yyyy hh:mm:ss} dentro de uma {@link String}.
 */
public class DateTimeToStringConverter implements Converter<DateTime, String> {

   /**
    * @see br.com.cygnus.framework.template.business.converter.Converter#convert(java.lang.Object)
    */
   @Override
   public String convert(DateTime source) {

      if (source == null) {

         return null;
      }

      return source.toString(DateTimeFormat.forPattern(IConstantes.PATTERN_DD_MM_YYYY_HH_MM_SS));
   }

}
