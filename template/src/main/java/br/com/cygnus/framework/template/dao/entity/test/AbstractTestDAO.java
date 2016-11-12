package br.com.cygnus.framework.template.dao.entity.test;

import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.hibernate.ejb.Ejb3Configuration;
import org.hibernate.envers.AuditReaderFactory;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import br.com.cygnus.framework.AObjetoGenerico;

/**
 * Infra estrutura basica para testes de persistencia. Utiliza banco de dados em memoria que eh destruido e recriado a cada teste, tambem possui controle manual
 * de transacoes. A classe varre o class path e registra todas as entidades encontradas para geracao do ddl script.
 */
public abstract class AbstractTestDAO extends AObjetoGenerico {

   /** Delimitador a ser utilizado na ciracao do banco. */
   private static final String DELIMITADOR_DE_QUERY = ";";

   /** Caminho para salvar o script de criacao do banco. */
   private static final String DDL_SCRIPT = "target/ddl.sql";

   /** Fabrica de {@link EntityManager}. */
   private EntityManagerFactory entityManagerFactory;

   /** Configuracao da persistencia. */
   private final Ejb3Configuration configuration;

   /** Gerenciador de entidades. */
   private EntityManager entityManager;

   /** Gerenciador de transacoes. */
   private EntityTransaction transaction;

   /** Exportar comandos de criacao do banco. */
   private final Boolean exportDDL = Boolean.TRUE;

   /** Exibir os comandos criacao do banco. */
   private final Boolean showDDL = Boolean.FALSE;

   /**
    * Construtor.
    */
   public AbstractTestDAO() {
      super();
      this.configuration = this.newEjb3Configuration();
   }

   /**
    * Cria banco de dados, conforme a propriedade "hibernate.hbm2ddl.auto" configurada.
    */
   public void before() {
      SchemaExport schemaExport = new SchemaExport(this.configuration.getHibernateConfiguration());
      if (this.exportDDL) {
         schemaExport.setDelimiter(DELIMITADOR_DE_QUERY);
         schemaExport.setOutputFile(DDL_SCRIPT);
         schemaExport.create(this.showDDL, this.exportDDL);
      }
   }

   /**
    * Entity manager configurado.
    * 
    * @return {@link EntityManager}
    */
   protected EntityManager getEntityManager() {
      if (this.entityManagerFactory == null) {
         this.entityManagerFactory = this.configuration.buildEntityManagerFactory();
         this.entityManager = this.entityManagerFactory.createEntityManager();
         AuditReaderFactory.get(this.getEntityManager());
      }
      return this.entityManager;
   }

   /**
    * Desfaz uma transacao.
    */
   protected void roolback() {
      this.transaction.rollback();
   }

   /**
    * Efetiva uma transacao.
    */
   protected void commit() {
      this.transaction.commit();
   }

   /**
    * Inicia uma transacao.
    */
   protected void begin() {
      this.transaction = this.entityManager.getTransaction();
      this.transaction.begin();
   }

   /**
    * Configuracao do JPA.
    * 
    * @return {@link Ejb3Configuration} a ser utilizado pelo JPA.
    */
   protected final Ejb3Configuration newEjb3Configuration() {
      Ejb3Configuration config = new Ejb3Configuration();
      Properties properties = this.getConnectionProperties();
      this.setAuditProperties(properties);
      config.addProperties(properties);
      this.registerEntities(config);
      return config;
   }

   /**
    * @param properties {@link Properties} onde serao incluida configuracao de auditoria.
    */
   protected final void setAuditProperties(Properties properties) {
      // Eventos de Auditoria
      properties.put("hibernate.ejb.event.post-insert", " org.hibernate.ejb.event.EJB3PostInsertEventListener,org.hibernate.envers.event.AuditEventListener");
      properties.put("hibernate.ejb.event.post-update", " org.hibernate.ejb.event.EJB3PostUpdateEventListener,org.hibernate.envers.event.AuditEventListener");
      properties.put("hibernate.ejb.event.post-delete", " org.hibernate.ejb.event.EJB3PostDeleteEventListener,org.hibernate.envers.event.AuditEventListener");
      properties.put("hibernate.ejb.event.pre-collection-update", " org.hibernate.envers.event.AuditEventListener");
      properties.put("hibernate.ejb.event.pre-collection-remove", " org.hibernate.envers.event.AuditEventListener");
      properties.put("hibernate.ejb.event.post-collection-recreate", " org.hibernate.envers.event.AuditEventListener");
   }

   /**
    * @return {@link Properties} com a configuracao de conexao.
    */
   protected final Properties getConnectionProperties() {
      Properties properties = new Properties();
      properties.put("hibernate.connection.url", "jdbc:hsqldb:mem:unit-testing-jpa");
      properties.put("hibernate.connection.driver_class", "org.hsqldb.jdbcDriver");
      properties.put("hibernate.dialect", "org.hibernate.dialect.HSQLDialect");
      properties.put("hibernate.connection.username", "sa");
      properties.put("hibernate.connection.password", "");
      properties.put("hibernate.show_sql", "true");
      properties.put("hibernate.format_sql", "true");
      properties.put("hibernate.hbm2ddl.auto", "create-drop");
      properties.put("hibernate.connection.pool_size", "1");
      return properties;
   }

   /**
    * Registra as entidades de um determinado pacote na configuracao do jpa.
    * 
    * @param configuration configuracao.
    */
   protected abstract void registerEntities(Ejb3Configuration configuration);

}
