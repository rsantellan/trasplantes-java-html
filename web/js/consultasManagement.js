/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
consultasManagement = function(options){
    this._initialize();

}

consultasManagement.instance = null;
consultasManagement.getInstance = function (){
    if(consultasManagement.instance == null)
        consultasManagement.instance = new consultasManagement();
    return consultasManagement.instance;
}

consultasManagement.prototype = {
    _initialize: function(){

    },
	
	/**
	 * Crea un array asociativo de una tabla
	 * Recive la columna de la tabla (la mismas empiezan en 0)
	 */
	createList: function(position)
	{
	  var list = new Array();
	  $("td.table_position_"+position).each(function(i,item){
	   if(list.hasOwnProperty($(item).text()))
	   {
		 list[$(item).text()] = list[$(item).text()] + 1; 
	   }
	   else
	   {
		 list[$(item).text()] = 1;
	   }
	  });
	  return consultasManagement.getInstance().readList(list);
	  return list;
	},
	/**
	 * Recorre un array asociativo, el mismo sirve para testeo
	 */
	readList: function(list)
	{
	  //var list = consultasManagement.getInstance().createList(3);
	  var aux = new Array();
	  //var cadena = "";
	  for(key in list)
	  {
	   //aux[key] = list[key];
	   var cadena = [key, list[key]];
	   aux.push(cadena);
	   //console.log(key + " : " + list[key]);
	   
	  }
	  //console.log(aux);
	  //console.log(list);
	  return aux;
	},

	renderPlot: function(container_id, position)
	{
	  //console.log(position);
	  var lista = consultasManagement.getInstance().createList(position);
	  //console.log(lista);
	  plot1 = $.jqplot(container_id, [lista], {
		  gridPadding: {top:0, bottom:38, left:0, right:0},
		seriesDefaults:{renderer:$.jqplot.PieRenderer, trendline:{show:false}, rendererOptions: { padding: 8, showDataLabels: true}},
					legend:{
						show:true, 
						placement: 'outside', 
						rendererOptions: {
							numberRows: 1
						}, 
						location:'s',
						marginTop: '15px',
						marginLeft: "150px"
					}       
	  });	  
	}
}

