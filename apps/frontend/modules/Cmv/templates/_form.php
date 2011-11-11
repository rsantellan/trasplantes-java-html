<?php use_stylesheets_for_form($form) ?>
<?php use_javascripts_for_form($form) ?>

<form action="<?php echo url_for('Cmv/'.($form->getObject()->isNew() ? 'create' : 'update').(!$form->getObject()->isNew() ? '?id='.$form->getObject()->getId() : '')) ?>" method="post" <?php $form->isMultipart() and print 'enctype="multipart/form-data" ' ?>>
<?php if (!$form->getObject()->isNew()): ?>
<input type="hidden" name="sf_method" value="put" />
<?php endif; ?>
  <table>
    <tfoot>
      <tr>
        <td colspan="2">
          <?php echo $form->renderHiddenFields(false) ?>
          &nbsp;<a href="<?php echo url_for('Cmv/index') ?>">Back to list</a>
          <?php if (!$form->getObject()->isNew()): ?>
            &nbsp;<?php echo link_to('Delete', 'Cmv/delete?id='.$form->getObject()->getId(), array('method' => 'delete', 'confirm' => 'Are you sure?')) ?>
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
        <th><?php echo $form['cmv_diagnostico_id']->renderLabel() ?></th>
        <td>
          <?php echo $form['cmv_diagnostico_id']->renderError() ?>
          <?php echo $form['cmv_diagnostico_id'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['tipo']->renderLabel() ?></th>
        <td>
          <?php echo $form['tipo']->renderError() ?>
          <?php echo $form['tipo'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['cmv_droga_id']->renderLabel() ?></th>
        <td>
          <?php echo $form['cmv_droga_id']->renderError() ?>
          <?php echo $form['cmv_droga_id'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['dias_tratamiento']->renderLabel() ?></th>
        <td>
          <?php echo $form['dias_tratamiento']->renderError() ?>
          <?php echo $form['dias_tratamiento'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['efecto_secundario']->renderLabel() ?></th>
        <td>
          <?php echo $form['efecto_secundario']->renderError() ?>
          <?php echo $form['efecto_secundario'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['cmv_emfermedades_list']->renderLabel() ?></th>
        <td>
          <?php echo $form['cmv_emfermedades_list']->renderError() ?>
          <?php echo $form['cmv_emfermedades_list'] ?>
        </td>
      </tr>
    </tbody>
  </table>
</form>
