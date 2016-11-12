package br.com.cygnus.framework.template.persistence;

import java.io.Serializable;

import br.com.cygnus.framework.IObjetoGenerico;
import br.com.cygnus.framework.template.dao.entity.AbstractEntity;

/**
 * Data manipulation business.
 * 
 * @param <T> an entity - a class than extends {@link br.com.cygnus.framework.template.dao.entity.AbstractEntity}.
 */
public interface DataStore<T extends AbstractEntity> extends IObjetoGenerico {

   /**
    * @param entity {@link br.com.cygnus.framework.template.dao.entity.AbstractEntity} to save.
    * @return {@link br.com.cygnus.framework.template.dao.entity.AbstractEntity} found otherwise, will return <code>null</code>.
    * @throws java.lang.IllegalArgumentException if the entity is <code>null</code>.
    */
   T save(T entity);

   /**
    * @param entity {@link br.com.cygnus.framework.template.dao.entity.AbstractEntity} to update.
    * @throws java.lang.IllegalArgumentException if the entity is <code>null</code>.
    */
   void update(T entity);

   /**
    * @param entity {@link br.com.cygnus.framework.template.dao.entity.AbstractEntity} to delete.
    * @throws java.lang.IllegalArgumentException if the entity is <code>null</code>.
    */
   void delete(T entity);

   /**
    * @param entityClass {@link br.com.cygnus.framework.template.dao.entity.AbstractEntity} to delete.
    * @param primaryKey entity's {@link Serializable} identifier.
    * @return {@link br.com.cygnus.framework.template.dao.entity.AbstractEntity} found otherwise, will return <code>null</code>.
    * @throws java.lang.IllegalArgumentException if the one of those parameters is <code>null</code>.
    */
   T find(Class<T> entityClass, Serializable primaryKey);
}
