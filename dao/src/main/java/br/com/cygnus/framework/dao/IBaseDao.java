package br.com.cygnus.framework.dao;

import java.io.Serializable;
import java.util.List;

import br.com.cygnus.framework.IObjetoGenerico;
import br.com.cygnus.framework.dao.exception.DAOException;
import br.com.cygnus.framework.template.dao.entity.AbstractEntity;

/**
 * Classe <tt>IBaseDao</tt> base para implementacao dos objetos persistentes.
 */
public interface IBaseDao<E extends AbstractEntity> extends IObjetoGenerico {

   /**
    * Grava a entidade persistente.
    * 
    * @param entity entidade a ser gravada.
    * @throws DAOException encapsula a PersistenceException, informando um erro generico em seu lugar.
    */
   void save(E entity) throws DAOException;

   /**
    * Atualiza a entidade persistente.
    * 
    * @param entity entidade a ser atualizada.
    * @throws DAOException encapsula a PersistenceException, informando um erro generico em seu lugar.
    */
   void update(E entity) throws DAOException;

   /**
    * Exclui uma entidade persistente.
    * 
    * @param entity entidade a ser excluida.
    * @throws DAOException encapsula a PersistenceException, informando um erro generico em seu lugar.
    */
   void delete(E entity) throws DAOException;

   /**
    * Carrega a entidade persistente.
    * 
    * @param primaryKey Identificador.
    * @return a entidade de acordo com o seu tipo.
    */
   E load(Serializable primaryKey);

   /**
    * Lista todas as entidades do tipo informado.
    * 
    * @return lista contendo todas as entidades do tipo informado.
    */
   List<E> list();

}
