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
    
    /***
     * 
     * Evolucion Cmv
     * 
     */
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
    },
    
    /***
     * 
     * Evolucion Ecg
     * 
     */
    saveEcgForm: function(form){
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
                        $("#evolucion_ecg_ul").append(json.options.body);
                      
                    }
                    else
                    {
                        $('#ecg_li_'+json.options.id).replaceWith(json.options.body);
                    }
                    manejadorEvolucionesManagement.getInstance().refreshFancyLinks();
                    $.fancybox.close();
                }
                else
                {
                    $("#evolucion_ecg_new_container").replaceWith(json.options.body);
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
    
    deleteEcg: function(id, text, url)
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
                        $('#ecg_li_'+json.options.id).remove();
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
    },
    
    /***
     * 
     * Evolucion Ecocardio
     * 
     */
    saveEcocardioForm: function(form){
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
                        $("#evolucion_ecocardio_ul").append(json.options.body);
                      
                    }
                    else
                    {
                        $('#ecocardio_li_'+json.options.id).replaceWith(json.options.body);
                    }
                    manejadorEvolucionesManagement.getInstance().refreshFancyLinks();
                    $.fancybox.close();
                }
                else
                {
                    $("#evolucion_ecocardio_new_container").replaceWith(json.options.body);
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
    
    deleteEcocardio: function(id, text, url)
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
                        $('#ecocardio_li_'+json.options.id).remove();
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
    },
    
    /***
     * 
     * Evolucion Nutricion
     * 
     */
    saveNutricionForm: function(form){
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
                        $("#evolucion_nutricion_ul").append(json.options.body);
                      
                    }
                    else
                    {
                        $('#nutricion_li_'+json.options.id).replaceWith(json.options.body);
                    }
                    manejadorEvolucionesManagement.getInstance().refreshFancyLinks();
                    $.fancybox.close();
                }
                else
                {
                    $("#evolucion_nutricion_new_container").replaceWith(json.options.body);
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
    
    deleteNutricion: function(id, text, url)
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
                        $('#nutricion_li_'+json.options.id).remove();
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
    },
    
    /***
     * 
     * Evolucion Paraclinica
     * 
     */
    saveParaclinicaForm: function(form){
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
                        $("#evolucion_paraclinica_ul").append(json.options.body);
                      
                    }
                    else
                    {
                        $('#paraclinica_li_'+json.options.id).replaceWith(json.options.body);
                    }
                    manejadorEvolucionesManagement.getInstance().refreshFancyLinks();
                    $.fancybox.close();
                }
                else
                {
                    $("#evolucion_paraclinica_new_container").replaceWith(json.options.body);
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
    
    deleteParaclinica: function(id, text, url)
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
                        $('#paraclinica_li_'+json.options.id).remove();
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
    },
    
    /***
     * 
     * Evolucion Ecodopler
     * 
     */
    saveEcodoplerForm: function(form){
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
                        $("#evolucion_ecodopler_ul").append(json.options.body);
                      
                    }
                    else
                    {
                        $('#ecodopler_li_'+json.options.id).replaceWith(json.options.body);
                    }
                    manejadorEvolucionesManagement.getInstance().refreshFancyLinks();
                    $.fancybox.close();
                }
                else
                {
                    $("#evolucion_ecodopler_new_container").replaceWith(json.options.body);
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
    
    deleteEcodopler: function(id, text, url)
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
                        $('#ecodopler_li_'+json.options.id).remove();
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
    },
    
    /***
     * 
     * Evolucion Ecografia
     * 
     */
    saveEcografiaForm: function(form){
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
                        $("#evolucion_ecografia_ul").append(json.options.body);
                      
                    }
                    else
                    {
                        $('#ecografia_li_'+json.options.id).replaceWith(json.options.body);
                    }
                    manejadorEvolucionesManagement.getInstance().refreshFancyLinks();
                    $.fancybox.close();
                }
                else
                {
                    $("#evolucion_ecografia_new_container").replaceWith(json.options.body);
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
    
    deleteEcografia: function(id, text, url)
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
                        $('#ecografia_li_'+json.options.id).remove();
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
    },
    
    /***
     * 
     * Evolucion Marvirales
     * 
     */
    saveMarviralesForm: function(form){
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
                        $("#evolucion_marvirales_ul").append(json.options.body);
                      
                    }
                    else
                    {
                        $('#marviral_li_'+json.options.id).replaceWith(json.options.body);
                    }
                    manejadorEvolucionesManagement.getInstance().refreshFancyLinks();
                    $.fancybox.close();
                }
                else
                {
                    $("#evolucion_marvirales_new_container").replaceWith(json.options.body);
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
    
    deleteMarvirales: function(id, text, url)
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
                        $('#marviral_li_'+json.options.id).remove();
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
    },
    
    /***
     * 
     * Evolucion Tx Torax
     * 
     */
    saveTxToraxForm: function(form){
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
                        $("#evolucion_txtorax_ul").append(json.options.body);
                      
                    }
                    else
                    {
                        $('#txtorax_li_'+json.options.id).replaceWith(json.options.body);
                    }
                    manejadorEvolucionesManagement.getInstance().refreshFancyLinks();
                    $.fancybox.close();
                }
                else
                {
                    $("#evolucion_txtorax_new_container").replaceWith(json.options.body);
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
    
    deleteTxTorax: function(id, text, url)
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
                        $('#txtorax_li_'+json.options.id).remove();
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