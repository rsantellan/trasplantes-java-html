<h1>Evolucion trasplante ecodoplers List</h1>

<table>
  <thead>
    <tr>
      <th>Id</th>
      <th>Trasplante</th>
      <th>Fecha</th>
      <th>Estructura</th>
      <th>Dilatacion</th>
      <th>Colecciones</th>
      <th>Eje arterial</th>
      <th>Eje venoso</th>
      <th>Arteria renal</th>
      <th>Vena renal</th>
      <th>Anast venosa</th>
      <th>Anast renosa</th>
      <th>Indice</th>
      <th>Otros</th>
    </tr>
  </thead>
  <tbody>
    <?php foreach ($evolucion_trasplante_ecodoplers as $evolucion_trasplante_ecodopler): ?>
    <tr>
      <td><a href="<?php echo url_for('EvolucionTrasplanteEcodopler/edit?id='.$evolucion_trasplante_ecodopler->getId()) ?>"><?php echo $evolucion_trasplante_ecodopler->getId() ?></a></td>
      <td><?php echo $evolucion_trasplante_ecodopler->getTrasplanteId() ?></td>
      <td><?php echo $evolucion_trasplante_ecodopler->getFecha() ?></td>
      <td><?php echo $evolucion_trasplante_ecodopler->getEstructura() ?></td>
      <td><?php echo $evolucion_trasplante_ecodopler->getDilatacion() ?></td>
      <td><?php echo $evolucion_trasplante_ecodopler->getColecciones() ?></td>
      <td><?php echo $evolucion_trasplante_ecodopler->getEjeArterial() ?></td>
      <td><?php echo $evolucion_trasplante_ecodopler->getEjeVenoso() ?></td>
      <td><?php echo $evolucion_trasplante_ecodopler->getArteriaRenal() ?></td>
      <td><?php echo $evolucion_trasplante_ecodopler->getVenaRenal() ?></td>
      <td><?php echo $evolucion_trasplante_ecodopler->getAnastVenosa() ?></td>
      <td><?php echo $evolucion_trasplante_ecodopler->getAnastRenosa() ?></td>
      <td><?php echo $evolucion_trasplante_ecodopler->getIndice() ?></td>
      <td><?php echo $evolucion_trasplante_ecodopler->getOtros() ?></td>
    </tr>
    <?php endforeach; ?>
  </tbody>
</table>

  <a href="<?php echo url_for('EvolucionTrasplanteEcodopler/new') ?>">New</a>
