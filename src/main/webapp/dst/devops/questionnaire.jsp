b<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<script type="text/javascript">
dojo.addOnLoad(function(){
	var ribbon = dojo.query('.ibm-ribbon2 .ibm-container-body'); 
	var s = new ibmweb.ribbon({
		srcNodeRef: ribbon[0],
		autoscroll: true, 
		freeScroll: true,
		interval: 5000
	});

	dojo.query('.ibm-ribbon2').forEach(function(i){
		dojo.addClass(i, 'ibm-ribbon');
	});
		
	s.startup();
});
</script>
<div id="ibm-pcon">
	<div id="ibm-content">
		<div id="ibm-content-body">
			<div id="ibm-content-main">
				<div class="ibm-columns">
					<div class="ibm-container ibm-ribbon">
						<div dojoattachpoint="ribbonContainer" class="ibm-container-body" id="ibmweb_ribbon_0" widgetid="ibmweb_ribbon_0">
							<a href="#" role="button" dojoattachpoint="scrollLeftButton" class="ibm-ribbon-prev ibm-disabled" style="margin-top: 98px;" title="Previous">Previous</a>
							<div dojoattachpoint="scrollContainer" class="ibm-ribbon-pane" style="height: 220px;">	
								<div role="listbox" dojoattachpoint="scrollableNode" class="ibm-ribbon-section" id="ibmweb_ribbon_0_scrollable" style="left: 0px;">
									<div role="option" dojoattachpoint="containerNode" class="ibm-columns" id="ibmweb_ribbonSlide_0" widgetid="ibmweb_ribbonSlide_0">
										<div class="ibm-col-1-1" role="document" tabindex="0" id="ibmweb_ribbonItemAbstract_0" widgetid="ibmweb_ribbonItemAbstract_0">
											<div style="padding:10px;">
												<h2 id="carouselfont">Choose the SCM (You are 4 steps away from completing the questionnaire! )</h2>
												<label for="scm">Choose your SCM:</label>
												<select class="ibm-styled" name="scm_sel" id="scm_sel">
													<option>CVS</option>
													<option>Jazz Source Control</option>
												</select>
												<label for="other_scm">Other:</label>
												<input name="other_scm" id="other_scm" placeholder="Enter SCM of your choice...">
											</div>
										</div>
									</div>
									<div role="option" dojoattachpoint="containerNode" class="ibm-columns" id="ibmweb_ribbonSlide_1" widgetid="ibmweb_ribbonSlide_1">
										<div class="ibm-col-1-1" role="document" tabindex="-1" id="ibmweb_ribbonItemAbstract_1" widgetid="ibmweb_ribbonItemAbstract_1">
											<div style="padding:10px;">
												<h2 id="carouselfont">Choose the Build (You are 3 steps away from completing the questionnaire! )</h2>
												<label for="other_bld">Other:</label>
												<input name="other_bld" id="other_bld" placeholder="Enter Bld of your choice...">
											</div>
										</div>
									</div>
									<div role="option" dojoattachpoint="containerNode" class="ibm-columns" id="ibmweb_ribbonSlide_2" widgetid="ibmweb_ribbonSlide_2">
										<div class="ibm-col-1-1" role="document" tabindex="-1" id="ibmweb_ribbonItemAbstract_2" widgetid="ibmweb_ribbonItemAbstract_2">
											<div style="padding:10px;">
												<h2 id="carouselfont">Choose the server provisioning(You are 2 steps away from completing the questionnaire! )</h2>
												<label for="other_serv">Other:</label>
												<input name="other_serv" id="other_serv" placeholder="Enter Server Provisioning of your choice...">
											</div>
										</div>
									</div>
									<div role="option" dojoattachpoint="containerNode" class="ibm-columns" id="ibmweb_ribbonSlide_3" widgetid="ibmweb_ribbonSlide_2">
										<div class="ibm-col-1-1" role="document" tabindex="-1" id="ibmweb_ribbonItemAbstract_3" widgetid="ibmweb_ribbonItemAbstract_2">
											<div style="padding:10px;">
												<h2 id="carouselfont">Choose the deployment options(You are 2 steps away from completing the questionnaire! )</h2>
												<label for="other_deploy">Other:</label>
												<input name="other_deploy" id="other_deploy" placeholder="Enter Deployment Option of your choice...">
											</div>
										</div>
									</div>
									<div role="option" dojoattachpoint="containerNode" class="ibm-columns" id="ibmweb_ribbonSlide_4" widgetid="ibmweb_ribbonSlide_2">
										<div class="ibm-col-1-1" role="document" tabindex="-1" id="ibmweb_ribbonItemAbstract_4" widgetid="ibmweb_ribbonItemAbstract_2">
											<div style="padding:10px;">
												<h2 id="carouselfont">Choose the testing options(You are 2 steps away from completing the questionnaire! )</h2>
												<label for="other_test">Other:</label>
												<input name="other_test" id="other_test" placeholder="Enter testing Provisioning of your choice...">
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<a href="#" role="button" dojoattachpoint="scrollRightButton" class="ibm-ribbon-next" title="Next">Next</a>
						<div class="ibm-ribbon-nav" role="toolbar" dojoattachpoint="navNode">
							<a class="ibm-active" href="#" role="button" aria-controls="ibmweb_ribbon_0_scrollable" ibmcarouselindex="0" tabindex="0">Show carousel 1</a>
							<a class="" href="#" role="button" aria-controls="ibmweb_ribbon_0_scrollable" ibmcarouselindex="1" tabindex="-1">Show carousel 2</a>
							<a class="" href="#" role="button" aria-controls="ibmweb_ribbon_0_scrollable" ibmcarouselindex="2" tabindex="-1">Show carousel 3</a>
							<a class="" href="#" role="button" aria-controls="ibmweb_ribbon_0_scrollable" ibmcarouselindex="3" tabindex="-1">Show carousel 4</a>
							<a class="" href="#" role="button" aria-controls="ibmweb_ribbon_0_scrollable" ibmcarouselindex="4" tabindex="-1">Show carousel 5</a>
						</div>						
					</div>
				</div>
			</div>
		</div>
	</div>
</div>