package br.com.cygnus.framework.dao;

/**
 * <tt>DaoFactoryEnum</tt> define as opcoes que podem ser utilizadas na construcao de objetos pela fabrica {@link DaoFactory}.
 */
public enum DaoFactoryEnum {

   /** Utilizar este padrao para configuracao do hibernate. */
   JPA(0, "JPA"),
   /** Utilizar a implementacao nativa do hibernate. */
   HIBERNATE(1, "Hibernate");

   /** identificador do item. */
   private Integer codigo;

   /** Nome do item. */
   private String nome;

   /**
    * Construtor padrao.
    * 
    * @param codigo identificador.
    * @param nome nome do item.
    */
   private DaoFactoryEnum(Integer codigo, String nome) {
      this.codigo = codigo;
      this.nome = nome;
   }

   /**
    * @return identificador do item.
    */
   public Integer getCodigo() {
      return this.codigo;
   }

   /**
    * @return nome do item.
    */
   public String getNome() {
      return this.nome;
   }

   /**
    * Carrega a partir do nome (descricao).
    * 
    * @param nome nome da fabrica desejada.
    * @return inst‰ncia do objeto.
    */
   public static DaoFactoryEnum getBy(String nome) {
      DaoFactoryEnum[] daos = values();
      for (DaoFactoryEnum daoFactoryEnum : daos) {
         if (daoFactoryEnum.getNome().equalsIgnoreCase(nome)) {
            return daoFactoryEnum;
         }
      }
      return null;
   }

   /**
    * Carrega a partir do identificador.
    * 
    * @param codigo identificador.
    * @return inst‰ncia do objeto.
    */
   public static DaoFactoryEnum getBy(Integer codigo) {
      DaoFactoryEnum[] daos = values();
      for (DaoFactoryEnum daoFactoryEnum : daos) {
         if (daoFactoryEnum.getCodigo().equals(codigo)) {
            return daoFactoryEnum;
         }
      }
      return null;
   }

}
