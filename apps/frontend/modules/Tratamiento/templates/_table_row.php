<?php 
  use_helper('Date'); 
?>
<tr id="tratamiento_row_<?php echo $tratamiento->getId();?>">
  <td><?php echo $tratamiento->getMedicaciones()->getNombre() ?></td>
  <td><?php echo $tratamiento->getDosis() ?></td>
  <td><?php echo format_date($tratamiento->getFechaInicio(), 'D');?></td>
  <td><?php echo format_date($tratamiento->getFechaFin(), 'D');?></td>
  <td><a class="fancy_small_link" href="<?php echo url_for('@editarTratamiento?id='.$tratamiento->getId()) ?>"><?php echo image_tag("edit-icon.png")?></a></td>
  <td><a class="fancy_small_link" href="<?php echo url_for('@cambiarFechaAltaTratamiento?id='.$tratamiento->getId()) ?>"><?php echo image_tag("calendar.png")?></a></td>
  <td><a href="javascript:void(0);" onclick="return tratamientoManagement.getInstance().deleteTratamiento(<?php echo $tratamiento->getId()?>,'<?php echo __("Tratamiento_esta seguro de querer eliminar?");?>', '<?php echo url_for('@eliminarTratamiento') ?>')" ><?php echo image_tag("trash.png")?></a></td>
</tr>