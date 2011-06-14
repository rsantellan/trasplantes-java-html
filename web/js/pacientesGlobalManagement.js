$(document).ready(function(){

  $('.simple_tip_container').each(function() {
	  $(this).simpletip({
		  content : $(this).find("div.tooltip_text").text(),
		  fixed: true, 
		  position: ["25", "-40"]
	  });
  });
  
  $("a#paciente_basic_info_link").fancybox({
		'transitionIn'	:	'elastic',
		'transitionOut'	:	'elastic',
		'speedIn'		:	600, 
		'speedOut'		:	200,
		'titlePosition'	:	'outside'
	});
});