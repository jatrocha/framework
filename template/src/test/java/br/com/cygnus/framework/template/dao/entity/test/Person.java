package br.com.cygnus.framework.template.dao.entity.test;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.cygnus.framework.template.dao.entity.AbstractEntity;

@Table
@Entity
public class Person extends AbstractEntity {

   private static final long serialVersionUID = 5537269190480190333L;
   private String name;
   private Long id = null;

   /**
    * @return identificador do registro.
    */
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "person_id", nullable = false, unique = true)
   public Long getId() {
      return this.id;
   }

   /**
    * @param id atribui um valor ao identificador do registro.
    */
   public void setId(Long id) {
      this.id = id;
   }

   public Person() {
   }

   public Person(String name) {
      this.name = name;
   }

   @Column(nullable = false)
   public String getName() {
      return this.name;
   }

   public void setName(String name) {
      this.name = name;
   }

}