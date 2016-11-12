package br.com.cygnus.framework.template.business.util;


/**
 * Utilitario que preenche um objeto a partir de um arquivo texto.<br/>
 * <br/>
 * Cada linha do arquivo deve representar um objeto distinto, sendo que, os atributos devem estar delimitados por um coringa, por exemplo: "#". <br/>
 * 
 * @param <T> {@link Object} tipo do objeto a ser preenchido.
 */
public interface LoadFromFile<T> extends LoadFrom<T> {

   /**
    * @param delimiter {@link String} delimitador coringa a ser utilizado.
    * @return {@link LoadFromFile} pronta a ser utilizada.
    * @throws java.lang.IllegalArgumentException caso o parametro de entrada seja <code>null</code> ou vazio.
    */
   LoadFromFile<T> withDelimiter(String delimiter);
}
