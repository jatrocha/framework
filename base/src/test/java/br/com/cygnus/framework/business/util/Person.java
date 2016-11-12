package br.com.cygnus.framework.business.util;

import br.com.cygnus.framework.AObjetoGenerico;

public class Person extends AObjetoGenerico {

   private Integer codigo;
   private String nome;

   public Person(Integer codigo, String nome) {
      this.codigo = codigo;
      this.nome = nome;
   }

   public Integer getCodigo() {
      return this.codigo;
   }

   public String getNome() {
      return this.nome;
   }

}
