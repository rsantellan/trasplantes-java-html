$(document).ready(function(){
  $('.simple_tip_container').each(function() {
	  $(this).simpletip({
		  content : $(this).find("div.tooltip_text").text(),
		  fixed: true, 
		  position: ["-5", "-60"]
	  });
  });  
  $(".save_button").button();
  $(".cancel_link").button();
  
  $("#manage_donantes_link").fancybox({
        'transitionIn'        :   'fade',
        'transitionOut'       :   'fade',
        'hideOnOverlayClick'  :   false,
        'autoDimensions'      :   false,
        'width'               :   560
    
    });  
});
