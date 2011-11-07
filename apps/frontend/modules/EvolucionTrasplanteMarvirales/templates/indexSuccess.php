<h1>Evolucion trasplante marviraless List</h1>

<table>
  <thead>
    <tr>
      <th>Id</th>
      <th>Trasplante</th>
      <th>Fecha</th>
      <th>Hsv</th>
      <th>Aghbs</th>
      <th>Hbsac</th>
      <th>Hbcac</th>
      <th>Hvc</th>
      <th>Hiv</th>
    </tr>
  </thead>
  <tbody>
    <?php foreach ($evolucion_trasplante_marviraless as $evolucion_trasplante_marvirales): ?>
    <tr>
      <td><a href="<?php echo url_for('EvolucionTrasplanteMarvirales/edit?id='.$evolucion_trasplante_marvirales->getId()) ?>"><?php echo $evolucion_trasplante_marvirales->getId() ?></a></td>
      <td><?php echo $evolucion_trasplante_marvirales->getTrasplanteId() ?></td>
      <td><?php echo $evolucion_trasplante_marvirales->getFecha() ?></td>
      <td><?php echo $evolucion_trasplante_marvirales->getHsv() ?></td>
      <td><?php echo $evolucion_trasplante_marvirales->getAghbs() ?></td>
      <td><?php echo $evolucion_trasplante_marvirales->getHbsac() ?></td>
      <td><?php echo $evolucion_trasplante_marvirales->getHbcac() ?></td>
      <td><?php echo $evolucion_trasplante_marvirales->getHvc() ?></td>
      <td><?php echo $evolucion_trasplante_marvirales->getHiv() ?></td>
    </tr>
    <?php endforeach; ?>
  </tbody>
</table>

  <a href="<?php echo url_for('EvolucionTrasplanteMarvirales/new') ?>">New</a>
