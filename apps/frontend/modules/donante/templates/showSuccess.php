<table>
  <tbody>
    <tr>
      <th>Id:</th>
      <td><?php echo $donante->getId() ?></td>
    </tr>
    <tr>
      <th>Identificador:</th>
      <td><?php echo $donante->getIdentificador() ?></td>
    </tr>
    <tr>
      <th>Tipo donante:</th>
      <td><?php echo $donante->getTipoDonante() ?></td>
    </tr>
    <tr>
      <th>Sexo donante:</th>
      <td><?php echo $donante->getSexoDonante() ?></td>
    </tr>
    <tr>
      <th>Edad donante:</th>
      <td><?php echo $donante->getEdadDonante() ?></td>
    </tr>
    <tr>
      <th>Enastab hemod:</th>
      <td><?php echo $donante->getEnastabHemod() ?></td>
    </tr>
    <tr>
      <th>Donante causa muerte:</th>
      <td><?php echo $donante->getDonanteCausaMuerteId() ?></td>
    </tr>
    <tr>
      <th>Cr p:</th>
      <td><?php echo $donante->getCrP() ?></td>
    </tr>
    <tr>
      <th>Otros:</th>
      <td><?php echo $donante->getOtros() ?></td>
    </tr>
    <tr>
      <th>Grupo sanguineo:</th>
      <td><?php echo $donante->getGrupoSanguineo() ?></td>
    </tr>
    <tr>
      <th>Relacion filiar:</th>
      <td><?php echo $donante->getRelacionFiliar() ?></td>
    </tr>
    <tr>
      <th>Peso:</th>
      <td><?php echo $donante->getPeso() ?></td>
    </tr>
    <tr>
      <th>Altura:</th>
      <td><?php echo $donante->getAltura() ?></td>
    </tr>
  </tbody>
</table>

<hr />

<a href="<?php echo url_for('donante/edit?id='.$donante->getId()) ?>">Edit</a>
&nbsp;
<a href="<?php echo url_for('donante/index') ?>">List</a>
