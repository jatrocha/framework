package br.com.cygnus.framework.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Mapeamento dos erros para a resposta do endpoint.
 */
@XmlRootElement
public class ErrorDTO implements Serializable {

   private static final long serialVersionUID = -8633734997780819980L;

   private String description;

   /**
    * @param description {@link String} descricao do erro.
    */
   public ErrorDTO(String description) {

      this.description = description;
   }

   /**
    * Construtor padrao.
    */
   public ErrorDTO() {

      super();
   }

   /**
    * @return {@link String} descricao do erro.
    */
   public String getDescription() {

      return this.description;
   }

   /**
    * @param description {@link String} descricao do erro.
    */
   public void setDescription(String description) {

      this.description = description;
   }

}
