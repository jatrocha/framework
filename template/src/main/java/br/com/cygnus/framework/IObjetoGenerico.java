package br.com.cygnus.framework;

/**
 * Classe <tt>IObjetoGenerico</tt> base da implementacao.
 */
public interface IObjetoGenerico {

   /** String vazia para comparacao. */
   String NULL_STRING = "";

   /** Character vazio para comparacao. */
   Character NULL_CHAR = Character.valueOf(' ');

   /** Inteiro vazio (valor 0) para comparacao. */
   int NUMERO_INTEIRO_ZERO = 0;

   /** Longo vazio (valor 0) para comparacao. */
   long NUMERO_LONGO_ZERO = 0;

   /** Byte vazio (valor 0) para comparacao. */
   byte NUMERO_BYTE_ZERO = 0;

   /** Integer vazio (valor 0) para comparacao. */
   Integer WRAPPER_INTEGER_ZERO = Integer.valueOf(NUMERO_INTEIRO_ZERO);

   /** Long vazio (valor 0) para comparacao. */
   Long WRAPPER_LONG_ZERO = Long.valueOf(NUMERO_INTEIRO_ZERO);

   /** Double vazio (valor 0) para comparacao. */
   Double WRAPPER_DOUBLE_ZERO = Double.valueOf(NUMERO_INTEIRO_ZERO);

   /** Byte vazio (valor 0) para comparacao. */
   Byte WRAPPER_BYTE_ZERO = Byte.valueOf(NUMERO_BYTE_ZERO);

   /** Short vazio (valor 0) para comparacao. */
   Short WRAPPER_SHORT_ZERO = Short.valueOf((short) NUMERO_INTEIRO_ZERO);

}
