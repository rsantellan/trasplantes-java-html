<?php
use_helper('mdAsset', 'Date'); 
//use_javascript("jquery-1.6.1.min.js","first");
use_plugin_stylesheet('mastodontePlugin', '../js/fancybox/jquery.fancybox-1.3.1.css');
use_plugin_javascript('mastodontePlugin','fancybox/jquery.fancybox-1.3.1.pack.js','last');

use_javascript("reoperacionesManagement.js");
?>

<h3><?php echo __("Reoperaciones_Lista de reoperaciones realizadas"); ?></h3>
<ul>
<?php
foreach($reoperaciones as $reoperacion):
?>
  <li id="reoperacion_<?php echo $reoperacion["id"]?>">
	<label class="bold_text"><?php echo format_date($reoperacion['fecha'], 'D'); ?></label>
	<a href=""><?php echo image_tag("search-icon.png", array("width" => 24)); ?></a>
	<a href="<?php echo url_for("@editarReoperacion?id=".$reoperacion["id"]);?>">
	  <?php echo image_tag("edit-icon.png", array("width" => 24)); ?>
	</a>
	<a href="javascript:void(0);" onclick="return reoperacionesManagement.getInstance().deleteReoperacion(<?php echo $reoperacion["id"]?>,'<?php echo __("reoperacion_esta seguro de querer eliminar?");?>', '<?php echo url_for('@eliminarReoperacion') ?>')" >
	  <?php echo image_tag("trash.png")?>
	</a>
	<?php //var_dump($reoperacion);?>
  </li>

<?php endforeach; ?>
</ul>
<div class="clear"></div>
<a href="<?php echo url_for("@agregarReoperacion?id=".$id); ?>"><?php echo __("reoperacion_agregar");?></a>


<div class="clear"></div>
<a href="">
  <span>Volver al trasplante.</span>
</a>