<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en-US">
	<head>
		<jsp:include page="/dst/theme/dst_meta_information.jsp" flush="true" />
		<title>My Tools</title>
		<link href="//1.w3.s81c.com/common/v17e/css/w3.css" rel="stylesheet" title="w3" type="text/css" />
		<link href="//1.w3.s81c.com/common/v17e/css/application.css" rel="stylesheet" title="www" type="text/css"/>
		<script src="//1.w3.s81c.com/common/v17e/js/w3.js" type="text/javascript">//</script>
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
			
			function getCookie(NameOfCookie){ 
			   if (document.cookie.length > 0) { 
			      begin = document.cookie.indexOf(NameOfCookie+"="); 
			      if (begin != -1) { 
			         begin += NameOfCookie.length+1; 
			         end = document.cookie.indexOf(";", begin);
			         if (end == -1){
			            end = document.cookie.length;
			         }
			         return document.cookie.substring(begin, end); 
			      } 
			   }
			   return null; 
			}
			
			function setCookie(NameOfCookie, value, expiredays) { 
			   var ExpireDate = new Date ();
			   ExpireDate.setTime(ExpireDate.getTime() + (expiredays * 24 * 3600 * 1000));
			   document.cookie = NameOfCookie + "=" + value + ((expiredays == null) ? "" : "; expires=" + ExpireDate.toGMTString()+"; path=/");
			}			
			
			function prefillUserID(){
			   // if userid value is found in the cookie, then put it in the textfield
			   var userId="";
			   if(document.getElementById("iip").value == ''){
			     var cvalue = getCookie("dstProfileCookie");
			      if(cvalue != null && cvalue != ''){
			         uid = cvalue.substring(0, cvalue.indexOf(":"));
			         if(uid != null && uid != "null"){
			            userId = uid;
			         }
			         
			         //if "true" exist in the cookie, that means user has previously selected
			         // the 'Remember my ID checkbox. 
			         // Check this checkbox
			         if(cvalue.indexOf("true") != -1){
			            document.getElementById("rememberme").checked = true;  
			            document.getElementById("iip").value = userId;
			         }else{
			            document.getElementById("rememberme").checked = false;
			         }
			      }
			   }
			}
			
			function submitLoginForm() {
				var storeUsername = false;
				if(document.getElementById("rememberme").checked ==true)
				{
					storeUsername = true;
				}
				var userid_value = document.getElementById("iip").value ;
				if(userid_value == ""){
				      alert("Enter an IBM intranet e-mail address.");
				      return false;
				   }
				var user_pwd = document.getElementById("ppwd").value;
				if(user_pwd == "")
				{
					alert("Enter an IBM intranet password.");
					return false;
				}
				var cookieVal = "null:null:null:null:false";
				if(storeUsername)
				{
					cookieVal = userid_value+":null:null:null:true";
				}
				 setCookie("dstProfileCookie", cookieVal, 365);
			}
		</script>		
	</head>
	<body id="ibm-com" class="ibm-type" onload="prefillUserID();">
		<!--  Level 1 -->
		<div id="ibm-top" class="ibm-landing-page">
			<!--  MAST HEAD START -->
			<!--  Level2 MAST HEAD -->
			<div role="banner" class="ibm-w3-masthead" id="ibm-masthead">
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
				</div>
			</div>
			<!--  MAST HEAD END -->
			<!--  Level2 ibm-content-wrapper" -->
			<div id="ibm-content-wrapper"">
				<!--  Level 3 -->
				<!--
				<header role="banner" aria-labelledby="ibm-pagetitle-h1">
					<div id="ibm-leadspace-head" class="ibm-alternate">
						<div id="ibm-leadspace-body">
							<img src="images/dst.gif"/>
						</div>
					</div>
					<nav role="navigation" aria-labelledby="ibm-pagetitle-h1">
						<div id="ibm-content-nav">
							<div id="ibm-primary-tabs">
							</div>
						</div>
					</nav>
				 </header>
				-->
				<header role="banner" aria-labelledby="ibm-pagetitle-h1">
					<div id="ibm-leadspace-head" class="ibm-alternate">
						<br /><br />
					</div>
				 </header>
				<!--  Level 3 -->
				<main role="main" aria-labelledby="ibm-pagetitle-h1">
					<div id="ibm-pcon">
						<div id="ibm-content">
							<div id="ibm-content-body">
								<div id="ibm-content-main">
									<div class="ibm-columns">
										<form action="j_security_check" method="post" onsubmit="return submitLoginForm();">
											<div class="ibm-col-1-1">
												<div>
													<div style="display:inline-block; height:60px">
														Use your IBM intranet ID to access this site <br/>
														Required fields are marked with an asterisk (*) and must be filled in to complete the form.
													</div>
													<div>
														<span style="display:inline-block;width:100px"><label for="intranet_id">Intranet Id:<span class="ibm-required">*&nbsp;</span></label></span>
														<span style="display:inline-block;width:150px"><input type="text" name="j_username" size="20" id="iip" /></span>
													</div>
													<p>
														<span style="display:inline-block;width:100px"><label for="password">Password:<span class="ibm-required">*&nbsp;</span></label></span>
														<span style="display:inline-block;width:150px"><input type="password" name="j_password" size="20" id="ppwd"/></span>
													</p>
												</div>
												<div>
													<span style="display:inline-block;width:97px">&nbsp;</span>
													<span style="display:inline-block;width:15px; vertical-align: top;"><input type="checkbox" name="rememberme" size="20" id="rememberme" value="rememberme" /></span>
													<span style="display:inline-block;width:135px"><label for="rememberme" style="font-weight: normal">Remember my ID</label></span>
												</div>
												<div>
													<span style="display:inline-block;width:100px">&nbsp;</span>
													<span style="display:inline-block;width:400px">Note: this information will be saved on your PC.</span>
												</div>
												<div><p></p></div>
												<div>
													<span style="display:inline-block;width:100px">&nbsp;</span>
													<span style="display:inline-block;width:150px"><a href="https://w3.ibm.com/profile/update/password/index.html">Forgot password</a></span>
												</div>
												<div class="ibm-rule"><hr/></div>										
												<div class="ibm-buttons-row">
													<p>
														<input value="Submit" type="submit" name="ibm-submit" class="ibm-btn-arrow-pri" />
													</p>
												</div>
											</div>
										</form>
									</div>
								</div>
							</div>
						</div>
					</div>
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