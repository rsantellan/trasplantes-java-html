<?php use_stylesheets_for_form($form) ?>
<?php use_javascripts_for_form($form) ?>

<form action="<?php echo url_for('EvolucionTrasplanteEcodopler/'.($form->getObject()->isNew() ? 'create' : 'update').(!$form->getObject()->isNew() ? '?id='.$form->getObject()->getId() : '')) ?>" method="post" <?php $form->isMultipart() and print 'enctype="multipart/form-data" ' ?>>
<?php if (!$form->getObject()->isNew()): ?>
<input type="hidden" name="sf_method" value="put" />
<?php endif; ?>
  <table>
    <tfoot>
      <tr>
        <td colspan="2">
          <?php echo $form->renderHiddenFields(false) ?>
          &nbsp;<a href="<?php echo url_for('EvolucionTrasplanteEcodopler/index') ?>">Back to list</a>
          <?php if (!$form->getObject()->isNew()): ?>
            &nbsp;<?php echo link_to('Delete', 'EvolucionTrasplanteEcodopler/delete?id='.$form->getObject()->getId(), array('method' => 'delete', 'confirm' => 'Are you sure?')) ?>
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
        <th><?php echo $form['estructura']->renderLabel() ?></th>
        <td>
          <?php echo $form['estructura']->renderError() ?>
          <?php echo $form['estructura'] ?>
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
        <th><?php echo $form['colecciones']->renderLabel() ?></th>
        <td>
          <?php echo $form['colecciones']->renderError() ?>
          <?php echo $form['colecciones'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['eje_arterial']->renderLabel() ?></th>
        <td>
          <?php echo $form['eje_arterial']->renderError() ?>
          <?php echo $form['eje_arterial'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['eje_venoso']->renderLabel() ?></th>
        <td>
          <?php echo $form['eje_venoso']->renderError() ?>
          <?php echo $form['eje_venoso'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['arteria_renal']->renderLabel() ?></th>
        <td>
          <?php echo $form['arteria_renal']->renderError() ?>
          <?php echo $form['arteria_renal'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['vena_renal']->renderLabel() ?></th>
        <td>
          <?php echo $form['vena_renal']->renderError() ?>
          <?php echo $form['vena_renal'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['anast_venosa']->renderLabel() ?></th>
        <td>
          <?php echo $form['anast_venosa']->renderError() ?>
          <?php echo $form['anast_venosa'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['anast_renosa']->renderLabel() ?></th>
        <td>
          <?php echo $form['anast_renosa']->renderError() ?>
          <?php echo $form['anast_renosa'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['indice']->renderLabel() ?></th>
        <td>
          <?php echo $form['indice']->renderError() ?>
          <?php echo $form['indice'] ?>
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
