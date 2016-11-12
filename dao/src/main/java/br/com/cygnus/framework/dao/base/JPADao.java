package br.com.cygnus.framework.dao.base;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import br.com.cygnus.framework.IMensagens;
import br.com.cygnus.framework.dao.exception.DAOException;
import br.com.cygnus.framework.template.dao.entity.AbstractEntity;
import br.com.cygnus.framework.util.Validacao;

/**
 * Implementacao da interface de acesso a Banco de Dados utilizando a tecnologia JPA.
 * 
 * @param <T> generico identifica a classe, sendo qualquer classe persistente do framework.
 */
public class JPADao<T extends AbstractEntity> extends POODao<T> {

   /**
    * Constructor.
    * 
    * @param persistenceUnitName nome da unidade de persistencia.
    * @param type entidade persistente.
    */
   public JPADao(String persistenceUnitName, Class<T> type) {
      super(type);
      this.createEntityManager(persistenceUnitName);
   }

   /**
    * Construtor.
    * 
    * @param entityManager gerenciador de entidades conectado.
    * @param type entidade persistente.
    */
   public JPADao(EntityManager entityManager, Class<T> type) {
      super(type);
      super.setEntityManager(entityManager);
   }

   /**
    * Grava a entidade persistente.
    * 
    * @param entity entidade a ser gravada.
    * @throws DAOException encapsula a {@link PersistenceException}, informando um erro generico em seu lugar.
    */
   @Override
   public void save(T entity) throws DAOException {
      Validacao.get().validarObrigatorio(entity, ENTITY);
      try {
         super.begin();
         super.getEntityManager().persist(entity);
         super.commit();
      } catch (PersistenceException e) {
         super.rollback();
         throw new DAOException(IMensagens.DAO016, e);
      }
      // TODO melhorar a mensagem de erro, especificando o nome da entidade (tipo)
   }

   /**
    * Atualiza a entidade persistente.
    * 
    * @param entity entidade a ser atualizada.
    * @throws DAOException encapsula a {@link PersistenceException}, informando um erro generico em seu lugar.
    */
   @Override
   public void update(T entity) throws DAOException {
      Validacao.get().validarObrigatorio(entity, ENTITY);
      try {
         super.begin();
         super.getEntityManager().merge(entity);
         super.commit();
      } catch (PersistenceException e) {
         super.rollback();
         throw new DAOException(IMensagens.DAO018, e);
      }
      // TODO melhorar a mensagem de erro, especificando o nome da entidade (tipo), bem como sua chave de identificacao.
   }

   /**
    * Exclui uma entidade persistente.
    * 
    * @param entity entidade a ser excluida.
    * @throws DAOException encapsula a {@link PersistenceException}, informando um erro generico em seu lugar.
    */
   @Override
   public void delete(T entity) throws DAOException {
      Validacao.get().validarObrigatorio(entity, ENTITY);
      try {
         super.begin();
         super.getEntityManager().remove(entity);
         super.commit();
      } catch (PersistenceException e) {
         super.rollback();
         throw new DAOException(IMensagens.DAO019, e);
      }
      // TODO melhorar a mensagem de erro, especificando o nome da entidade (tipo), bem como sua chave de identificacao.
   }

   /**
    * Cria um {@link EntityManager} a partir do nome da unidade de persistencia.
    * 
    * @param persistenceUnitName nome da unidade de persistencia.
    */
   private void createEntityManager(String persistenceUnitName) {
      super.setEntityManager(Persistence.createEntityManagerFactory(persistenceUnitName).createEntityManager());
   }

}
