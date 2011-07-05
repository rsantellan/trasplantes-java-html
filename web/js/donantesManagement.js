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
                $("#donante_causa_muerte_container").show();
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
                  $("#donantes_causa_muerte_selector").
                          append($("<option></option>").
                          attr("value",json.options.id).
                          attr("id",'donante_causa_muerte_option_'+json.options.id).
                          text(json.options.nombre));
						
                  $('#donante_donante_causa_muerte_id').
                          append($("<option></option>").
                          attr("value",json.options.id).
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
	
    showDonanteCausaMuerte: function()
    {
      var id = $("#donantes_causa_muerte_selector").val();
      var url = $('#donante_causa_muerte_show_url_input').val();
      $.fancybox.showActivity();
      $.ajax({
          url: url,
          data: {'id': id},
          type: 'post',
          dataType: 'json',
          success: function(json){
              if(json.response == "OK")
              {
                  $("#donante_causa_muerte_container").show();
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
    
    deleteDonanteCausaMuerte: function(id, text, url)
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
                $('#donante_causa_muerte_option_'+json.options.id).remove();
                $("#donante_donante_causa_muerte_id option[value='"+json.options.id+"']").remove();                  
                $("#donante_causa_muerte_container").empty();
                
              }
              else
              {
                $(".donante_causa_muerte_delete_error").show();
                
              }
          }, 
          complete: function()
          {
            $.fancybox.hideActivity();
            $.fancybox.resize();
          }
		});
	  }
	},

    showOrganosManagement: function(url)
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
	
    newDonanteOrgano: function(url)
    {
      $.fancybox.showActivity();
      $.ajax({
          url: url,
          type: 'post',
          dataType: 'json',
          success: function(json){
			  if(json.response == "OK")
              {
                $("#donante_organos_container").html(json.options.body);
                $(".save_button").button();
				$("#donante_organos_container").show();
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
    
    saveDonanteOrganoForm: function(form)
    {
      $.fancybox.showActivity();
      $.ajax({
          url: $(form).attr('action'),
          data: $(form).serialize(),
          type: 'post',
          dataType: 'json',
          success: function(json){
              $("#donante_organos_container").html(json.options.body);
              
              $(".save_button").button();
              
              if(json.response == "OK")
              {
                $('#donante_organos_container input').effect("highlight", {}, 300);
                
                if(json.options.isnew)
                {
				  $("#donantes_organos_selector").
                          append($("<option></option>").
                          attr("value",json.options.id).
                          attr("id",'donante_organos_option_'+json.options.id).
                          text(json.options.nombre));
						
                  $('#donante_donante_organos_list').
                          append($("<option></option>").
                          attr("value",json.options.id).
                          text(json.options.nombre));
                   
                }
                else
                {
                  $('#donante_organos_option_'+json.options.id).text(json.options.nombre);
                
                  $("#donante_donante_organos_list option[value='"+json.options.id+"']").text(json.options.nombre);                  
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
	
    showDonanteOrgano: function()
    {
      var id = $("#donantes_organos_selector").val();
      var url = $('#donante_organos_show_url_input').val();
      $.fancybox.showActivity();
      $.ajax({
          url: url,
          data: {'id': id},
          type: 'post',
          dataType: 'json',
          success: function(json){
              if(json.response == "OK")
              {
				$("#donante_organos_container").show();
                $("#donante_organos_container").html(json.options.body);
                
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
    
    deleteDonanteOrgano: function(id, text, url)
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
                $('#donante_organos_option_'+json.options.id).remove();
                $("#donante_donante_organos_list option[value='"+json.options.id+"']").remove();                  
                $("#donante_organos_container").empty();
                
              }
              else
              {
                $(".donante_causa_muerte_delete_error").show();
                
              }
          }, 
          complete: function()
          {
            $.fancybox.hideActivity();
            $.fancybox.resize();
          }
		});
	  }
	},

    showAntecedentesManagement: function(url)
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
	
    newDonanteAntecedentes: function(url)
    {
      $.fancybox.showActivity();
      $.ajax({
          url: url,
          type: 'post',
          dataType: 'json',
          success: function(json){
              if(json.response == "OK")
              {
                $("#donante_antecedentes_container").html(json.options.body);
                $(".save_button").button();
                $("#donante_antecedentes_container").show();
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
    
    saveDonanteAntecedenteForm: function(form)
    {
      $.fancybox.showActivity();
      $.ajax({
          url: $(form).attr('action'),
          data: $(form).serialize(),
          type: 'post',
          dataType: 'json',
          success: function(json){
              $("#donante_antecedentes_container").html(json.options.body);
              
              $(".save_button").button();
              
              if(json.response == "OK")
              {
                $('#donante_antecedentes_container input').effect("highlight", {}, 300);
                
                if(json.options.isnew)
                {
                  $("#donantes_antecedentes_selector").
                          append($("<option></option>").
                          attr("value",json.options.id).
                          attr("id",'donante_antecedentes_option_'+json.options.id).
                          text(json.options.nombre));
						
                  $('#donante_donante_antecedentes_list').
                          append($("<option></option>").
                          attr("value",json.options.id).
                          text(json.options.nombre));
                   
                }
                else
                {
                  $('#donante_antecedentes_option_'+json.options.id).text(json.options.nombre);
                
                  $("#donante_donante_antecedentes_list option[value='"+json.options.id+"']").text(json.options.nombre);                  
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
	
    showDonanteAntecedente: function()
    {
      var id = $("#donantes_antecedentes_selector").val();
      var url = $('#donante_antecedentes_show_url_input').val();
      $.fancybox.showActivity();
      $.ajax({
          url: url,
          data: {'id': id},
          type: 'post',
          dataType: 'json',
          success: function(json){
              if(json.response == "OK")
              {
                $("#donante_antecedentes_container").show();
                $("#donante_antecedentes_container").html(json.options.body);
                
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
    
    deleteDonanteAntecedente: function(id, text, url)
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
                $('#donante_antecedentes_option_'+json.options.id).remove();
                $("#donante_donante_antecedentes_list option[value='"+json.options.id+"']").remove();                  
                $("#donante_antecedentes_container").empty();
                
              }
              else
              {
                $(".donante_causa_muerte_delete_error").show();
                
              }
          }, 
          complete: function()
          {
            $.fancybox.hideActivity();
            $.fancybox.resize();
          }
        });
	  }
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
    },

//Seroles
    showSerolesManagement: function(url)
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
	
    showSerol: function()
    {
      var id = $("#serol_selector").val();
      var url = $('#serol_show_url_input').val();
      $.fancybox.showActivity();
      $.ajax({
          url: url,
          data: {'id': id},
          type: 'post',
          dataType: 'json',
          success: function(json){
              if(json.response == "OK")
              {
                  $("#serol_container").show();
                  $("#serol_container").html(json.options.body);
                  
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
    
    saveSerolForm: function(form)
    {
      $.fancybox.showActivity();
      $.ajax({
          url: $(form).attr('action'),
          data: $(form).serialize(),
          type: 'post',
          dataType: 'json',
          success: function(json){
              $("#serol_container").html(json.options.body);
              
              $(".save_button").button();
              
              if(json.response == "OK")
              {
                $('#serol_container input').effect("highlight", {}, 300);
                
                if(json.options.isnew)
                {
                  $("#serol_selector").
                          append($("<option></option>").
                          attr("value",json.options.id).
                          attr("id",'serol_option_'+json.options.id).
                          text(json.options.nombre));
                  $(".all_seroles_container").append(json.options.serol_div);
                }
                else
                {
                  $('#serol_option_'+json.options.id).text(json.options.nombre);
                  var selected_value = $(".serol_container_"+json.options.id+" input:checked").val();
                  $('.serol_container_'+json.options.id).replaceWith(json.options.serol_div);
                  $(".serol_container_"+json.options.id+" input[value='"+selected_value+"']").attr("checked", "checked");
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
	
    newSerol: function(url)
    {
      $.fancybox.showActivity();
      $.ajax({
          url: url,
          type: 'post',
          dataType: 'json',
          success: function(json){
              if(json.response == "OK")
              {
                $("#serol_container").html(json.options.body);
                $(".save_button").button();
                $("#serol_container").show();
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
    
    deleteSerol: function(id, text, url)
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
                $('#serol_option_'+json.options.id).remove();
                $('.serol_container_'+json.options.id).remove();
                //$("#donante_donante_antecedentes_list option[value='"+json.options.id+"']").remove();                  
                $("#serol_container").empty();
                
              }
              else
              {
                $(".donante_causa_muerte_delete_error").show();
                
              }
          }, 
          complete: function()
          {
            $.fancybox.hideActivity();
            $.fancybox.resize();
          }
        });
      }
    },
	
    showSerolValor: function()
    {
      var id = $("#serol_valor_selector").val();
      var url = $('#serol_valor_show_url_input').val();
      $.fancybox.showActivity();
      $.ajax({
          url: url,
          data: {'id': id},
          type: 'post',
          dataType: 'json',
          success: function(json){
              if(json.response == "OK")
              {
                  $("#serol_valor_container").show();
                  $("#serol_valor_container").html(json.options.body);
                  
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
	
    newSerolValor: function(url, id)
    {
      $.fancybox.showActivity();
      $.ajax({
          url: url,
          type: 'post',
          data: {'id': id},
          dataType: 'json',
          success: function(json){
              if(json.response == "OK")
              {
                $("#serol_valor_container").html(json.options.body);
                $(".save_button").button();
                $("#serol_valor_container").show();
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
    
    saveSerolValorForm: function(form)
    {
      $.fancybox.showActivity();
      $.ajax({
          url: $(form).attr('action'),
          data: $(form).serialize(),
          type: 'post',
          dataType: 'json',
          success: function(json){
              $("#serol_valor_container").html(json.options.body);
              
              $(".save_button").button();
              
              if(json.response == "OK")
              {
                $('#serol_valor_container input').effect("highlight", {}, 300);
                
                if(json.options.isnew)
                {
                  $("#serol_valor_selector").
                          append($("<option></option>").
                          attr("value",json.options.id).
                          attr("id",'serol_valor_option_'+json.options.id).
                          text(json.options.nombre));
                }
                else
                {
                  $('#serol_valor_option_'+json.options.id).text(json.options.nombre);
                
                  //$("#donante_donante_organos_list option[value='"+json.options.id+"']").text(json.options.nombre);                  
                }
                var selected_value = $(".serol_container_"+json.options.serol_id+" input:checked").val();
                $('.serol_container_'+json.options.serol_id).replaceWith(json.options.serol_div);
                $(".serol_container_"+json.options.serol_id+" input[value='"+selected_value+"']").attr("checked", "checked");                
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
    
    deleteSerolValor: function(id, text, url)
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
                $('#serol_valor_option_'+json.options.id).remove();
                //$("#donante_donante_antecedentes_list option[value='"+json.options.id+"']").remove();                  
                $("#serol_valor_container").empty();
                var selected_value = $(".serol_container_"+json.options.serol_id+" input:checked").val();
                $('.serol_container_'+json.options.serol_id).replaceWith(json.options.serol_div);
                $(".serol_container_"+json.options.serol_id+" input[value='"+selected_value+"']").attr("checked", "checked");                                
                
              }
              else
              {
                $(".donante_causa_muerte_delete_error").show();
                
              }
          }, 
          complete: function()
          {
            $.fancybox.hideActivity();
            $.fancybox.resize();
          }
        });
      }
    }
}



/*
  Seleccionar un radio button que esta checked
* 
  $("#serol_container_1 input:checked").val()
* 
  Para volver a seleccionar el valor
*
  $("#serol_container_1 input[value='3']").attr("checked", "checked");

*/
