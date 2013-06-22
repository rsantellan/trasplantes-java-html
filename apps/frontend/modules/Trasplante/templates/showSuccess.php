<?php 
  use_helper("Date");
  use_helper('mdAsset');
  use_plugin_stylesheet('mastodontePlugin', '../js/fancybox/jquery.fancybox-1.3.1.css');
  use_plugin_javascript('mastodontePlugin','fancybox/jquery.fancybox-1.3.1.pack.js','last');
  use_javascript("trasplanteShowManagement.js",'last');
?>
<div class="volver">
    <a href="<?php echo url_for("@mostrarPaciente?id=".$pacienteId);?>"><?php echo __("Trasplante_volver al paciente");?></a>
</div>

<div class="trasplante_min_info_basica">
  <h2><?php echo __("Trasplante_Informacion basica")?></h2>
  <?php echo __("Trasplante_Fecha del trasplante");?> : <label class="bold_text"><?php echo format_date($trasplante['fecha'], 'D'); ?></label>
  <div class="clear"></div>
  <p class="slide">
	<a href="javascript:void(0)" onclick="trasplanteShowManagement.getInstance().showTrasplanteMoreInfo(this)" class="trasplante_min_info_basica_link"><?php echo __("Trasplante_Ver Informacion")?></a>
  </p>
</div>
<div class="trasplante_info_basica">
  <?php include_partial("showTrasplante", array("id" => $id)); ?>
</div>
<div class="clear"></div>
<div class="trasplante_fecha_alta_reoperaciones_container">
  <div class="trasplante_fecha_alta_container">
    <?php echo __("Trasplante_Fecha de alta del trasplante");?> :
    <label class="bold_text" id="fecha_alta_label">
      <?php if(!is_null($trasplante["fecha_alta"])): ?>
        <?php echo format_date($trasplante['fecha_alta'], 'D'); ?>
        <br/>
        <?php echo __("Trasplante_Siendo la cantidad de dias internado: ");?>
        <?php echo basicFunction::calculateDifferenceInDays($trasplante['fecha'], $trasplante['fecha_alta']); ?>
        <?php //echo $trasplante['fecha'] . " ".$trasplante['fecha_alta']; ?>
      <?php else: ?>
        <?php echo __("Trasplante_No tiene Fecha de alta del trasplante");?>
      <?php endif; ?>
    </label> 
    <br/>
    <a class="fancy_small_link" href="<?php echo url_for("@cambiarFechaAlta?id=".$id);?>"><?php echo __("Trasplante_Cambiar Fecha de alta del trasplante");?></a>
  </div>
  <div class="clear"></div>
  <br/>
  <div class="trasplante_reoperaciones_container">
      <a href="<?php echo url_for("@manejarReoperaciones?id=".$id);?>">reoperaciones</a>
  </div>
</div>

<div class="trasplante_complicaciones_container">
  
  <?php include_component("TrasplanteComplicaciones", "complicacionesBox", array("id" => $id)); ?>
  <a href="<?php echo url_for("@mostrarComplicaciones?trasplanteId=".$id); ?>"><?php echo __("Trasplante_Complicaciones");?></a>
</div>


<div class="trasplante_evolucion_container">
    
    <a href="<?php echo url_for("@manejarEvoluciones?id=".$id); ?>"> 
        <?php echo __("Trasplante_Evoluciones");?>
    </a>
    
</div>

<div class="trasplante_evolucion_container">
    
    <a href="<?php echo url_for("@manejarCmv?id=".$id); ?>"> 
        <?php echo __("Trasplante_Cmv");?>
    </a>
    
</div>


<div class="trasplante_evolucion_container">
    
    <a href="<?php echo url_for("@manejarEvolucionInjerto?id=".$id); ?>"> 
        <?php echo __("Trasplante_Evolucion del injerto");?>
    </a>
    
</div>

<!-- 
<a href="<?php echo url_for('Trasplante/edit?id='.$id) ?>">Edit</a>
&nbsp;
<a href="<?php echo url_for('Trasplante/index') ?>">List</a>
-->
