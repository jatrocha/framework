package br.com.cygnus.framework;

/**
 * Classe <tt>IMensagens</tt> que identifica as mensagens no arquivo de recursos.
 */
public interface IMensagens extends IObjetoGenerico {

   /**
    * Mensagem: ERRO GERAL.
    */
   String CODIGO_MENSAGEM_ERRO_GERAL = "FRA000";

   /**
    * Mensagem: Erro ao tentar localizar o contexto JNDI.
    */
   String FRA001 = "FRA001";

   /**
    * Mensagem: Erro ao tentar localizar o Data Source "{0}".
    */
   String FRA002 = "FRA002";

   /**
    * Mensagem: Erro ao obter a instancia do EJB.
    */
   String FRA003 = "FRA003";

   /**
    * Mensagem: N/A.
    */
   String FRA004 = "FRA004";

   /**
    * Mensagem: Erro ao obter uma conexao do Pool de Conexoes.
    */
   String FRA005 = "FRA005";

   /**
    * Mensagem: Erro ao gerar o relatorio.
    */
   String FRA006 = "FRA006";

   /**
    * Mensagem: Erro ao executar a operacao de BD.
    */
   String FRA007 = "FRA007";

   /**
    * Mensagem: Erro ao efetuar pesquisa no banco de dados.
    */
   String FRA008 = "FRA008";

   /**
    * Mensagem: Erro ao efetuar atualizacao de informacoes no banco de dados.
    */
   String FRA009 = "FRA009";

   /**
    * Mensagem: N/A.
    */
   String FRA010 = "FRA010";

   /**
    * Mensagem: Erro ao gerar o codigo sequencial. Sequence informada: {0}.
    */
   String FRA011 = "FRA011";

   /**
    * Mensagem: O registro nao existe no banco de dados.
    */
   String FRA012 = "FRA012";

   /**
    * Mensagem: O objeto infomado nao pode ser nulo.
    */
   String FRA013 = "FRA013";

   /**
    * Mensagem: Data invalida! Favor verificar.
    */
   String FRA014 = "FRA014";

   /**
    * Mensagem: O campo {0} e invalido.
    */
   String FRA015 = "FRA015";

   /**
    * Mensagem: O campo {0} e obrigatorio e nao esta preenchido.
    */
   String FRA016 = "FRA016";

   /**
    * Mensagem: O campo {0} ultrapassou o numero maximo de caracteres permitido({1}).
    */
   String FRA017 = "FRA017";

   /**
    * Mensagem: Erro ao separar o String ({0}) de acordo com o token ({1}).
    */
   String FRA018 = "FRA018";

   /**
    * Mensagem: Erro ao abrir o arquivo de configuracao do Log4J ({0}).
    */
   String FRA019 = "FRA019";

   /**
    * Mensagem: Erro ao abrir o arquivo XML (Caminho {0}).
    */
   String FRA020 = "FRA020";

   /**
    * Mensagem: String nao esta no formato correto({0}).
    */
   String FRA021 = "FRA021";

   /**
    * Mensagem: Erro na tratamento do XML.
    */
   String FRA022 = "FRA022";

   /**
    * Mensagem: Erro ao gerar md5 de uma string.
    */
   String FRA023 = "FRA023";

   /**
    * Mensagem: Comando nao existe.
    */
   String FRA024 = "FRA024";

   /**
    * Mensagem: Erro ao carregar o(s) arquivo(s) de configuracao das querys.
    */
   String FRA025 = "FRA025";

   /**
    * Mensagem: Erro ao montar query.
    */
   String FRA026 = "FRA026";

   /**
    * Mensagem: Erro ao carregar as configuracoes de paginacao.
    */
   String FRA027 = "FRA027";

   /**
    * Mensagem: Nao se pode configurar o componente com as informacoes passadas.
    */
   String FRA028 = "FRA028";

   /**
    * Mensagem: Nem todas as informacoes necessarias foram preenchidas.
    */
   String FRA029 = "FRA029";

   /**
    * Mensagem: String hexadecimal invalida.
    */
   String FRA030 = "FRA030";

   /**
    * Mensagem: Erro ao excluir o arquivo: o caminho pertence a um diretorio.
    */
   String FRA031 = "FRA031";

   /**
    * Mensagem: Erro ao excluir o diretorio: o caminho pretence a um arquivo.
    */
   String FRA032 = "FRA032";

   /**
    * Mensagem: Erro ao renomear o diretorio: o caminho pertence a um arquivo.
    */
   String FRA033 = "FRA033";

   /**
    * Mensagem: Erro de IO ao abrir o arquivo.
    */
   String FRA034 = "FRA034";

   /**
    * Mensagem: O arquivo nao foi encontrado.
    */
   String FRA035 = "FRA035";

   /**
    * Mensagem: Erro ao criar o diret—rio no caminho: {0}.
    */
   String FRA036 = "FRA036";

   /**
    * Mensagem: Erro ao incluir a entidade persistente (registro).
    */
   String DAO016 = "DAO016";

   /**
    * Mensagem: Erro ao gravar (alterar) a entidade persistente (registro).
    */
   String DAO018 = "DAO018";

   /**
    * Mensagem: Erro ao excluir a entidade persistente (registro).
    */
   String DAO019 = "DAO019";

}
