package br.com.cygnus.framework.util;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNull;
import static junit.framework.Assert.assertTrue;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import org.junit.Before;
import org.junit.Test;

/**
 * Classe de teste para o {@link ValorUtil}.
 */
public class ValorUtilTest {

   private ValorUtil valorUtil;

   /**
    * Configura��es para o teste.
    */
   @Before
   public void setUp() {
      this.valorUtil = ValorUtil.get();
   }

   /**
    * Teste do m�todo de verifica��o da quantidade de caracteres do valor do .
    * 
    * Caso de teste: valor do com 13 caracteres antes da v�rgula e 2 caracteres depois da v�rgula.
    */
   @Test
   public void testValidarQuantidadeCaracteres() {
      assertTrue(this.valorUtil.validarQuantidadeCaracteres(new BigDecimal("1234567891234.99")));
   }

   /**
    * Teste do m�todo de verifica��o da quantidade de caracteres do valor do .
    * 
    * Caso de teste: valor do com 13 caracteres antes da v�rgula e NENHUM caracter depois da v�rgula.
    */
   @Test
   public void testValidarQuantidadeCaracteresCom13CaracteresAntesDaVirgulaENenhumDepois() {
      assertTrue(this.valorUtil.validarQuantidadeCaracteres(new BigDecimal("1234567891234")));
   }

   /**
    * Teste do m�todo de verifica��o da quantidade de caracteres do valor do .
    * 
    * Caso de teste: valor do com 15 caracteres antes da v�rgula e NENHUM caracter depois da v�rgula.
    */
   @Test
   public void testValidarQuantidadeCaracteresCom15CaracteresAntesDaVirgulaENenhumDepois() {
      assertFalse(this.valorUtil.validarQuantidadeCaracteres(new BigDecimal("123456789123456")));
   }

   /**
    * Teste do m�todo de verifica��o da quantidade de caracteres do valor do .
    * 
    * Caso de teste: valor do com 15 caracteres antes da v�rgula e 3 caracteres depois da v�rgula.
    */
   @Test
   public void testValidarQuantidadeCaracteresCom15CaracteresAntesDaVirgulaE3Depois() {
      assertFalse(this.valorUtil.validarQuantidadeCaracteres(new BigDecimal("123456789123456.123")));
   }

   /**
    * Teste do m�todo de verifica��o da quantidade de caracteres do valor do .
    * 
    * Caso de teste: valor do com 10 caracteres antes da v�rgula e 3 caracteres depois da v�rgula.
    */
   @Test
   public void testValidarQuantidadeCaracteresCom10CaracteresAntesDaVirgulaE3Depois() {
      assertFalse(this.valorUtil.validarQuantidadeCaracteres(new BigDecimal("1234567890.123")));
   }

   /**
    * Teste do m�todo de verifica��o da quantidade de caracteres do valor do .
    * 
    * Caso de teste: valor do <code>null</code>.
    */
   @Test
   public void testValidarQuantidadeCaracteresNull() {
      assertFalse(this.valorUtil.validarQuantidadeCaracteres(null));
   }

   @Test
   public void testIsValorPositivoNull() {
      assertFalse(this.valorUtil.isValorPositivo(null));
   }

   /**
    * Teste do m�todo: {@link ValorUtil#isValorPositivo(BigDecimal)}.
    * <p>
    * Caso de teste: valor negativo.
    */
   @Test
   public void testIsValorPositivoValorNegativo() {
      assertFalse(this.valorUtil.isValorPositivo(new BigDecimal(-1)));
   }

   /**
    * Teste do m�todo: {@link ValorUtil#isValorPositivo(BigDecimal)}.
    * <p>
    * Caso de teste: valor zero.
    */
   @Test
   public void testIsValorPositivoValorZero() {
      assertFalse(this.valorUtil.isValorPositivo(BigDecimal.ZERO));
   }

   /**
    * Teste do m�todo: {@link ValorUtil#isValorPositivo(BigDecimal)}.
    * <p>
    * Caso de teste: valor maior que zero.
    */
   @Test
   public void testIsValorPositivoMaiorQueZero() {
      assertTrue(this.valorUtil.isValorPositivo(BigDecimal.ONE));
   }

   /**
    * Teste do m�todo: {@link ValorUtil#arredondar(BigDecimal)}.
    * <p>
    * Caso de teste: N�mero com precis�o maior que a quantidade de casas decimais padr�o.
    */
   @Test
   public void testArredondarComQuantidadeDeCasasDecimaisPadrao() {
      BigDecimal valorNaoArredondado = new BigDecimal("1.123456780123456789");
      BigDecimal valorArredondado = new BigDecimal("1.12");
      BigDecimal valorRecebido = this.valorUtil.arredondar(valorNaoArredondado);
      assertEquals(valorArredondado, valorRecebido);
   }

   /**
    * Teste do m�todo: {@link ValorUtil#arredondar(BigDecimal, int)}.
    * <p>
    * Caso de teste: N�mero NEGATIVO com precis�o maior que a quantidade de casas decimais padr�o. <br>
    * Bug evidenciado: Ap�s a quantidade de casas arredondadas, qualquer n�mero >= 45 quebrava o teste, por causa que o sinal negativo (-) estava sendo
    * contado como quantidade total de d�gitos do n�mero.
    */
   @Test
   public void testArredondarNumeroNegativoMaiorOuIgual45() {
      BigDecimal valorNaoArredondado = new BigDecimal("-113636202.224511");
      BigDecimal valorArredondado = new BigDecimal("-113636202.22");
      BigDecimal valorRecebido = this.valorUtil.arredondar(valorNaoArredondado, 2);
      assertEquals(valorArredondado, valorRecebido);
   }

   /**
    * Teste do m�todo: {@link ValorUtil#arredondar(BigDecimal, int)}.
    * <p>
    * Caso de teste: N�mero NEGATIVO com precis�o maior que a quantidade de casas decimais padr�o. <br>
    * Bug evidenciado: Ap�s a quantidade de casas arredondadas, qualquer n�mero >= 45 quebrava o teste, por causa que o sinal negativo (-) estava sendo
    * contado como quantidade total de d�gitos do n�mero.
    */
   @Test
   public void testArredondarNumeroNegativoMenor45() {
      BigDecimal valorNaoArredondado = new BigDecimal("-113636202.224411");
      BigDecimal valorArredondado = new BigDecimal("-113636202.22");
      BigDecimal valorRecebido = this.valorUtil.arredondar(valorNaoArredondado, 2);
      assertEquals(valorArredondado, valorRecebido);
   }

   /**
    * Teste do m�todo: {@link ValorUtil#arredondar(BigDecimal, int)}.
    * <p>
    * Caso de teste: 1.123456789 deve ser arredondado para 1.12345679. Precis�o de 8 casas decimais.
    */
   @Test
   public void testArredondarComNumeroDeCasasDecimais() {
      BigDecimal valorNaoArredondado = new BigDecimal("1.123456789");
      BigDecimal valorArredondado = new BigDecimal("1.12345679");
      BigDecimal valorRecebido = this.valorUtil.arredondar(valorNaoArredondado, ValorUtil.QTD_CASAS_DECIMAIS_INDICE_PERCENTUAL);
      assertEquals(valorArredondado, valorRecebido);
   }

   /**
    * Teste do m�todo: {@link ValorUtil#arredondar(BigDecimal, int)}.
    * <p>
    * Caso de teste: M�todo de arredondamento {@link java.math.RoundingMode#HALF_UP}. Precis�o de 8 casas decimais.
    */
   @Test
   public void testArredondarModoDeArredondamento() {
      BigDecimal valorNaoArredondado = new BigDecimal("1.123456785");
      BigDecimal valorArredondado = new BigDecimal("1.12345679");
      BigDecimal valorRecebido = this.valorUtil.arredondar(valorNaoArredondado, ValorUtil.QTD_CASAS_DECIMAIS_INDICE_PERCENTUAL);
      assertEquals(valorArredondado, valorRecebido);

      valorNaoArredondado = new BigDecimal("1.123456786");
      valorArredondado = new BigDecimal("1.12345679");
      valorRecebido = this.valorUtil.arredondar(valorNaoArredondado, ValorUtil.QTD_CASAS_DECIMAIS_INDICE_PERCENTUAL);
      assertEquals(valorArredondado, valorRecebido);

      valorNaoArredondado = new BigDecimal("1.123456784");
      valorArredondado = new BigDecimal("1.12345678");
      valorRecebido = this.valorUtil.arredondar(valorNaoArredondado, ValorUtil.QTD_CASAS_DECIMAIS_INDICE_PERCENTUAL);
      assertEquals(valorArredondado, valorRecebido);

      valorNaoArredondado = new BigDecimal("1.123456784");
      valorArredondado = BigDecimal.ONE;
      valorRecebido = this.valorUtil.arredondar(valorNaoArredondado, 0);
      assertEquals(valorArredondado, valorRecebido);

      valorNaoArredondado = new BigDecimal("109401481.88478700");
      valorArredondado = new BigDecimal("109401481.88478700");
      valorRecebido = this.valorUtil.arredondar(valorNaoArredondado, ValorUtil.QTD_CASAS_DECIMAIS_INDICE_PERCENTUAL);
      assertEquals(valorArredondado, valorRecebido);
   }

   /**
    * Teste do m�todo: {@link ValorUtil#arredondar(BigDecimal, int)}.
    * <p>
    * Caso de teste: 1 deve ser arredondado para 1.000000. Precis�o de 6 casas decimais.
    */
   @Test
   public void testArredondarNumeroInteiro() {
      BigDecimal valorNaoArredondado = BigDecimal.ONE;
      BigDecimal valorArredondado = new BigDecimal("1.000000");
      BigDecimal valorRecebido = this.valorUtil.arredondar(valorNaoArredondado, ValorUtil.QTD_CASAS_DECIMAIS_INDICE);
      assertEquals(valorArredondado, valorRecebido);
   }

   /**
    * Testes do m�todo: {@link ValorUtil#truncar(BigDecimal)}. <br>
    * Cen�rio: quantidade de casas padr�o.
    */
   @Test
   public void testTruncarComQuantidadeDeCasasDecimaisPadrao() {
      this.assertTruncar("pr�ximo digito depois da casa truncada < 5", "23.12", "23.123456789");
      this.assertTruncar("pr�ximo digito depois da casa truncada > 5", "23.12", "23.129945678");

      this.assertTruncar("n�mero inteiro sendo truncado para decimal", "0.00", "0");

      String msg = "n�mero grande sendo truncado em 1, com pr�ximo n�mero " //
            + "depois da casa truncada cheio de noves";
      this.assertTruncar(msg, "1.00", "1.000099999999999999999999999999999999999999999999999999999999999999999990");
   }

   private void assertTruncar(String msg, String valorEsperado, String valor) {
      BigDecimal valorTruncadoEsperado = new BigDecimal(valorEsperado);
      BigDecimal valorTruncado = this.valorUtil.truncar(new BigDecimal(valor));
      assertEquals(msg, valorTruncadoEsperado, valorTruncado);
   }

   /**
    * Testes do m�todo: {@link ValorUtil#truncar(BigDecimal, int)}. <br>
    * Cen�rio: com quantidade de casas decimais informada.
    */
   @Test
   public void testTruncarComQuantidadeDeCasasDecimaisInformada() {
      this.assertTruncar("pr�ximo digito depois da casa truncada < 5", "23.1234", "23.1234156789", 4);
      this.assertTruncar("pr�ximo digito depois da casa truncada > 5", "23.12345", "23.123456789", 5);

      this.assertTruncar("n�mero inteiro sendo truncado para decimal", "0.0", "0", 1);

      String msg = "n�mero grande sendo truncado em 1, com pr�ximo n�mero " //
            + "depois da casa truncada cheio de noves";
      this.assertTruncar(msg, "1.0000", "1.000099999999999999999999999999999999999999999999999999999999999999999990", 4);
   }

   private void assertTruncar(String msg, String valorEsperado, String valor, int qtdCasasDecimais) {
      BigDecimal valorTruncadoEsperado = new BigDecimal(valorEsperado);
      BigDecimal valorTruncado = this.valorUtil.truncar(new BigDecimal(valor), qtdCasasDecimais);
      assertEquals(msg, valorTruncadoEsperado, valorTruncado);
   }

   /**
    * Teste do m�todo: {@link ValorUtil#isMaiorQueZero(BigDecimal)}.
    */
   @Test
   public void testIsMaiorQueZero() {
      assertTrue("positivo", this.valorUtil.isMaiorQueZero(new BigDecimal("0.00000001")));
      assertFalse("zero", this.valorUtil.isMaiorQueZero(BigDecimal.ZERO));
      assertFalse("zero scala 6 digitos", this.valorUtil.isMaiorQueZero(new BigDecimal("0.000000")));
      assertFalse("negativo", this.valorUtil.isMaiorQueZero(new BigDecimal("-0.00000000000000001")));
   }

   /**
    * Teste do m�todo {@link ValorUtil#isMaior(BigDecimal, BigDecimal)}.
    */
   @Test
   public void testIsMaiorValorComparadoMenorValorReferencia() {
      assertTrue(this.valorUtil.isMaior(BigDecimal.ONE, BigDecimal.ZERO));
   }

   /**
    * Teste do m�todo {@link ValorUtil#isMaior(BigDecimal, BigDecimal)}.
    */
   @Test
   public void testIsMaiorValorComparadoMaiorValorReferencia() {
      assertFalse(this.valorUtil.isMaior(BigDecimal.ZERO, BigDecimal.ONE));
   }

   /**
    * Teste do m�todo {@link ValorUtil#isMaior(BigDecimal, BigDecimal)}.
    */
   @Test
   public void testIsMaiorValorComparadoIgualValorReferencia() {
      assertFalse(this.valorUtil.isMaior(BigDecimal.ONE, BigDecimal.ONE));
   }

   /**
    * Teste do m�todo {@link ValorUtil#isMaiorOuIgual(BigDecimal, BigDecimal)}.
    */
   @Test
   public void testIsMaiorOuIgualValor1MaiorValor2() {
      assertTrue(this.valorUtil.isMaiorOuIgual(BigDecimal.ONE, BigDecimal.ZERO));
   }

   /**
    * Teste do m�todo {@link ValorUtil#isMaiorOuIgual(BigDecimal, BigDecimal)}.
    */
   @Test
   public void testIsMaiorOuIgualValor1MenorValor2() {
      assertFalse(this.valorUtil.isMaiorOuIgual(BigDecimal.ZERO, BigDecimal.ONE));
   }

   /**
    * Teste do m�todo {@link ValorUtil#isMaiorOuIgual(BigDecimal, BigDecimal)}.
    */
   @Test
   public void testIsMaiorOuIgualValor1IgualValor2() {
      assertTrue(this.valorUtil.isMaiorOuIgual(BigDecimal.ONE, BigDecimal.ONE));
   }

   /**
    * Teste do m�todo {@link ValorUtil#isIgualComTolerancia(BigDecimal, BigDecimal)}.
    */
   @Test
   public void testIsIgualComToleranciaTrue() {
      assertTrue(this.valorUtil.isIgualComTolerancia(BigDecimal.ONE, new BigDecimal("1.03")));
      assertTrue(this.valorUtil.isIgualComTolerancia(BigDecimal.ONE, new BigDecimal("0.99")));
      assertTrue(this.valorUtil.isIgualComTolerancia(BigDecimal.ONE, BigDecimal.ONE));
      assertTrue(this.valorUtil.isIgualComTolerancia(BigDecimal.TEN, new BigDecimal("10.02999999999999999999999999999")));

      BigDecimal valor1 = new BigDecimal("0.000000000000001");
      BigDecimal valor2 = new BigDecimal("0.000000000000000");
      assertTrue(this.valorUtil.isIgualComTolerancia(valor1, valor2, ValorUtil.ERRO_MAX_PRECISAO_PERCENTUAL_JUROS));
   }

   /**
    * Teste do m�todo {@link ValorUtil#isIgualComTolerancia(BigDecimal, BigDecimal)}.
    */
   @Test
   public void testIsIgualComToleranciaFalse() {
      assertFalse(this.valorUtil.isIgualComTolerancia(BigDecimal.ONE, new BigDecimal("1.1")));
      assertFalse(this.valorUtil.isIgualComTolerancia(BigDecimal.ONE, new BigDecimal("0.95")));
      assertFalse(this.valorUtil.isIgualComTolerancia(BigDecimal.ONE, BigDecimal.ZERO));
      assertFalse(this.valorUtil.isIgualComTolerancia(BigDecimal.TEN, new BigDecimal("10.030000000000000000000000000001")));

      BigDecimal valor1 = new BigDecimal("0.000000000000002");
      BigDecimal valor2 = new BigDecimal("0.0000000000000001");
      assertFalse(this.valorUtil.isIgualComTolerancia(valor1, valor2, ValorUtil.ERRO_MAX_PRECISAO_PERCENTUAL_JUROS));
   }

   /**
    * Teste do m�todo {@link ValorUtil#isMaiorComTolerancia(BigDecimal, BigDecimal, BigDecimal)}.
    */
   @Test
   public void testIsMaiorComToleranciaTrue() {
      BigDecimal erroMaximo = ValorUtil.ERRO_MAX_PRECISAO;
      assertTrue(this.valorUtil.isMaiorComTolerancia(new BigDecimal("1.04"), BigDecimal.ONE, erroMaximo));
      assertTrue(this.valorUtil.isMaiorComTolerancia(BigDecimal.ONE, new BigDecimal("0.95"), erroMaximo));
      assertTrue(this.valorUtil.isMaiorComTolerancia(new BigDecimal("1.0300000000000000000000000001"), BigDecimal.ONE, erroMaximo));
      assertTrue(this.valorUtil.isMaiorComTolerancia(BigDecimal.TEN, BigDecimal.ONE, erroMaximo));
   }

   /**
    * Teste do m�todo {@link ValorUtil#isMaiorComTolerancia(BigDecimal, BigDecimal, BigDecimal)}.
    */
   @Test
   public void testIsMaiorComToleranciaFalse() {
      BigDecimal erroMaximo = ValorUtil.ERRO_MAX_PRECISAO;
      assertFalse(this.valorUtil.isMaiorComTolerancia(BigDecimal.ONE, new BigDecimal("1.01"), erroMaximo));
      assertFalse(this.valorUtil.isMaiorComTolerancia(BigDecimal.ONE, BigDecimal.ONE, erroMaximo));
      assertFalse(this.valorUtil.isMaiorComTolerancia(BigDecimal.ONE, new BigDecimal("1.03"), erroMaximo));
   }

   /**
    * Teste do m�todo {@link ValorUtil#dividir(BigDecimal, BigDecimal)}.<br/>
    * Cen�rio: divis�o com resultado positivo, com arredondamento de {@link ValorUtil#VINTE_CASAS_DECIMAIS}.
    * <p>
    * Exemplo:
    * 
    * <pre>
    * 1 / 589     = 0,0016977928692699490[6]6213921901528 
    * arredondado = 0,0016977928692699490[7]
    * </pre>
    */
   @Test
   public void testDividirComResultadoPositivo() {
      BigDecimal divisao = this.valorUtil.dividir(BigDecimal.ONE, new BigDecimal("589"));
      assertEquals(new BigDecimal("0.00169779286926994907"), divisao);
   }

   /**
    * Teste do m�todo {@link ValorUtil#dividir(BigDecimal, BigDecimal)}.<br/>
    * Cen�rio: divis�o com resultado negativo, com arredondamento de {@link ValorUtil#VINTE_CASAS_DECIMAIS}.
    * <p>
    * Exemplo:
    * 
    * <pre>
    * -1 / 589    = -0,0016977928692699490[6]6213921901528 
    * arredondado = -0,0016977928692699490[7]
    * </pre>
    */
   @Test
   public void testDividirComResultadoNegativo() {
      BigDecimal divisao = this.valorUtil.dividir(BigDecimal.ONE.negate(), new BigDecimal("589"));
      assertEquals(new BigDecimal("-0.00169779286926994907"), divisao);
   }

   /**
    * Teste do m�todo {@link ValorUtil#dividir(BigDecimal, BigDecimal)}.<br/>
    * Cen�rio: divis�o com resultado positivo, com arredondamento de 5 casas decimais.
    * <p>
    * Exemplo:
    * 
    * <pre>
    * 1 / 589    = 0,0016[9]7792869269949066213921901528 
    * arredondado = 0,001[70]
    * </pre>
    */
   @Test
   public void testDividirComResultadoNegativoCom5CasasDecimais() {
      BigDecimal divisao = this.valorUtil.dividir(BigDecimal.ONE, new BigDecimal("589"), 5);
      assertEquals(new BigDecimal("0.00170"), divisao);
   }

   /**
    * Teste do m�todo {@link ValorUtil#multiplicar(BigDecimal, BigDecimal, int)}. <br/>
    * Cen�rio: multiplica��o de n�meros positivos arredondada com {@link ValorUtil#VINTE_CASAS_DECIMAIS}.
    */
   @Test
   public void testMultiplicarResultadoPositivo() {
      BigDecimal multiplicacao = this.valorUtil.multiplicar(new BigDecimal("0.90710382513661202186"), new BigDecimal("0.03"), ValorUtil.VINTE_CASAS_DECIMAIS);

      assertEquals(new BigDecimal("0.02721311475409836066"), multiplicacao);
   }

   /**
    * Teste do m�todo {@link ValorUtil#multiplicar(BigDecimal, BigDecimal, int)}. <br/>
    * Cen�rio: multiplica��o com resultado negativo arredondada com {@link ValorUtil#VINTE_CASAS_DECIMAIS}.
    */
   @Test
   public void testMultiplicarResultadoNegativo() {
      BigDecimal multiplicacao = this.valorUtil.multiplicar(new BigDecimal("-0.90710382513661202186"), new BigDecimal("0.03"), ValorUtil.VINTE_CASAS_DECIMAIS);

      assertEquals(new BigDecimal("-0.02721311475409836066"), multiplicacao);
   }

   /**
    * Teste do m�todo {@link ValorUtil#multiplicar(BigDecimal, BigDecimal)}. <br/>
    * Cen�rio: multiplica��o de n�meros positivos arredondada com quantidade de casas decimais padr�o.
    */
   @Test
   public void testMultiplicarResultadoPositivoCasasDecimaisPadrao() {
      BigDecimal multiplicacao = this.valorUtil.multiplicar(new BigDecimal("0.90710382513661202186"), new BigDecimal("0.03"));
      assertEquals(new BigDecimal("0.02721311475409836066"), multiplicacao);
   }

   /**
    * Teste do m�todo {@link ValorUtil#converterNumeroIndiceParaValor(BigDecimal)}.
    * <p>
    * Cen�rio: convers�o de n�mero �ndice para percentual com precis�o de {@link ValorUtil#VINTE_CASAS_DECIMAIS}.
    */
   @Test
   public void testConverterNumeroIndiceParaValor() {
      BigDecimal numeroIndice = new BigDecimal("1.001234567890123456789012345");
      BigDecimal percentual = this.valorUtil.converterNumeroIndiceParaValor(numeroIndice);
      assertEquals(new BigDecimal("0.12345678901234567890"), percentual);
   }

   /**
    * Teste do m�todo: {@link ValorUtil#converterValorParaNumeroIndice(BigDecimal, int)}.
    * <p>
    * Cen�rio: convers�o de percentual para n�mero �ndice com precis�o de {@link ValorUtil#VINTE_CASAS_DECIMAIS}.
    */
   @Test
   public void testConverteValorParaNumeroIndice() {
      BigDecimal numeroIndice = new BigDecimal("0.12345678901234567890123456");
      BigDecimal percentual = this.valorUtil.converterValorParaNumeroIndice(numeroIndice);
      assertEquals(new BigDecimal("1.00123456789012345679"), percentual);
   }

   /**
    * Teste do m�todo: {@link ValorUtil#converterValorParaNumeroIndice(BigDecimal, int)}.
    * <p>
    * Cen�rio: convers�o de percentual para n�mero �ndice com precis�o de 5 casas decimais.
    */
   @Test
   public void testConverteValorParaNumeroIndiceCom5CasasDecimais() {
      BigDecimal numeroIndice = new BigDecimal("0.12345678901234567890123456");
      BigDecimal percentual = this.valorUtil.converterValorParaNumeroIndice(numeroIndice, 5);
      assertEquals(new BigDecimal("1.00123"), percentual);
   }

   @Test
   public void testElevarComAproximacao() {
      assertEquals(BigDecimal.valueOf(1.83), this.valorUtil.elevar(BigDecimal.valueOf(1.5), BigDecimal.valueOf(1.5), ValorUtil.DUAS_CASAS_DECIMAIS));
   }

   @Test
   public void testCalcularMathContext() {
      BigDecimal nulo = null;
      assertNull(this.valorUtil.calcularMathContext(nulo, 2, RoundingMode.DOWN));

   }

   @Test
   public void testeAMF() {
      BigDecimal valorNaoArredondado = new BigDecimal("1.5346");
      BigDecimal valorArredondado = new BigDecimal("1.53");
      BigDecimal valorRecebido = this.valorUtil.arredondar(valorNaoArredondado, ValorUtil.DUAS_CASAS_DECIMAIS);
      assertEquals(valorArredondado, valorRecebido);

   }

   @Test
   public void testeAMF2() {
      // BigDecimal r = 0.5346;
      int decimalPlace = 2;
      BigDecimal bd = BigDecimal.valueOf(0.5346);
      // bd = bd.setScale(decimalPlace,RoundingMode.HALF_UP);
      // bd = bd.doubleValue();
      // bd.round(decimalPlace,RoundingMode.HALF_UP);
      MathContext mathContext = new MathContext(5, RoundingMode.HALF_EVEN);
      BigDecimal valorArredondado = bd.round(mathContext);
      BigDecimal r = valorArredondado.setScale(decimalPlace, RoundingMode.HALF_EVEN);
      assertEquals(new BigDecimal("0.53"), r);

   }

   @Test
   public void testArrendondamentoEstranho() {
      BigDecimal numeroAArredondar = BigDecimal.valueOf(6.0050001);
      assertEquals(BigDecimal.valueOf(6.01), this.valorUtil.arredondar(numeroAArredondar, 2, RoundingMode.HALF_UP));
   }

   @Test
   public void testArrendondamentoMaisEstranhoAinda() {
      BigDecimal numeroAArredondar = BigDecimal.valueOf(6.3049);
      assertEquals(new BigDecimal("6.30"), this.valorUtil.arredondar(numeroAArredondar, 2, RoundingMode.HALF_UP));
   }

   @Test
   public void testArredondaValorCET() {
      BigDecimal numeroAArredondar = BigDecimal.valueOf(.173231487858634);
      assertEquals(new BigDecimal("17.3231"), this.valorUtil.arredondar(this.valorUtil.multiplicar(numeroAArredondar, new BigDecimal("100")), 4, RoundingMode.HALF_UP));
   }

   @Test
   public void testElevarBaseNegativa() {
      BigDecimal base = BigDecimal.valueOf(-3);
      BigDecimal expoente = BigDecimal.valueOf(3);
      assertEquals(BigDecimal.valueOf(-27.0), this.valorUtil.elevar(base, expoente));
   }

   @Test
   public void testElevarExpoenteNegativo() {
      BigDecimal base = BigDecimal.valueOf(0.25);
      BigDecimal expoente = BigDecimal.valueOf(-2);
      assertEquals(new BigDecimal("16.0"), this.valorUtil.elevar(base, expoente));
   }

   // @Test
   // public void testDivisaoPorZero() {
   // assertNotNull(this.valorUtil.dividir(BigDecimal.ONE, BigDecimal.ZERO));
   // }

}
