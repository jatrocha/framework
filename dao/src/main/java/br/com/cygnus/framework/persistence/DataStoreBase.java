package br.com.cygnus.framework.persistence;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.cygnus.framework.template.dao.entity.AbstractEntity;
import br.com.cygnus.framework.template.persistence.DataStore;

/**
 * Base for datastore pattern implementation.
 * 
 * @param <T> an entity - a class than extends {@link br.com.cygnus.framework.template.dao.entity.AbstractEntity}.
 */
public abstract class DataStoreBase<T extends AbstractEntity> implements DataStore<T> {

   @PersistenceContext
   private EntityManager entityManager;

   /**
    * @see br.com.cygnus.apps.biblia.engine.datastore.DataStore#save(br.com.cygnus.framework.template.dao.entity.AbstractEntity).
    */
   @Override
   public T save(T entity) {

      if (entity == null) {

         throw new IllegalArgumentException();
      }

      this.getEntityManager().persist(entity);

      this.getEntityManager().flush();

      return entity;
   }

   /**
    * @see br.com.cygnus.apps.biblia.engine.datastore.DataStore#update(br.com.cygnus.framework.template.dao.entity.AbstractEntity).
    */
   @Override
   public void update(T entity) {

      if (entity == null) {

         throw new IllegalArgumentException();
      }

      this.getEntityManager().merge(entity);

   }

   /**
    * @see br.com.cygnus.apps.biblia.engine.datastore.DataStore#delete(br.com.cygnus.framework.template.dao.entity.AbstractEntity).
    */
   @Override
   public void delete(T entity) {

      if (entity == null) {

         throw new IllegalArgumentException();
      }

      this.getEntityManager().remove(entity);
   }

   /**
    * @see br.com.cygnus.apps.biblia.engine.datastore.DataStore#find(java.lang.Class, java.io.Serializable).
    */
   @Override
   public T find(Class<T> entityClass, Serializable primaryKey) {

      if (entityClass == null || primaryKey == null) {

         throw new IllegalArgumentException();
      }

      return this.getEntityManager().find(entityClass, primaryKey);
   }

   /**
    * @param entityManager {@link EntityManager}.
    */
   protected final void setEntityManager(final EntityManager entityManager) {

      this.entityManager = entityManager;
   }

   /**
    * @return {@link EntityManager}.
    */
   protected final EntityManager getEntityManager() {

      return this.entityManager;
   }
}
