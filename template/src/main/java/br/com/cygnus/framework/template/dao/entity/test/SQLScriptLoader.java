package br.com.cygnus.framework.template.dao.entity.test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import br.com.cygnus.framework.AObjetoGenerico;

/**
 * Efetua a carga de arquivos SQL no banco de dados em memoria, visando ter carga para os testes unitarios.
 */
public class SQLScriptLoader extends AObjetoGenerico {

   /** ; =]. */
   private static final String PONTO_E_VIRGULA = ";";

   /** Separador de linha. */
   private static final String LINE_SEPARATOR = "line.separator";

   /** Instancia da classe de log. */
   private static final Logger LOG = Logger.getLogger(SQLScriptLoader.class);

   /**
    * Carrega e excuta os comandos contra o banco de dados em memoria.
    * 
    * @param path caminho para o arquivo contendo os comandos.
    * @param em {@link EntityManager} conectado ao banco de dados.
    * @throws SQLException no caso de algum erro de banco de dados.
    * @throws IOException caso ocorra algum erro de leitura do arquivo.
    */
   @SuppressWarnings("deprecation")
   public static void loadScript(String path, EntityManager em) throws SQLException, IOException {
      Connection conn = null;
      try {
         conn = ((Session) em.getDelegate()).connection();

         String line;
         StringBuffer command = new StringBuffer();

         BufferedReader reader = getFile(path);
         try {
            while ((line = reader.readLine()) != null) {
               if (isContemPontoEVirgulaNaString(line)) {
                  command.append(line).append(System.getProperty(LINE_SEPARATOR));
                  continue;
               }

               command.append(line.substring(0, line.indexOf(PONTO_E_VIRGULA)));
               LOG.info("COMMAND EXEC: [" + command + "]");

               if (!isStringComandoVazia(command)) {
                  Statement st = null;
                  try {
                     st = conn.createStatement();
                     st.executeUpdate(command.toString()); // NOSONAR
                  } finally {
                     st.close();
                  }
               }
               command = new StringBuffer(line.substring(line.indexOf(PONTO_E_VIRGULA) + 1, line.length()));
            }
         } finally {
            reader.close();
         }
      } finally {
         conn.close();
      }
   }

   /**
    * Recupera o arquivo com os comandos SQL.
    * 
    * @param path caminho para o arquivo.
    * @return {@link BufferedReader} arquivo com leitura via buffer.
    * @throws FileNotFoundException caso o arquivo nao seja encontrado.
    */
   protected static BufferedReader getFile(String path) throws FileNotFoundException {
      InputStream in = new FileInputStream(path);
      return new BufferedReader(new InputStreamReader(in));
   }

   /**
    * @param command {@link StringBuffer} contendo o comando a ser executado.
    * @return <code>Boolean.TRUE</code> caso a linha esteja vazia, <code>Boolean.FALSE</code> caso contrario.
    */
   protected static Boolean isStringComandoVazia(StringBuffer command) {
      return command.toString().trim().equals(NULL_STRING);
   }

   /**
    * 
    * @param line linha do arquivo de comando.
    * @return <code>Boolean.TRUE</code> caso a linha termine com um ";", <code>Boolean.FALSE</code> caso contrario.
    */
   protected static Boolean isContemPontoEVirgulaNaString(String line) {
      return line.indexOf(PONTO_E_VIRGULA) == -1;
   }

}
