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
	<form method="GET" action="<?php echo url_for("@buscarPersona");?>">
	  <label for="buscarPaciente_nombre"><?php echo __("buscar_escriba el nombre de la persona a buscar");?></label>
	  <a href="javascript:void(0)" class="simple_tip_container">
		<?php echo image_tag("Categories-system-help-icon.png", array("width" => 25)); ?>
		<div class="tooltip">A simple tooltip</div>		
	  </a>
	  <div class="clear"></div>
	  <?php
		echo $buscarForm->renderHiddenFields();
		echo $buscarForm["nombre"]->render();
		echo $buscarForm["nombre"]->renderError();
	  ?>
	  <input type="submit" value="<?php echo __("buscar_buscar persona");?>" />
	</form>
  </div>  
</div>