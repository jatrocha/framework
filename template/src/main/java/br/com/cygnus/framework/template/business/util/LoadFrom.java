package br.com.cygnus.framework.template.business.util;

import java.util.List;

/**
 * Utilitario que preenche um objeto a partir de um arquivo texto.
 * 
 * @param <T> {@link Object} tipo do objeto a ser preenchido.
 */
public interface LoadFrom<T> {

   /**
    * @return {@link java.util.List} contendo os objeto(s) carregados do arquivo. {@link java.util.List#isEmpty()} sera <code>TRUE</code> caso a lista esteja
    *         vazia (se nenhuma linha for encontrada no arquivo).
    */
   List<T> load();

   /**
    * 
    * @param line {@link String} linha recuperada do arquivo texto.
    * @return {@link Object} preenchido com os dados do arquivo.
    * @throws java.lang.IllegalArgumentException caso o parametro de entrada seja <code>null</code> ou vazio.
    */
   T parseLine(String line);
}
