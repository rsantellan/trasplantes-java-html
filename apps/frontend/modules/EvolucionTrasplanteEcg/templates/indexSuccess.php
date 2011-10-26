<h1>Evolucion trasplante ecgs List</h1>

<table>
  <thead>
    <tr>
      <th>Id</th>
      <th>Trasplante</th>
      <th>Fecha</th>
      <th>Rs ecg</th>
      <th>Hvi ecg</th>
      <th>Onda q ecg</th>
    </tr>
  </thead>
  <tbody>
    <?php foreach ($evolucion_trasplante_ecgs as $evolucion_trasplante_ecg): ?>
    <tr>
      <td><a href="<?php echo url_for('EvolucionTrasplanteEcg/show?id='.$evolucion_trasplante_ecg->getId()) ?>"><?php echo $evolucion_trasplante_ecg->getId() ?></a></td>
      <td><?php echo $evolucion_trasplante_ecg->getTrasplanteId() ?></td>
      <td><?php echo $evolucion_trasplante_ecg->getFecha() ?></td>
      <td><?php echo $evolucion_trasplante_ecg->getRsEcg() ?></td>
      <td><?php echo $evolucion_trasplante_ecg->getHviEcg() ?></td>
      <td><?php echo $evolucion_trasplante_ecg->getOndaQEcg() ?></td>
    </tr>
    <?php endforeach; ?>
  </tbody>
</table>

  <a href="<?php echo url_for('EvolucionTrasplanteEcg/new') ?>">New</a>
