<?php slot('layout_paciente',':D') ?>
<?php 
  use_helper('mdAsset', 'Date'); 
  use_javascript("jquery-1.6.1.min.js","first");
  use_javascript("simpleTip/jquery.simpletip-1.3.1.js"); 
  use_javascript("pacientesGlobalManagement.js");
  use_plugin_stylesheet('mastodontePlugin', '../js/fancybox/jquery.fancybox-1.3.1.css');
  use_plugin_javascript('mastodontePlugin','fancybox/jquery.fancybox-1.3.1.pack.js','last');
  //print_r($paciente);

?>
<label class="big_title"><?php echo $paciente["nombre"]. " ".$paciente["apellido"]?></label>
<a id="paciente_basic_info_link" href="#paciente_basic_info" class="simple_tip_container" title="<?php echo __("paciente_ver la informacion del paciente titulo");?>">
  <?php echo image_tag("search-icon.png", array("width" => 24)); ?>
  <div class="tooltip_text"><?php echo __("paciente_ver la informacion del paciente");?></div>		
</a>
<div style="display:none">
  <?php include_partial('paciente_small_ul_info', array('paciente' =>$paciente, 'sf_cache_key' => $paciente["id"]));?>
</div>

<?php include_partial('paciente_small_estado', array('id' =>$paciente["id"], 'sf_cache_key' => $paciente["id"]));?>

<div class="clear"></div>
<br/>


<?php
  $perdidas = PacienteHandler::retrivePacientePerdidasByPacienteId($paciente["id"], Doctrine_Core::HYDRATE_ARRAY);
  $preTrasplantes = preTrasplanteHandler::retriveByPacienteIdOrdered($paciente["id"]);
?>
<?php 
  if(count($perdidas) == count($preTrasplantes)):
?>
<div class="iniciar_pre_trasplante">
  <label><?php echo __("preTrasplante_iniciar proceso de pretrasplante");?></label>
  <a href="<?php echo url_for("@iniciarPreTrasplante?paciente_id=".$paciente["id"]);?>" class="simple_tip_container">
	<?php echo image_tag("add-icon.png", array("width" => 24)); ?>
  </a>	
</div>
<?php endif;?>

<?php 
  $auxPerdidas = array();
  foreach($perdidas as $perdida)
  {
	$auxPerdidas[$perdida["paciente_pre_trasplante_id"]] = $perdida["paciente_pre_trasplante_id"];
  }
?>

<?php
  
  foreach($preTrasplantes as $preTrasplante):
?>
<div class="small_pre_trasplante<?php if(array_key_exists($preTrasplante["id"], $auxPerdidas)) echo " pre_trasplante_perdido" ?>">
  <ul>
	<li><?php echo __("pacientePreTrasplante_Informacion del pretrasplante");?></li>
	<li><?php echo __("pacientePreTrasplante_the");?> : <label class="bold_text"><?php echo $preTrasplante['the']?></label></li>
	<li><?php echo __("pacientePreTrasplante_fecha de ingreso a la lista");?> : <label class="bold_text"><?php echo format_date($preTrasplante['fecha_ingreso_lista'], 'D');?></label></li>
	<?php if($preTrasplante["fecha_egreso"]): ?>
	  <li><?php echo __("pacientePreTrasplante_fecha de egreso de la lista (fecha del trasplante)");?> : <label class="bold_text"><?php echo format_date($preTrasplante['fecha_egreso'], 'D');?></label></li>
	  <?php if(array_key_exists($preTrasplante["id"], $auxPerdidas)): ?>
		<li><label class="bold_text"><?php echo __("pacientePreTrasplante_Hubo perdida del trasplante.");?></label></li>
	  <?php endif;?>
	<?php else: ?>
	  <li><label class="bold_text"><?php echo __("pacientePreTrasplante_No se a realizado el trasplante de este pretrasplante");?></label></li>
	<?php endif; ?>
  </ul>
  <div style="margin-left: 95%; width: 25px;">
	<a href="<?php echo url_for("@editarPaciente?id=".$preTrasplante['id']); ?>"><?php echo image_tag("edit-icon.png")?></a>
  </div>
</div>
<div class="clear"></div>
<?php 
  endforeach;
?>

<div class="clear"></div>