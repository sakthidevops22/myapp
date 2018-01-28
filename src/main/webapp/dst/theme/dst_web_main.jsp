<%@page import="com.ibm.dst.fw.DSTFmwkConstants,com.ibm.dst.apps.common.AppConstants"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	String contentMainPage  = (String)request.getAttribute(DSTFmwkConstants.MAIN_CONTENT); 
	String pageTitle = 	(String)request.getAttribute(DSTFmwkConstants.PAGE_TITLE);
	String appName = 	(String)request.getAttribute(DSTFmwkConstants.APP_NAME);
%>	
<!DOCTYPE html>
<html lang="en-US">
<head>
<jsp:include page="/dst/theme/dst_meta_information.jsp" flush="true" />
<title>My Portal Lite</title>
<link href="//1.w3.s81c.com/common/v17e/css/w3.css" rel="stylesheet" title="w3" type="text/css" />
<link href="//1.w3.s81c.com/common/v17e/css/application.css" rel="stylesheet" title="w3" type="text/css"/>
<link href="//1.www.s81c.com/common/v17e/css/data.css" rel="stylesheet" title="w3" type="text/css" />
<script src="//1.w3.s81c.com/common/v17e/js/w3.js" type="text/javascript"></script>
<!-- ENABLE SIGN IN AND GREETING -->
<script type="text/javascript">
	ibmweb.config.set({
	signin: {
	enabled: true
	},
	greeting: {
	enabled: true
	}
	});
</script>
<script type="text/javascript">
	function W3UserServiceCallback(data)
	{
		var hkey = data.User.Hkey;
		dojo.cookie("w3ibmProfile", hkey, {
						expires: 5
		});
	}

	function loadMyProfile(){
		var getID = dojo.cookie("w3ibmProfile");
		if(getID) return;
		var intranetId = "<%=request.getRemoteUser()%>";
		var emailBase = "//w3.ibm.com/w3restsvc/user/1.0.0/6127839ee7627460c4189e36fc6b1b01/json/email/"+intranetId+"/callback/W3UserServiceCallback" ;
		dojo.io.script.get({ 
			callbackParamName : "callback", 
			timeout: 3000, 
			url: emailBase, 
			});
	}
	loadMyProfile();
</script>
</head>

<body id="ibm-com" class="ibm-type">
	<!--  Level 1 -->
	<div id="ibm-top" class="ibm-landing-page">
		<!--  MAST HEAD START -->
		<jsp:include page="/dst/theme/dst_mast_head.jsp" flush="true" />
		<!--  MAST HEAD END -->
		<!--  Level2 ibm-content-wrapper" -->
		<div id="ibm-content-wrapper"">
			<!--  Level 3 -->
			<header role="banner" aria-labelledby="ibm-pagetitle-h1">
				<div id="ibm-leadspace-head" class="ibm-alternate">
					<div id="ibm-leadspace-body">
						<div class="ibm-columns">
							<div class="ibm-col-6-4">
								<h1 id="ibm-pagetitle-h1"><%=pageTitle%></h1>
							</div>
						</div>
					</div>
				</div>
				<nav role="navigation" aria-labelledby="ibm-pagetitle-h1">
					<div id="ibm-content-nav">
						<div id="ibm-primary-tabs">
							<ul class="ibm-tabs" role="tablist">
								<% if(appName.equals(AppConstants.HOME_APP_NAME)){%>
									<li class="ibm-active"><a role="tab" aria-selected="true" href="home.wss">Home</a></li>
									<li><a role="tab" href="myapps.wss">My Apps</a></li>
									<li><a role="tab" href="supportlinks.wss">Support Links</a></li>
									<li><a role="tab" href="faq.wss">FAQ</a></li>
								<%}%>
								<% if(appName.equals(AppConstants.MYAPP_APP_NAME)){%>
									<li><a role="tab" href="home.wss">Home</a></li>
									<li class="ibm-active"><a role="tab" aria-selected="true" href="myapps.wss">My Apps</a></li>
									<li><a role="tab" href="supportlinks.wss">Support Links</a></li>
									<li><a role="tab" href="faq.wss">FAQ</a></li>
								<%}%>
								<% if(appName.equals(AppConstants.SUPLNK_APP_NAME)){%>
									<li><a role="tab" href="home.wss">Home</a></li>
									<li><a role="tab" href="myapps.wss">My Apps</a></li>
									<li class="ibm-active"><a role="tab" aria-selected="true" href="supportlinks.wss">Support Links</a></li>
									<li><a role="tab" href="faq.wss">FAQ</a></li>
								<%}%>
								<% if(appName.equals(AppConstants.FAQ_APP_NAME)){%>
									<li><a role="tab" href="home.wss">Home</a></li>
									<li><a role="tab" href="myapps.wss">My Apps</a></li>
									<li><a role="tab" href="supportlinks.wss">Support Links</a></li>
									<li class="ibm-active"><a role="tab" aria-selected="true" href="faq.wss">FAQ</a></li>
								<%}%>
							</ul>
						</div>
					</div>
				</nav>
			</header>
			<!--  Level 3 -->
			<main role="main" aria-labelledby="ibm-pagetitle-h1">
				<jsp:include page="<%=contentMainPage%>" flush="true"/>
			</main>
			<!--  Level 3 -->
			<div id="ibm-related-content">
				<div id="ibm-merchandising-module">
					<!-- MTE will generate this -->
					<!-- <aside role="complementary" aria-label="Related content"> MTE dynamic modules populate in here. <aside> -->
					<!-- /MTE -->
				</div>
			</div>

		</div>
		<!--  Level2 Footer module -->
		<jsp:include page="/dst/theme/dst_footer.jsp" />
	</div>
	<!--  Level 1 -->
	<div id="ibm-metrics">
		<script src="//w3.ibm.com/common/stats/ida_stats.js"
			type="text/javascript"></script>
	</div>
</body>
</html>