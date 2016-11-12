package br.com.cygnus.framework.template.business.util;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import net.sf.ehcache.CacheManager;

import org.junit.Before;
import org.junit.Test;

public class EhCacheWrapperTest {

   private final EhCacheWrapper<Integer, String> cacheWrapper = new EhCacheWrapper<Integer, String>("teste", CacheManager.create());

   @Before
   public void setUp() {
      this.loadCacheData();
   }

   private void loadCacheData() {
      for (int i = 0; i < 32000; i++) {
         this.cacheWrapper.put(Integer.valueOf(i), "Valor ".concat(Integer.valueOf(i).toString()));
      }
   }

   @Test
   public void testGet() {
      assertNotNull(this.cacheWrapper.get(Integer.valueOf(50)));
      assertNull(this.cacheWrapper.get(Integer.valueOf(320001)));
   }

}
