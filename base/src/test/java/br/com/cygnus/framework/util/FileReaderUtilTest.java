package br.com.cygnus.framework.util;

import static org.junit.Assert.assertNotNull;

import java.io.BufferedReader;
import java.io.IOException;

import org.junit.Test;

public class FileReaderUtilTest {

   @Test(expected = IllegalArgumentException.class)
   public void testReadQuandoArquivoInvalidoNull() {

      String filename = null;

      new FileReaderUtil().read(filename);
   }

   @Test(expected = IllegalArgumentException.class)
   public void testReadQuandoArquivoInvalidoVazio() {

      String filename = "";

      new FileReaderUtil().read(filename);
   }

   @Test(expected = IllegalArgumentException.class)
   public void testReadQuandoArquivInvalido() {

      String filename = "";

      new FileReaderUtil().read(filename);
   }

   @Test
   public void testReadQuandoArquivoInvalido() throws IOException {

      BufferedReader reader = new FileReaderUtil().read("carros.txt");

      assertNotNull(reader);
   }

}
