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
  <table>
	<tbody>
  <?php
	  $head = false;
	  $head_list = array();
	?>
  <?php 
	foreach($result as $row):
  ?>
	
	  <tr>
	<?php foreach($row as $key => $data): ?>
		<?php 
		  if(!$head)
			array_push($head_list, $key);
		?>
		<td><?php echo $data?></td>


	  <?php endforeach; ?>
	  <?php $head = true; ?>
	  </tr>
  <?php endforeach; ?>
	</tbody>
	<thead>
	  <?php foreach($head_list as $title): ?>
		<th><?php echo $title?></th>
	  <?php endforeach; ?>
	</thead>
  </table>
  