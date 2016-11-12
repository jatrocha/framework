/**
 * Utilitários manipulação de datas.
 */
package br.com.cygnus.framework.util.data;

import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import br.com.cygnus.framework.IObjetoGenerico;

/**
 * Wrapper para validacao e manipulacao de datas utilizando a bibliteca JodaTime.
 */
public class JodaTimeData implements IObjetoGenerico {

   /** Dia primeiro do mes. */
   private static final Integer DIA_PRIMEIRO = Integer.valueOf(1);

   /** Data informada invalida para conversao. */
   private static final String DATA_INVALIDA = "Data informada inválida.";

   /** Formatador padrao para datas. */
   private static DateTimeFormatter formatoData = DateTimeFormat.forPattern(FormatoEnum.DD_MM_YYYY.getPadrao());

   /**
    * Converte uma {@link String} em um {@link LocalDate}.
    * 
    * @param origem {@link String} contendo a data de origem.
    * @return {@link LocalDate} formatado.
    */
   public LocalDate toLocalDate(String origem) {

      if (origem == null || origem.isEmpty()) {

         throw new IllegalArgumentException(DATA_INVALIDA);
      }

      try {

         return new LocalDate(formatoData.parseDateTime(origem));

      } catch (Exception e) {

         throw new IllegalArgumentException(DATA_INVALIDA, e);
      }
   }

   /**
    * Constroi um {@link LocalDate} apartir dos parametros informados.
    * 
    * @param ano numero do ano.
    * @param mes numero do mes.
    * @param dia numero do dia.
    * @return {@link LocalDate} formatado.
    */
   public LocalDate toLocalDate(Integer ano, Integer mes, Integer dia) {

      if (ano == null || mes == null || dia == null) {

         throw new IllegalArgumentException(DATA_INVALIDA);
      }

      return new LocalDate(ano, mes, dia);
   }

   /**
    * Recupera um {@link LocalDate} contendo o ultimo dia do mes informado.
    * 
    * @param origem {@link LocalDate} de origem contendo o mes.
    * @return {@link LocalDate} com o dia configurado para o ultimo a partir da origem informada.
    */
   public LocalDate obterUltimoDiaDoMes(LocalDate origem) {

      if (origem == null) {

         throw new IllegalArgumentException(DATA_INVALIDA);
      }

      return origem.dayOfMonth().withMaximumValue();
   }

   /**
    * Recupera um {@link LocalDate} contendo o ultimo dia do mes informado.
    * 
    * @param ano que compoem a data.
    * @param mes que compoem a data.
    * @return {@link LocalDate} com o dia configurado para o ultimo a partir da origem informada.
    */
   public LocalDate obterUltimoDiaDoMes(Integer ano, Integer mes) {

      if (ano == null || mes == null) {

         throw new IllegalArgumentException(DATA_INVALIDA);
      }

      return this.obterUltimoDiaDoMes(this.toLocalDate(ano, mes, DIA_PRIMEIRO));
   }

}
