<?php use_javascript("consultasManagement.js"); ?>
<?php use_javascript("jqplot/jquery.jqplot.js"); ?>
<?php use_javascript("jqplot/plugins/jqplot.pieRenderer.js"); ?>
<?php use_stylesheet("jqplot/jquery.jqplot.css"); ?>
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
<div style="text-align: 'center' ">
  
  <div id="pie1" style="margin-top:20px; margin-left:20px; width:100%; height:600px;"></div>
</div>

<?php 
$head_list = array();
$head = false;
foreach($result as $row)
{
  foreach($row as $key => $data)
  {
    if(!$head)
    {
      array_push($head_list, $key);
    }
  }
  $head = true;  
}

$counter = 0;
?>
<select id="change_plot_selector">
  <?php foreach($head_list as $title): ?>
  <option value="<?php echo $counter; ?>">
    <?php echo $title; ?>
  </option>
  <?php $counter++; ?>
  <?php endforeach; ?>
</select>

<input type="button" id="changePlot" onclick="consultasManagement.getInstance().changePlot()" value="<?php echo __("consulta_cambiar grafica");?>" />
  <hr/>
  <table id="hor-minimalist-b">
	<tbody>
  <?php
	  
	  
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
	  <?php  ?>
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
  
<script class="code" type="text/javascript">
  $(document).ready(function(){
	consultasManagement.getInstance().renderPiePlot('pie1', <?php echo $counter - 1; ?>);
});</script>
