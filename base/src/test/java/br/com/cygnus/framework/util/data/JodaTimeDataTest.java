package br.com.cygnus.framework.util.data;

import static org.junit.Assert.assertEquals;

import org.joda.time.LocalDate;
import org.junit.Test;

import br.com.cygnus.framework.IObjetoGenerico;

public class JodaTimeDataTest implements IObjetoGenerico {

   private final LocalDate maio = new LocalDate(2012, 5, 1);

   private final JodaTimeData util = new JodaTimeData();

   @Test(expected = IllegalArgumentException.class)
   public void testToLocalDateInvalidoNull() {
      this.util.toLocalDate(null);
   }

   @Test(expected = IllegalArgumentException.class)
   public void testToLocalDateInvalidoEmpty() {
      this.util.toLocalDate(NULL_STRING);
   }

   @Test(expected = IllegalArgumentException.class)
   public void testToLocalDateFormatoInvalido() {
      this.util.toLocalDate("01-01-2012");
   }

   @Test
   public void testToLocalDate() {
      LocalDate expected = new LocalDate(1980, 1, 1);
      assertEquals(expected, this.util.toLocalDate("01/01/1980"));
   }

   @Test(expected = IllegalArgumentException.class)
   public void testToLocalDateIntegerNull() {
      this.util.toLocalDate(null, null, null);
   }

   @Test
   public void testToLocalDateInteger() {
      this.util.toLocalDate(Integer.valueOf(2012), Integer.valueOf(5), Integer.valueOf(1));
   }

   @Test(expected = IllegalArgumentException.class)
   public void testObjterUltimoDiaDoMesNull() {
      this.util.obterUltimoDiaDoMes(null);
   }

   @Test
   public void testObterUltimoDiaDoMes() {

      assertEquals(new LocalDate(2012, 5, 31), this.util.obterUltimoDiaDoMes(this.maio));
   }

   @Test
   public void testObterUltimoDiaDoMesInteger() {
      LocalDate final_maio = new LocalDate(2012, 5, 31);
      assertEquals(final_maio, this.util.obterUltimoDiaDoMes(Integer.valueOf(2012), Integer.valueOf(5)));
   }
}
