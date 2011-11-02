<?php use_stylesheets_for_form($form) ?>
<?php use_javascripts_for_form($form) ?>

<form action="<?php echo url_for('EvolucionTrasplanteEcoCardio/'.($form->getObject()->isNew() ? 'create' : 'update').(!$form->getObject()->isNew() ? '?id='.$form->getObject()->getId() : '')) ?>" method="post" <?php $form->isMultipart() and print 'enctype="multipart/form-data" ' ?>>
<?php if (!$form->getObject()->isNew()): ?>
<input type="hidden" name="sf_method" value="put" />
<?php endif; ?>
  <table>
    <tfoot>
      <tr>
        <td colspan="2">
          <?php echo $form->renderHiddenFields(false) ?>
          &nbsp;<a href="<?php echo url_for('EvolucionTrasplanteEcoCardio/index') ?>">Back to list</a>
          <?php if (!$form->getObject()->isNew()): ?>
            &nbsp;<?php echo link_to('Delete', 'EvolucionTrasplanteEcoCardio/delete?id='.$form->getObject()->getId(), array('method' => 'delete', 'confirm' => 'Are you sure?')) ?>
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
        <th><?php echo $form['fevi_normal']->renderLabel() ?></th>
        <td>
          <?php echo $form['fevi_normal']->renderError() ?>
          <?php echo $form['fevi_normal'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['insuf_hipodiast']->renderLabel() ?></th>
        <td>
          <?php echo $form['insuf_hipodiast']->renderError() ?>
          <?php echo $form['insuf_hipodiast'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['iao']->renderLabel() ?></th>
        <td>
          <?php echo $form['iao']->renderError() ?>
          <?php echo $form['iao'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['eao']->renderLabel() ?></th>
        <td>
          <?php echo $form['eao']->renderError() ?>
          <?php echo $form['eao'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['im']->renderLabel() ?></th>
        <td>
          <?php echo $form['im']->renderError() ?>
          <?php echo $form['im'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['em']->renderLabel() ?></th>
        <td>
          <?php echo $form['em']->renderError() ?>
          <?php echo $form['em'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['ip']->renderLabel() ?></th>
        <td>
          <?php echo $form['ip']->renderError() ?>
          <?php echo $form['ip'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['ep']->renderLabel() ?></th>
        <td>
          <?php echo $form['ep']->renderError() ?>
          <?php echo $form['ep'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['it']->renderLabel() ?></th>
        <td>
          <?php echo $form['it']->renderError() ?>
          <?php echo $form['it'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['et']->renderLabel() ?></th>
        <td>
          <?php echo $form['et']->renderError() ?>
          <?php echo $form['et'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['derrame']->renderLabel() ?></th>
        <td>
          <?php echo $form['derrame']->renderError() ?>
          <?php echo $form['derrame'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['calcif_valvular']->renderLabel() ?></th>
        <td>
          <?php echo $form['calcif_valvular']->renderError() ?>
          <?php echo $form['calcif_valvular'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['hvi']->renderLabel() ?></th>
        <td>
          <?php echo $form['hvi']->renderError() ?>
          <?php echo $form['hvi'] ?>
        </td>
      </tr>
    </tbody>
  </table>
</form>
