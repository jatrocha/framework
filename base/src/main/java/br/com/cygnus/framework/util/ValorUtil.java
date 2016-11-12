package br.com.cygnus.framework.util;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * Utilitï¿½rio para Valores.
 */
public class ValorUtil {

   /** Margem de erro aceitï¿½vel para o sistema (utilizado nos TAï¿½s). */
   public static final BigDecimal ERRO_MAX_PRECISAO = new BigDecimal("0.03");

   /**
    * Margem de erro aceitï¿½vel para verificacao do percentural de juros do PROER (utilizado nos TAï¿½s).
    */
   public static final BigDecimal ERRO_MAX_PRECISAO_PERCENTUAL_JUROS = new BigDecimal("0.000000000000001");

   /** Modo de arredondamento utilizado para os cï¿½lculos. */
   public static final RoundingMode MODO_ARREDONDAMENTO = RoundingMode.HALF_UP;

   /** Precisï¿½o para cï¿½lculo de 15 casas decimais. */
   public static final int QUINZE_CASAS_DECIMAIS = 15;

   /** Precisï¿½o para cï¿½lculo de 20 casas decimais. */
   public static final int VINTE_CASAS_DECIMAIS = 20;

   /** Precisão para cálculo de 2 casas decimais. */
   public static final int DUAS_CASAS_DECIMAIS = 2;

   /** Precisão para cálculo de 9 casas decimais. */
   public static final int NOVE_CASAS_DECIMAIS = 9;

   /** Quantidade de casas decimais para arredondamento dos ï¿½ndices. */
   public static final int QTD_CASAS_DECIMAIS_INDICE = 6;

   /** Quantidade de casas decimais para conversï¿½o do ï¿½ndice em percentual do ï¿½ndice. */
   public static final int QTD_CASAS_DECIMAIS_INDICE_PERCENTUAL = 8;

   /** Nï¿½mero 100. Utilizado para cï¿½lculo valor percentual. */
   public static final BigDecimal BASE_PERCENTUAL = BigDecimal.valueOf(100);

   public static final int QTD_CASAS_ARREDONDAMENTO = 2;

   private static final String SEPARADOR_DECIMAL = "\\.";

   private static final int TAMANHO_PARTE_INTEIRA = 13;

   private static final int TAMANHO_PARTE_DECIMAL = 2;

   public static final int QUATRO_CASAS_DECIMAIS = 4;

   public static final BigDecimal CENTENA = BigDecimal.valueOf(100);

   private static final ValorUtil INSTANCE = new ValorUtil();

   /**
    * Obtï¿½m a ï¿½nica instï¿½ncia da classe {@link ValorUtil}.
    * 
    * @return instï¿½ncia de {@link ValorUtil}
    */
   public static ValorUtil get() {
      return INSTANCE;
   }

   /**
    * Verifica se o valor comparado ï¿½ maior que o valor de referï¿½ncia.
    * 
    * @param valor1 referï¿½ncia para a comparaï¿½ï¿½o
    * @param valor2 valor comparado com a referï¿½ncia
    * @return <code>true</code> caso seja maior
    */
   public boolean isMaior(BigDecimal valor1, BigDecimal valor2) {
      return valor1.compareTo(valor2) > 0;
   }

   /**
    * Verifica se o 1ï¿½ valor ï¿½ >= que o 2ï¿½ valor.
    * 
    * @param valor1 1ï¿½ valor
    * @param valor2 2ï¿½ valor
    * 
    * @return se ï¿½ maior ou igual
    */
   public boolean isMaiorOuIgual(BigDecimal valor1, BigDecimal valor2) {
      return valor1.compareTo(valor2) >= 0;
   }

   /**
    * Verifica se o valor1 ï¿½ igual ao valor 2 com tolerï¿½ncia de {@value #ERRO_MAX_PRECISAO}.
    * 
    * @param valor1 valor1
    * @param valor2 valor2
    * @return <code>true</code> caso a diferenï¿½a entre o valor1 e o valor2 seja maior ou igual a tolerï¿½ncia de {@value #ERRO_MAX_PRECISAO}.
    */
   public boolean isIgualComTolerancia(BigDecimal valor1, BigDecimal valor2) {
      return this.isIgualComTolerancia(valor1, valor2, ERRO_MAX_PRECISAO);
   }

   /**
    * Verifica se o valor1 ï¿½ igual ao valor 2 com tolerï¿½ncia informada.
    * 
    * @param valor1 valor1
    * @param valor2 valor2
    * @param erroMaximo valor mï¿½ximo do erro de precisï¿½o
    * @return <code>true</code> caso o valor1 seja igual ao valor2 com a tolerï¿½ncia informada
    */
   public boolean isIgualComTolerancia(BigDecimal valor1, BigDecimal valor2, BigDecimal erroMaximo) {
      BigDecimal diferencaAbsoluta = valor1.subtract(valor2).abs();
      return !this.isMaiorQueTolerancia(diferencaAbsoluta, erroMaximo);
   }

   /**
    * Verifica se o valor1 ï¿½ maior que o valor 2 com tolerï¿½ncia informada.
    * 
    * @param valor1 valor1
    * @param valor2 valor2
    * @param erroMaximo valor mï¿½ximo do erro de precisï¿½o
    * @return <code>true</code> caso o valor1 seja maior que o valor2 com a tolerï¿½ncia informada
    */
   public boolean isMaiorComTolerancia(BigDecimal valor1, BigDecimal valor2, BigDecimal erroMaximo) {
      if (valor1.compareTo(valor2) == 1) {
         BigDecimal diferencaAbsoluta = valor1.subtract(valor2).abs();
         return this.isMaiorQueTolerancia(diferencaAbsoluta, erroMaximo);
      }
      return false;
   }

   private boolean isMaiorQueTolerancia(BigDecimal diferenca, BigDecimal tolerancia) {
      return (diferenca.compareTo(tolerancia) == 1);
   }

   /**
    * Retorna <code>true</code> se o valor passado como parï¿½metro ï¿½ > 0.
    * 
    * @param valor valor testado
    * @return se atende a condiï¿½ï¿½o
    */
   protected boolean isMaiorQueZero(BigDecimal valor) {
      return (valor.compareTo(BigDecimal.ZERO) > 0);
   }

   /**
    * Verifica se o valor ï¿½ positivo.
    * 
    * @param valor valor a ser verificado
    * @return <code>true</code> se o valor for positivo
    */
   public boolean isValorPositivo(BigDecimal valor) {
      return ((valor != null) && (valor.signum() == 1));
   }

   /**
    * Este mï¿½todo valida se o valor tem no mï¿½ximo 13 caracteres antes da vï¿½rgula e 2 apï¿½s a vï¿½rgula.
    * 
    * @param valor Valor a ser validado
    * @return <code>true</code> se o valor estiver dentro do padrï¿½o e <code>false</code> se o valor estiver fora do padrï¿½o
    */
   public boolean validarQuantidadeCaracteres(BigDecimal valor) {

      return this.validarQuantidadeCaracteres(valor, TAMANHO_PARTE_INTEIRA, TAMANHO_PARTE_DECIMAL);
   }

   /**
    * Este mï¿½todo valida se o valor tem no mï¿½ximo a quantidade de caracteres informada.
    * 
    * @param valor Valor a ser validado
    * @param tamanhoParteInteira tamanho mï¿½ximo da parte inteira
    * @param tamanhoParteDecimal tamanho mï¿½ximo da parte decimal
    * @return <code>true</code> se o valor estiver dentro do padrï¿½o e <code>false</code> se o valor estiver fora do padrï¿½o
    */
   public boolean validarQuantidadeCaracteres(BigDecimal valor, int tamanhoParteInteira, int tamanhoParteDecimal) {
      if (valor == null) {
         return false;
      }
      String valorString = valor.toPlainString();
      String[] valores = valorString.split(SEPARADOR_DECIMAL);
      String parteInteira = valores[0];
      String parteDecimal = "";
      if (valores.length > 1) {
         parteDecimal = valores[1];
      }
      if (parteInteira.length() > tamanhoParteInteira) {
         return false;
      }
      if (parteDecimal.length() > tamanhoParteDecimal) {
         return false;
      }
      return true;
   }

   /**
    * Este mï¿½todo arredonda um valor recebido em duas casas decimais.
    * 
    * @param valor valor a ser arredondado
    * @return valor arredondado
    * 
    * @see #arredondar(BigDecimal, int)
    */
   public BigDecimal arredondar(BigDecimal valor) {
      return this.arredondar(valor, QTD_CASAS_ARREDONDAMENTO);
   }

   /**
    * Este mï¿½todo arredonda um valor recebido.
    * 
    * @param valor valor a ser arredondado
    * @param quantidadeCasasDecimais quantidade de cadas decimais do arredondamento
    * @return valor arredondado
    * @see #MODO_ARREDONDAMENTO
    */
   public BigDecimal arredondar(BigDecimal valor, int quantidadeCasasDecimais) {
      return this.arredondar(valor, quantidadeCasasDecimais, MODO_ARREDONDAMENTO);
   }

   /**
    * Este mï¿½todo trunca um valor recebido em duas casas decimais.
    * 
    * @param valor valor a ser truncado
    * @return valor truncado
    * @see #truncar(BigDecimal, int)
    */
   public BigDecimal truncar(BigDecimal valor) {
      return this.truncar(valor, QTD_CASAS_ARREDONDAMENTO);
   }

   /**
    * Este mï¿½todo trunca um valor recebido.
    * 
    * @param valor valor a ser truncado
    * @param quantidadeCasasDecimais quantidade de cadas decimais a partir da qual o nï¿½mero ï¿½ truncado
    * @return valor truncado
    */
   public BigDecimal truncar(BigDecimal valor, int quantidadeCasasDecimais) {
      return this.arredondar(valor, quantidadeCasasDecimais, RoundingMode.DOWN);
   }

   /**
    * Este mï¿½todo arredonda um valor recebido.
    * 
    * @param valor valor a ser arredondado
    * @param quantidadeCasasDecimais quantidade de cadas decimais do arredondamento
    * @param modoArredondamento modo de arredondamento
    * @return valor arredondado
    */
   protected BigDecimal arredondar(BigDecimal valor, int quantidadeCasasDecimais, RoundingMode modoArredondamento) {
      MathContext mathContext = this.calcularMathContext(valor, quantidadeCasasDecimais, modoArredondamento);

      BigDecimal valorArredondado = valor.round(mathContext);
      return valorArredondado.setScale(quantidadeCasasDecimais, modoArredondamento);
   }

   /**
    * Cria o contexto matematico.
    * 
    * @param valor valor a ser arredondado.
    * @param quantidadeCasasDecimais quantidade de casas decimais.
    * @param modoArredondamento modo de arredondamento.
    * @return contexto matematico.
    */
   protected MathContext calcularMathContext(BigDecimal valor, int quantidadeCasasDecimais, RoundingMode modoArredondamento) {

      if (valor == null) {

         return null;
      }

      return new MathContext(valor.toPlainString().replaceAll("-", "").replaceAll(SEPARADOR_DECIMAL, "").length(), modoArredondamento);
   }

   /**
    * Realiza operaï¿½ï¿½o de divisï¿½o. <br>
    * ï¿½ utilizado o modo de arredondamento {@link #MODO_ARREDONDAMENTO}. <br>
    * Arredonda o resultado em {@link #VINTE_CASAS_DECIMAIS}.
    * 
    * @param dividendo dividendo da operaï¿½ï¿½o
    * @param divisor divisor da operaï¿½ï¿½o
    * @return resultado da divisï¿½o
    * @see #VINTE_CASAS_DECIMAIS
    * @see #MODO_ARREDONDAMENTO
    */
   public BigDecimal dividir(BigDecimal dividendo, BigDecimal divisor) {
      return this.dividir(dividendo, divisor, VINTE_CASAS_DECIMAIS);
   }

   /**
    * Realiza operaï¿½ï¿½o de divisï¿½o. <br>
    * ï¿½ utilizado o modo de arredondamento {@link #MODO_ARREDONDAMENTO}.
    * 
    * @param dividendo dividendo da operaï¿½ï¿½o
    * @param divisor divisor da operaï¿½ï¿½o
    * @param quantidadeCasasDecimais quantidade de casas decimais
    * @return resultado da divisï¿½o
    * @see #MODO_ARREDONDAMENTO
    */
   public BigDecimal dividir(BigDecimal dividendo, BigDecimal divisor, int quantidadeCasasDecimais) {
      return dividendo.divide(divisor, quantidadeCasasDecimais, MODO_ARREDONDAMENTO);
   }

   /**
    * Realiza operaï¿½ï¿½o de multiplicaï¿½ï¿½o, arredondando o resultado de acordo com a quantidade de casas decimais passada como parï¿½metro. <br>
    * ï¿½ utilizado o modo de arredondamento {@link #MODO_ARREDONDAMENTO} e precisï¿½o de {@link #VINTE_CASAS_DECIMAIS}.
    * 
    * @param multiplicando multiplicando
    * @param multiplicador multiplicador
    * @return valor multiplicado arredondado
    */
   public BigDecimal multiplicar(BigDecimal multiplicando, BigDecimal multiplicador) {
      return this.multiplicar(multiplicando, multiplicador, VINTE_CASAS_DECIMAIS);
   }

   /**
    * Realiza operaï¿½ï¿½o de multiplicaï¿½ï¿½o, arredondando o resultado de acordo com a quantidade de casas decimais passada como parï¿½metro. <br>
    * ï¿½ utilizado o modo de arredondamento {@link #MODO_ARREDONDAMENTO}.
    * 
    * @param multiplicando multiplicando
    * @param multiplicador multiplicador
    * @param quantidadeCasasDecimais quantidadade de casas decimais
    * @return valor multiplicado arredondado
    */
   public BigDecimal multiplicar(BigDecimal multiplicando, BigDecimal multiplicador, int quantidadeCasasDecimais) {
      BigDecimal multiplicacao = multiplicando.multiply(multiplicador);
      return this.arredondar(multiplicacao, quantidadeCasasDecimais);
   }

   /**
    * Converte um nï¿½mero ï¿½ndice em um percentual.
    * <p>
    * Exemplo: (1.00123 - 1) * 100 = 0.123%
    * 
    * @param numeroIndice nï¿½mero ï¿½ndice
    * @return valor
    */
   public BigDecimal converterNumeroIndiceParaValor(BigDecimal numeroIndice) {
      return this.multiplicar(numeroIndice.subtract(BigDecimal.ONE), BASE_PERCENTUAL);
   }

   /**
    * Converte um percentual em um nï¿½mero ï¿½ndice.
    * <p>
    * Exemplo: ((0.123%) / 100) + 1 = 1.00123
    * 
    * @param valor valor (ex. 0,13)
    * @return nï¿½mero ï¿½ndice (ex. 1,0013)
    */
   public BigDecimal converterValorParaNumeroIndice(BigDecimal valor) {
      return this.converterValorParaNumeroIndice(valor, VINTE_CASAS_DECIMAIS);
   }

   /**
    * Converte um percentual em um nï¿½mero ï¿½ndice.
    * <p>
    * Exemplo: ((0.123%) / 100) + 1 = 1.00123
    * 
    * @param valor valor (ex. 0,13)
    * @param quantidadeCasasDecimais quantidadade de casas decimais
    * @return nï¿½mero ï¿½ndice (ex. 1,0013)
    */
   public BigDecimal converterValorParaNumeroIndice(BigDecimal valor, int quantidadeCasasDecimais) {
      return this.dividir(valor, BASE_PERCENTUAL, quantidadeCasasDecimais).add(BigDecimal.ONE);
   }

   /**
    * Calcula a potencia entre dois numeros.
    * 
    * @param base numero base.
    * @param expoente numero a elevar a base.
    * @return resultado da potencia.
    */
   public BigDecimal elevar(BigDecimal base, BigDecimal expoente) {
      return BigDecimal.valueOf(Math.pow(base.doubleValue(), expoente.doubleValue()));
   }

   /**
    * Calcula a potencia entre dois numeros, truncando o resultado.
    * 
    * @param base numero base.
    * @param expoente numero a elevar a base.
    * @param quantidadeCasasDecimais quantidade de casas decimais a truncar.
    * @return resultado da potencia, truncado.
    */
   public BigDecimal elevar(BigDecimal base, BigDecimal expoente, int quantidadeCasasDecimais) {
      return this.truncar(this.elevar(base, expoente), quantidadeCasasDecimais);
   }
}
