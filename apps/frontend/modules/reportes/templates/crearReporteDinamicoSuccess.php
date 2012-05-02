
<select>
<?php foreach($pacientes as $id => $nombre): ?>
  <option value="<?php echo $id;?>"><?php echo $nombre;?></option>
<?php endforeach; ?>
</select>
<br/>
<input type="checkbox" name="muerte" value="1" /> <?php echo __("reportes_agregar muerte a los reportes");?>
