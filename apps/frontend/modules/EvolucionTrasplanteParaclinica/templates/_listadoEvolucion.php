<?php use_helper("Date"); ?>
<li id="paraclinica_li_<?php echo $evolucion->getId();?>">
<?php echo __("Evoluciones_Paraclinica del dia: ");?>
<?php echo format_date($evolucion->getFecha(), 'D');?>
<a href="<?php echo url_for("@mostrarEvolucionParaclinica?id=".$evolucion->getId()); ?>" class="fancy_link">
	<?php echo image_tag("search-icon.png", array("width" => 24)); ?>
</a>
<a href="<?php echo url_for("@editarEvolucionParaclinica?id=".$evolucion->getId());?>" class="fancy_link">
    <?php echo image_tag("edit-icon.png", array("width" => 24)); ?>
</a>
</li>