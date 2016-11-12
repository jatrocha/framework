package br.com.cygnus.framework.template.view;

import java.io.Serializable;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

/**
 * Define o tratamento da sessao pelo framework.
 */
public interface Session<T> extends SessionAware, Serializable {

   /**
    * @return {@link Map<String, T>}.
    */
   Map<String, T> getSession();
}
