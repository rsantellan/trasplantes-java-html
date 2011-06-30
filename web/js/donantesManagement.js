donantesManagement = function(options){
	this._initialize();

}

donantesManagement.instance = null;

donantesManagement.getInstance = function (){
	if(donantesManagement.instance == null)
		donantesManagement.instance = new donantesManagement();
	return donantesManagement.instance;
}

donantesManagement.prototype = {
    _initialize: function(){
        
    },
    
    newDonante: function(url)
    {
      $.fancybox.showActivity();
      $.ajax({
          url: url,
          type: 'post',
          dataType: 'json',
          success: function(json){
              if(json.response == "OK")
              {
                $("#donante_container").html(json.options.body);
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
            donantesManagement.getInstance().reenableToolTips();
          }
      });

      return false;       
    },
    
    showDonante: function()
    {
      var id = $("#donantes_selector").val();
      var url = $('#donante_show_url_input').val();
      $.fancybox.showActivity();
      $.ajax({
          url: url,
          data: {'id': id},
          type: 'post',
          dataType: 'json',
          success: function(json){
              if(json.response == "OK")
              {
                $("#donante_container").html(json.options.body);
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
              $("#donante_container").html(json.options.body);
              
              $(".save_button").button();
              
              if(json.response == "OK")
              {
                $('#donante_container').effect("highlight", {}, 300);
                
                if(json.options.isnew)
                {
                  //alert("aca esto funca");
                  $('#pacientes_nefropatia_id').
                          append($("<option></option>").
                          attr("value",json.options.id).
                          text(json.options.identificador));
                          
                   $("#donantes_selector").
                          append($("<option></option>").
                          attr("value",json.options.id).
                          attr("id",'nefropatia_option_'+json.options.id).
                          text(json.options.identificador));
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
    
    deleteDonante: function(id, text, url)
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
                $('#donante_option_'+json.options.id).remove();
                //$("#pacientes_nefropatia_id option[value='"+json.options.id+"']").remove();                  
                $("#donante_container").empty();
                
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
    
    showCausaMuerteManagement: function(url)
    {
      $.fancybox.showActivity();
      $.ajax({
          url: url,
          type: 'post',
          dataType: 'json',
          success: function(json){
              if(json.response == "OK")
              {
                $("#auxiliary_fields").html(json.options.body);
                $("#auxiliary_fields").show();
                $("#donante_manage_container").fadeOut('slow', function() {
                  $.fancybox.resize();
                });
                $("#donante_container").fadeOut('slow', function() {
                  $.fancybox.resize();
                });
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
    
    verDonante: function()
    {
      $("#donante_container").fadeIn('slow', function() {
        $.fancybox.resize();
      });       
      $("#auxiliary_fields").fadeOut('slow', function() {
        $("#auxiliary_fields").empty();
        $.fancybox.resize();
      });
      
      $("#donante_manage_container").fadeIn('slow', function() {
        $.fancybox.resize();
      });
      $.fancybox.resize();
    },
    
    newDonanteCausaMuerte: function(url)
    {
      $.fancybox.showActivity();
      $.ajax({
          url: url,
          type: 'post',
          dataType: 'json',
          success: function(json){
              if(json.response == "OK")
              {
                $("#donante_causa_muerte_container").html(json.options.body);
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
    
    saveDonanteCausaMuerteForm: function(form)
    {
      $.fancybox.showActivity();
      $.ajax({
          url: $(form).attr('action'),
          data: $(form).serialize(),
          type: 'post',
          dataType: 'json',
          success: function(json){
              $("#donante_causa_muerte_container").html(json.options.body);
              
              $(".save_button").button();
              
              if(json.response == "OK")
              {
                $('#donante_causa_muerte_container input').effect("highlight", {}, 300);
                
                if(json.options.isnew)
                {
                  //alert("aca esto funca");
                  $('#donante_donante_causa_muerte_id').
                          append($("<option></option>").
                          attr("value",json.options.id).
                          text(json.options.nombre));
                          
                   $("#donantes_selector").
                          append($("<option></option>").
                          attr("value",json.options.id).
                          attr("id",'donante_option_'+json.options.id).
                          text(json.options.nombre));
                }
                else
                {
                  $('#donante_option_'+json.options.id).text(json.options.nombre);
                
                  $("#donante_donante_causa_muerte_id option[value='"+json.options.id+"']").text(json.options.nombre);                  
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
	
    
    reenableToolTips: function()
    {
      return false;
      $('#donante_container a.simple_tip_container').each(function() {
        $(this).simpletip({
          content : $(this).find("div.tooltip_text").text(),
          fixed: false, 
          position: ["-5", "-60"]
        });
      });
    }
}
