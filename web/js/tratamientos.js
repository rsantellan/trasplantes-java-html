tratamientoManagement = function(options){
	this._initialize();

}

tratamientoManagement.instance = null;

tratamientoManagement.getInstance = function (){
	if(tratamientoManagement.instance == null)
		tratamientoManagement.instance = new tratamientoManagement();
	return tratamientoManagement.instance;
}

tratamientoManagement.prototype = {
    _initialize: function(){
        
    },
 
    saveForm: function(form){
      $.fancybox.showActivity();
      $.ajax({
          url: $(form).attr('action'),
          data: $(form).serialize(),
          type: 'post',
          dataType: 'json',
          success: function(json){
              if(json.response == "OK")
              {
                  if(json.options.isnew == true)
                  {
                      $("#tratamientos_tbody").append(json.options.body);
                      
                  }
                  else
                  {
                      $('#tratamiento_row_'+json.options.id).replaceWith(json.options.body);
                  }
                  $.fancybox.close();
              }
              else
              {
                  $("#tratamiento_form_container").replaceWith(json.options.body);
              }
                  
          }
          , 
          complete: function()
          {
            $.fancybox.hideActivity();
            $.fancybox.resize();
          }
      });
      return false;        
    },
    
    saveFechaAltaForm: function(form)
    {
      $.fancybox.showActivity();
      $.ajax({
          url: $(form).attr('action'),
          data: $(form).serialize(),
          type: 'post',
          dataType: 'json',
          success: function(json)
          {
            if(json.response == "OK")
            {
              $('#tratamiento_row_'+json.options.id).replaceWith(json.options.body);
              $.fancybox.close();
            }
            else
            {
              $("#fecha_alta_form_container").html(json.options.body);
            }
          }, 
          complete: function()
          {
            $.fancybox.hideActivity();
            $.fancybox.resize();
          }
      });

      return false;
      
    },
    
    deleteTratamiento: function(id, text, url)
    {
      if(confirm(text))
      {
        $.fancybox.showActivity();
        $.ajax({
          url: url,
          data: {'id': id},
          type: 'post',
          dataType: 'json',
          success: function(json){
              if(json.response == "OK")
              {
                $('#tratamiento_row_'+json.options.id).fadeOut("slow", function(){$(this).remove();});
              }
              else
              {
                
              }
          }, 
          complete: function()
          {
            $.fancybox.hideActivity();
            $.fancybox.resize();
          }
      });
	}
	return false;
      
    }
}

$(document).ready(function(){
  $(".fancy_small_link").fancybox({
        'transitionIn'        :   'fade',
        'transitionOut'       :   'fade',
        'hideOnOverlayClick'  :   false
    
    });
});