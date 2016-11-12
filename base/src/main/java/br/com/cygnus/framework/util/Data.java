package br.com.cygnus.framework.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import br.com.cygnus.framework.AObjetoGenerico;
import br.com.cygnus.framework.util.data.CalendarioEnum;

/**
 * Funcoes genericas para manipulacao e validacao de Datas.
 */
public class Data extends AObjetoGenerico {

   /** Formato desejado. */
   protected static final String FORMATO_DESEJADO = "Formato";

   /** Data informada. */
   protected static final String CAMPO_DATA = "Data";

   /** Singleton. */
   private static Data singleton = new Data();

   /** Locale do Brasil. */
   private static Locale locale = new Locale("pt", "BR");

   /** Calend‡rio. */
   private Calendar calendar = null;

   /**
    * Construtor padrao.
    */
   public Data() {
      super();
      this.calendar = Calendar.getInstance();
   }

   /**
    * Recupera instancia unica da classe.
    * 
    * @return Instancia unica da classe.
    */
   public static Data get() {
      return singleton;
   }

   /**
    * @param calendar calendario.
    */
   protected void setCalendar(Calendar calendar) {
      this.calendar = calendar;
   }

   /**
    * @return calendario.
    */
   protected Calendar getCalendar() {
      return this.calendar;
   }

   /**
    * Configura um calend‡rio de acordo com a sua data.
    * 
    * @param data data informada.
    * @return respectivo calendario.
    */
   protected Calendar getCalendar(Date data) {
      Calendar cal = Calendar.getInstance();
      cal.setTime(data);
      return cal;
   }

   /**
    * Retorna uma instancia do Local Brasil.
    * 
    * @return Local Brasileiro
    */
   protected Locale getDefaultLocale() {
      return locale;
   }

   /**
    * Data e hora por extenso. Ex: "segunda, 01 de janeiro de 2004 00:00"
    * 
    * @param data A data a formatar.
    * @return String com a data por extenso.
    */
   public String getDataExtenso(Date data) {
      Validacao.get().validarObrigatorio(data, CAMPO_DATA);
      SimpleDateFormat format = new SimpleDateFormat("EEEEEEEEEEEEE, dd 'de' MMMMMMMMM 'de' yyyy HH:mm", this.getDefaultLocale());
      return format.format(data);
   }

   /**
    * Formata uma string para um objeto java.util.Date de acordo com o pattern informado.
    * 
    * @param date A data a ser formatada.
    * @param pattern O formato desejado.
    * @return String com a data formatada.
    */
   public String formatar(Date date, String pattern) {
      Validacao.get().validarObrigatorio(date, CAMPO_DATA);
      return new SimpleDateFormat(pattern).format(date);
   }

   /**
    * Formata uma string para um objeto java.util.Date de acordo com o pattern informado.
    * 
    * @param data A data a ser formatada.
    * @param pattern O formato desejado.
    * @return Date. Caso aconteca alguma excecao, ser‡ retornado "null".
    */
   public Date formatar(String data, String pattern) {
      Validacao.get().validarObrigatorio(data, CAMPO_DATA);
      Validacao.get().validarObrigatorio(pattern, FORMATO_DESEJADO);
      try {
         return new SimpleDateFormat(pattern, this.getDefaultLocale()).parse(data);
      } catch (ParseException e) {
         return null;
      }
   }

   /**
    * Recupera o ano de uma determinada data.
    * 
    * @param data data informada.
    * @return ano.
    */
   public Integer getAno(Date data) {
      if (Validacao.get().isNull(data)) {
         return null;
      }
      return Integer.valueOf(this.getCalendar(data).get(Calendar.YEAR));
   }

   /**
    * Recupera o mes de uma determinada data.
    * 
    * @param data data informada.
    * @return mes.
    */
   public CalendarioEnum getMes(Date data) {
      if (Validacao.get().isNull(data)) {
         return null;
      }
      return CalendarioEnum.getBy(data);
   }

   /**
    * Zera as Horas, Minutos, Segundos e Milisegundos de um {@link Date}.
    * 
    * @param data a data.
    * @return date com as horas, minutos, segundos e milisegundos zerados.
    */
   public Date zerarHorasMinutosSegundos(Date data) {
      if (Validacao.get().isNull(data)) {
         return null;
      }

      Calendar calFim = Calendar.getInstance(this.getDefaultLocale());
      calFim.setTime(data);
      calFim.set(Calendar.HOUR_OF_DAY, NUMERO_INTEIRO_ZERO);
      calFim.set(Calendar.MINUTE, NUMERO_INTEIRO_ZERO);
      calFim.set(Calendar.SECOND, NUMERO_INTEIRO_ZERO);
      calFim.set(Calendar.MILLISECOND, NUMERO_INTEIRO_ZERO);
      return calFim.getTime();
   }
}
