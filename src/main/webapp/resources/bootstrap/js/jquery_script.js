/**
 * 
 */

$(document).ready(function(){
	
//	var url      =  window.location.href;
//	var urlarr=url.split("/");
//	urlarrlength=urlarr.length;
//	var urltitle=urlarr[urlarrlength-1];
//	if(urltitle===""){
//		urltitle="home"
//	}
//	$('#navigator li a[href='+urltitle+']').closest('li').addClass("selected");
	
	$('#login_link').click(function(){$('#loginModal').addClass('show');});
	$("#login_close").click(function(){$("#loginModal").removeClass("show");});
	
	

});