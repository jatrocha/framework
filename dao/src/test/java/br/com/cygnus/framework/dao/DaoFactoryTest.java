package br.com.cygnus.framework.dao;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.ejb.Ejb3Configuration;
import org.junit.Test;

import br.com.cygnus.framework.dao.base.Piras;
import br.com.cygnus.framework.template.dao.entity.test.AbstractTestDAO;

public class DaoFactoryTest extends AbstractTestDAO {

   @Test
   public void testGetJPADaoEMInvalidNull() {
      EntityManager em = null;
      try {
         DaoFactory.get(em, Piras.class);
      } catch (IllegalArgumentException e) {
         assertEquals(DaoFactory.ERRO_CONFIGURAR_FABRICA, e.getMessage());
      }
   }

   @Test
   public void testGetJPADaoPUInvalidNull() {
      String config = null;
      try {
         DaoFactory.get(config, Piras.class);
      } catch (IllegalArgumentException e) {
         assertEquals(DaoFactory.ERRO_CONFIGURAR_FABRICA, e.getMessage());
      }
   }

   @Test
   public void testGetJPAPU() {

      try {
         DaoFactory.get("persistenceUnit", Piras.class);
      } catch (IllegalArgumentException e) {
         assertEquals(DaoFactory.ERRO_CONFIGURAR_FABRICA, e.getMessage());
      }
   }

   @Test
   public void testGetHibernateInvalidNull() {
      Session session = null;
      try {
         DaoFactory.get(session, Piras.class);
      } catch (IllegalArgumentException e) {
         assertEquals(DaoFactory.ERRO_CONFIGURAR_FABRICA, e.getMessage());
      }
   }

   @Override
   protected void registerEntities(Ejb3Configuration configuration) {
      // TODO Auto-generated method stub

   }

}
