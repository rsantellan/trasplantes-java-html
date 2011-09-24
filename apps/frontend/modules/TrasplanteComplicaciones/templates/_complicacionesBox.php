<table>
  <tbody>
	<tr>
	  <td><?php echo __("trasplanteComplicacion_Complicaciones infecciosas");?></td>
	  <td><?php echo count($complicaciones_infecciosas_trasplante)?></td>
	  <td><?php echo count($complicaciones_infecciosas_evolucion)?></td>
	</tr>
	<tr>
	  <td><?php echo __("trasplanteComplicacion_Complicaciones no infecciosas");?></td>
	  <td><?php echo count($complicaciones_no_infecciosas_trasplante)?></td>
	  <td><?php echo count($complicaciones_no_infecciosas_evolucion)?></td>
	</tr>
  </tbody>
  <thead>
	<tr>
	  <td></td>
	  <td><?php echo __("trasplanteComplicacion_Trasplante");?></td>
	  <td><?php echo __("trasplanteComplicacion_Evolucion");?></td>
	</tr>
  </thead>
</table>