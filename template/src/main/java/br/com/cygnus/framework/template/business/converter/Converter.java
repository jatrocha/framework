package br.com.cygnus.framework.template.business.converter;

/**
 * Converts on object into another.
 * 
 * @param <F> source object class.
 * @param <T> target object class.
 */
public interface Converter<F, T> {

   /**
    * @param source {@link Object} object to be converted.
    * @return the converted {@link Object}.
    * @throws java.lang.IllegalArgumentException if the source object is <code>null</code>.
    */
   T convert(final F source);
}
