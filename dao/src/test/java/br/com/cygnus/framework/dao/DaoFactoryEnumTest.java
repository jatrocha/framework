package br.com.cygnus.framework.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class DaoFactoryEnumTest {

   @Test
   public void testGetByNomeInvalidNull() {
      Integer nulo = null;
      assertNull(DaoFactoryEnum.getBy(nulo));
   }

   @Test
   public void testGetByNome() {
      assertEquals(DaoFactoryEnum.JPA, DaoFactoryEnum.getBy("JPA"));
      assertEquals(DaoFactoryEnum.HIBERNATE, DaoFactoryEnum.getBy("Hibernate"));
   }

   @Test
   public void testGetByNomeInvalidEmpty() {
      String nulo = null;
      assertNull(DaoFactoryEnum.getBy(nulo));
   }

   @Test
   public void testGetById() {
      assertEquals(DaoFactoryEnum.JPA, DaoFactoryEnum.getBy(Integer.valueOf(0)));
      assertEquals(DaoFactoryEnum.HIBERNATE, DaoFactoryEnum.getBy(Integer.valueOf(1)));
   }

}
