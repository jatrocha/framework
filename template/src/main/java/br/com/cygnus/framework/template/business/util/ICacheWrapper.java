/**
 * 
 */
package br.com.cygnus.framework.template.business.util;

import br.com.cygnus.framework.IObjetoGenerico;

/**
 * Contrato de utilizacao do cache.
 * 
 * @param <K> identificador.
 * @param <V> Objecto a ser armazenado no cache.
 */
public interface ICacheWrapper<K, V> extends IObjetoGenerico {

   /**
    * Adiciona item no cache.
    * 
    * @param key identificador do item.
    * @param value o item propriamente dito.
    */
   void put(final K key, final V value);

   /**
    * Recupera um item do cache.
    * 
    * @param key identificador.
    * @return item no cache, <code>null</code> caso nao exista.
    */
   V get(final K key);

}