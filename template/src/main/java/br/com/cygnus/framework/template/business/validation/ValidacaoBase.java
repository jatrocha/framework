/**
 * Base para valida��o de negocio.
 */
package br.com.cygnus.framework.template.business.validation;

/**
 * <p>
 * Ele facilita a configura��o e execu��o da cadeia de responsabilidades como por exemplo: A->B->C->D, basta passar no construtor da super classe de A a
 * inst�ncia de B, no construtor da super classe de B a inst�ncia de C, no construtor da super classe de C a inst�ncia de D e no construtor da super classe de D
 * passar <code>null</code> para encerrar a cadeida de responsabilidade.
 * </p>
 * <p>
 * Esta classe implementa o padr�o builder e o padr�o template m�todo, apoiando a constru��o e execu��o do padr�o chain of responsibility. O template method
 * evita que todas as classes filhas de {@link ValidacaoBase} tenha que executar a pr�xima responsabilidade para dar continuidade ao fluxo. O builder restrige a
 * cria��o do fluxo de valida��o somente ao m�todo {@link ValidacaoBase#buildValidacao()} desacoplando a cria��o da cadeia de reponsabilidades dos clientes.
 * </p>
 * <p>
 * O padr�o permite que a complexidade das regras de valida��o sejam dilu�das em classes com responsabilidades bem definidas, tamb�m garante o fluxo de execu��o
 * de forma transparente e caso alguma regra seja violada a exece��o {@link br.com.sicoob.metodosdecalculo.exception.MetodoDeCalculoRuntimeException} dever� ser
 * lan�ada para impedir que o fluxo prossiga .
 * </p>
 * 
 * @see <a href="http://java.dzone.com/articles/design-patterns-uncovered-chain-of-responsibility">Chain of Responsibility - dzone.com</a>
 * @see <a href="http://java.dzone.com/articles/design-patterns-template-method">Template Method - dzone.com</a>
 * @see <a href="http://en.wikipedia.org/wiki/Builder_pattern">Builder - wikipedia</a>
 */
public abstract class ValidacaoBase<T> implements Validacao<T> {

   // private static final String MENSAGEM_ERRO_AO_CRIAR_VALIDACAO = "Erro ao criar valida��o!";

   private ValidacaoBase<T> proximaValidacao;

   /**
    * Recebe a pr�xima regra a ser executada como par�metro.
    * 
    * @param proximaValidacao {@link ValidacaoBase} pr�xima regra de valida��o. {@link null} caso seja o �ltimo elo da cadeia.
    */
   protected ValidacaoBase(final ValidacaoBase<T> proximaValidacao) {

      this.proximaValidacao = proximaValidacao;
   }

   /**
    * @see br.com.sicoob.credito.validacao.core.Validacao#validar(Object).
    */
   @Override
   public final void validar(final T objeto) {

      this.validarRegra(objeto);

      this.executarProximaRegra(objeto);
   }

   /**
    * M�todo gancho para implementa��o das regras espec�ficas de cada dom�nio, este m�todo ser� chamado sempre que o {@link #validar(Object)} for chamado, em
    * seguida ser� chamada a pr�xima valida��o configurada no construtor dando continuidade � cadeia de responsabilidades.
    * 
    * @param objeto a ser validado.
    */
   protected abstract void validarRegra(final T objeto); // template method

   /**
    * Executa a pr�xima regra de valida��o da cadeia caso ela exista.
    * 
    * @param objeto par�metros que ser�o validados ao longo da cadeia.
    */
   protected void executarProximaRegra(final T objeto) {

      if (this.isContinuarValidacao(objeto)) {

         this.proximaValidacao.validar(objeto); // chain of responsibility
      }
   }

   /**
    * Verifica se uma valida��o em cadeia deve continuar.
    * 
    * @param Boolean
    */
   protected Boolean isContinuarValidacao(final T objeto) {

      return this.proximaValidacao != null && objeto != null;
   }

   /**
    * @return {@link ValidacaoBase} sendo a pr�xima valida��o de uma cadeia de valida��es.
    */
   protected ValidacaoBase<T> getProximaValidacao() {

      return this.proximaValidacao;
   }

   /**
    * Configura o pr�ximo elo da cadeia de valida��es.
    * 
    * @param ValidacaoBase<T> pr�ximo elo da cadeia de valida��es.
    */
   protected void setProximaValidacao(ValidacaoBase<T> proximaValidacao) {

      this.proximaValidacao = proximaValidacao;
   }

   /**
    * Cria valida��o individual de uma regra espec�fica do fluxo. Sempre que a classe de valida��o � informada a {@link #proximaValidacao} ser�
    * <code>null</code>.
    * 
    * @param classeValidacao classe de valida��o
    * @return {@link Validacao} �nica
    */
   public static final <T extends ValidacaoBase<?>> T buildValidacao(final Class<T> classeValidacao) { // builder

      try {

         T newInstance = classeValidacao.newInstance();

         newInstance.setProximaValidacao(null);

         return newInstance;

      } catch (InstantiationException e) {

         // LOG.erro(e, MENSAGEM_ERRO_AO_CRIAR_VALIDACAO);

      } catch (IllegalAccessException e) {

         // LOG.erro(e, MENSAGEM_ERRO_AO_CRIAR_VALIDACAO);
      }

      return null;
   }
}
