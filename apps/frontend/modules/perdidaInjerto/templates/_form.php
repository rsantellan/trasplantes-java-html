<?php use_stylesheets_for_form($form) ?>
<?php use_javascripts_for_form($form) ?>

<form action="<?php echo url_for('perdidaInjerto/'.($form->getObject()->isNew() ? 'create' : 'update').(!$form->getObject()->isNew() ? '?id='.$form->getObject()->getId() : '')) ?>" method="post" <?php $form->isMultipart() and print 'enctype="multipart/form-data" ' ?>>
<?php if (!$form->getObject()->isNew()): ?>
<input type="hidden" name="sf_method" value="put" />
<?php endif; ?>
  <table>
    <tfoot>
      <tr>
        <td colspan="2">
          <?php echo $form->renderHiddenFields(false) ?>
          &nbsp;<a href="<?php echo url_for('perdidaInjerto/index') ?>">Back to list</a>
          <?php if (!$form->getObject()->isNew()): ?>
            &nbsp;<?php echo link_to('Delete', 'perdidaInjerto/delete?id='.$form->getObject()->getId(), array('method' => 'delete', 'confirm' => 'Are you sure?')) ?>
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
        <th><?php echo $form['paciente_causa_perdida_injerto_id']->renderLabel() ?></th>
        <td>
          <?php echo $form['paciente_causa_perdida_injerto_id']->renderError() ?>
          <?php echo $form['paciente_causa_perdida_injerto_id'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['fecha_perdida']->renderLabel() ?></th>
        <td>
          <?php echo $form['fecha_perdida']->renderError() ?>
          <?php echo $form['fecha_perdida'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['paciente_pre_trasplante_id']->renderLabel() ?></th>
        <td>
          <?php echo $form['paciente_pre_trasplante_id']->renderError() ?>
          <?php echo $form['paciente_pre_trasplante_id'] ?>
        </td>
      </tr>
    </tbody>
  </table>
</form>
