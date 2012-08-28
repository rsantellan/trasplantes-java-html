<?php
/*
var_dump($days);
var_dump($months);
var_dump($years);
*/
?>
<?php use_javascript("consultasManagement.js"); ?>
<?php use_javascript("jqplot/jquery.jqplot.js"); ?>
<?php use_javascript("jqplot/plugins/jqplot.highlighter.min.js"); ?>
<?php //use_javascript("jqplot/plugins/jqplot.pieRenderer.js"); ?>
<?php use_stylesheet("jqplot/jquery.jqplot.css"); ?>

<h1><?php echo __("Consultas_titulo complicaciones trasplante");?></h1>

<a href="<?php echo url_for('consulta/index') ?>"><?php echo __("Consultas_volver a la lista"); ?></a>

<h3><?php echo __("Consultas_subtitulo complicaciones trasplante");?></h3>

<form method="GET" action="<?php echo url_for('@consultaTrasplanteComplicaciones');?>">
  <div>
    <label><?php echo __("Consultas_complicaciones trasplante dias");?></label>
    <select name="d">
      <?php foreach($days as $day): ?>
      <option value="<?php echo $day;?>" <?php echo ($day == $dia)? 'selected': '';?>><?php echo $day;?></option>
      <?php
      endforeach;
      ?>
    </select>
  </div>
  <div class="clear"></div>
  <input type="submit" value="<?php echo __("Consultas_consultar");?>" />
</form>  

<form method="GET" action="<?php echo url_for('@consultaTrasplanteComplicaciones');?>">
  <div>
    <label><?php echo __("Consultas_complicaciones trasplante meses");?></label>
    <select name="m">
      <?php foreach($months as $month): ?>
      <option value="<?php echo $month;?>" <?php echo ($month == $mes)? 'selected': '';?>><?php echo $month;?></option>
      <?php
      endforeach;
      ?>
    </select>
  </div>
  <div class="clear"></div>
  <input type="submit" value="<?php echo __("Consultas_consultar");?>" />
</form>  

<form method="GET" action="<?php echo url_for('@consultaTrasplanteComplicaciones');?>">
  <div>
    <label><?php echo __("Consultas_complicaciones trasplante años");?></label>
    <select name="y">
      <?php foreach($years as $year): ?>
      <option value="<?php echo $year;?>" <?php echo ($year == $mYear)? 'selected': '';?>><?php echo $year;?></option>
      <?php
      endforeach;
      ?>
    </select>
  </div>
  <div class="clear"></div>
  <input type="submit" value="<?php echo __("Consultas_consultar");?>" />
</form>  

<hr/>

<div id="chart1" style="margin-top:20px; margin-left:20px; width:800px; height:800px;">
  
  
</div>

<div id="chart2" style="margin-top:20px; margin-left:20px; width:800px; height:800px;">
  
  
</div>

<script type="text/javascript">


var fullData = <?php echo json_encode($datos->getRawValue());?>;
console.log(fullData);
var dataInf = <?php echo json_encode($datosInfecciosas->getRawValue());?>;
console.log(dataInf);
var dataNoInf = <?php echo json_encode($datosNoInfecciosas->getRawValue());?>;
console.log(dataNoInf);
</script>

<?php if($plotEnable): ?>

<script type="text/javascript">

$(document).ready(function(){
    $.jqplot.config.enablePlugins = true;
    $.jqplot('chart1', [fullData], {
      title:'<?php echo __("Consultas_titulo grafica trasplante complicacion");?>',
      axes:{
        xaxis:{
          renderer:$.jqplot.DateAxisRenderer
          
        }
      },
      legend:{show:true},
      series:[
        {label: '<?php echo __("Consultas_grafica todas");?>', showLabel:true},
      ]
    });


    $.jqplot('chart2', [dataInf, dataNoInf], {
      title:'<?php echo __("Consultas_titulo grafica trasplante complicacion separadas");?>',
      axes:{
        xaxis:{
          renderer:$.jqplot.DateAxisRenderer
          
        }
      },
      legend:{show:true},
      series:[
        {label: '<?php echo __("Consultas_grafica infecciosas");?>',showLabel:true},
        {label: '<?php echo __("Consultas_grafica no infecciosas");?>',showLabel:true}
      ]
    });
  });

</script>

<?php endif; ?>
