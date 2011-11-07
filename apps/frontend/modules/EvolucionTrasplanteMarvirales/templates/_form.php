<?php use_stylesheets_for_form($form) ?>
<?php use_javascripts_for_form($form) ?>

<form action="<?php echo url_for('EvolucionTrasplanteMarvirales/'.($form->getObject()->isNew() ? 'create' : 'update').(!$form->getObject()->isNew() ? '?id='.$form->getObject()->getId() : '')) ?>" method="post" <?php $form->isMultipart() and print 'enctype="multipart/form-data" ' ?>>
<?php if (!$form->getObject()->isNew()): ?>
<input type="hidden" name="sf_method" value="put" />
<?php endif; ?>
  <table>
    <tfoot>
      <tr>
        <td colspan="2">
          <?php echo $form->renderHiddenFields(false) ?>
          &nbsp;<a href="<?php echo url_for('EvolucionTrasplanteMarvirales/index') ?>">Back to list</a>
          <?php if (!$form->getObject()->isNew()): ?>
            &nbsp;<?php echo link_to('Delete', 'EvolucionTrasplanteMarvirales/delete?id='.$form->getObject()->getId(), array('method' => 'delete', 'confirm' => 'Are you sure?')) ?>
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
        <th><?php echo $form['hsv']->renderLabel() ?></th>
        <td>
          <?php echo $form['hsv']->renderError() ?>
          <?php echo $form['hsv'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['aghbs']->renderLabel() ?></th>
        <td>
          <?php echo $form['aghbs']->renderError() ?>
          <?php echo $form['aghbs'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['hbsac']->renderLabel() ?></th>
        <td>
          <?php echo $form['hbsac']->renderError() ?>
          <?php echo $form['hbsac'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['hbcac']->renderLabel() ?></th>
        <td>
          <?php echo $form['hbcac']->renderError() ?>
          <?php echo $form['hbcac'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['hvc']->renderLabel() ?></th>
        <td>
          <?php echo $form['hvc']->renderError() ?>
          <?php echo $form['hvc'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['hiv']->renderLabel() ?></th>
        <td>
          <?php echo $form['hiv']->renderError() ?>
          <?php echo $form['hiv'] ?>
        </td>
      </tr>
    </tbody>
  </table>
</form>
