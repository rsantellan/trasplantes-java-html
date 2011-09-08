complicacionesManagement = function(options){
	this._initialize();

}

complicacionesManagement.instance = null;

complicacionesManagement.getInstance = function (){
	if(complicacionesManagement.instance == null)
		complicacionesManagement.instance = new complicacionesManagement();
	return complicacionesManagement.instance;
}

complicacionesManagement.prototype = {
    _initialize: function(){
        
    },

    saveFormNoInfecciosa: function(form)
    {
      $.fancybox.showActivity();
      $.ajax({
          url: $(form).attr('action'),
          data: $(form).serialize(),
          type: 'post',
          dataType: 'json',
          success: function(json){
              if(json.response == "OK")
              {
                //$('#donante_container').effect("highlight", {}, 300);
                
                if(json.options.isnew)
                {
                  if(!json.options.is_evolucion)
                  {
                    $("#complicaciones_no_infecciosas_trasplante_list").append(json.options.body);
                  }
                  else
                  {
                    $("#complicaciones_no_infecciosas_evolucion_list").append(json.options.body);
                  }
                  
				  
                }
                else
                {
                  $("#complicacion_"+json.options.id).replaceWith(json.options.body);
                }
                $("#complicaciones_no_infecciosas_trasplante_list").effect("highlight", {}, 2000);
                $.fancybox.close();
                
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


    showMedicacionesManagement: function(url)
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
				if($("#trasplante_complicacion_no_infecciosa_form").length != 0)
				{
				  $("#trasplante_complicacion_no_infecciosa_form").fadeOut('slow', function() {
					$.fancybox.resize();
				  });
				}
                
                
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
	
    showMedicacion: function()
    {
      var id = $("#complicacion_medicacion_selector").val();
      var url = $('#complicacion_medicacion_show_url_input').val();
      $.fancybox.showActivity();
      $.ajax({
          url: url,
          data: {'id': id},
          type: 'post',
          dataType: 'json',
          success: function(json){
              if(json.response == "OK")
              {
                  $("#complicacion_medicacion_container").show();
                  $("#complicacion_medicacion_container").html(json.options.body);
                  
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
    
    saveMedicacionForm: function(form)
    {
      $.fancybox.showActivity();
      $.ajax({
          url: $(form).attr('action'),
          data: $(form).serialize(),
          type: 'post',
          dataType: 'json',
          success: function(json){
              $("#complicacion_medicacion_container").html(json.options.body);
              
              $(".save_button").button();
              
              if(json.response == "OK")
              {
				var isInfecciosa = false;
				if($('#trasplante_complicaciones_no_infecciosas_medicacion_id').length == 0)
				{
				  isInfecciosa = true;
				}
                $('#complicacion_medicacion_container input').effect("highlight", {}, 300);
                
                if(json.options.isnew)
                {
                  $("#complicacion_medicacion_selector").
                          append($("<option></option>").
                          attr("value",json.options.id).
                          attr("id",'complicacion_medicacion_option_'+json.options.id).
                          text(json.options.nombre));
				  	
				  if(!isInfecciosa)
				  {
					$('#trasplante_complicaciones_no_infecciosas_medicacion_id').
							  append($("<option></option>").
							  attr("value",json.options.id).
							  text(json.options.nombre));	
				  }
                  
                   
                }
                else
                {
                  $('#complicacion_medicacion_option_'+json.options.id).text(json.options.nombre);
				  if(!isInfecciosa)
				  {
					$("#trasplante_complicaciones_no_infecciosas_medicacion_id option[value='"+json.options.id+"']").text(json.options.nombre);                  
				  }
				  else
				  {
					
				  }
                  
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
	
    newMedicacion: function(url)
    {
      $.fancybox.showActivity();
      $.ajax({
          url: url,
          type: 'post',
          dataType: 'json',
          success: function(json){
              if(json.response == "OK")
              {
                $("#complicacion_medicacion_container").show();
                $("#complicacion_medicacion_container").html(json.options.body);
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
    
    deleteMedicacion: function(id, text, url)
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
				var isInfecciosa = false;
				if($('#trasplante_complicaciones_no_infecciosas_medicacion_id').length == 0)
				{
				  isInfecciosa = true;
				}
                $('#complicacion_medicacion_option_'+json.options.id).remove();
				if(!isInfecciosa)
				{
				  $("#trasplante_complicaciones_no_infecciosas_medicacion_id option[value='"+json.options.id+"']").remove();
				}
                                  
                $("#complicacion_medicacion_container").empty();
                
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


    showComplicacionesTipoManagement: function(url)
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
				if($("#trasplante_complicacion_no_infecciosa_form").length != 0)
				{
				  $("#trasplante_complicacion_no_infecciosa_form").fadeOut('slow', function() {
					$.fancybox.resize();
				  });
				}
                
                
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
 
    showComplicacionTipo: function()
    {
      var id = $("#complicacion_tipo_selector").val();
      var url = $('#complicacion_tipo_show_url_input').val();
      $.fancybox.showActivity();
      $.ajax({
          url: url,
          data: {'id': id},
          type: 'post',
          dataType: 'json',
          success: function(json){
              if(json.response == "OK")
              {
                  $("#complicacion_tipo_container").show();
                  $("#complicacion_tipo_container").html(json.options.body);
                  
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
	
    newComplicacionTipo: function(url)
    {
      $.fancybox.showActivity();
      $.ajax({
          url: url,
          type: 'post',
          dataType: 'json',
          success: function(json){
              if(json.response == "OK")
              {
                $("#complicacion_tipo_container").show();
                $("#complicacion_tipo_container").html(json.options.body);
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
	
	saveComplicacionTipoForm: function(form)
    {
      $.fancybox.showActivity();
      $.ajax({
          url: $(form).attr('action'),
          data: $(form).serialize(),
          type: 'post',
          dataType: 'json',
          success: function(json){
              $("#complicacion_tipo_container").html(json.options.body);
              
              $(".save_button").button();
              
              if(json.response == "OK")
              {
				$('#complicacion_tipo_container input').effect("highlight", {}, 300);
                
                if(json.options.isnew)
                {
                  $("#complicacion_tipo_selector").
                          append($("<option></option>").
                          attr("value",json.options.id).
                          attr("id",'complicacion_tipo_option_'+json.options.id).
                          text(json.options.nombre));
                        complicacionesManagement.getInstance().refrescarComplicacionTipoSelect();
                }
                else
                {
                  $('#complicacion_tipo_option_'+json.options.id).text(json.options.nombre);
                  complicacionesManagement.getInstance().refrescarComplicacionTipoSelect();
                }
                
              }
			  else
			  {
				$("#complicacion_valor_container").html(json.options.body);
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
	
  refrescarComplicacionTipoSelect: function()
  {
    var url = $("#complicacion_valor_refrescar_datos").val();
		$.ajax({
          url: url,
          type: 'post',
          dataType: 'json',
          success: function(json){
              if(json.response == "OK")
              {
                $("#trasplante_complicaciones_no_infecciosas_complicacion_valor_id").find('option').remove().end();
                for(index in json.options.list)
                {
                  var aux = json.options.list[index];
                  $('#trasplante_complicaciones_no_infecciosas_complicacion_valor_id').
                    append($("<option></option>").
                    attr("value",aux.id).
                    text(aux.name));	
                }
                
                
              }
              else
              {
                
              }
          }
		});    
  },
  
	deleteComplicacionTipo: function(id, text, url)
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
				$('#complicacion_tipo_option_'+json.options.id).remove();
				complicacionesManagement.getInstance().refrescarComplicacionTipoSelect();
                $("#complicacion_tipo_container").empty();
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
	
    showComplicacionTipoValor: function()
    {
      var id = $("#complicacion_tipo_valor_selector").val();
      var url = $('#complicacion_tipo_valor_show_url_input').val();
      $.fancybox.showActivity();
      $.ajax({
          url: url,
          data: {'id': id},
          type: 'post',
          dataType: 'json',
          success: function(json){
              if(json.response == "OK")
              {
                  $("#complicacion_tipo_valor_container").show();
                  $("#complicacion_tipo_valor_container").html(json.options.body);
                  
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

    newComplicacionTipoValor: function(url, id)
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
                $("#complicacion_tipo_valor_container").show();
                $("#complicacion_tipo_valor_container").html(json.options.body);
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
	
	saveComplicacionTipoValorForm: function(form)
    {
      $.fancybox.showActivity();
      $.ajax({
          url: $(form).attr('action'),
          data: $(form).serialize(),
          type: 'post',
          dataType: 'json',
          success: function(json){
              $("#complicacion_tipo_valor_container").html(json.options.body);
              
              $(".save_button").button();
              
              if(json.response == "OK")
              {
				$('#complicacion_tipo_valor_container input').effect("highlight", {}, 300);
                
                if(json.options.isnew)
                {
                  $("#complicacion_tipo_valor_selector").
                          append($("<option></option>").
                          attr("value",json.options.id).
                          attr("id",'complicacion_tipo_valor_option_'+json.options.id).
                          text(json.options.nombre));
				  complicacionesManagement.getInstance().refrescarComplicacionTipoSelect();
                }
                else
                {
                  $('#complicacion_tipo_valor_option_'+json.options.id).text(json.options.nombre);
				  complicacionesManagement.getInstance().refrescarComplicacionTipoSelect();
                }
                
              }
              else
			  {
				$("#complicacion_tipo_valor_container").html(json.options.body);
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
	
	
	verComplicacion: function()
    {
	  if($("#trasplante_complicacion_no_infecciosa_form").length != 0)
	  {
		$("#trasplante_complicacion_no_infecciosa_form").fadeIn('slow', function() {
		  $.fancybox.resize();
		});
	  }
	  
             
      $("#auxiliary_fields").fadeOut('slow', function() {
        $("#auxiliary_fields").empty();
        $.fancybox.resize();
      });
      
      $.fancybox.resize();
    },
	
	
	// De aca para abajo no sirve
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
            complicacionesManagement.getInstance().reenableToolTips();
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
				  var mySeroles=new Array();
				  $("serol_container_"+json.options.id).each(function(index, item){
					mySeroles[index] = $(item).find("input:checked").val();
				  });
				  $('.serol_container_'+json.options.id).each(function(index, item){
					$(item).replaceWith(json.options.serol_div);
				  });
				  $('.serol_container_'+json.options.id).each(function(index, item){
					$(item).find("input[value='"+mySeroles[index]+"']").attr("checked", "checked");
				  });
				  
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
				$('.serol_container_'+json.options.id).each(function(index, item){
					$(item).remove();
				  });
                //$('.serol_container_'+json.options.id).remove();
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
				var mySeroles=new Array();
				$("serol_container_"+json.options.id).each(function(index, item){
				  mySeroles[index] = $(item).find("input:checked").val();
				});
				$('.serol_container_'+json.options.id).each(function(index, item){
				  $(item).replaceWith(json.options.serol_div);
				});
				$('.serol_container_'+json.options.id).each(function(index, item){
				  $(item).find("input[value='"+mySeroles[index]+"']").attr("checked", "checked");
				});

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
//                var selected_value = $(".serol_container_"+json.options.serol_id+" input:checked").val();
//                $('.serol_container_'+json.options.serol_id).replaceWith(json.options.serol_div);
//                $(".serol_container_"+json.options.serol_id+" input[value='"+selected_value+"']").attr("checked", "checked");                                

				var mySeroles=new Array();
				$("serol_container_"+json.options.id).each(function(index, item){
				  mySeroles[index] = $(item).find("input:checked").val();
				});
				$('.serol_container_'+json.options.id).each(function(index, item){
				  $(item).replaceWith(json.options.serol_div);
				});
				$('.serol_container_'+json.options.id).each(function(index, item){
				  $(item).find("input[value='"+mySeroles[index]+"']").attr("checked", "checked");
				});

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

$(document).ready(function(){
  $(".fancy_link").each(function(index, item){
	$(item).fancybox({
        'transitionIn'        :   'fade',
        'transitionOut'       :   'fade',
        'hideOnOverlayClick'  :   false,
        'autoDimensions'      :   true    
    });  
  });
  
});

/*
  Seleccionar un radio button que esta checked
* 
  $("#serol_container_1 input:checked").val()
* 
  Para volver a seleccionar el valor
*
  $("#serol_container_1 input[value='3']").attr("checked", "checked");

*/
/*
 * 
$(".serol_container").each(function(index, item){
  console.log(index);
  console.log(item);
  $(item).replaceWith("hola");
})
  
var mySeroles=new Array();
$(".serol_container").each(function(index, item){
  mySeroles[index] = $(item).find("input:checked").val();
})
console.log(mySeroles);  
  
 * 
 */
