<?php use_stylesheets_for_form($form) ?>
<?php use_javascripts_for_form($form) ?>

<form action="<?php echo url_for('EvolucionTrasplanteEcografia/'.($form->getObject()->isNew() ? 'create' : 'update').(!$form->getObject()->isNew() ? '?id='.$form->getObject()->getId() : '')) ?>" method="post" <?php $form->isMultipart() and print 'enctype="multipart/form-data" ' ?>>
<?php if (!$form->getObject()->isNew()): ?>
<input type="hidden" name="sf_method" value="put" />
<?php endif; ?>
  <table>
    <tfoot>
      <tr>
        <td colspan="2">
          <?php echo $form->renderHiddenFields(false) ?>
          &nbsp;<a href="<?php echo url_for('EvolucionTrasplanteEcografia/index') ?>">Back to list</a>
          <?php if (!$form->getObject()->isNew()): ?>
            &nbsp;<?php echo link_to('Delete', 'EvolucionTrasplanteEcografia/delete?id='.$form->getObject()->getId(), array('method' => 'delete', 'confirm' => 'Are you sure?')) ?>
          <?php endif; ?>
          <input type="submit" value="Save" />
        </td>
      </tr>
    </tfoot>
    <tbody>
      <?php echo $form->renderGlobalErrors() ?>
      <tr>
        <th><?php echo $form['trasplante_id']->renderLabel() ?></th>
        <td>
          <?php echo $form['trasplante_id']->renderError() ?>
          <?php echo $form['trasplante_id'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['fecha']->renderLabel() ?></th>
        <td>
          <?php echo $form['fecha']->renderError() ?>
          <?php echo $form['fecha'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['diametros']->renderLabel() ?></th>
        <td>
          <?php echo $form['diametros']->renderError() ?>
          <?php echo $form['diametros'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['dilatacion']->renderLabel() ?></th>
        <td>
          <?php echo $form['dilatacion']->renderError() ?>
          <?php echo $form['dilatacion'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['litiasin']->renderLabel() ?></th>
        <td>
          <?php echo $form['litiasin']->renderError() ?>
          <?php echo $form['litiasin'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['vejiga']->renderLabel() ?></th>
        <td>
          <?php echo $form['vejiga']->renderError() ?>
          <?php echo $form['vejiga'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['espesor']->renderLabel() ?></th>
        <td>
          <?php echo $form['espesor']->renderError() ?>
          <?php echo $form['espesor'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['otros']->renderLabel() ?></th>
        <td>
          <?php echo $form['otros']->renderError() ?>
          <?php echo $form['otros'] ?>
        </td>
      </tr>
    </tbody>
  </table>
</form>
