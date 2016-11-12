package br.com.cygnus.framework;

/**
 * Classe <tt>IConstantes</tt> que sao utilizadas pelo framework.
 * 
 * @deprecated
 */
@Deprecated
public interface IConstantes extends IObjetoGenerico {

   // Comparacao ------------------------------------------------------

   /** Representa o valor True para os campos booleanos. */
   String SIM = "S";

   /** Representa o valor False para os campos booleanos. */
   String NAO = "N";

   /** Representa o valor True para os campos booleanos. */
   String TRUE = "true";

   /** Representa o valor False para os campos booleanos. */
   String FALSE = "false";

   // Comparacao ------------------------------------------------------

   // Formatacao ------------------------------------------------------

   /**
    * Padrao de formatacao de moeda.
    */
   String PATTERN_COTACAO_MOEDA = "#,##0.00;-#,##0.00";

   // Formatacao ------------------------------------------------------

   // Configuracoes ---------------------------------------------------

   /**
    * Nome da pasta dos arquivos de properties.
    */
   String PASTA_PROPERTIES = "properties/";

   /**
    * Nome do arquivo das mensagens de erro.
    */
   String ARQUIVO_MENSAGEM_ERRO = "mensagens";

   /**
    * Caminho para o arquivo das mensagens de erro.
    */
   String ARQUIVO_MENSAGEM_ERRO_PATH = PASTA_PROPERTIES.concat(ARQUIVO_MENSAGEM_ERRO);

   // Configuracoes ----------------------------------------------------

   // Mensagens --------------------------------------------------------

   // Mensagens --------------------------------------------------------

   // Datas ------------------------------------------------------------

   /**
    * Patern de formatacao de data: dd/MM/yyyy.
    */
   String PATTERN_DD_MM_YYYY = "dd/MM/yyyy";

   /**
    * Patern de formatacao de data: dd/MM.
    */
   String PATTERN_DD_MM = "dd/MM";

   /**
    * Patern de formatacao de data: dd/MM/yyyy HH:mm:sss.
    */
   String PATTERN_DD_MM_YYYY_HH_MM_SS = "dd/MM/yyyy HH:mm:ss";

   /**
    * Patern de formatacao de data: yyyyMMdd.
    */
   String PATTERN_YYYYMMDD = "yyyyMMdd";

   /**
    * Patern de formatacao de data: ddMMyyyy.
    */
   String PATTERN_DDMMYYYY = "ddMMyyyy";

   // Datas ------------------------------------------------------------

}
