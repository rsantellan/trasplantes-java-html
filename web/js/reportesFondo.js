function sendFondoData(myUrl)
{
  $("#reporte_fondo_button").hide();
  $("#reporte_fondo_image_container").show();
  $.ajax({
      url: myUrl,
      data: {'year': $("#reporte_fondo_selector").val()},
      type: 'post',
      dataType: 'json',
      success: function(json){
          
          if(json.response == "OK")
          {
            $("#listado_container").html(json.options.body);
          }
          
          
      }, 
      complete: function()
      {
        $("#reporte_fondo_button").show();
        $("#reporte_fondo_image_container").hide();
      }
  });

  return false;
}

function sendFondoRACMVData(myUrl)
{
  $("#reporte_fondo_button").hide();
  $("#reporte_fondo_image_container").show();
  $.ajax({
      url: myUrl,
      data: {'year': $("#reporte_fondo_selector").val(), 'yearFinish': $("#reporte_fondo_selector_situacion").val()},
      type: 'post',
      dataType: 'json',
      success: function(json){
          
          if(json.response == "OK")
          {
            $("#listado_container").html(json.options.body);
          }
          
          
      }, 
      complete: function()
      {
        $("#reporte_fondo_button").show();
        $("#reporte_fondo_image_container").hide();
      }
  });

  return false;
}
