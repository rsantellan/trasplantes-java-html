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
  $preTrasplantes = preTrasplanteHandler::retriveByPacienteId($paciente["id"]);
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
  foreach($preTrasplantes as $preTrasplante):
?>

  <?php print_r($preTrasplante->toArray()); ?>

<?php 
  endforeach;

?>


