<a href="<?php echo url_for('consulta/index') ?>"><?php echo __("Consultas_volver a la lista"); ?></a>

<div class="clear"></div>
<h1><?php echo $consulta->getNombre() ?></h1>

<hr/>


<?php

include_partial('tableGraficaRedonda', array('result' => $result));
?>