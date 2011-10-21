<div class="evoluciones_cmv_container">
    <h2><?php echo __("Evoluciones_Cmv titulo");?></h2>
    <ul>
        <?php foreach($listEvolucionesCmv as $evolucion): ?>
            <li id="cmv_li_<?php echo $evolucion->getId();?>">
                a
            </li>
        <?php endforeach; ?>
    </ul>
    <a href="<?php echo url_for("@evolucionAgregarCmv?id=".$trasplanteId); ?>"> 
        <?php echo __("Evoluciones_Cmv Agregar");?>
    </a>
</div>