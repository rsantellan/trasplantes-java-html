cmvManagement = function(options){
	this._initialize();

}

cmvManagement.instance = null;

cmvManagement.getInstance = function (){
	if(cmvManagement.instance == null)
		cmvManagement.instance = new cmvManagement();
	return cmvManagement.instance;
}

cmvManagement.prototype = {
    _initialize: function(){
        
    },
    
    showHideEmfermedades: function()
    {
        var valor = $("#cmv_tipo").val();
        
        if(valor == 0)
        {
            $("#emfermedades_block").show();
        }
        else
        {
            $("#emfermedades_block").hide();
            $("#emfermedades_block input:checkbox").attr('checked', false);
        }
        return false;
    },
    
    saveCmvForm: function(form){
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
                        $("#cmv_container").append(json.options.body);
                      
                    }
                    else
                    {
                        $('#cmv_list_'+json.options.id).replaceWith(json.options.body);
                    }
                    manejadorEvolucionesManagement.getInstance().refreshFancyLinks();
                    $.fancybox.close();
                }
                else
                {
                    $("#cmv_new_container").replaceWith(json.options.body);
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