<?php use_stylesheets_for_form($form) ?>
<?php use_javascripts_for_form($form) ?>

<form action="<?php echo url_for('EvolucionTrasplanteCmv/'.($form->getObject()->isNew() ? 'create' : 'update').(!$form->getObject()->isNew() ? '?id='.$form->getObject()->getId() : '')) ?>" method="post" <?php $form->isMultipart() and print 'enctype="multipart/form-data" ' ?>>
<?php if (!$form->getObject()->isNew()): ?>
<input type="hidden" name="sf_method" value="put" />
<?php endif; ?>
  <table>
    <tfoot>
      <tr>
        <td colspan="2">
          <?php echo $form->renderHiddenFields(false) ?>
          &nbsp;<a href="<?php echo url_for('EvolucionTrasplanteCmv/index') ?>">Back to list</a>
          <?php if (!$form->getObject()->isNew()): ?>
            &nbsp;<?php echo link_to('Delete', 'EvolucionTrasplanteCmv/delete?id='.$form->getObject()->getId(), array('method' => 'delete', 'confirm' => 'Are you sure?')) ?>
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
        <th><?php echo $form['igg_cmv']->renderLabel() ?></th>
        <td>
          <?php echo $form['igg_cmv']->renderError() ?>
          <?php echo $form['igg_cmv'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['igm_cmv']->renderLabel() ?></th>
        <td>
          <?php echo $form['igm_cmv']->renderError() ?>
          <?php echo $form['igm_cmv'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['pcr_cmv']->renderLabel() ?></th>
        <td>
          <?php echo $form['pcr_cmv']->renderError() ?>
          <?php echo $form['pcr_cmv'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['ag_pp65']->renderLabel() ?></th>
        <td>
          <?php echo $form['ag_pp65']->renderError() ?>
          <?php echo $form['ag_pp65'] ?>
        </td>
      </tr>
    </tbody>
  </table>
</form>
