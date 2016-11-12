package br.com.cygnus.framework.util;

import java.io.File;

import br.com.cygnus.framework.AObjetoGenerico;
import br.com.cygnus.framework.IMensagens;
import br.com.cygnus.framework.exception.FrameworkException;

/**
 * Classe <tt>Arquivo</tt> apresenta funcoes para manipulacao arquivos e diretorios no sistema de arquivos.
 */
public class Arquivo extends AObjetoGenerico {

   /** Singleton. */
   private static Arquivo singleton = new Arquivo();

   // private static final byte SIZE = (byte) 1024;

   private File file = null;

   // private FileOutputStream fileOutputStream = null;

   /**
    * Constructor.
    */
   protected Arquivo() {
      super();
   }

   /**
    * Recupera instancia unica da classe.
    * 
    * @return Instancia unica da classe.
    */
   public static Arquivo get() {
      return singleton;
   }

   /**
    * Cria um diretorio no sistema de arquivos.
    * 
    * @param path caminho do diretorio.
    * 
    * @throws FrameworkException caso num seja possivel criar o diretorio.
    */
   public void criarDiretorio(String path) throws FrameworkException {
      Validacao.get().validarObrigatorio(path, "path");
      if (!this.getFile().mkdir()) {
         throw new FrameworkException(IMensagens.FRA036, new String[] { path });
      }

   }

   /**
    * Exclui um arquivo do sistema de arquivos.
    * 
    * @param path caminho do arquivo.
    * 
    * @throws FrameworkException caso o path não seja de um arquivo ou o mesmo não possa ser excluído.
    */
   public void excluirArquivo(String path) throws FrameworkException {
      Validacao.get().validarObrigatorio(path, "path");
      if (!this.file.isFile() || !this.file.delete()) {
         throw new FrameworkException(IMensagens.FRA031, new String[] { path });
      }
   }

   /**
    * Exclui um diretorio do sistema de arquivos.
    * 
    * @param path caminho do diretorio.
    * 
    * @throws FrameworkException caso o path não seja de um diretorio ou o mesmo não possa ser excluído.
    */
   public void excluirDiretorio(String path) throws FrameworkException {
      Validacao.get().validarObrigatorio(path, "path");
      if (!this.file.isDirectory() || !this.file.delete()) {
         throw new FrameworkException(IMensagens.FRA032, new String[] { path });
      }
   }

   // /**
   // * Grava um arquivo no sistema de arquivo.
   // *
   // * @param path
   // * caminho do arquivo.
   // * @param arquivo
   // * arquivo a ser gravado.
   // * @return boolean status da operacao.
   // * @throws FrameworkException
   // */
   // public boolean gravarArquivo(String path, InputStream arquivo) throws FrameworkException {
   // try {
   // criarArquivo(path);
   // byte[] buffer = new byte[SIZE];
   // while (true) {
   // int n = arquivo.read(buffer);
   // if (n < 0) {
   // break;
   // }
   // getFileOutputStream().write(buffer, 0, n);
   // }
   // return true;
   // } catch (FileNotFoundException e) {
   // throw new FrameworkException(Mensagem.get().getMensagem(IMensagens.FRA034, new String[] { path }), e);
   // } catch (IOException e) {
   // throw new FrameworkException(Mensagem.get().getMensagem(IMensagens.FRA035, new String[] { path }), e);
   // } finally {
   // try {
   // getFileOutputStream().close();
   // } catch (IOException e) {
   // throw new FrameworkException(Mensagem.get().getMensagem(IMensagens.FRA035, new String[] { path }), e);
   // }
   // setFileOutputStream(null);
   // }
   //
   // }

   // /**
   // * @param path
   // * @return
   // * @throws FileNotFoundException
   // */
   // protected void criarArquivo(String path) throws FileNotFoundException {
   // fileOutputStream = new FileOutputStream(path);
   // }

   /**
    * Renomeia um diretorio no sistema de arquivos.
    * 
    * @param pathOrigem caminho de origem.
    * @param pathDestino novo caminho.
    * 
    * @throws FrameworkException caso o path não seja de um diretorio ou o mesmo não possa ser excluído.
    */
   public void renomearDiretorio(String pathOrigem, String pathDestino) throws FrameworkException {
      Validacao.get().validarObrigatorio(pathOrigem, "pathOrigem");
      Validacao.get().validarObrigatorio(pathDestino, "pathDestino");
      if (!this.file.isDirectory() || !this.file.renameTo(new File(pathDestino))) {
         throw new FrameworkException(IMensagens.FRA033, new String[] { pathOrigem });
      }
   }

   /**
    * @param file Classe <tt>File</tt> mockada.
    */
   protected void setFile(File file) {
      this.file = file;
   }

   /**
    * @return arquivo real ou mockado, dependendo da utilização.
    */
   protected File getFile() {
      return this.file;
   }

   // /**
   // *
   // * @param fileOutputStream
   // * Classe <tt>FileOutputStream</tt> mockada.
   // */
   // protected void setFileOutputStream(FileOutputStream fileOutputStream) {
   // this.fileOutputStream = fileOutputStream;
   // }
   //
   // /**
   // * @return arquivo real ou mockado, dependendo da utilização.
   // */
   // protected FileOutputStream getFileOutputStream() {
   // return fileOutputStream;
   // }

}
