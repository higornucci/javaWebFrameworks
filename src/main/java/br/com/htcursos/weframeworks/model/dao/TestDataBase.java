package br.com.htcursos.weframeworks.model.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.com.htcursos.weframeworks.model.entidade.Usuario;

public class TestDataBase {
	public static void main(String[] args) {
		//Carregando o contexto do Spring
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("file:src/main/webapp/WEB-INF/springbeans.xml");
		EntityManagerFactory emf = (EntityManagerFactory) ctx.getBean("entityManagerFactory"); 

		//Obtendo um objeto gerenciador de entidades
		EntityManager em = emf.createEntityManager();

		//Criando um objeto Usuario
		Usuario usu = new Usuario("Maria", "mar", "123");

		//Obtendo um objeto gerenciador de transacoes
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.persist(usu);
		transaction.commit();
	}
}
