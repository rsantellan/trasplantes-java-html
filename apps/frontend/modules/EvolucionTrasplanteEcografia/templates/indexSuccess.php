<h1>Evolucion trasplante ecografias List</h1>

<table>
  <thead>
    <tr>
      <th>Id</th>
      <th>Trasplante</th>
      <th>Fecha</th>
      <th>Diametros</th>
      <th>Dilatacion</th>
      <th>Litiasin</th>
      <th>Vejiga</th>
      <th>Espesor</th>
      <th>Otros</th>
    </tr>
  </thead>
  <tbody>
    <?php foreach ($evolucion_trasplante_ecografias as $evolucion_trasplante_ecografia): ?>
    <tr>
      <td><a href="<?php echo url_for('EvolucionTrasplanteEcografia/edit?id='.$evolucion_trasplante_ecografia->getId()) ?>"><?php echo $evolucion_trasplante_ecografia->getId() ?></a></td>
      <td><?php echo $evolucion_trasplante_ecografia->getTrasplanteId() ?></td>
      <td><?php echo $evolucion_trasplante_ecografia->getFecha() ?></td>
      <td><?php echo $evolucion_trasplante_ecografia->getDiametros() ?></td>
      <td><?php echo $evolucion_trasplante_ecografia->getDilatacion() ?></td>
      <td><?php echo $evolucion_trasplante_ecografia->getLitiasin() ?></td>
      <td><?php echo $evolucion_trasplante_ecografia->getVejiga() ?></td>
      <td><?php echo $evolucion_trasplante_ecografia->getEspesor() ?></td>
      <td><?php echo $evolucion_trasplante_ecografia->getOtros() ?></td>
    </tr>
    <?php endforeach; ?>
  </tbody>
</table>

  <a href="<?php echo url_for('EvolucionTrasplanteEcografia/new') ?>">New</a>
