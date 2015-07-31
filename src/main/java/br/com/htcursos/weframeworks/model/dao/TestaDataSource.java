package br.com.htcursos.weframeworks.model.dao;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestaDataSource {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("file:src/main/webapp/WEB-INF/springbeans.xml");

		//Acessando o objeto BasicDataSource criado dentro do contexto do 
		BasicDataSource basicDataSource = (BasicDataSource)	ctx.getBean("dataSource");
		
		//Imprimindo dados do objeto BasicDataSource criado no contexto do 
		System.out.println( basicDataSource.getDriverClassName() );
		System.out.println( basicDataSource.getUrl() );
		System.out.println( basicDataSource.getUsername() );
		System.out.println( basicDataSource.getPassword());

		//O Objeto de Carregamento de Recursos
		ctx.close();
	}
}