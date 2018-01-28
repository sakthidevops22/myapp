<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h2>Our apology page</h2>
<c:if test="${actionError!=null }">
<div>
		<p class="ibm-error">
			<strong>${actionError.errorMessage}</strong>
		</p>
</div>
</c:if>
