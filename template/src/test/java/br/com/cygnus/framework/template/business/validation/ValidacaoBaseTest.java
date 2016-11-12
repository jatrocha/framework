package br.com.cygnus.framework.template.business.validation;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

public class ValidacaoBaseTest {

   private ValidacaoBase<ObjetoParaValidacao> base;

   @Before
   public void before() {

      this.base = new ValidacaoBase<ObjetoParaValidacao>(null) {

         @Override
         protected void validarRegra(ObjetoParaValidacao objeto) {

            if (objeto.isLancarErro()) {

               throw new RuntimeException("ERRO!");
            }
         }
      };
   }

   @Test(expected = RuntimeException.class)
   public void testValidar() {

      this.base.validar(new ObjetoParaValidacao(Boolean.TRUE));
   }

   @Test
   public void testIsContinuarValidacaoException() {

      assertFalse(this.base.isContinuarValidacao(new ObjetoParaValidacao(Boolean.TRUE)));
   }

   @Test
   public void testIsContinuarValidacaoSemException() {

      assertFalse(this.base.isContinuarValidacao(new ObjetoParaValidacao(Boolean.FALSE)));
   }

   @Test
   public void testIsContinuarValidacaoInvalid() {

      assertFalse(this.base.isContinuarValidacao(null));
   }

   @Test
   public void testGetProximaValidacao() {

      assertNull(this.base.getProximaValidacao());
   }

}

class ObjetoParaValidacao {

   private final Boolean lancarErro;

   public ObjetoParaValidacao(Boolean lancarErro) {

      this.lancarErro = lancarErro;
   }

   public Boolean isLancarErro() {

      return this.lancarErro;
   }

}
