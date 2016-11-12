package br.com.cygnus.framework.util.data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Date;

import org.joda.time.LocalDate;
import org.junit.Test;

import br.com.cygnus.framework.AObjetoGenerico;

public class CalendarioEnumTest extends AObjetoGenerico {

   private final int JANEIRO = 1;
   private final int FEVEREIRO = 2;
   private final int MARCO = 3;
   private final int ABRIL = 4;
   private final int MAIO = 5;
   private final int JUNHO = 6;
   private final int JULHO = 7;
   private final int AGOSTO = 8;
   private final int SETEMBRO = 9;
   private final int OUTUBRO = 10;
   private final int NOVEMBRO = 11;
   private final int DEZEMBRO = 12;

   @Test
   public void testGetByNumero() {
      assertEquals(CalendarioEnum.JANEIRO, CalendarioEnum.valueOf(Integer.valueOf(1)));
      assertEquals(CalendarioEnum.FEVEREIRO, CalendarioEnum.valueOf(Integer.valueOf(2)));
      assertEquals(CalendarioEnum.MARCO, CalendarioEnum.valueOf(Integer.valueOf(3)));
      assertEquals(CalendarioEnum.ABRIL, CalendarioEnum.valueOf(Integer.valueOf(4)));
      assertEquals(CalendarioEnum.MAIO, CalendarioEnum.valueOf(Integer.valueOf(5)));
      assertEquals(CalendarioEnum.JUNHO, CalendarioEnum.valueOf(Integer.valueOf(6)));
      assertEquals(CalendarioEnum.JULHO, CalendarioEnum.valueOf(Integer.valueOf(7)));
      assertEquals(CalendarioEnum.AGOSTO, CalendarioEnum.valueOf(Integer.valueOf(8)));
      assertEquals(CalendarioEnum.SETEMBRO, CalendarioEnum.valueOf(Integer.valueOf(9)));
      assertEquals(CalendarioEnum.OUTUBRO, CalendarioEnum.valueOf(Integer.valueOf(10)));
      assertEquals(CalendarioEnum.NOVEMBRO, CalendarioEnum.valueOf(Integer.valueOf(11)));
      assertEquals(CalendarioEnum.DEZEMBRO, CalendarioEnum.valueOf(Integer.valueOf(12)));
      assertNull(CalendarioEnum.valueOf(WRAPPER_INTEGER_ZERO));
   }

   @Test
   public void testGetByNome() {
      assertEquals(CalendarioEnum.JANEIRO, CalendarioEnum.getBy("Janeiro"));
      assertEquals(CalendarioEnum.FEVEREIRO, CalendarioEnum.getBy("Fevereiro"));
      assertEquals(CalendarioEnum.MARCO, CalendarioEnum.getBy("Março"));
      assertEquals(CalendarioEnum.ABRIL, CalendarioEnum.getBy("Abril"));
      assertEquals(CalendarioEnum.MAIO, CalendarioEnum.getBy("Maio"));
      assertEquals(CalendarioEnum.JUNHO, CalendarioEnum.getBy("Junho"));
      assertEquals(CalendarioEnum.JULHO, CalendarioEnum.getBy("Julho"));
      assertEquals(CalendarioEnum.AGOSTO, CalendarioEnum.getBy("Agosto"));
      assertEquals(CalendarioEnum.SETEMBRO, CalendarioEnum.getBy("Setembro"));
      assertEquals(CalendarioEnum.OUTUBRO, CalendarioEnum.getBy("Outubro"));
      assertEquals(CalendarioEnum.NOVEMBRO, CalendarioEnum.getBy("Novembro"));
      assertEquals(CalendarioEnum.DEZEMBRO, CalendarioEnum.getBy("Dezembro"));

      assertEquals(CalendarioEnum.JANEIRO, CalendarioEnum.getBy("JANEIRO"));
      assertEquals(CalendarioEnum.JANEIRO, CalendarioEnum.getBy("JAnEiRO"));

      assertNull(CalendarioEnum.getBy(NULL_STRING));
   }

   @Test
   public void testGetByDate() {
      assertEquals(CalendarioEnum.JANEIRO, CalendarioEnum.getBy(this.getDate(Integer.valueOf(this.JANEIRO))));
      assertEquals(CalendarioEnum.FEVEREIRO, CalendarioEnum.getBy(this.getDate(Integer.valueOf(this.FEVEREIRO))));
      assertEquals(CalendarioEnum.MARCO, CalendarioEnum.getBy(this.getDate(Integer.valueOf(this.MARCO))));
      assertEquals(CalendarioEnum.ABRIL, CalendarioEnum.getBy(this.getDate(Integer.valueOf(this.ABRIL))));
      assertEquals(CalendarioEnum.MAIO, CalendarioEnum.getBy(this.getDate(Integer.valueOf(this.MAIO))));
      assertEquals(CalendarioEnum.JUNHO, CalendarioEnum.getBy(this.getDate(Integer.valueOf(this.JUNHO))));
      assertEquals(CalendarioEnum.JULHO, CalendarioEnum.getBy(this.getDate(Integer.valueOf(this.JULHO))));
      assertEquals(CalendarioEnum.AGOSTO, CalendarioEnum.getBy(this.getDate(Integer.valueOf(this.AGOSTO))));
      assertEquals(CalendarioEnum.SETEMBRO, CalendarioEnum.getBy(this.getDate(Integer.valueOf(this.SETEMBRO))));
      assertEquals(CalendarioEnum.OUTUBRO, CalendarioEnum.getBy(this.getDate(Integer.valueOf(this.OUTUBRO))));
      assertEquals(CalendarioEnum.NOVEMBRO, CalendarioEnum.getBy(this.getDate(Integer.valueOf(this.NOVEMBRO))));
      assertEquals(CalendarioEnum.DEZEMBRO, CalendarioEnum.getBy(this.getDate(Integer.valueOf(this.DEZEMBRO))));
      Date data = null;
      assertNull(CalendarioEnum.getBy(data));
   }

   private Date getDate(Integer mes) {

      switch (mes) {
         case NUMERO_INTEIRO_ZERO:
            return null;
         case JANEIRO:
            return new LocalDate(2012, 1, 1).toDate();
         case FEVEREIRO:
            return new LocalDate(2012, 2, 1).toDate();
         case MARCO:
            return new LocalDate(2012, 3, 1).toDate();
         case ABRIL:
            return new LocalDate(2012, 4, 1).toDate();
         case MAIO:
            return new LocalDate(2012, 5, 1).toDate();
         case JUNHO:
            return new LocalDate(2012, 6, 1).toDate();
         case JULHO:
            return new LocalDate(2012, 7, 1).toDate();
         case AGOSTO:
            return new LocalDate(2012, 8, 1).toDate();
         case SETEMBRO:
            return new LocalDate(2012, 9, 1).toDate();
         case OUTUBRO:
            return new LocalDate(2012, 10, 1).toDate();
         case NOVEMBRO:
            return new LocalDate(2012, 11, 1).toDate();
         case DEZEMBRO:
            return new LocalDate(2012, 12, 1).toDate();
      }
      return null;

   }

}
