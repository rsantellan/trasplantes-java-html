<?php use_stylesheets_for_form($form) ?>
<?php use_javascripts_for_form($form) ?>

<form action="<?php echo url_for('Pacientes/'.($form->getObject()->isNew() ? 'create' : 'update').(!$form->getObject()->isNew() ? '?id='.$form->getObject()->getId() : '')) ?>" method="post" <?php $form->isMultipart() and print 'enctype="multipart/form-data" ' ?>>
<?php if (!$form->getObject()->isNew()): ?>
<input type="hidden" name="sf_method" value="put" />
<?php endif; ?>
  <table>
    <tfoot>
      <tr>
        <td colspan="2">
          <?php echo $form->renderHiddenFields(false) ?>
          &nbsp;<a href="<?php echo url_for('Pacientes/index') ?>">Back to list</a>
          <?php if (!$form->getObject()->isNew()): ?>
            &nbsp;<?php echo link_to('Delete', 'Pacientes/delete?id='.$form->getObject()->getId(), array('method' => 'delete', 'confirm' => 'Are you sure?')) ?>
          <?php endif; ?>
          <input type="submit" value="Save" />
        </td>
      </tr>
    </tfoot>
    <tbody>
      <?php echo $form->renderGlobalErrors() ?>
      <tr>
        <th><?php echo $form['the']->renderLabel() ?></th>
        <td>
          <?php echo $form['the']->renderError() ?>
          <?php echo $form['the'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['ci']->renderLabel() ?></th>
        <td>
          <?php echo $form['ci']->renderError() ?>
          <?php echo $form['ci'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['nombre']->renderLabel() ?></th>
        <td>
          <?php echo $form['nombre']->renderError() ?>
          <?php echo $form['nombre'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['apellido']->renderLabel() ?></th>
        <td>
          <?php echo $form['apellido']->renderError() ?>
          <?php echo $form['apellido'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['num_fnr']->renderLabel() ?></th>
        <td>
          <?php echo $form['num_fnr']->renderError() ?>
          <?php echo $form['num_fnr'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['raza']->renderLabel() ?></th>
        <td>
          <?php echo $form['raza']->renderError() ?>
          <?php echo $form['raza'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['sexo']->renderLabel() ?></th>
        <td>
          <?php echo $form['sexo']->renderError() ?>
          <?php echo $form['sexo'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['fecha_nacimiento']->renderLabel() ?></th>
        <td>
          <?php echo $form['fecha_nacimiento']->renderError() ?>
          <?php echo $form['fecha_nacimiento'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['fecha_dialisis']->renderLabel() ?></th>
        <td>
          <?php echo $form['fecha_dialisis']->renderError() ?>
          <?php echo $form['fecha_dialisis'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['nefropatia_id']->renderLabel() ?></th>
        <td>
          <?php echo $form['nefropatia_id']->renderError() ?>
          <?php echo $form['nefropatia_id'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['grupo_sanguineo']->renderLabel() ?></th>
        <td>
          <?php echo $form['grupo_sanguineo']->renderError() ?>
          <?php echo $form['grupo_sanguineo'] ?>
        </td>
      </tr>
    </tbody>
  </table>
</form>
