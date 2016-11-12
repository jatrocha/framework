package br.com.cygnus.framework.util.data;

import java.util.Calendar;
import java.util.Date;

import br.com.cygnus.framework.IObjetoGenerico;
import br.com.cygnus.framework.util.Validacao;

/**
 * Definicoes dos dias da semana.
 */
public enum DiaDaSemanaEnum implements IObjetoGenerico {

   DOMINGO(Integer.valueOf(1), "domingo"),
   SEGUNDA(Integer.valueOf(2), "segunda-feira"),
   TERCA(Integer.valueOf(3), "terça-feira"),
   QUARTA(Integer.valueOf(4), "quarta-feira"),
   QUINTA(Integer.valueOf(5), "quinta-feira"),
   SEXTA(Integer.valueOf(6), "sexta-feira"),
   SABADO(Integer.valueOf(7), "sábado");

   /** Numero do dia. */
   private Integer numero = null;

   /** Nome do dia. */
   private String nome = null;

   /**
    * Construtor padrao.
    * 
    * @param numero nœmero do dia.
    * @param nome nome do dia.
    */
   private DiaDaSemanaEnum(Integer numero, String nome) {
      this.numero = numero;
      this.nome = nome;
   }

   /**
    * @return numero do dia.
    */
   public Integer getNumero() {
      return this.numero;
   }

   /**
    * @return nome do dia.
    */
   public String getNome() {
      return this.nome;
   }

   /**
    * Recupera o <tt>DiaDaSemanaEnum</tt> a partir do nœmero do dia.
    * 
    * @param numero numero do dia.
    * @return respectivo (@link DiaDaSemanaEnum}.
    */
   public static DiaDaSemanaEnum valueOf(Integer numero) {
      DiaDaSemanaEnum[] diasDaSemana = values();

      for (DiaDaSemanaEnum dias : diasDaSemana) {
         if (dias.getNumero().equals(numero)) {
            return dias;
         }

      }
      return null;
   }

   /**
    * Recupera o <tt>DiaDaSemanaEnum</tt> a partir do nome do dia.
    * 
    * @param nome nome do dia.
    * @return respectivo (@link DiaDaSemanaEnum}.
    */
   public static DiaDaSemanaEnum getBy(String nome) {
      DiaDaSemanaEnum[] diasDaSemana = values();

      for (DiaDaSemanaEnum dias : diasDaSemana) {
         if (dias.getNome().equalsIgnoreCase(nome)) {
            return dias;
         }
      }
      return null;
   }

   /**
    * Recupera o <tt>DiaDaSemanaEnum</tt> a partir de uma data.
    * 
    * @param data data informada.
    * @return respectivo (@link DiaDaSemanaEnum}.
    */
   public static DiaDaSemanaEnum getBy(Date data) {
      if (Validacao.get().isNotNull(data)) {
         DiaDaSemanaEnum[] diasDaSemana = values();

         Calendar cal = Calendar.getInstance();
         cal.setTime(data);

         for (DiaDaSemanaEnum calendarioEnum : diasDaSemana) {
            if (calendarioEnum.getNumero().equals(cal.get(Calendar.DAY_OF_WEEK))) {
               return calendarioEnum;
            }
         }
      }
      return null;
   }

}
