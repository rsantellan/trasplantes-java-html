manejadorInjertoEvolucion = function(options){
    this._initialize();

}

manejadorInjertoEvolucion.instance = null;

manejadorInjertoEvolucion.getInstance = function (){
    if(manejadorInjertoEvolucion.instance == null)
        manejadorInjertoEvolucion.instance = new manejadorInjertoEvolucion();
    return manejadorInjertoEvolucion.instance;
}

manejadorInjertoEvolucion.prototype = {
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
    
    saveForm: function(form)
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
                    if(json.options.isnew == true)
                    {
                        if(json.options.trasplante == 1)
                        {
                            $("#injerto_evolucion_trasplante_list_container").append(json.options.body);
                        }
                        else
                        {
                          $("#injerto_evolucion_list_container").append(json.options.body);
                        }
                      
                    }
                    else
                    {
                        $('#evolucion_injerto_li_'+json.options.id).replaceWith(json.options.body);
                    }
                    manejadorInjertoEvolucion.getInstance().refreshFancyLinks();
                    $.fancybox.close();
                }
                else
                {
                    $("#injerto_evolucion_new_container").replaceWith(json.options.body);
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
    
    delete: function(id, text, url)
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
                        $('#evolucion_injerto_li_'+json.options.id).remove();
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
    manejadorInjertoEvolucion.getInstance().refreshFancyLinks();
  
});
