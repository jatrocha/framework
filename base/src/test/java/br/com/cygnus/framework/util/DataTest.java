package br.com.cygnus.framework.util;

import static junit.framework.Assert.fail;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Calendar;
import java.util.Date;

import org.joda.time.LocalDate;
import org.junit.Test;

import br.com.cygnus.framework.AObjetoGenerico;
import br.com.cygnus.framework.IConstantes;
import br.com.cygnus.framework.IMensagens;
import br.com.cygnus.framework.util.data.CalendarioEnum;
import br.com.cygnus.framework.util.data.DiaDaSemanaEnum;

public class DataTest extends AObjetoGenerico {

   private static final String EXCEPTION_NAO_LANCADA = "Exception não lançada! =/";

   @Test
   public void testGetDataExtenso() {
      assertEquals("Segunda-feira, 02 de Janeiro de 2012 00:00", Data.get().getDataExtenso(this.getDate(9)));

   }

   @Test
   public void testGetDataExtensoInvalido() {
      try {
         Data.get().getDataExtenso(null);
         fail(EXCEPTION_NAO_LANCADA);
      } catch (IllegalArgumentException e) {
         assertEquals(Mensagem.get().getMensagem(IMensagens.FRA016, new String[] { Data.CAMPO_DATA }), e.getMessage());
      }

   }

   @Test
   public void testStringFormatar() {
      assertEquals("10/03/2012", Data.get().formatar(this.getDate(DiaDaSemanaEnum.SABADO.getNumero()), IConstantes.PATTERN_DD_MM_YYYY));
      assertEquals("10/03/2012 00:00:00", Data.get().formatar(this.getDate(DiaDaSemanaEnum.SABADO.getNumero()), IConstantes.PATTERN_DD_MM_YYYY_HH_MM_SS));
      assertEquals("10/03", Data.get().formatar(this.getDate(DiaDaSemanaEnum.SABADO.getNumero()), IConstantes.PATTERN_DD_MM));

      assertEquals("10032012", Data.get().formatar(this.getDate(DiaDaSemanaEnum.SABADO.getNumero()), IConstantes.PATTERN_DDMMYYYY));
      assertEquals("20120310", Data.get().formatar(this.getDate(DiaDaSemanaEnum.SABADO.getNumero()), IConstantes.PATTERN_YYYYMMDD));

   }

   @Test
   public void testFormatarDataInvalido() {
      try {
         Date data = null;
         Data.get().formatar(data, NULL_STRING);
         fail(EXCEPTION_NAO_LANCADA);
      } catch (IllegalArgumentException e) {
         assertEquals(Mensagem.get().getMensagem(IMensagens.FRA016, new String[] { Data.CAMPO_DATA }), e.getMessage());
      }
   }

   @Test
   public void testGetAnoInvalido() {
      assertNull(Data.get().getAno(null));
   }

   @Test
   public void testGetAno() {
      assertEquals(Integer.valueOf(2012), Data.get().getAno(this.getDate(DiaDaSemanaEnum.SABADO.getNumero())));
   }

   @Test
   public void testGetMesInvalido() {
      assertNull(Data.get().getMes(null));
   }

   @Test
   public void testGetMes() {
      assertEquals(CalendarioEnum.MARCO, Data.get().getMes(this.getDate(DiaDaSemanaEnum.SABADO.getNumero())));
   }

   @Test
   public void testZerarHorasMinutosSegundosInvalido() {
      assertNull(Data.get().zerarHorasMinutosSegundos(null));
   }

   @Test
   public void testZerarHorasMinutosSegundos() {
      assertEquals(this.getDate(DiaDaSemanaEnum.SABADO.getNumero()), Data.get().zerarHorasMinutosSegundos(this.getDate(DiaDaSemanaEnum.SABADO.getNumero())));
   }

   protected Date getDate(Integer diaDaSemana) {

      switch (diaDaSemana) {
         case 0:
            return null;
         case Calendar.SUNDAY:
            return new LocalDate(2012, 3, 11).toDate();
         case Calendar.MONDAY:
            return new LocalDate(2012, 3, 5).toDate();
         case Calendar.TUESDAY:
            return new LocalDate(2012, 3, 6).toDate();
         case Calendar.WEDNESDAY:
            return new LocalDate(2012, 3, 7).toDate();
         case Calendar.THURSDAY:
            return new LocalDate(2012, 3, 8).toDate();
         case Calendar.FRIDAY:
            return new LocalDate(2012, 3, 9).toDate();
         case Calendar.SATURDAY:
            return new LocalDate(2012, 3, 10).toDate();
         default:
            return new LocalDate(2012, 1, 2).toDate();
      }
   }

}
