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
      //Cuando lo ponga en la fancy
	  //$.fancybox.showActivity();
      $.ajax({
          url: url,
          type: 'post',
          dataType: 'json',
          success: function(json){
              if(json.response == "OK")
              {
                $("#donante_container").html(json.options.body);
                //$.fancybox.resize();
                $(".save_button").button();
              }
              else 
              {

              }
          }, 
          complete: function()
          {
            //$.fancybox.hideActivity();
          }
      });

      return false;       
    },
    
    showDonante: function()
    {
      var id = $("#donantes_selector").val();
      var url = $('#donante_show_url_input').val();
      //$.fancybox.showActivity();
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
            //$.fancybox.hideActivity();
			//$.fancybox.resize();
          }
      });

      return false;      
    },
    
    saveForm: function(form)
    {
      //$.fancybox.showActivity();
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
            //$.fancybox.hideActivity();
			//$.fancybox.resize();
          }
      });
      return false;      
    },
    
    deleteDonante: function(id, text, url)
    {
      if(confirm(text))
      {
      //$.fancybox.showActivity();
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
            //$.fancybox.hideActivity();
			//$.fancybox.resize();
          }
      });

      
        
      }
	  return false;
      
      
    }
}
