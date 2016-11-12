package br.com.cygnus.framework.template.business.util;

import java.io.Serializable;
import java.util.Comparator;

import br.com.cygnus.framework.AObjetoGenerico;
import br.com.cygnus.framework.IObjetoGenerico;

/**
 * Contrato para ordenacao de listas.
 */
public interface IOrdenacao<T extends AObjetoGenerico> extends IObjetoGenerico, Comparator<T>, Serializable {

   /**
    * De acordo com o construtor chamado efetua a ordenacao.
    * 
    * @param base objeto base a se comparar.
    * @param comparacao objeto para comparar.
    * @return o indice para a ordenar.
    */
   @Override
   int compare(T base, T comparacao);

}
