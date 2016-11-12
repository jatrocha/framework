/**
 * 
 */
package br.com.cygnus.framework.template.dao.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Version;

import br.com.cygnus.framework.AObjetoGenerico;

/**
 * Classe <code>AbstractEntity</code> e a base para implementacao de entidades persistentes.
 */
public abstract class AbstractEntity extends AObjetoGenerico implements Serializable {

   /** serialVersionUID. */
   private static final long serialVersionUID = 1L;

   /** Versao do registro. */
   private Long version = null;

   /**
    * Construtor padrao.
    */
   public AbstractEntity() {
      super();
   }

   /**
    * @return versao do registro.
    */
   @Version
   @Column(name = "VERSION", nullable = false, unique = false)
   public Long getVersion() {
      return this.version;
   }

   /**
    * @param version registro.
    */
   public void setVersion(Long version) {
      this.version = version;
   }

}
