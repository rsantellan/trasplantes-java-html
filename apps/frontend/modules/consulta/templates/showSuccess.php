<?php use_javascript("consultasManagement.js"); ?>
<?php use_javascript("jqplot/jquery.jqplot.js"); ?>
<?php use_javascript("jqplot/plugins/jqplot.pieRenderer.js"); ?>
<?php use_stylesheet("jqplot/jquery.jqplot.css"); ?>

<a href="<?php echo url_for('consulta/index') ?>"><?php echo __("Consultas_volver a la lista"); ?></a>

<div class="clear"></div>
<h1><?php echo $consulta->getNombre() ?></h1>

<hr/>

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
  <div class="consulta_table_container">
    <table id="hor-minimalist-b">
      <tbody>
      <?php $index = 0;?>
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
  </div>
<hr/>

<div style="text-align: 'center' ">
  
  <div id="pie1" style="margin-top:20px; margin-left:20px; width:100%; height:600px;"></div>
</div>

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

<a href="<?php echo url_for('consulta/index') ?>"><?php echo __("Consultas_volver a la lista"); ?></a>
<div class="clear"></div>

    
<script class="code" type="text/javascript">
  $(document).ready(function(){
	consultasManagement.getInstance().renderPiePlot('pie1', <?php echo $counter - 1; ?>);
});</script>
