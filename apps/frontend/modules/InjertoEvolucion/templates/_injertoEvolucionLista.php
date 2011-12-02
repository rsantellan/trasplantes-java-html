<?php use_helper("Date"); ?>
<li id="evolucion_injerto_li_<?php echo $injerto->getId();?>">
<?php echo __("InjertoEvolucions_del dia: ");?>
<?php echo format_date($injerto->getFecha(), 'D');?>
<a href="<?php echo url_for("@mostrarEvolucionInjerto?id=".$injerto->getId()); ?>" class="fancy_link">
	<?php echo image_tag("search-icon.png", array("width" => 24)); ?>
</a>
<a href="<?php echo url_for("@editarEvolucionInjerto?id=".$injerto->getId());?>" class="fancy_link">
    <?php echo image_tag("edit-icon.png", array("width" => 24)); ?>
</a>
</li>