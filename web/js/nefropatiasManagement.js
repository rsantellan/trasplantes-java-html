nefropatiasManagement = function(options){
	this._initialize();

}

nefropatiasManagement.instance = null;

nefropatiasManagement.getInstance = function (){
	if(nefropatiasManagement.instance == null)
		nefropatiasManagement.instance = new nefropatiasManagement();
	return nefropatiasManagement.instance;
}

nefropatiasManagement.prototype = {
    _initialize: function(){
        
    },
    
    newNefropatia: function(url)
    {
      $.fancybox.showActivity();
      $.ajax({
          url: url,
          type: 'post',
          dataType: 'json',
          success: function(json){
              if(json.response == "OK")
              {
                $("#nefropatia_container").html(json.options.body);
                
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
    
    showNefropatia: function()
    {
      var id = $("#nefropatias_selector").val();
      var url = $('#nefropatias_show_url_input').val();
      $.fancybox.showActivity();
      $.ajax({
          url: url,
          data: {'id': id},
          type: 'post',
          dataType: 'json',
          success: function(json){
              if(json.response == "OK")
              {
                $("#nefropatia_container").html(json.options.body);
                
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
    
    saveForm: function(form)
    {
      $.fancybox.showActivity();
      $.ajax({
          url: $(form).attr('action'),
          data: $(form).serialize(),
          type: 'post',
          dataType: 'json',
          success: function(json){
              $("#nefropatia_container").html(json.options.body);
              
              $(".save_button").button();
              
              if(json.response == "OK")
              {
                $('#nefropatia_container input').effect("highlight", {}, 300);
                
                if(json.options.isnew)
                {
                  //alert("aca esto funca");
                  $('#pacientes_nefropatia_id').
                          append($("<option></option>").
                          attr("value",json.options.id).
                          text(json.options.nombre));
                          
                   $("#nefropatias_selector").
                          append($("<option></option>").
                          attr("value",json.options.id).
                          attr("id",'nefropatia_option_'+json.options.id).
                          text(json.options.nombre));
                }
                else
                {
                  $('#nefropatia_option_'+json.options.id).text(json.options.nombre);
                
                  $("#pacientes_nefropatia_id option[value='"+json.options.id+"']").text(json.options.nombre);                  
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
    
    deleteNefropatia: function(id, text, url)
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
                $('#nefropatia_option_'+json.options.id).remove();
                $("#pacientes_nefropatia_id option[value='"+json.options.id+"']").remove();                  
                $("#nefropatia_container").empty();
                
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
