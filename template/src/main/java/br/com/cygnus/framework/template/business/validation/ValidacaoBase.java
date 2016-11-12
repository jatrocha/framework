/**
 * Base para validação de negocio.
 */
package br.com.cygnus.framework.template.business.validation;

/**
 * <p>
 * Ele facilita a configuração e execução da cadeia de responsabilidades como por exemplo: A->B->C->D, basta passar no construtor da super classe de A a
 * instância de B, no construtor da super classe de B a instância de C, no construtor da super classe de C a instância de D e no construtor da super classe de D
 * passar <code>null</code> para encerrar a cadeida de responsabilidade.
 * </p>
 * <p>
 * Esta classe implementa o padrão builder e o padrão template método, apoiando a construção e execução do padrão chain of responsibility. O template method
 * evita que todas as classes filhas de {@link ValidacaoBase} tenha que executar a próxima responsabilidade para dar continuidade ao fluxo. O builder restrige a
 * criação do fluxo de validação somente ao método {@link ValidacaoBase#buildValidacao()} desacoplando a criação da cadeia de reponsabilidades dos clientes.
 * </p>
 * <p>
 * O padrão permite que a complexidade das regras de validação sejam diluídas em classes com responsabilidades bem definidas, também garante o fluxo de execução
 * de forma transparente e caso alguma regra seja violada a execeção {@link br.com.sicoob.metodosdecalculo.exception.MetodoDeCalculoRuntimeException} deverá ser
 * lançada para impedir que o fluxo prossiga .
 * </p>
 * 
 * @see <a href="http://java.dzone.com/articles/design-patterns-uncovered-chain-of-responsibility">Chain of Responsibility - dzone.com</a>
 * @see <a href="http://java.dzone.com/articles/design-patterns-template-method">Template Method - dzone.com</a>
 * @see <a href="http://en.wikipedia.org/wiki/Builder_pattern">Builder - wikipedia</a>
 */
public abstract class ValidacaoBase<T> implements Validacao<T> {

   // private static final String MENSAGEM_ERRO_AO_CRIAR_VALIDACAO = "Erro ao criar validação!";

   private ValidacaoBase<T> proximaValidacao;

   /**
    * Recebe a próxima regra a ser executada como parâmetro.
    * 
    * @param proximaValidacao {@link ValidacaoBase} próxima regra de validação. {@link null} caso seja o último elo da cadeia.
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
    * Método gancho para implementação das regras específicas de cada domínio, este método será chamado sempre que o {@link #validar(Object)} for chamado, em
    * seguida será chamada a próxima validação configurada no construtor dando continuidade à cadeia de responsabilidades.
    * 
    * @param objeto a ser validado.
    */
   protected abstract void validarRegra(final T objeto); // template method

   /**
    * Executa a próxima regra de validação da cadeia caso ela exista.
    * 
    * @param objeto parâmetros que serão validados ao longo da cadeia.
    */
   protected void executarProximaRegra(final T objeto) {

      if (this.isContinuarValidacao(objeto)) {

         this.proximaValidacao.validar(objeto); // chain of responsibility
      }
   }

   /**
    * Verifica se uma validação em cadeia deve continuar.
    * 
    * @param Boolean
    */
   protected Boolean isContinuarValidacao(final T objeto) {

      return this.proximaValidacao != null && objeto != null;
   }

   /**
    * @return {@link ValidacaoBase} sendo a próxima validação de uma cadeia de validações.
    */
   protected ValidacaoBase<T> getProximaValidacao() {

      return this.proximaValidacao;
   }

   /**
    * Configura o próximo elo da cadeia de validações.
    * 
    * @param ValidacaoBase<T> próximo elo da cadeia de validações.
    */
   protected void setProximaValidacao(ValidacaoBase<T> proximaValidacao) {

      this.proximaValidacao = proximaValidacao;
   }

   /**
    * Cria validação individual de uma regra específica do fluxo. Sempre que a classe de validação é informada a {@link #proximaValidacao} será
    * <code>null</code>.
    * 
    * @param classeValidacao classe de validação
    * @return {@link Validacao} única
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
