package br.com.cygnus.framework.dao.base;

import static junit.framework.Assert.fail;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.ejb.Ejb3Configuration;
import org.junit.Before;
import org.junit.Test;

import br.com.cygnus.framework.IMensagens;
import br.com.cygnus.framework.dao.DaoFactory;
import br.com.cygnus.framework.dao.exception.DAOException;
import br.com.cygnus.framework.template.dao.entity.test.AbstractTestDAO;
import br.com.cygnus.framework.template.dao.entity.test.SQLScriptLoader;
import br.com.cygnus.framework.util.Mensagem;

public class JPADaoTest extends AbstractTestDAO {

   protected static final String ENTITY = "entity";

   private JPADao<Piras> base = null;

   protected static final String UNFORESEEN_CONSEQUENCE = "Face the thing that should not be! =]";

   @Before
   public void setUp() {

      this.base = DaoFactory.get(super.getEntityManager(), Piras.class);
   }

   @Test
   public void testSaveInvalidNull() throws DAOException {

      try {

         this.base.save(null);

         fail(UNFORESEEN_CONSEQUENCE);

      } catch (IllegalArgumentException e) {

         assertEquals(Mensagem.get().getMensagem(IMensagens.FRA016, new String[] { ENTITY }), e.getMessage());
      }
   }

   @Test
   public void testSaveInvalidEmpty() {
      try {

         this.base.save(this.getEmptyPerson());

         fail(UNFORESEEN_CONSEQUENCE);

      } catch (IllegalArgumentException e) {

         fail(UNFORESEEN_CONSEQUENCE);

      } catch (DAOException e) {

         assertEquals(Mensagem.get().getMensagem(IMensagens.DAO016, new String[] { ENTITY }), e.getMessage());
      }
   }

   @Test
   public void testSave() throws DAOException {

      this.base.save(this.getValidPerson());
   }

   @Test
   public void testLoadInvalid() {

      assertNull(this.base.load(WRAPPER_LONG_ZERO));

      assertNull(this.base.load(null));
   }

   @Test
   public void testLoad() throws DAOException {

      this.base.save(this.getValidPerson());

      Piras person = this.base.load(Long.valueOf(1));

      assertNotNull(person);

      assertNotNull(person.getName());
   }

   @Test
   public void testUpdateInvalidNull() throws DAOException {

      try {

         this.base.update(null);

         fail(UNFORESEEN_CONSEQUENCE);

      } catch (IllegalArgumentException e) {

         assertEquals(Mensagem.get().getMensagem(IMensagens.FRA016, new String[] { ENTITY }), e.getMessage());
      }
   }

   @Test
   public void testUpdateInvalidEmpty() {

      try {

         this.base.update(this.getEmptyPerson());

         fail(UNFORESEEN_CONSEQUENCE);

      } catch (IllegalArgumentException e) {

         fail(UNFORESEEN_CONSEQUENCE);

      } catch (DAOException e) {

         assertEquals(Mensagem.get().getMensagem(IMensagens.DAO018, new String[] { ENTITY }), e.getMessage());
      }
   }

   @Test
   public void testUpdate() throws DAOException {

      Piras before = this.getValidPerson();

      this.base.save(before);

      Piras after = this.base.load(Long.valueOf(1));

      after.setName(UNFORESEEN_CONSEQUENCE);

      this.base.update(after);

      Piras test = this.base.load(Long.valueOf(1));

      assertEquals(UNFORESEEN_CONSEQUENCE, test.getName());
   }

   @Test
   public void testDeleteInvalidNull() throws DAOException {

      try {

         this.base.delete(null);

         fail(UNFORESEEN_CONSEQUENCE);

      } catch (IllegalArgumentException e) {

         assertEquals(Mensagem.get().getMensagem(IMensagens.FRA016, new String[] { ENTITY }), e.getMessage());
      }
   }

   @Test
   public void testDelete() throws DAOException {

      Piras person = this.getValidPerson();

      this.base.save(person);

      this.base.delete(person);

      assertNull(this.base.load(Long.valueOf(1)));
   }

   @Test
   public void testList() throws SQLException, IOException {

      this.loadEntitiesFromFile();

      List<Piras> lista = this.base.list();

      assertNotNull(lista);

      assertEquals(5, lista.size());
   }

   private void loadEntitiesFromFile() throws SQLException, IOException {

      this.begin();

      SQLScriptLoader.loadScript("src/test/resources/scripts/pessoa-load.sql", this.getEntityManager());

      this.commit();
   }

   protected Piras getValidPerson() {

      return new Piras("dummy");
   }

   protected Piras getEmptyPerson() {

      return new Piras();
   }

   @Override
   protected void registerEntities(Ejb3Configuration configuration) {

      configuration.addAnnotatedClass(Piras.class);
   }

}
