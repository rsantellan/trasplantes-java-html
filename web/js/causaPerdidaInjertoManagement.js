causaPerdidaInjertoManagement = function(options){
	this._initialize();

}

causaPerdidaInjertoManagement.instance = null;

causaPerdidaInjertoManagement.getInstance = function (){
	if(causaPerdidaInjertoManagement.instance == null)
		causaPerdidaInjertoManagement.instance = new causaPerdidaInjertoManagement();
	return causaPerdidaInjertoManagement.instance;
}

causaPerdidaInjertoManagement.prototype = {
	_initialize: function(){
        
	},
    
	newCausa: function(url)
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
    
	showCausa: function()
	{
		var id = $("#causaPerdidaInjerto_selector").val();
		var url = $('#causaPerdidaInjerto_show_url_input').val();
        if(id == 0 || id == "0")
          return false;
		$.fancybox.showActivity();
		$.ajax({
			url: url,
			data: {
				'id': id
			},
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
						$('#paciente_perdida_injerto_paciente_causa_perdida_injerto_id').
						append($("<option></option>").
							attr("value",json.options.id).
							text(json.options.nombre));
                          
						$("#causaPerdidaInjerto_selector").
						append($("<option></option>").
							attr("value",json.options.id).
							attr("id",'nefropatia_option_'+json.options.id).
							text(json.options.nombre));
					}
					else
					{
						$('#nefropatia_option_'+json.options.id).text(json.options.nombre);
                
						$("#paciente_perdida_injerto_paciente_causa_perdida_injerto_id option[value='"+json.options.id+"']").text(json.options.nombre);                  
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
    
	deleteCausa: function(id, text, url)
	{
		if(confirm(text))
		{
			$.fancybox.showActivity();
			$.ajax({
				url: url,
				data: {
					'id': id
				},
				type: 'post',
				dataType: 'json',
				success: function(json){
					if(json.response == "OK")
					{
						$('#nefropatia_option_'+json.options.id).remove();
						$("#paciente_perdida_injerto_paciente_causa_perdida_injerto_id option[value='"+json.options.id+"']").remove();                  
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
