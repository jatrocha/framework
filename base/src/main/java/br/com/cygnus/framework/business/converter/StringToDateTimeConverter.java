package br.com.cygnus.framework.business.converter;

import org.apache.commons.lang.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

import br.com.cygnus.framework.IConstantes;
import br.com.cygnus.framework.template.business.converter.Converter;

/**
 * Utilitario para converter uma {@link String} contendo uma {@code data} em um {@link DateTime}.
 */
public class StringToDateTimeConverter implements Converter<String, DateTime>  {

   /**
    * @see br.com.cygnus.framework.template.business.converter.Converter#convert(java.lang.Object)
    */
   @Override
   public DateTime convert(String source) {

      if (StringUtils.isEmpty(source)) {

         return null;
      }

      return DateTimeFormat.forPattern(IConstantes.PATTERN_DD_MM_YYYY_HH_MM_SS).parseDateTime(source);
   }

}
