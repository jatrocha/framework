/**
 *
 */
package br.com.cygnus.framework.util.criptografia;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import br.com.cygnus.framework.AObjetoGenerico;
import br.com.cygnus.framework.IMensagens;
import br.com.cygnus.framework.exception.FrameworkException;
import br.com.cygnus.framework.log.Log;
import br.com.cygnus.framework.template.log.ILog;
import br.com.cygnus.framework.util.Validacao;

/**
 * Classe <tt>MD5</tt> apresenta funcao para criptografar um texto.
 */
public class MD5 extends AObjetoGenerico {

   /** Parte do calculo. */
   private static final int ZERO_X_FF = 0xFF;

   /** Algoritmo para criptografia. */
   private String algoritmo = "MD5";

   /** Sequencia hexa-decimal para o substituicao no calculo. */
   private static final String HEX_DIGITS = "0123456789abcdef";

   /** Parte do c‡lculo. */
   private static final int SIXTEEN = 16;

   /** Singleton. */
   private static MD5 singleton = new MD5();

   /** Instancia da classe de log. */
   private final ILog<MD5> log = Log.get(MD5.class);

   /**
    * Construtor padrao.
    */
   protected MD5() {
      super();
   }

   /**
    * @return Instancia unica da classe.
    */
   public static MD5 get() {
      return singleton;
   }

   /**
    * Realiza um digest em um array de bytes atraves do algoritmo selecionado.
    *
    * @param input array de bytes a ser criptografado.
    * @param algoritmo algoritmo a ser utilizado.
    * @return O resultado da criptografia
    * @throws NoSuchAlgorithmException Caso o algoritmo fornecido nao seja valido
    */
   private byte[] digest(byte[] input, String algoritmo) throws NoSuchAlgorithmException {
      final MessageDigest md = MessageDigest.getInstance(algoritmo);
      md.reset();
      return md.digest(input);
   }

   /**
    * Converte o array de bytes em uma representacao hexadecimal.
    *
    * @param input O array de bytes a ser convertido.
    * @return Uma String com a representacao hexa do array
    */
   private String byteArrayToHexString(byte[] input) {
      final StringBuffer buf = new StringBuffer();

      for (final byte element : input) {
         final int j = element & ZERO_X_FF;
         buf.append(HEX_DIGITS.charAt(j / SIXTEEN));
         buf.append(HEX_DIGITS.charAt(j % SIXTEEN));
      }

      return buf.toString();
   }

   /**
    * Gera o hash md5 da String informada.
    *
    * @param origem Texto de origem.
    * @return String contendo o hash MD5 gerado.
    * @throws FrameworkException caso n‹o se ache o algoritmo de criptgrafia adequado.
    */
   public String criptografar(String origem) throws FrameworkException {
      Validacao.get().validarObrigatorio(origem, "origem");
      try {
         return this.byteArrayToHexString(this.digest(origem.getBytes(), this.algoritmo));
      } catch (final NoSuchAlgorithmException e) {
         this.log.error(new FrameworkException(IMensagens.FRA023), e.getMessage());
         throw new FrameworkException(IMensagens.FRA023, e);
      }
   }

   /**
    *
    * @param algoritmo tipo do algoritmo a se utilizar.
    */
   protected void setAlgoritmo(String algoritmo) {
      this.algoritmo = algoritmo;
   }

}
