<?php slot('layout_paciente',':D') ?>
<?php 
  use_helper('mdAsset', 'Date'); 
//  use_javascript("jquery-1.6.1.min.js","first");
//  use_javascript("simpleTip/jquery.simpletip-1.3.1.js");
  use_plugin_stylesheet('mastodontePlugin', '../js/fancybox/jquery.fancybox-1.3.1.css');
  use_plugin_javascript('mastodontePlugin','fancybox/jquery.fancybox-1.3.1.pack.js','last');
  
?>
<label><?php echo __("paciente_Estado del paciente :");?></label>
<?php if($muerte): ?>
  <?php if($muerte["transplante_funcionando"] == 1): ?>
    <?php echo __("paciente_El paciente fallecio con trasplante funcionando.");?>
  <?php else: ?>
    <?php echo __("paciente_El paciente fallecio sin el trasplante funcionando.");?>
  <?php endif;?>
  <a id="paciente_muerte_basic_info_link" href="#paciente_muerte_basic_info" class="simple_tip_container" title="<?php echo __("muertePaciente_ver la informacion de la muerte del paciente titulo");?>">
    <?php echo image_tag("search-icon.png", array("width" => 24)); ?>
    <div class="tooltip_text"><?php echo __("muertePaciente_ver informacion de la muerte del paciente");?></div>		
  </a>  
  <div style="display:none">
    <div id="paciente_muerte_basic_info" class="paciente_muerte_basic_info">
      <ul>
        <?php $causa = PacienteMuertehandler::retrieveCausaById($muerte['causa_muerte_id'], Doctrine_Core::HYDRATE_ARRAY);?>
        <li><?php echo __("pacienteMuerte_Causa");?> : <label class="bold_text"><?php echo $causa['nombre']?></label></li>
        <li><?php echo __("pacienteMuerte_Fecha de muerte");?> : <label class="bold_text"><?php echo format_date($muerte['fecha_muerte'], 'D'); ?></label></li>
        <li>
          <?php echo __("pacienteMuerte_Trasplante funcionando");?> : 
          <label class="bold_text">
            <?php if($muerte["transplante_funcionando"] == 1): ?>
              <?php echo __("paciente_El paciente fallecio con trasplante funcionando.");?>
            <?php else: ?>
              <?php echo __("paciente_El paciente fallecio sin el trasplante funcionando.");?>
            <?php endif;?>
          </label>
          
        </li>
      </ul>
      <div style="float: right;width: 25px;">
        <a href="<?php echo url_for("@editarMuertePaciente?id=".$muerte['paciente_id']); ?>"><?php echo image_tag("edit-icon.png")?></a>
      </div>
    </div>
  </div>  
  <?php //print_r($muerte);?>
<?php else: ?>
	<?php if($cantidad_pre_trasplantes[0][0] == 0): ?>
	  <?php echo __("paciente_El paciente no se a realizado ningun trasplante.");?>
	<?php else: ?>
	  <?php if($cantidad_pre_trasplantes[0][0] == count($perdidas)): ?>
		<?php echo __("paciente_El paciente se hizo un trasplante que resulto en perdida.");?>
	  <?php else: ?>
		<?php echo __("paciente_El paciente esta vivo con el trasplante funcionando.");?>
	  <?php endif;?>
	<?php endif;?>
  <a href="<?php echo url_for("@crearMuertePaciente?id=".$id); ?>">muerte...</a>
<?php endif;?>
<div class="clear"></div>
<a href="<?php echo url_for("@mostrarPaciente?id=".$id); ?>">Volver</a>

<script type="text/javascript">
$(document).ready(function(){

  $('.simple_tip_container').each(function() {
	  $(this).simpletip({
		  content : $(this).find("div.tooltip_text").text(),
		  fixed: true, 
		  position: ["25", "-40"]
	  });
  });
  
  $("a#paciente_muerte_basic_info_link").fancybox({
		'transitionIn'	:	'elastic',
		'transitionOut'	:	'elastic',
		'speedIn'		:	600, 
		'speedOut'		:	200,
		'titlePosition'	:	'outside'
	});
  
});
</script>
