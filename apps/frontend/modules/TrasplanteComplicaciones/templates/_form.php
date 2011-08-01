<?php use_stylesheets_for_form($form) ?>
<?php use_javascripts_for_form($form) ?>

<form action="<?php echo url_for('TrasplanteComplicaciones/'.($form->getObject()->isNew() ? 'create' : 'update').(!$form->getObject()->isNew() ? '?id='.$form->getObject()->getId() : '')) ?>" method="post" <?php $form->isMultipart() and print 'enctype="multipart/form-data" ' ?>>
<?php if (!$form->getObject()->isNew()): ?>
<input type="hidden" name="sf_method" value="put" />
<?php endif; ?>
  <table>
    <tfoot>
      <tr>
        <td colspan="2">
          <?php echo $form->renderHiddenFields(false) ?>
          &nbsp;<a href="<?php echo url_for('TrasplanteComplicaciones/index') ?>">Back to list</a>
          <?php if (!$form->getObject()->isNew()): ?>
            &nbsp;<?php echo link_to('Delete', 'TrasplanteComplicaciones/delete?id='.$form->getObject()->getId(), array('method' => 'delete', 'confirm' => 'Are you sure?')) ?>
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
        <th><?php echo $form['medicacion_id']->renderLabel() ?></th>
        <td>
          <?php echo $form['medicacion_id']->renderError() ?>
          <?php echo $form['medicacion_id'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['internado']->renderLabel() ?></th>
        <td>
          <?php echo $form['internado']->renderError() ?>
          <?php echo $form['internado'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['dias_de_internacion']->renderLabel() ?></th>
        <td>
          <?php echo $form['dias_de_internacion']->renderError() ?>
          <?php echo $form['dias_de_internacion'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['evolucion']->renderLabel() ?></th>
        <td>
          <?php echo $form['evolucion']->renderError() ?>
          <?php echo $form['evolucion'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['comentario']->renderLabel() ?></th>
        <td>
          <?php echo $form['comentario']->renderError() ?>
          <?php echo $form['comentario'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['infecciosa']->renderLabel() ?></th>
        <td>
          <?php echo $form['infecciosa']->renderError() ?>
          <?php echo $form['infecciosa'] ?>
        </td>
      </tr>
    </tbody>
  </table>
</form>
