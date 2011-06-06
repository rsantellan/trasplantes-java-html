<table>
  <tbody>
    <tr>
      <th>Id:</th>
      <td><?php echo $consulta->getId() ?></td>
    </tr>
    <tr>
      <th>Nombre:</th>
      <td><?php echo $consulta->getNombre() ?></td>
    </tr>
    <tr>
      <th>Sentencia:</th>
      <td><?php echo $consulta->getSentencia() ?></td>
    </tr>
  </tbody>
</table>

<hr />

<a href="<?php echo url_for('consulta/edit?id='.$consulta->getId()) ?>">Edit</a>
&nbsp;
<a href="<?php echo url_for('consulta/index') ?>">List</a>


  <hr/>
  <table id="hor-minimalist-b">
	<tbody>
  <?php
	  $head = false;
	  $head_list = array();
    $index = 0;
	?>
  <?php 
	foreach($result as $row):
  ?>
	
	  <tr>
    <?php $index = 0;?>
	<?php foreach($row as $key => $data): ?>
		<?php 
		  if(!$head)
			array_push($head_list, $key);
		?>
		<td class="table_position_<?php echo $index;?>"><?php echo $data?></td>

      <?php $index++;?>
	  <?php endforeach; ?>
	  <?php $head = true; ?>
	  </tr>
  <?php endforeach; ?>
	</tbody>
	<thead>
    <?php $index = 0;?>
	  <?php foreach($head_list as $title): ?>
		<th class="table_position_<?php echo $index;?>"><?php echo $title?></th>
    <?php $index++;?>
	  <?php endforeach; ?>
	</thead>
  </table>
  
