<?php use_stylesheets_for_form($form) ?>
<?php use_javascripts_for_form($form) ?>

<form action="<?php echo url_for('EvolucionTrasplanteEcg/'.($form->getObject()->isNew() ? 'create' : 'update').(!$form->getObject()->isNew() ? '?id='.$form->getObject()->getId() : '')) ?>" method="post" <?php $form->isMultipart() and print 'enctype="multipart/form-data" ' ?>>
<?php if (!$form->getObject()->isNew()): ?>
<input type="hidden" name="sf_method" value="put" />
<?php endif; ?>
  <table>
    <tfoot>
      <tr>
        <td colspan="2">
          <?php echo $form->renderHiddenFields(false) ?>
          &nbsp;<a href="<?php echo url_for('EvolucionTrasplanteEcg/index') ?>">Back to list</a>
          <?php if (!$form->getObject()->isNew()): ?>
            &nbsp;<?php echo link_to('Delete', 'EvolucionTrasplanteEcg/delete?id='.$form->getObject()->getId(), array('method' => 'delete', 'confirm' => 'Are you sure?')) ?>
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
        <th><?php echo $form['rs_ecg']->renderLabel() ?></th>
        <td>
          <?php echo $form['rs_ecg']->renderError() ?>
          <?php echo $form['rs_ecg'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['hvi_ecg']->renderLabel() ?></th>
        <td>
          <?php echo $form['hvi_ecg']->renderError() ?>
          <?php echo $form['hvi_ecg'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['onda_q_ecg']->renderLabel() ?></th>
        <td>
          <?php echo $form['onda_q_ecg']->renderError() ?>
          <?php echo $form['onda_q_ecg'] ?>
        </td>
      </tr>
    </tbody>
  </table>
</form>
