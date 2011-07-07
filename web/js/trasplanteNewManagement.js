

trasplanteNewManagement = function(options){
	this._initialize();

}

trasplanteNewManagement.instance = null;

trasplanteNewManagement.getInstance = function (){
	if(trasplanteNewManagement.instance == null)
		trasplanteNewManagement.instance = new trasplanteNewManagement();
	return trasplanteNewManagement.instance;
}

trasplanteNewManagement.prototype = {
    _initialize: function(){
        
    },
    //Inmunosupresores
    newInmunosupresor: function(url)
    {
      $.fancybox.showActivity();
      $.ajax({
          url: url,
          type: 'post',
          dataType: 'json',
          success: function(json){
              if(json.response == "OK")
              {
                $("#inmunosupresores_container").html(json.options.body);
                $("#inmunosupresores_container").show();
                $(".save_button").button();
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

      return false;       
    },
    
    showInmunosupresor: function()
    {
      var id = $("#inmunosupresores_selector").val();
      var url = $('#inmunosupresores_show_url_input').val();
      $.fancybox.showActivity();
      $.ajax({
          url: url,
          data: {'id': id},
          type: 'post',
          dataType: 'json',
          success: function(json){
              if(json.response == "OK")
              {
                $("#inmunosupresores_container").html(json.options.body);
                $("#inmunosupresores_container").show();
                $(".save_button").button();
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

      return false;      
    },
    
    saveInmunosupresorForm: function(form)
    {
      $.fancybox.showActivity();
      $.ajax({
          url: $(form).attr('action'),
          data: $(form).serialize(),
          type: 'post',
          dataType: 'json',
          success: function(json){
              $("#inmunosupresores_container").html(json.options.body);
              
              $(".save_button").button();
              
              if(json.response == "OK")
              {
                $('#inmunosupresores_container input').effect("highlight", {}, 300);
                
                if(json.options.isnew)
                {
                  //alert("aca esto funca");
                  $('#trasplante_trasplante_inmunosupresores_list').
                          append($("<option></option>").
                          attr("value",json.options.id).
                          text(json.options.nombre));
                          
                   $("#inmunosupresores_selector").
                          append($("<option></option>").
                          attr("value",json.options.id).
                          attr("id",'inmunosupresores_option_'+json.options.id).
                          text(json.options.nombre));
                }
                else
                {
                  $('#inmunosupresores_option_'+json.options.id).text(json.options.nombre);
                
                  $("#trasplante_trasplante_inmunosupresores_list option[value='"+json.options.id+"']").text(json.options.nombre);                  
                }
                
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
    
    deleteInmunosupresor: function(id, text, url)
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
                $('#inmunosupresores_option_'+json.options.id).remove();
                $("#trasplante_trasplante_inmunosupresores_list option[value='"+json.options.id+"']").remove();                  
                $("#inmunosupresores_container").empty();
                
              }
              else
              {
                $(".nefropatia_delete_error").show();
                
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
      
    },
    //Inducciones
    newInduccion: function(url)
    {
      $.fancybox.showActivity();
      $.ajax({
          url: url,
          type: 'post',
          dataType: 'json',
          success: function(json){
              if(json.response == "OK")
              {
                $("#induccion_container").html(json.options.body);
                $("#induccion_container").show();
                $(".save_button").button();
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

      return false;       
    },
    
    showInduccion: function()
    {
      var id = $("#induccion_selector").val();
      var url = $('#induccion_show_url_input').val();
	  
      $.fancybox.showActivity();
      $.ajax({
          url: url,
          data: {'id': id},
          type: 'post',
          dataType: 'json',
          success: function(json){
              if(json.response == "OK")
              {
                $("#induccion_container").html(json.options.body);
                $("#induccion_container").show();
                $(".save_button").button();
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

      return false;      
    },
    
    saveInduccionForm: function(form)
    {
      $.fancybox.showActivity();
      $.ajax({
          url: $(form).attr('action'),
          data: $(form).serialize(),
          type: 'post',
          dataType: 'json',
          success: function(json){
              $("#induccion_container").html(json.options.body);
              
              $(".save_button").button();
              
              if(json.response == "OK")
              {
                $('#induccion_container input').effect("highlight", {}, 300);
                
                if(json.options.isnew)
                {
                  //alert("aca esto funca");
                  $('#trasplante_trasplante_inducciones_list').
                          append($("<option></option>").
                          attr("value",json.options.id).
                          text(json.options.nombre));
                          
                   $("#induccion_selector").
                          append($("<option></option>").
                          attr("value",json.options.id).
                          attr("id",'induccion_option_'+json.options.id).
                          text(json.options.nombre));
                }
                else
                {
                  $('#induccion_option_'+json.options.id).text(json.options.nombre);
                
                  $("#trasplante_trasplante_inducciones_list option[value='"+json.options.id+"']").text(json.options.nombre);                  
                }
                
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
    
    deleteInduccion: function(id, text, url)
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
                $('#induccion_option_'+json.options.id).remove();
                $("#trasplante_trasplante_inducciones_list option[value='"+json.options.id+"']").remove();                  
                $("#induccion_container").empty();
                
              }
              else
              {
                $(".nefropatia_delete_error").show();
                
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
  
  $(".save_button").button();
  $(".cancel_link").button();
  
  $("#manage_donantes_link").fancybox({
        'transitionIn'        :   'fade',
        'transitionOut'       :   'fade',
        'hideOnOverlayClick'  :   false,
        'autoDimensions'      :   false,
        'width'               :   560
    
    });  


  $("#manage_inmunosupresores_link").fancybox({
        'transitionIn'        :   'fade',
        'transitionOut'       :   'fade',
        'hideOnOverlayClick'  :   false,
        'autoDimensions'      :   false,
        'width'               :   560
    
    });  

  $("#manage_inducciones_link").fancybox({
        'transitionIn'        :   'fade',
        'transitionOut'       :   'fade',
        'hideOnOverlayClick'  :   false,
        'autoDimensions'      :   false,
        'width'               :   560
    
    });  
	
	
	
  $("#form_tabs").tabs();
  $('.simple_tip_container').hover(function(){
									$(this).find("div.tooltip_text").show();
								  }, 
								  function(){
									$(this).find("div.tooltip_text").hide();
								  });
});