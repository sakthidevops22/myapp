<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!--  Level2 MAST HEAD -->
<div role="banner" class="ibm-w3-masthead" id="ibm-masthead">
	<script type="text/javascript">
	function logout() {
		var logoutForm = document.getElementById('dst_logout_frm');
		logoutForm.submit();
	}
	</script>
	<!--  Level 3 -->
	<div aria-label="MastheadOptions" role="toolbar" id="ibm-mast-options">
		<ul role="presentation">
			<li role="presentation" id="ibm-home"><a tabindex="0" role="button" href="http://w3.ibm.com/">w3</a></li>
		</ul>
	</div>
	<!--  Level 3 -->			
	<div id="ibm-universal-nav">
		<p id="ibm-site-title"><em>My Portal Lite</em></p>
		<ul id="ibm-menu-links">
			<li><a href="http://w3.ibm.com/sitemap/us/en/">Site map</a></li>
		</ul>
		<div id="ibm-search-module">
			<form id="ibm-search-form" action="http://w3.ibm.com/search/do/search" method="get">
				<p>
					<label for="q"><span class="ibm-access">Search</span></label>
					<input type="text" maxlength="100" value="" name="qt" id="q"/>
					<input type="hidden" value="17" name="v"/>
					<input value="en" type="hidden" name="langopt"/>
					<input value="all" type="hidden" name="la"/>
					<input type="submit" id="ibm-search" class="ibm-btn-search" value=""/>
				</p>
			</form>
		</div>
		<div id="ibm-profile-links">
			<div id="ibm-sso" role="presentation">
			</div>
			<div class="ibm-profile-custom-links">
				<a id="ibm-sign-in-out" href="javascript: logout();" tabindex="-1" style="padding:0 5px 1px 2px;" role="button" 
					aria-label="Sign out" aria-describedby="ibm-user-name">&nbsp;|&nbsp;Sign out</a>
				<div style="display:none;">
					<form method="POST" action="ibm_security_logout" name="logout" id="dst_logout_frm">
						<input type="hidden" name="logoutExitPage" value="login.jsp">
					</form>
				</div>
			</div>
		</div>
	</div>
</div>