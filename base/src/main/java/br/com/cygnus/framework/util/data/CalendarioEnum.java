package br.com.cygnus.framework.util.data;

import java.util.Calendar;
import java.util.Date;

import br.com.cygnus.framework.IObjetoGenerico;
import br.com.cygnus.framework.util.Validacao;

/**
 * Relaciona o nœmero do mes com o nome.
 */
public enum CalendarioEnum implements IObjetoGenerico {

   JANEIRO(Integer.valueOf(1), "Janeiro", Integer.valueOf(0)),
   FEVEREIRO(Integer.valueOf(2), "Fevereiro", Integer.valueOf(1)),
   MARCO(Integer.valueOf(3), "Março", Integer.valueOf(2)),
   ABRIL(Integer.valueOf(4), "Abril", Integer.valueOf(3)),
   MAIO(Integer.valueOf(5), "Maio", Integer.valueOf(4)),
   JUNHO(Integer.valueOf(6), "Junho", Integer.valueOf(5)),
   JULHO(Integer.valueOf(7), "Julho", Integer.valueOf(6)),
   AGOSTO(Integer.valueOf(8), "Agosto", Integer.valueOf(7)),
   SETEMBRO(Integer.valueOf(9), "Setembro", Integer.valueOf(8)),
   OUTUBRO(Integer.valueOf(10), "Outubro", Integer.valueOf(9)),
   NOVEMBRO(Integer.valueOf(11), "Novembro", Integer.valueOf(10)),
   DEZEMBRO(Integer.valueOf(12), "Dezembro", Integer.valueOf(11));

   /** Numero do mes. */
   private Integer numero;

   /** Nome do mes. */
   private String nome;

   /** Numero para Date. */
   private Integer idDate;

   /**
    * Construtor padrao.
    * 
    * @param numero numero do mes.
    * @param nome nome do mes.
    * @param idDate id para Date.
    */
   private CalendarioEnum(Integer numero, String nome, Integer idDate) {
      this.numero = numero;
      this.nome = nome;
      this.idDate = idDate;
   }

   /**
    * @return the numero
    */
   public Integer getNumero() {
      return this.numero;
   }

   /**
    * @return the nome
    */
   public String getNome() {
      return this.nome;
   }

   /**
    * @return the idDate
    */
   public Integer getIdDate() {
      return this.idDate;
   }

   /**
    * Recupera o <tt>CalendarioEnum</tt> a partir do nœmero do mes.
    * 
    * @param numero numero do mes.
    * @return respectivo (@link CalendarioEnum}.
    */
   public static CalendarioEnum valueOf(Integer numero) {
      CalendarioEnum[] calendarios = values();

      for (CalendarioEnum calendarioEnum : calendarios) {
         if (calendarioEnum.getNumero().equals(numero)) {
            return calendarioEnum;
         }

      }
      return null;
   }

   /**
    * Recupera o <tt>CalendarioEnum</tt> a partir do nome do mes.
    * 
    * @param nome nome do mes.
    * @return respectivo (@link CalendarioEnum}.
    */
   public static CalendarioEnum getBy(String nome) {
      CalendarioEnum[] calendarios = values();

      for (CalendarioEnum calendarioEnum : calendarios) {
         if (calendarioEnum.getNome().equalsIgnoreCase(nome)) {
            return calendarioEnum;
         }

      }
      return null;
   }

   /**
    * Recupera o <tt>CalendarioEnum</tt> a partir de uma data.
    * 
    * @param data data informada.
    * @return respectivo (@link CalendarioEnum}.
    */

   public static CalendarioEnum getBy(Date data) {
      if (Validacao.get().isNotNull(data)) {
         CalendarioEnum[] calendarios = values();

         Calendar cal = Calendar.getInstance();
         cal.setTime(data);

         for (CalendarioEnum calendarioEnum : calendarios) {
            if (calendarioEnum.getIdDate().equals(cal.get(Calendar.MONTH))) {
               return calendarioEnum;
            }
         }
      }
      return null;
   }

}
