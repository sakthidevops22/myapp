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
					<!--
					<div id="ibm-leadspace-head" class="ibm-alternate">
						<div id="ibm-leadspace-body">
							<div class="ibm-columns">
								<div class="ibm-col-6-4">
								</div>
							</div>
						</div>
					</div>
					 -->
					<nav role="navigation" aria-labelledby="ibm-pagetitle-h1">
						<div id="ibm-content-nav">
							<div id="ibm-primary-tabs">
							</div>
						</div>
					</nav>
				</header>
				<!--  Level 3 -->
				<main role="main" aria-labelledby="ibm-pagetitle-h1">
				<div id="ibm-pcon">
					<div id="ibm-content">
						<div id="ibm-content-body">
							<div id="ibm-content-main">
								<div class="ibm-columns">
										<div class="ibm-col-1-1">
											<div>
												<br>
												<div>
												<p>
												<b>Unauthorized access attempted</b>
												</p>
												<p>
												You must obtain access to continue
												</p>
												<p>
												You have attempted to access the <!-- DST --> My Tools application, but currently you are not authorized for access. If you feel that this is in error, please send an email DST Team.
												</p>
												<p>
												<b>NOTE:</b> <!-- DST --> My Tools has adopted the use of Blue Groups for access authorization. This is required to comply with Data Privacy policy requirements. If you require authorization, please contact DST Team.
												</p> 
												</div>
												<br>
												<br>
											</div>
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