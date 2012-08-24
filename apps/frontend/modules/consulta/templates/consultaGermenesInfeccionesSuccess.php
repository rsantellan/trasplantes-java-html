<h1><?php echo __("Consultas_titulo germenes e infecciones");?></h1>

<a href="<?php echo url_for('consulta/index') ?>"><?php echo __("Consultas_volver a la lista"); ?></a>

<form method="GET" action="<?php echo url_for('@consultaGermenInfeccion');?>">
  <div>
    <label><?php echo __("Consultas_germenes");?></label>
    <select name="g">
      <option value="0" <?php echo ($germen_id == 0)? 'selected': '';?>><?php echo __("Consultas_ninguno");?></option>
      <?php foreach($germenes as $germen): ?>
      <option value="<?php echo $germen->getId();?>" <?php echo ($germen_id == $germen->getId())? 'selected': '';?>><?php echo $germen->getNombre();?></option>
      <?php
      endforeach;
      ?>
    </select>
  </div>
  
  <div>
    <label><?php echo __("Consultas_infeccion");?></label>
    <select name="i">
      <option value="0" <?php echo ($infeccion_id == 0)? 'selected': '';?>><?php echo __("Consultas_ninguno");?></option>
      <?php foreach($infecciones as $infeccion): ?>
      <option value="<?php echo $infeccion->getId();?>" <?php echo ($infeccion_id == $infeccion->getId())? 'selected': '';?>><?php echo $infeccion->getNombre();?></option>
      <?php
      endforeach;
      ?>
    </select>
  </div>
  <div class="clear"></div>
  <input type="submit" value="<?php echo __("Consultas_consultar");?>" />
</form>

<hr/>


<?php

include_partial('tableGraficaRedonda', array( 'result' => $result));
?>