package br.com.cygnus.framework.template.dao.entity.test;

import static org.junit.Assert.assertNotNull;

import org.hibernate.ejb.Ejb3Configuration;
import org.junit.Before;
import org.junit.Test;

import br.com.cygnus.framework.IObjetoGenerico;

public class AbstractTestDAOTest implements IObjetoGenerico {

   private AbstractTestDAO testDao = null;

   @Before
   public void setUp() {
      this.testDao = new AbstractTestDAO() {
         @Override
         protected void registerEntities(Ejb3Configuration configuration) {
            configuration.addAnnotatedClass(Person.class);
         }
      };
   }

   @Test
   public void testGetEntityManager() {
      assertNotNull(this.testDao.getEntityManager());
   }

   @Test
   public void testTransactionRoolback() {
      assertNotNull(this.testDao.getEntityManager());
      this.testDao.begin();
      this.testDao.roolback();
   }

   @Test
   public void testTransactionCommit() {
      assertNotNull(this.testDao.getEntityManager());
      this.testDao.begin();
      this.testDao.commit();
   }

}
