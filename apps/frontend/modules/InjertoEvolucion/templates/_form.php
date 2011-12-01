<?php use_stylesheets_for_form($form) ?>
<?php use_javascripts_for_form($form) ?>

<form action="<?php echo url_for('InjertoEvolucion/'.($form->getObject()->isNew() ? 'create' : 'update').(!$form->getObject()->isNew() ? '?id='.$form->getObject()->getId() : '')) ?>" method="post" <?php $form->isMultipart() and print 'enctype="multipart/form-data" ' ?>>
<?php if (!$form->getObject()->isNew()): ?>
<input type="hidden" name="sf_method" value="put" />
<?php endif; ?>
  <table>
    <tfoot>
      <tr>
        <td colspan="2">
          <?php echo $form->renderHiddenFields(false) ?>
          &nbsp;<a href="<?php echo url_for('InjertoEvolucion/index') ?>">Back to list</a>
          <?php if (!$form->getObject()->isNew()): ?>
            &nbsp;<?php echo link_to('Delete', 'InjertoEvolucion/delete?id='.$form->getObject()->getId(), array('method' => 'delete', 'confirm' => 'Are you sure?')) ?>
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
        <th><?php echo $form['injerto_evolucion_pbrs_list']->renderLabel() ?></th>
        <td>
          <?php echo $form['injerto_evolucion_pbrs_list']->renderError() ?>
          <?php echo $form['injerto_evolucion_pbrs_list'] ?>
        </td>
      </tr> 
      <tr>
        <th><?php echo $form['ra_tratamiento_id']->renderLabel() ?></th>
        <td>
          <?php echo $form['ra_tratamiento_id']->renderError() ?>
          <?php echo $form['ra_tratamiento_id'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['tm_cual']->renderLabel() ?></th>
        <td>
          <?php echo $form['tm_cual']->renderError() ?>
          <?php echo $form['tm_cual'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['tm']->renderLabel() ?></th>
        <td>
          <?php echo $form['tm']->renderError() ?>
          <?php echo $form['tm'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['gp_de_novo']->renderLabel() ?></th>
        <td>
          <?php echo $form['gp_de_novo']->renderError() ?>
          <?php echo $form['gp_de_novo'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['recidiva_gp_de_novo']->renderLabel() ?></th>
        <td>
          <?php echo $form['recidiva_gp_de_novo']->renderError() ?>
          <?php echo $form['recidiva_gp_de_novo'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['ra']->renderLabel() ?></th>
        <td>
          <?php echo $form['ra']->renderError() ?>
          <?php echo $form['ra'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['rc']->renderLabel() ?></th>
        <td>
          <?php echo $form['rc']->renderError() ?>
          <?php echo $form['rc'] ?>
        </td>
      </tr>
      
      <tr>
        <th><?php echo $form['en_trasplante']->renderLabel() ?></th>
        <td>
          <?php echo $form['en_trasplante']->renderError() ?>
          <?php echo $form['en_trasplante'] ?>
        </td>
      </tr>
           
    </tbody>
  </table>
</form>
