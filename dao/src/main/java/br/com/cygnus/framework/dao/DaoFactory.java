package br.com.cygnus.framework.dao;

import javax.persistence.EntityManager;

import org.hibernate.Session;

import br.com.cygnus.framework.dao.base.JPADao;
import br.com.cygnus.framework.template.dao.entity.AbstractEntity;
import br.com.cygnus.framework.util.Validacao;

/**
 * Classe <tt>DaoFactory</tt> monta objetos de acesso a dados de acordo com os parametros informados.
 */
public abstract class DaoFactory<T extends AbstractEntity> implements IBaseDao<T> {

   /** Mensagem de erro caso n‹o seja possivel configurar a fabrica. */
   protected static final String ERRO_CONFIGURAR_FABRICA = "Não foi possível configurar a fábrica.";

   /**
    * Construtor padrao.
    */
   protected DaoFactory() {
      super();
   }

   /**
    * Constroi a respectiva instancia da classe <tt>JPADao</tt>.
    * 
    * @param persistenceUnitName nome da unidade de persistencia.
    * @param type tipo da classe utilizada no template.
    * @param <A> tipo gererico que derive de {@link AbstractEntity}.
    * @param <D> tipo gererico que derive de {@link DaoFactory}.
    * @return instancia da fabrica desejada.
    */
   @SuppressWarnings("unchecked")
   public static <A extends AbstractEntity, D extends DaoFactory<A>> D get(String persistenceUnitName, Class<A> type) {
      if (Validacao.get().isNull(persistenceUnitName)) {
         throw new IllegalArgumentException(ERRO_CONFIGURAR_FABRICA);
      }

      return (D) new JPADao<A>(persistenceUnitName, type);
   }

   /**
    * Constroi a respectiva instancia da classe <tt>JPADao</tt>.
    * 
    * @param entityManager gerenciador de entidades.
    * @param type tipo da classe utilizada no template.
    * @param <A> tipo gererico que derive de {@link AbstractEntity}.
    * @param <D> tipo gererico que derive de {@link DaoFactory}.
    * @return instancia da fabrica desejada.
    */
   @SuppressWarnings("unchecked")
   public static <A extends AbstractEntity, D extends DaoFactory<A>> D get(EntityManager entityManager, Class<A> type) {
      if (Validacao.get().isNull(entityManager)) {
         throw new IllegalArgumentException(ERRO_CONFIGURAR_FABRICA);
      }

      return (D) new JPADao<A>(entityManager, type);
   }

   // Session session

   /**
    * Constroi a respectiva instancia da classe <tt>JPADao</tt>.
    * 
    * @param session sess‹o do hibernate conectada.
    * @param type tipo da classe utilizada no template.
    * @param <A> tipo gererico que derive de {@link AbstractEntity}.
    * @param <D> tipo gererico que derive de {@link DaoFactory}.
    * @return instancia da fabrica desejada.
    */
   public static <A extends AbstractEntity, D extends DaoFactory<A>> D get(Session session, Class<A> type) {
      if (Validacao.get().isNull(session)) {
         throw new IllegalArgumentException(ERRO_CONFIGURAR_FABRICA);
      }

      return null;
   }

}
