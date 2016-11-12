package br.com.cygnus.framework.template.dao.entity.test;

import static junit.framework.Assert.fail;
import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import org.hibernate.ejb.Ejb3Configuration;
import org.junit.Before;
import org.junit.Test;

import br.com.cygnus.framework.IObjetoGenerico;

public class SQLScriptLoaderTest implements IObjetoGenerico {

   protected static final String UNFORESEEN_CONSEQUENCE = "Face the thing that should not be! =]";

   private AbstractTestDAO testDao;

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
   public void testLoadScriptInvalido() {
      try {
         SQLScriptLoader.loadScript(NULL_STRING, this.testDao.getEntityManager());
      } catch (SQLException e) {
         fail(UNFORESEEN_CONSEQUENCE);
      } catch (IOException e) {
         assertTrue(e instanceof FileNotFoundException);
      }
   }

   @Test
   public void testLoadScript() {
      try {
         SQLScriptLoader.loadScript("src/test/resources/scripts/person-load.sql", this.testDao.getEntityManager());
      } catch (SQLException e) {
         fail(UNFORESEEN_CONSEQUENCE);
      } catch (IOException e) {
         assertTrue(e instanceof FileNotFoundException);
      }
   }

}
