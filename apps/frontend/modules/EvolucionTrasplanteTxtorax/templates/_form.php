<?php use_stylesheets_for_form($form) ?>
<?php use_javascripts_for_form($form) ?>

<form action="<?php echo url_for('EvolucionTrasplanteTxtorax/'.($form->getObject()->isNew() ? 'create' : 'update').(!$form->getObject()->isNew() ? '?id='.$form->getObject()->getId() : '')) ?>" method="post" <?php $form->isMultipart() and print 'enctype="multipart/form-data" ' ?>>
<?php if (!$form->getObject()->isNew()): ?>
<input type="hidden" name="sf_method" value="put" />
<?php endif; ?>
  <table>
    <tfoot>
      <tr>
        <td colspan="2">
          <?php echo $form->renderHiddenFields(false) ?>
          &nbsp;<a href="<?php echo url_for('EvolucionTrasplanteTxtorax/index') ?>">Back to list</a>
          <?php if (!$form->getObject()->isNew()): ?>
            &nbsp;<?php echo link_to('Delete', 'EvolucionTrasplanteTxtorax/delete?id='.$form->getObject()->getId(), array('method' => 'delete', 'confirm' => 'Are you sure?')) ?>
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
        <th><?php echo $form['rct']->renderLabel() ?></th>
        <td>
          <?php echo $form['rct']->renderError() ?>
          <?php echo $form['rct'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['foco']->renderLabel() ?></th>
        <td>
          <?php echo $form['foco']->renderError() ?>
          <?php echo $form['foco'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['lateralizado']->renderLabel() ?></th>
        <td>
          <?php echo $form['lateralizado']->renderError() ?>
          <?php echo $form['lateralizado'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['derrame_pleural']->renderLabel() ?></th>
        <td>
          <?php echo $form['derrame_pleural']->renderError() ?>
          <?php echo $form['derrame_pleural'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['lateral_derrame']->renderLabel() ?></th>
        <td>
          <?php echo $form['lateral_derrame']->renderError() ?>
          <?php echo $form['lateral_derrame'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['secuelas']->renderLabel() ?></th>
        <td>
          <?php echo $form['secuelas']->renderError() ?>
          <?php echo $form['secuelas'] ?>
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
