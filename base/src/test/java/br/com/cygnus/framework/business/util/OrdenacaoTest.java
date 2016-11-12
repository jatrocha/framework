package br.com.cygnus.framework.business.util;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class OrdenacaoTest {

   @Test
   public void testOrdencaoPorPropriedade() {

      List<Person> lista = this.montarListaAOrdenar();

      Collections.sort(lista, new Ordenacao<Person>("codigo"));

      assertEquals("A", lista.get(0).getNome());
      assertEquals("B", lista.get(1).getNome());
      assertEquals("C", lista.get(2).getNome());
      assertEquals("D", lista.get(3).getNome());

   }

   @Test
   public void testOrdencaoPorPropriedadeInvalido() {

      List<Person> lista = this.montarListaAOrdenar();

      Collections.sort(lista, new Ordenacao<Person>("naoexiste"));

      assertEquals("D", lista.get(0).getNome());
      assertEquals("C", lista.get(1).getNome());
      assertEquals("B", lista.get(2).getNome());
      assertEquals("A", lista.get(3).getNome());

   }

   @Test
   public void testOrdencaoPorPropriedadeArray() {

      List<Person> lista = this.montarListaAOrdenar();

      Collections.sort(lista, new Ordenacao<Person>(new String[] { "nome" }));

      assertEquals("A", lista.get(0).getNome());
      assertEquals("B", lista.get(1).getNome());
      assertEquals("C", lista.get(2).getNome());
      assertEquals("D", lista.get(3).getNome());

   }

   private List<Person> montarListaAOrdenar() {

      List<Person> lista = new ArrayList<Person>(4);

      lista.add(new Person(Integer.valueOf(4), "D"));
      lista.add(new Person(Integer.valueOf(3), "C"));
      lista.add(new Person(Integer.valueOf(2), "B"));
      lista.add(new Person(Integer.valueOf(1), "A"));

      return lista;

   }

}
