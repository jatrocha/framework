package br.com.cygnus.framework.dao.base;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import br.com.cygnus.framework.dao.DaoFactory;
import br.com.cygnus.framework.template.dao.entity.AbstractEntity;
import br.com.cygnus.framework.util.Validacao;

/**
 * Implementacao da interface de acesso a Banco de Dados utilizando persistencia orientada a objetos.
 * 
 * @param <T> generico identifica a classe, sendo qualquer classe persistente do framework.
 */
public abstract class POODao<T extends AbstractEntity> extends DaoFactory<T> {

   /** Nome do campo para comparacao. */
   protected static final String ENTITY = "entity";

   /** Gerenciador de transacoes. */
   private EntityTransaction transaction = null;

   /** Tipo da classe desejada. */
   private Class<T> type;

   /** Gerenciador de entidades. */
   @PersistenceContext
   private EntityManager entityManager = null;

   /**
    * Constructor.
    */
   public POODao() {
      super();
   }

   /**
    * Construtor.
    * 
    * @param type generico que identifica a classe persistente do framework.
    */
   protected POODao(Class<T> type) {
      super();
      this.setType(type);
   }

   /**
    * @return the transaction.
    */
   protected EntityTransaction getTransaction() {
      return this.transaction;
   }

   /**
    * @param transaction the transaction to set.
    */
   protected void setTransaction(EntityTransaction transaction) {
      this.transaction = transaction;
   }

   /**
    * Desfaz uma transacao.
    */
   protected void rollback() {
      this.getTransaction().rollback();
   }

   /**
    * Efetiva uma transacao.
    */
   protected void commit() {
      this.getTransaction().commit();
   }

   /**
    * @return the classe.
    */
   protected Class<T> getType() {
      return this.type;
   }

   /**
    * @param type the type to set.
    */
   protected final void setType(Class<T> type) {
      this.type = type;
   }

   /**
    * @param entityManager instancia do {@link EntityManager} conectada ao SGDB.
    */
   protected final void setEntityManager(EntityManager entityManager) {
      this.entityManager = entityManager;
   }

   /**
    * @return instancia do {@link EntityManager} conectada ao SGDB.
    */
   protected EntityManager getEntityManager() {
      return this.entityManager;
   }

   /**
    * Inicia uma transacao.
    */
   protected void begin() {
      if (this.getTransaction() == null) {
         this.setTransaction(this.getEntityManager().getTransaction());
      }
      this.getTransaction().begin();
   }

   /**
    * Carrega a entidade persistente.
    * 
    * @param primaryKey identificador.
    * @return a entidade de acordo com o seu tipo.
    */
   @Override
   public T load(Serializable primaryKey) {
      if (Validacao.get().isNotNull(primaryKey)) {
         return this.getEntityManager().find(this.getType(), primaryKey);
      }
      return null;
   }

   /**
    * Lista todas as entidades do tipo informado.
    * 
    * @return lista contendo todas as entidades do tipo informado.
    */
   @Override
   public List<T> list() {
      CriteriaBuilder criteriaBuilder = this.getEntityManager().getCriteriaBuilder();
      CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(this.getType());
      criteriaQuery.select(criteriaQuery.from(this.getType()));
      return this.getEntityManager().createQuery(criteriaQuery).getResultList();
   }

}
