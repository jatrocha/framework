package br.com.cygnus.framework.util;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * F�brica de n�meros para c�lculos.
 */
public class BigDecimalFactory implements Serializable {

   private static final long serialVersionUID = 1L;

   private static final int QUATRO_CASAS_DECIMAIS = 4;

   private static final int DUAS_CASAS_DECIMAIS = 2;

   private static final int NOVE_CASAS_DECIMAIS = 9;

   private static final BigDecimalFactory INSTANCE = new BigDecimalFactory();

   private static final String SEPARADOR_PONTO = ".";

   private static final String SEPARADOR_VIRGULA = ",";

   /**
    * Construtor padr�o.
    */
   protected BigDecimalFactory() {
      super();
   }

   /**
    * Singleton.
    * 
    * @return <tt>BigDecimalFactory</tt> singleton.
    */
   public static BigDecimalFactory get() {

      return INSTANCE;
   }

   /**
    * @param value n�mero a ser truncado.
    * @return n�mero truncado.
    */
   public BigDecimal duasCasasDecimaisTruncado(String value) {

      return new BigDecimal(this.retirarSeparadorVirgula(value)).setScale(DUAS_CASAS_DECIMAIS, RoundingMode.DOWN);
   }

   /**
    * @param bigDecimal n�mero a ser truncado.
    * @return n�mero truncado.
    */
   public BigDecimal duasCasasDecimaisTruncado(BigDecimal bigDecimal) {

      return bigDecimal.setScale(DUAS_CASAS_DECIMAIS, RoundingMode.DOWN);
   }

   /**
    * @param value n�mero a ser arredondado.
    * @return n�mero arredondado.
    */
   public BigDecimal duasCasasDecimaisArredondado(String value) {
      return new BigDecimal(value).setScale(DUAS_CASAS_DECIMAIS, RoundingMode.HALF_UP);
   }

   /**
    * @param bigDecimal n�mero a ser arredondado.
    * @return n�mero arredondado.
    */
   public BigDecimal duasCasasDecimaisArredondado(BigDecimal bigDecimal) {
      return bigDecimal.setScale(DUAS_CASAS_DECIMAIS, RoundingMode.HALF_UP);
   }

   /**
    * @param value n�mero a ser truncado.
    * @return n�mero truncado.
    */
   public BigDecimal quatroCasasDecimaisTruncado(String value) {
      String temp = this.retirarSeparadorVirgula(value);
      return new BigDecimal(temp).setScale(QUATRO_CASAS_DECIMAIS, RoundingMode.DOWN);
   }

   /**
    * @param bigDecimal n�mero a ser truncado.
    * @return n�mero truncado.
    */
   public BigDecimal quatroCasasDecimaisTruncado(BigDecimal bigDecimal) {
      return bigDecimal != null ? bigDecimal.setScale(QUATRO_CASAS_DECIMAIS, RoundingMode.DOWN) : null;
   }

   /**
    * @param bigDecimal n�emro a ser arredondado.
    * @return n�mero arredondado.
    */
   public BigDecimal quatroCasasDecimaisArredondado(BigDecimal bigDecimal) {
      return bigDecimal.setScale(QUATRO_CASAS_DECIMAIS, RoundingMode.HALF_UP);
   }

   /**
    * @param valor n�mero a ser truncado.
    * @return n�mero truncado.
    */
   public BigDecimal noveCasasDecimaisTruncado(String valor) {
      return new BigDecimal(valor).setScale(NOVE_CASAS_DECIMAIS, RoundingMode.DOWN);
   }

   /**
    * @param bigDecimal n�mero a ser truncado.
    * @return n�mero truncado.
    */
   public BigDecimal noveCasasDecimaisTruncado(BigDecimal bigDecimal) {
      return bigDecimal.setScale(NOVE_CASAS_DECIMAIS, RoundingMode.DOWN);
   }

   /**
    * @param value
    * @return
    */
   private String retirarSeparadorVirgula(String value) {

      if (Validacao.get().isNotEmpty(value) && value.contains(SEPARADOR_VIRGULA)) {

         return value.replace(SEPARADOR_VIRGULA, SEPARADOR_PONTO);
      }

      return value;
   }

}
