package br.com.cygnus.framework.template.business.util;

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;
import br.com.cygnus.framework.AObjetoGenerico;

/**
 * Wrapper para utilizacao do cache.
 * 
 * @param <K> Identificador.
 * @param <V> Objecto a ser armazenado no cache.
 */
public class EhCacheWrapper<K, V> extends AObjetoGenerico implements ICacheWrapper<K, V> {

   /** Nome do cache no arquivo de configuracao. */
   private final String cacheName;

   /** Instancia do gerenciador de cache. */
   private final CacheManager cacheManager;

   /**
    * Construtor.
    * 
    * @param cacheName Nome do cache no arquivo de configuracao.
    * @param cacheManager Instancia do gerenciador de cache.
    */
   public EhCacheWrapper(final String cacheName, final CacheManager cacheManager) {
      this.cacheName = cacheName;
      this.cacheManager = cacheManager;
   }

   /**
    * Adiciona item no cache.
    * 
    * @param key identificador do item.
    * @param value o item propriamente dito.
    */
   @Override
   public void put(K key, V value) {
      this.getCache().put(new Element(key, value));
   }

   /**
    * Recupera um item do cache.
    * 
    * @param key identificador.
    * @return item no cache, <code>null</code> caso nao exista.
    */
   @SuppressWarnings("unchecked")
   @Override
   public V get(K key) {
      Element element = this.getCache().get(key);
      if (element != null) {
         return (V) element.getValue();
      }
      return null;
   }

   /**
    * @return {@link Ehcache} configurado.
    */
   public Ehcache getCache() {
      return this.cacheManager.getEhcache(this.cacheName);
   }
}