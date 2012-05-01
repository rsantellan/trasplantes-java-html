$(document).ready(function(){
$('.simple_tip_container').each(function() {
	  $(this).simpletip({
		  content : $(this).find("div.tooltip_text").text(),
		  fixed: true, 
		  position: ["-5", "-60"]
	  });
  });  
  $(".save_button").button();
  
  $("#manage_nefropatias_link").fancybox({
        'transitionIn'        :   'fade',
        'transitionOut'       :   'fade',
        'hideOnOverlayClick'  :   false
    
    });
});


function deletePaciente(texto, texto2)
{
  if(confirm(texto))
  {
      if(confirm(texto2))
      {
          return true;
      }
  }
  return false;
}