package br.com.cygnus.framework.util.data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Date;

import org.junit.Test;

import br.com.cygnus.framework.util.DataTest;

public class DiaDaSemanaEnumTest extends DataTest {

   @Test
   public void testGetByNumero() {
      assertEquals(DiaDaSemanaEnum.DOMINGO, DiaDaSemanaEnum.valueOf(Integer.valueOf(1)));
      assertEquals(DiaDaSemanaEnum.SEGUNDA, DiaDaSemanaEnum.valueOf(Integer.valueOf(2)));
      assertEquals(DiaDaSemanaEnum.TERCA, DiaDaSemanaEnum.valueOf(Integer.valueOf(3)));
      assertEquals(DiaDaSemanaEnum.QUARTA, DiaDaSemanaEnum.valueOf(Integer.valueOf(4)));
      assertEquals(DiaDaSemanaEnum.QUINTA, DiaDaSemanaEnum.valueOf(Integer.valueOf(5)));
      assertEquals(DiaDaSemanaEnum.SEXTA, DiaDaSemanaEnum.valueOf(Integer.valueOf(6)));
      assertEquals(DiaDaSemanaEnum.SABADO, DiaDaSemanaEnum.valueOf(Integer.valueOf(7)));
      assertNull(DiaDaSemanaEnum.valueOf(WRAPPER_INTEGER_ZERO));
   }

   @Test
   public void testGetByNome() {
      assertEquals(DiaDaSemanaEnum.DOMINGO, DiaDaSemanaEnum.getBy("domingo"));
      assertEquals(DiaDaSemanaEnum.SEGUNDA, DiaDaSemanaEnum.getBy("segunda-feira"));
      assertEquals(DiaDaSemanaEnum.TERCA, DiaDaSemanaEnum.getBy("terça-feira"));
      assertEquals(DiaDaSemanaEnum.QUARTA, DiaDaSemanaEnum.getBy("quarta-feira"));
      assertEquals(DiaDaSemanaEnum.QUINTA, DiaDaSemanaEnum.getBy("quinta-feira"));
      assertEquals(DiaDaSemanaEnum.SEXTA, DiaDaSemanaEnum.getBy("sexta-feira"));
      assertEquals(DiaDaSemanaEnum.SABADO, DiaDaSemanaEnum.getBy("sábado"));
      assertNull(DiaDaSemanaEnum.getBy(NULL_STRING));

   }

   @Test
   public void testGetByDate() {
      assertEquals(DiaDaSemanaEnum.DOMINGO, DiaDaSemanaEnum.getBy(super.getDate(DiaDaSemanaEnum.DOMINGO.getNumero())));
      assertEquals(DiaDaSemanaEnum.SEGUNDA, DiaDaSemanaEnum.getBy(super.getDate(DiaDaSemanaEnum.SEGUNDA.getNumero())));
      assertEquals(DiaDaSemanaEnum.TERCA, DiaDaSemanaEnum.getBy(super.getDate(DiaDaSemanaEnum.TERCA.getNumero())));
      assertEquals(DiaDaSemanaEnum.QUARTA, DiaDaSemanaEnum.getBy(super.getDate(DiaDaSemanaEnum.QUARTA.getNumero())));
      assertEquals(DiaDaSemanaEnum.QUINTA, DiaDaSemanaEnum.getBy(super.getDate(DiaDaSemanaEnum.QUINTA.getNumero())));
      assertEquals(DiaDaSemanaEnum.SEXTA, DiaDaSemanaEnum.getBy(super.getDate(DiaDaSemanaEnum.SEXTA.getNumero())));
      assertEquals(DiaDaSemanaEnum.SABADO, DiaDaSemanaEnum.getBy(super.getDate(DiaDaSemanaEnum.SABADO.getNumero())));
      Date data = null;
      assertNull(DiaDaSemanaEnum.getBy(data));

   }

}
