reoperacionesManagement = function(options){
	this._initialize();

}

reoperacionesManagement.instance = null;

reoperacionesManagement.getInstance = function (){
	if(reoperacionesManagement.instance == null)
		reoperacionesManagement.instance = new reoperacionesManagement();
	return reoperacionesManagement.instance;
}

reoperacionesManagement.prototype = {
    _initialize: function(){
        
    },
	
	showHideComplicationType: function(element)
	{
	  if($(element).val() == 1)
	  {
		$("#complicacion_no_infecciosa select").val(0);
		$("#complicacion_infecciosa").removeClass("hide");
		$("#complicacion_no_infecciosa").addClass("hide");
	  }
	  else
	  {
		$("#complicacion_infecciosa select").val(0);
		$("#complicacion_infecciosa").addClass("hide");
		$("#complicacion_no_infecciosa").removeClass("hide");
	  }
	},
	
	basicFormValidation: function()
	{
	  var radio = $('input[name=trasplante_reoperacion[es_infecciosa]]:checked', '#reoperacion_form').val();
	  if(radio == 1 && $("#complicacion_infecciosa select").val() == 0)
	  {
		alert($("#reoperacion_sin_infeccion_error").val());
		return false;
	  }
	  else
	  {
		if(radio == 0 && $("#complicacion_no_infecciosa select").val() == 0)
		{
		  alert($("#reoperacion_sin_infeccion_error").val());
		  return false;
		}
	  }
	  return true;
	},
	
	deleteReoperacion: function(id, text, url)
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
                $('#reoperacion_'+json.options.id).fadeOut("slow", function(){$(this).remove();});
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

