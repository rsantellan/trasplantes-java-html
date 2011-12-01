<div class="volver">
    <a href="<?php echo url_for("@mostrarTrasplante?id=".$trasplanteId);?>"><?php echo __("Trasplante_volver a ver trasplante");?></a>
</div>

<h1><?php echo __("InjertoEvolucions_Titulo");?></h1>

<?php if($evolucionTrasplante): ?>

<?php else: ?>
    <a class="fancy_link" href="<?php echo url_for("@agregarEvolucionInjertoTrasplante?id=".$trasplanteId);?>">
        <?php echo __("InjertoEvolucions_agregar nuevo evolucion");?>
    </a>
<?php endif; ?>


<table>
  <thead>
    <tr>
      <th>Id</th>
      <th>Trasplante</th>
      <th>Fecha</th>
      <th>Tm</th>
      <th>Tm cual</th>
      <th>Gp de novo</th>
      <th>Recidiva gp de novo</th>
      <th>Ra</th>
      <th>Rc</th>
      <th>Ra tratamiento</th>
      <th>En trasplante</th>
    </tr>
  </thead>
  <tbody>
    <?php foreach ($injerto_evolucions as $injerto_evolucion): ?>
    <tr>
      <td><a href="<?php echo url_for('InjertoEvolucion/show?id='.$injerto_evolucion->getId()) ?>"><?php echo $injerto_evolucion->getId() ?></a></td>
      <td><?php echo $injerto_evolucion->getTrasplanteId() ?></td>
      <td><?php echo $injerto_evolucion->getFecha() ?></td>
      <td><?php echo $injerto_evolucion->getTm() ?></td>
      <td><?php echo $injerto_evolucion->getTmCual() ?></td>
      <td><?php echo $injerto_evolucion->getGpDeNovo() ?></td>
      <td><?php echo $injerto_evolucion->getRecidivaGpDeNovo() ?></td>
      <td><?php echo $injerto_evolucion->getRa() ?></td>
      <td><?php echo $injerto_evolucion->getRc() ?></td>
      <td><?php echo $injerto_evolucion->getRaTratamientoId() ?></td>
      <td><?php echo $injerto_evolucion->getEnTrasplante() ?></td>
    </tr>
    <?php endforeach; ?>
  </tbody>
</table>

  <a href="<?php echo url_for('InjertoEvolucion/new') ?>">New</a>
