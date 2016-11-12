package br.com.cygnus.framework.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.Test;

import br.com.cygnus.framework.AObjetoGenerico;
import br.com.cygnus.framework.IMensagens;
import br.com.cygnus.framework.exception.FrameworkException;

public class ArquivoTest {

   private static final String EXCEPTION_NAO_ESPERADA = "Exception nao esperada... =/";
   private static final String EXCEPTION_ERRADA = "Exception errada... =/";
   private static final String EXCEPTION_ESPERADA = "Exception esperada... =/";
   private static final String TEMP_DIR = System.getProperty("java.io.tmpdir").concat("teste");
   private static final String TEMP_FILE = System.getProperty("java.io.tmpdir").concat("teste/teste.out");

   @Test
   public void testCriarDiretorioPathNull() {
      try {
         Arquivo.get().criarDiretorio(null);
         fail(EXCEPTION_ESPERADA);
      } catch (IllegalArgumentException e) {
         assertEquals(Mensagem.get().getMensagem(IMensagens.FRA016, new String[] { "path" }), e.getMessage());
      } catch (FrameworkException e) {
         fail(EXCEPTION_ERRADA);
      }
   }

   @Test
   public void testCriarDiretorioInvalido() {
      try {
         new FileMockFactory().getFileMkdir(false).criarDiretorio(TEMP_DIR);
         fail(EXCEPTION_ESPERADA);
      } catch (FrameworkException e) {
         assertEquals(Mensagem.get().getMensagem(IMensagens.FRA036, new String[] { TEMP_DIR }), e.getMessage());
      }
   }

   @Test
   public void testCriarDiretorioValido() {
      try {
         new FileMockFactory().getFileMkdir(true).criarDiretorio(TEMP_DIR);
         assertTrue(true);
      } catch (FrameworkException e) {
         fail(EXCEPTION_NAO_ESPERADA);
      }
   }

   @Test
   public void testExcluirArquivoPathNull() {
      try {
         Arquivo.get().excluirArquivo(null);
         fail(EXCEPTION_ESPERADA);
      } catch (IllegalArgumentException e) {
         assertEquals(Mensagem.get().getMensagem(IMensagens.FRA016, new String[] { "path" }), e.getMessage());
      } catch (FrameworkException e) {
         fail(EXCEPTION_ERRADA);
      }
   }

   @Test
   public void testExcluirArquivoInvalido() {
      try {
         new FileMockFactory().getFileDelete(Boolean.FALSE, Boolean.TRUE).excluirArquivo(TEMP_FILE);
         fail(EXCEPTION_ESPERADA);
      } catch (FrameworkException e) {
         assertEquals(Mensagem.get().getMensagem(IMensagens.FRA031, new String[] { TEMP_FILE }), e.getMessage());
      }
   }

   @Test
   public void testExcluirArquivoPathInvalido() {
      try {
         new FileMockFactory().getFileDelete(Boolean.FALSE, Boolean.FALSE).excluirArquivo(TEMP_FILE);
         fail(EXCEPTION_ESPERADA);
      } catch (FrameworkException e) {
         assertEquals(Mensagem.get().getMensagem(IMensagens.FRA031, new String[] { TEMP_FILE }), e.getMessage());
      }
   }

   @Test
   public void testExcluirArquivoValido() {
      try {
         new FileMockFactory().getFileDelete(Boolean.TRUE, Boolean.TRUE).excluirArquivo(TEMP_FILE);
         assertTrue(true);
      } catch (FrameworkException e) {
         fail(EXCEPTION_NAO_ESPERADA);
      }
   }

   @Test
   public void testExcluirDiretorioPathNull() {
      try {
         Arquivo.get().excluirDiretorio(null);
         fail(EXCEPTION_ESPERADA);
      } catch (IllegalArgumentException e) {
         assertEquals(Mensagem.get().getMensagem(IMensagens.FRA016, new String[] { "path" }), e.getMessage());
      } catch (FrameworkException e) {
         fail(EXCEPTION_ERRADA);
      }
   }

   @Test
   public void testExcluirDiretorioInvalido() {
      try {
         new FileMockFactory().getFileDeleteDirectory(Boolean.FALSE, Boolean.TRUE).excluirDiretorio(TEMP_DIR);
         fail(EXCEPTION_ESPERADA);
      } catch (FrameworkException e) {
         assertEquals(Mensagem.get().getMensagem(IMensagens.FRA032, new String[] { TEMP_DIR }), e.getMessage());
      }
   }

   @Test
   public void testExcluirDiretorioPathInvalido() {
      try {
         new FileMockFactory().getFileDeleteDirectory(Boolean.FALSE, Boolean.FALSE).excluirDiretorio(TEMP_DIR);
         fail(EXCEPTION_ESPERADA);
      } catch (FrameworkException e) {
         assertEquals(Mensagem.get().getMensagem(IMensagens.FRA032, new String[] { TEMP_DIR }), e.getMessage());
      }
   }

   @Test
   public void testExcluirDiretorioValido() {
      try {
         new FileMockFactory().getFileDeleteDirectory(Boolean.TRUE, Boolean.TRUE).excluirDiretorio(TEMP_DIR);
         assertTrue(true);
      } catch (FrameworkException e) {
         fail(EXCEPTION_NAO_ESPERADA);
      }
   }

   @Test
   public void testRenomearDiretorioValido() {
      try {
         new FileMockFactory().getFileRenameDirectory(Boolean.TRUE, Boolean.TRUE).renomearDiretorio(TEMP_DIR, TEMP_DIR);
         assertTrue(true);
      } catch (FrameworkException e) {
         fail(EXCEPTION_NAO_ESPERADA);
      }
   }

   /**
    * Fabrica de File.class mockados!
    */
   private class FileMockFactory extends AObjetoGenerico {

      /**
       * Classe concreta...
       */
      private Mockery context = new JUnit4Mockery() {
         {
            this.setImposteriser(ClassImposteriser.INSTANCE);
         }
      };

      /**
       * Gera um File de acordo com a necessidade.
       * 
       * @param retorno no metodo file.mkdir() teve sucesso ou nao.
       * @return respectivo mock.
       */
      public Arquivo getFileMkdir(Boolean status) {
         final File fileMock = this.context.mock(File.class);
         final Boolean retorno = status;

         Arquivo arquivo = Arquivo.get();

         this.context.checking(new Expectations() {
            {
               this.oneOf(fileMock).mkdir();
               this.will(returnValue(retorno));
            }
         });

         arquivo.setFile(fileMock);

         return arquivo;
      }

      /**
       * Gera um File de acordo com a necessidade.
       * 
       * @param retorno no metodo file.delete() teve sucesso ou nao.
       * @param isFile informa se o path Ž de um arquivo ou de um diret—rio.
       * @return respectivo mock.
       */
      public Arquivo getFileDelete(Boolean status, Boolean isFile) {
         final File fileMock = this.context.mock(File.class);
         final Boolean retorno = status;
         final Boolean file = isFile;

         Arquivo arquivo = Arquivo.get();

         this.context.checking(new Expectations() {
            {
               this.oneOf(fileMock).isFile();
               this.will(returnValue(file));
               this.oneOf(fileMock).delete();
               this.will(returnValue(retorno));
            }
         });

         arquivo.setFile(fileMock);

         return arquivo;
      }

      /**
       * Gera um File de acordo com a necessidade.
       * 
       * @param retorno no metodo file.delete() teve sucesso ou nao.
       * @param isDirectory informa se o path Ž de um diret—rio.
       * @return respectivo mock.
       */
      public Arquivo getFileDeleteDirectory(Boolean status, Boolean isDirectory) {
         final File fileMock = this.context.mock(File.class);
         final Boolean retorno = status;
         final Boolean file = isDirectory;

         Arquivo arquivo = Arquivo.get();

         this.context.checking(new Expectations() {
            {
               this.oneOf(fileMock).isDirectory();
               this.will(returnValue(file));
               this.oneOf(fileMock).delete();
               this.will(returnValue(retorno));
            }
         });

         arquivo.setFile(fileMock);

         return arquivo;
      }

      /**
       * Gera um File de acordo com a necessidade.
       * 
       * @param retorno no metodo file.renameTo() teve sucesso ou nao.
       * @param isDirectory informa se o path Ž de um diret—rio.
       * @return respectivo mock.
       */
      public Arquivo getFileRenameDirectory(Boolean status, Boolean isDirectory) {
         final File fileMock = this.context.mock(File.class);

         final Boolean retorno = status;
         final Boolean diretory = isDirectory;

         Arquivo arquivo = Arquivo.get();

         this.context.checking(new Expectations() {
            {
               this.oneOf(fileMock).isDirectory();
               this.will(returnValue(diretory));

               this.oneOf(fileMock).renameTo(this.with(any(File.class)));
               this.will(returnValue(retorno));
            }
         });

         arquivo.setFile(fileMock);

         return arquivo;
      }

   }

}