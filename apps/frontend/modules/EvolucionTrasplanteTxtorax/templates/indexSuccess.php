<h1>Evolucion trasplante txtoraxs List</h1>

<table>
  <thead>
    <tr>
      <th>Id</th>
      <th>Trasplante</th>
      <th>Fecha</th>
      <th>Rct</th>
      <th>Foco</th>
      <th>Lateralizado</th>
      <th>Derrame pleural</th>
      <th>Lateral derrame</th>
      <th>Secuelas</th>
      <th>Otros</th>
    </tr>
  </thead>
  <tbody>
    <?php foreach ($evolucion_trasplante_txtoraxs as $evolucion_trasplante_txtorax): ?>
    <tr>
      <td><a href="<?php echo url_for('EvolucionTrasplanteTxtorax/edit?id='.$evolucion_trasplante_txtorax->getId()) ?>"><?php echo $evolucion_trasplante_txtorax->getId() ?></a></td>
      <td><?php echo $evolucion_trasplante_txtorax->getTrasplanteId() ?></td>
      <td><?php echo $evolucion_trasplante_txtorax->getFecha() ?></td>
      <td><?php echo $evolucion_trasplante_txtorax->getRct() ?></td>
      <td><?php echo $evolucion_trasplante_txtorax->getFoco() ?></td>
      <td><?php echo $evolucion_trasplante_txtorax->getLateralizado() ?></td>
      <td><?php echo $evolucion_trasplante_txtorax->getDerramePleural() ?></td>
      <td><?php echo $evolucion_trasplante_txtorax->getLateralDerrame() ?></td>
      <td><?php echo $evolucion_trasplante_txtorax->getSecuelas() ?></td>
      <td><?php echo $evolucion_trasplante_txtorax->getOtros() ?></td>
    </tr>
    <?php endforeach; ?>
  </tbody>
</table>

  <a href="<?php echo url_for('EvolucionTrasplanteTxtorax/new') ?>">New</a>
