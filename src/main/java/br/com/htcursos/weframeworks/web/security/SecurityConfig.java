package br.com.htcursos.weframeworks.web.security;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName("org.postgresql.Driver");
        ds.setUrl("jdbc:postgresql://104.131.169.167:5432/webframeworks");
        ds.setUsername("postgres");
        ds.setPassword("123");
		
        auth.jdbcAuthentication().dataSource(ds)
		.usersByUsernameQuery("select login, senha, ativo from usuario where login=?")
		.authoritiesByUsernameQuery("select u.login, p.descricao from usuario u, perfil p where u.perfil_id=p.id and login=?");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeRequests()
			.antMatchers("/admin/inserirusuario.xhtml").access("hasAuthority('Administrador')")  
		.and()
			.formLogin().loginPage("/login.xhtml")
			.usernameParameter("login").passwordParameter("senha")
			.defaultSuccessUrl("/admin/inserirusuario.xhtml")
			.failureUrl("/login.xhtml?erro=true")
		.and()
			.logout().logoutSuccessUrl("/login.xhtml")
		.and()
			.exceptionHandling();
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**");
	}
}
