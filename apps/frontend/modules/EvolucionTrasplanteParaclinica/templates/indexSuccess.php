<h1>Evolucion trasplante paraclinicas List</h1>

<table>
  <thead>
    <tr>
      <th>Id</th>
      <th>Trasplante</th>
      <th>Fecha</th>
      <th>Pas</th>
      <th>Pad</th>
      <th>Diuresis</th>
      <th>Peso</th>
      <th>Urea</th>
      <th>Creatinina</th>
      <th>Ht</th>
      <th>Hb</th>
      <th>Gb</th>
      <th>Plaquetas</th>
      <th>Sodio</th>
      <th>Potasio</th>
      <th>Cloro</th>
      <th>Calcio</th>
      <th>Fosforo</th>
      <th>Glicemia</th>
      <th>Uricemia</th>
      <th>Prot u</th>
      <th>Ccreatinina</th>
      <th>Curea</th>
      <th>Na u</th>
      <th>Ku</th>
      <th>Cya pv</th>
      <th>Cya pp</th>
      <th>Fk p</th>
      <th>Mfm p</th>
      <th>Eve p</th>
      <th>Bd</th>
      <th>Bi</th>
      <th>Tgo</th>
      <th>Tgp</th>
      <th>Gammagt</th>
      <th>F alc</th>
      <th>T prot</th>
      <th>Kptt</th>
      <th>Howell</th>
      <th>Fibrinogeno</th>
      <th>Colesterol</th>
      <th>Hdl</th>
      <th>Ldl</th>
      <th>R at</th>
      <th>Tg</th>
      <th>Hna1c</th>
      <th>Albumina</th>
      <th>Globulinas</th>
      <th>Pthi</th>
      <th>Otros</th>
      <th>Numpthi</th>
    </tr>
  </thead>
  <tbody>
    <?php foreach ($evolucion_trasplante_paraclinicas as $evolucion_trasplante_paraclinica): ?>
    <tr>
      <td><a href="<?php echo url_for('EvolucionTrasplanteParaclinica/edit?id='.$evolucion_trasplante_paraclinica->getId()) ?>"><?php echo $evolucion_trasplante_paraclinica->getId() ?></a></td>
      <td><?php echo $evolucion_trasplante_paraclinica->getTrasplanteId() ?></td>
      <td><?php echo $evolucion_trasplante_paraclinica->getFecha() ?></td>
      <td><?php echo $evolucion_trasplante_paraclinica->getPas() ?></td>
      <td><?php echo $evolucion_trasplante_paraclinica->getPad() ?></td>
      <td><?php echo $evolucion_trasplante_paraclinica->getDiuresis() ?></td>
      <td><?php echo $evolucion_trasplante_paraclinica->getPeso() ?></td>
      <td><?php echo $evolucion_trasplante_paraclinica->getUrea() ?></td>
      <td><?php echo $evolucion_trasplante_paraclinica->getCreatinina() ?></td>
      <td><?php echo $evolucion_trasplante_paraclinica->getHt() ?></td>
      <td><?php echo $evolucion_trasplante_paraclinica->getHb() ?></td>
      <td><?php echo $evolucion_trasplante_paraclinica->getGb() ?></td>
      <td><?php echo $evolucion_trasplante_paraclinica->getPlaquetas() ?></td>
      <td><?php echo $evolucion_trasplante_paraclinica->getSodio() ?></td>
      <td><?php echo $evolucion_trasplante_paraclinica->getPotasio() ?></td>
      <td><?php echo $evolucion_trasplante_paraclinica->getCloro() ?></td>
      <td><?php echo $evolucion_trasplante_paraclinica->getCalcio() ?></td>
      <td><?php echo $evolucion_trasplante_paraclinica->getFosforo() ?></td>
      <td><?php echo $evolucion_trasplante_paraclinica->getGlicemia() ?></td>
      <td><?php echo $evolucion_trasplante_paraclinica->getUricemia() ?></td>
      <td><?php echo $evolucion_trasplante_paraclinica->getProtU() ?></td>
      <td><?php echo $evolucion_trasplante_paraclinica->getCcreatinina() ?></td>
      <td><?php echo $evolucion_trasplante_paraclinica->getCurea() ?></td>
      <td><?php echo $evolucion_trasplante_paraclinica->getNaU() ?></td>
      <td><?php echo $evolucion_trasplante_paraclinica->getKu() ?></td>
      <td><?php echo $evolucion_trasplante_paraclinica->getCyaPv() ?></td>
      <td><?php echo $evolucion_trasplante_paraclinica->getCyaPp() ?></td>
      <td><?php echo $evolucion_trasplante_paraclinica->getFkP() ?></td>
      <td><?php echo $evolucion_trasplante_paraclinica->getMfmP() ?></td>
      <td><?php echo $evolucion_trasplante_paraclinica->getEveP() ?></td>
      <td><?php echo $evolucion_trasplante_paraclinica->getBd() ?></td>
      <td><?php echo $evolucion_trasplante_paraclinica->getBi() ?></td>
      <td><?php echo $evolucion_trasplante_paraclinica->getTgo() ?></td>
      <td><?php echo $evolucion_trasplante_paraclinica->getTgp() ?></td>
      <td><?php echo $evolucion_trasplante_paraclinica->getGammagt() ?></td>
      <td><?php echo $evolucion_trasplante_paraclinica->getFAlc() ?></td>
      <td><?php echo $evolucion_trasplante_paraclinica->getTProt() ?></td>
      <td><?php echo $evolucion_trasplante_paraclinica->getKptt() ?></td>
      <td><?php echo $evolucion_trasplante_paraclinica->getHowell() ?></td>
      <td><?php echo $evolucion_trasplante_paraclinica->getFibrinogeno() ?></td>
      <td><?php echo $evolucion_trasplante_paraclinica->getColesterol() ?></td>
      <td><?php echo $evolucion_trasplante_paraclinica->getHdl() ?></td>
      <td><?php echo $evolucion_trasplante_paraclinica->getLdl() ?></td>
      <td><?php echo $evolucion_trasplante_paraclinica->getRAt() ?></td>
      <td><?php echo $evolucion_trasplante_paraclinica->getTg() ?></td>
      <td><?php echo $evolucion_trasplante_paraclinica->getHna1c() ?></td>
      <td><?php echo $evolucion_trasplante_paraclinica->getAlbumina() ?></td>
      <td><?php echo $evolucion_trasplante_paraclinica->getGlobulinas() ?></td>
      <td><?php echo $evolucion_trasplante_paraclinica->getPthi() ?></td>
      <td><?php echo $evolucion_trasplante_paraclinica->getOtros() ?></td>
      <td><?php echo $evolucion_trasplante_paraclinica->getNumpthi() ?></td>
    </tr>
    <?php endforeach; ?>
  </tbody>
</table>

  <a href="<?php echo url_for('EvolucionTrasplanteParaclinica/new') ?>">New</a>
