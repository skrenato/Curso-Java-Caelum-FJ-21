package br.com.caelum.agenda.filtro;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter("/*")
public class FiltroTempoDeExecucao implements Filter {

	@Override
	public void destroy() {	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		//Calcula tempo de execução de request
		long tempoInicio = System.currentTimeMillis();
		
		chain.doFilter(request, response);
		
		long tempoFim = System.currentTimeMillis();
		
		String uri = ((HttpServletRequest)request).getRequestURI();
		
		String parametros = ((HttpServletRequest)request)
				.getParameter("logica");
		
		System.out.println("Tempo da requisicao de " + uri
			+ "?logica="
			+ parametros + " demorou "
			+ (tempoFim - tempoInicio)
			+ " ms"); 
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException { }
	
}
