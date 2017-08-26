<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
	
	<c:import url="cabecalho.jsp" />
	
	<!-- cria contatoDAO -->
	<jsp:useBean id="dao" class="br.com.caelum.agenda.dao.ContatoDao" />
	
	<table>
		<tr>
			<td>ID</td>
			<td>Nome</td>
			<td>E-mail</td>
			<td>Data de Nascimento</td>
		</tr>
		<!-- percorre contatos montando linhas na tabela -->
		<c:forEach var="contato" items="${ dao.lista }">
			<tr>
				<td>${ contato.nome }</td>
				<c:if test="${ empty contato.email }">
					<td>E-mail não informado</td>				
				</c:if>
				<c:if test="${not empty contato.email}">
					<td><a href="mailto:${ contato.email }" > ${ contato.email }</a></td>
				</c:if>
				<td>${ contato.endereco }</td>
				<td><fmt:formatDate value="${ contato.dataNascimento.time }" pattern="dd/MM/yyyy" /></td>
			</tr>
		</c:forEach>
	</table>
	
	<c:import url="rodape.jsp" />
	
</body>
</html>