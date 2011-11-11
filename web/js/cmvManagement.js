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
 
    refreshFancyLinks: function()
    {
        $(".fancy_link").each(function(index, item){
            $(item).fancybox({
                'transitionIn'        :   'fade',
                'transitionOut'       :   'fade',
                'hideOnOverlayClick'  :   false    
            });  
        });        
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
                    cmvManagement.getInstance().refreshFancyLinks();
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
    },
    
    deleteCmv: function(id, text, url)
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
                        $('#cmv_list_'+json.options.id).remove();
                        $.fancybox.close();
                    }
                    else
                    {
                        //$(".donante_causa_muerte_delete_error").show();
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
    cmvManagement.getInstance().refreshFancyLinks();
});