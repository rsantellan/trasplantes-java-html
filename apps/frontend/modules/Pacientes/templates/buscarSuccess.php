<?php use_javascript("jquery-1.6.1.min.js","first");?>
<?php 
  use_helper('mdAsset') ;
  use_plugin_javascript('mastodontePlugin', 'jquery-ui-1.8.4/js/jquery-ui-1.8.4.custom.min.js', 'first');
  use_plugin_stylesheet('mastodontePlugin', '../js/jquery-ui-1.8.4/css/smoothness/jquery-ui-1.8.4.custom.css');
  use_stylesheet("buscarPersonaStyles.css");
  use_javascript("simpleTip/jquery.simpletip-1.3.1.js");
?>
<div class="box_container">
  <div class="simple_rounded">
	<form method="POST" action="<?php echo url_for("@buscarPaciente");?>">
	  <label for="buscarPaciente_nombre"><?php echo __("buscar_escriba el nombre de la persona a buscar");?></label>
	  <a href="javascript:void(0)" class="simple_tip_container">
		<?php echo image_tag("help-icon2.png", array("width" => 24)); ?>
		<div class="tooltip_text"><?php echo __("buscar_ayuda sobre buscar persona");?></div>		
	  </a>
	  <a href="<?php echo url_for("@agregarPaciente");?>" class="simple_tip_container">
		<?php echo image_tag("add-icon.png", array("width" => 24)); ?>
		<div class="tooltip_text"><?php echo __("buscar_agregar nueva persona");?></div>		
	  </a>	  
	  <div class="clear"></div>
	  <?php
		echo $buscarForm->renderHiddenFields();
		echo $buscarForm["nombre"]->render();
		echo $buscarForm["nombre"]->renderError();
	  ?>
	  <input class="button_submit" type="submit" value="<?php echo __("buscar_buscar persona");?>" />
	</form>
  </div>  
</div>

<script type="text/javascript">
$(document).ready(function(){

  $('.simple_tip_container').each(function() {
	  $(this).simpletip({
		  content : $(this).find("div.tooltip_text").text(),
		  fixed: true, 
		  position: ["25", "-40"]
	  });
  });
  
  $(".button_submit").button();
  
});
</script>