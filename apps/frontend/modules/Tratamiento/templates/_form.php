<?php use_stylesheets_for_form($form) ?>
<?php use_javascripts_for_form($form) ?>

<form action="<?php echo url_for('Tratamiento/'.($form->getObject()->isNew() ? 'create' : 'update').(!$form->getObject()->isNew() ? '?id='.$form->getObject()->getId() : '')) ?>" method="post" <?php $form->isMultipart() and print 'enctype="multipart/form-data" ' ?>>
<?php if (!$form->getObject()->isNew()): ?>
<input type="hidden" name="sf_method" value="put" />
<?php endif; ?>
  <table>
    <tfoot>
      <tr>
        <td colspan="2">
          <?php echo $form->renderHiddenFields(false) ?>
          &nbsp;<a href="<?php echo url_for('Tratamiento/index') ?>">Back to list</a>
          <?php if (!$form->getObject()->isNew()): ?>
            &nbsp;<?php echo link_to('Delete', 'Tratamiento/delete?id='.$form->getObject()->getId(), array('method' => 'delete', 'confirm' => 'Are you sure?')) ?>
          <?php endif; ?>
          <input type="submit" value="Save" />
        </td>
      </tr>
    </tfoot>
    <tbody>
      <?php echo $form->renderGlobalErrors() ?>
      <tr>
        <th><?php echo $form['paciente_id']->renderLabel() ?></th>
        <td>
          <?php echo $form['paciente_id']->renderError() ?>
          <?php echo $form['paciente_id'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['medicacion_id']->renderLabel() ?></th>
        <td>
          <?php echo $form['medicacion_id']->renderError() ?>
          <?php echo $form['medicacion_id'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['dosis']->renderLabel() ?></th>
        <td>
          <?php echo $form['dosis']->renderError() ?>
          <?php echo $form['dosis'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['fecha_inicio']->renderLabel() ?></th>
        <td>
          <?php echo $form['fecha_inicio']->renderError() ?>
          <?php echo $form['fecha_inicio'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['fecha_fin']->renderLabel() ?></th>
        <td>
          <?php echo $form['fecha_fin']->renderError() ?>
          <?php echo $form['fecha_fin'] ?>
        </td>
      </tr>
    </tbody>
  </table>
</form>
