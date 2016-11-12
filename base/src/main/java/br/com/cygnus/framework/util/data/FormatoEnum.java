package br.com.cygnus.framework.util.data;

import br.com.cygnus.framework.IObjetoGenerico;

/**
 * String contendo padroes para formatacao de data.
 */
public enum FormatoEnum implements IObjetoGenerico {

   /** Dia mes ano. */
   DD_MM_YYYY("dd/MM/yyyy"),
   /** Dia e Mes. */
   DD_MM("dd/MM"),
   /** Data e hora, formato 24h. */
   DD_MM_YYYY_HH_MM_SS("dd/MM/yyyy HH:mm:ss"),
   /** Dia mes ano. */
   YYYYMMDD("yyyyMMdd"),
   /** Dia mes ano. */
   DDMMYYYY("ddMMyyyy");

   /** Padrao que define o formato. */
   private String padrao;

   /**
    * Construtor.
    * 
    * @param padrao definido por um padrao.
    */
   private FormatoEnum(final String padrao) {
      this.padrao = padrao;
   }

   /**
    * @return formato definido por um padrao.
    */
   public final String getPadrao() {
      return this.padrao;
   }

}
