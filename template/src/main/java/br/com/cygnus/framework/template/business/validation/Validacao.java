/**
 * Base para validação de negocio.
 */
package br.com.cygnus.framework.template.business.validation;

import br.com.cygnus.framework.IObjetoGenerico;

/**
 * Contrato para implementação de todos os validadores.
 * 
 * @param <T> Objeto a ser validado.
 */
public interface Validacao<T> extends IObjetoGenerico {

   /**
    * Executa a cadeia de validação.
    * 
    * @param objeto Objeto a ser validado.
    */
   void validar(final T objeto);

}
