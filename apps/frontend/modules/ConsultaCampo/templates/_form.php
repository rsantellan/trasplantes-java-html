<?php use_stylesheets_for_form($form) ?>
<?php use_javascripts_for_form($form) ?>

<form action="<?php echo url_for('ConsultaCampo/'.($form->getObject()->isNew() ? 'create' : 'update').(!$form->getObject()->isNew() ? '?id='.$form->getObject()->getId() : '')) ?>" method="post" <?php $form->isMultipart() and print 'enctype="multipart/form-data" ' ?>>
<?php if (!$form->getObject()->isNew()): ?>
<input type="hidden" name="sf_method" value="put" />
<?php endif; ?>
  <table>
    <tfoot>
      <tr>
        <td colspan="2">
          <?php echo $form->renderHiddenFields(false) ?>
          &nbsp;<a href="<?php echo url_for('ConsultaCampo/index') ?>">Back to list</a>
          <?php if (!$form->getObject()->isNew()): ?>
            &nbsp;<?php echo link_to('Delete', 'ConsultaCampo/delete?id='.$form->getObject()->getId(), array('method' => 'delete', 'confirm' => 'Are you sure?')) ?>
          <?php endif; ?>
          <input type="submit" value="Save" />
        </td>
      </tr>
    </tfoot>
    <tbody>
      <?php echo $form->renderGlobalErrors() ?>
      <tr>
        <th><?php echo $form['nombre']->renderLabel() ?></th>
        <td>
          <?php echo $form['nombre']->renderError() ?>
          <?php echo $form['nombre'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['nombre_visible']->renderLabel() ?></th>
        <td>
          <?php echo $form['nombre_visible']->renderError() ?>
          <?php echo $form['nombre_visible'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['consulta_id']->renderLabel() ?></th>
        <td>
          <?php echo $form['consulta_id']->renderError() ?>
          <?php echo $form['consulta_id'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['tipo_id']->renderLabel() ?></th>
        <td>
          <?php echo $form['tipo_id']->renderError() ?>
          <?php echo $form['tipo_id'] ?>
        </td>
      </tr>
    </tbody>
  </table>
</form>
