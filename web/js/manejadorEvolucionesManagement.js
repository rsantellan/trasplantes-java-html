manejadorEvolucionesManagement = function(options){
    this._initialize();

}

manejadorEvolucionesManagement.instance = null;

manejadorEvolucionesManagement.getInstance = function (){
    if(manejadorEvolucionesManagement.instance == null)
        manejadorEvolucionesManagement.instance = new manejadorEvolucionesManagement();
    return manejadorEvolucionesManagement.instance;
}

manejadorEvolucionesManagement.prototype = {
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
                        $("#evolucion_cmv_ul").append(json.options.body);
                      
                    }
                    else
                    {
                        $('#cmv_li_'+json.options.id).replaceWith(json.options.body);
                    }
                    manejadorEvolucionesManagement.getInstance().refreshFancyLinks();
                    $.fancybox.close();
                }
                else
                {
                    $("#evolucion_cmv_new_container").replaceWith(json.options.body);
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
                        $('#cmv_li_'+json.options.id).remove();
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
    manejadorEvolucionesManagement.getInstance().refreshFancyLinks();
  
});