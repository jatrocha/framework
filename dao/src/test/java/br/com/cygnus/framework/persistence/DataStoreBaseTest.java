package br.com.cygnus.framework.persistence;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;
import static org.junit.Assert.assertEquals;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.cygnus.framework.dao.base.Piras;

public class DataStoreBaseTest {

   private Mockery context;

   @Before
   public void setup() {

      this.context = new Mockery() {

         {

            this.setImposteriser(ClassImposteriser.INSTANCE);
         }

      };
   }

   @After
   public void teardown() {

      this.context = null;
   }

   @Test(expected = IllegalArgumentException.class)
   public void testSaveQuandoParametroInvalidoNull() {

      new DataStoreBase<Piras>() {
      }.save(null);
   }

   @Test
   public void testSave() {

      final EntityManager entityManager = this.context.mock(EntityManager.class);

      final Piras entity = this.context.mock(Piras.class);

      this.context.checking(new Expectations() {

         {
            this.one(entityManager).persist(entity);

            this.one(entityManager).flush();

            this.one(entity).getId();

            this.will(returnValue(Long.valueOf(1)));

         }

      });

      DataStoreBase<Piras> dataStore = new DataStoreBase<Piras>() {
      };

      dataStore.setEntityManager(entityManager);

      dataStore.save(entity);

      assertEquals(Long.valueOf(1), entity.getId());

      this.context.assertIsSatisfied();
   }

   @Test(expected = IllegalArgumentException.class)
   public void testUpdateQuandoParametroInvalidoNull() {

      new DataStoreBase<Piras>() {
      }.update(null);
   }

   public void testUpdate() {

      final EntityManager entityManager = this.context.mock(EntityManager.class);

      final Piras entity = new Piras("Teste");

      this.context.checking(new Expectations() {

         {
            this.one(entityManager).merge(entity);
         }

      });

      DataStoreBase<Piras> dataStore = new DataStoreBase<Piras>() {
      };

      dataStore.setEntityManager(entityManager);

      dataStore.update(entity);

      this.context.assertIsSatisfied();
   }

   @Test(expected = IllegalArgumentException.class)
   public void testDeleteQuandoParametroInvalidoNull() {

      new DataStoreBase<Piras>() {
      }.delete(null);
   }

   public void testDelete() {

      final EntityManager entityManager = this.context.mock(EntityManager.class);

      final Piras entity = new Piras("Teste");

      this.context.checking(new Expectations() {

         {
            this.one(entityManager).remove(entity);
         }

      });

      DataStoreBase<Piras> dataStore = new DataStoreBase<Piras>() {
      };

      dataStore.setEntityManager(entityManager);

      dataStore.delete(entity);

      this.context.assertIsSatisfied();
   }

   @Test(expected = IllegalArgumentException.class)
   public void testFindQuandoParametroEntityClassInvalidoNull() {

      Class<Piras> classe = null;

      Serializable primaryKey = null;

      new DataStoreBase<Piras>() {
      }.find(classe, primaryKey);
   }

   @Test(expected = IllegalArgumentException.class)
   public void testFindQuandoParametroPrimaryKeyInvalidoNull() {

      Class<Piras> classe = Piras.class;

      Serializable primaryKey = null;

      new DataStoreBase<Piras>() {
      }.find(classe, primaryKey);
   }

   public void testFindQuandoEntidadeNaoEncontrada() {

      final EntityManager entityManager = this.context.mock(EntityManager.class);

      final Long primaryKey = Long.valueOf(0);

      this.context.checking(new Expectations() {

         {
            this.one(entityManager).find(Piras.class, primaryKey);

            this.will(returnValue(null));
         }

      });

      DataStoreBase<Piras> dataStore = new DataStoreBase<Piras>() {
      };

      dataStore.setEntityManager(entityManager);

      assertNull(dataStore.find(Piras.class, primaryKey));

      this.context.assertIsSatisfied();
   }

   public void testFind() {

      final EntityManager entityManager = this.context.mock(EntityManager.class);

      final Piras entity = new Piras("Teste");

      final Long primaryKey = Long.valueOf(1);

      this.context.checking(new Expectations() {

         {
            this.one(entityManager).find(Piras.class, primaryKey);

            this.will(returnValue(entity));
         }

      });

      DataStoreBase<Piras> dataStore = new DataStoreBase<Piras>() {
      };

      dataStore.setEntityManager(entityManager);

      assertNotNull(dataStore.find(Piras.class, primaryKey));

      this.context.assertIsSatisfied();
   }

}
