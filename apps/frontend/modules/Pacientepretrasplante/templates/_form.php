<?php use_stylesheets_for_form($form) ?>
<?php use_javascripts_for_form($form) ?>

<form action="<?php echo url_for('Pacientepretrasplante/'.($form->getObject()->isNew() ? 'create' : 'update').(!$form->getObject()->isNew() ? '?id='.$form->getObject()->getId() : '')) ?>" method="post" <?php $form->isMultipart() and print 'enctype="multipart/form-data" ' ?>>
<?php if (!$form->getObject()->isNew()): ?>
<input type="hidden" name="sf_method" value="put" />
<?php endif; ?>
  <table>
    <tfoot>
      <tr>
        <td colspan="2">
          <?php echo $form->renderHiddenFields(false) ?>
          &nbsp;<a href="<?php echo url_for('Pacientepretrasplante/index') ?>">Back to list</a>
          <?php if (!$form->getObject()->isNew()): ?>
            &nbsp;<?php echo link_to('Delete', 'Pacientepretrasplante/delete?id='.$form->getObject()->getId(), array('method' => 'delete', 'confirm' => 'Are you sure?')) ?>
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
        <th><?php echo $form['the']->renderLabel() ?></th>
        <td>
          <?php echo $form['the']->renderError() ?>
          <?php echo $form['the'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['fecha_ingreso_lista']->renderLabel() ?></th>
        <td>
          <?php echo $form['fecha_ingreso_lista']->renderError() ?>
          <?php echo $form['fecha_ingreso_lista'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['fecha_egreso']->renderLabel() ?></th>
        <td>
          <?php echo $form['fecha_egreso']->renderError() ?>
          <?php echo $form['fecha_egreso'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['modalidad_d']->renderLabel() ?></th>
        <td>
          <?php echo $form['modalidad_d']->renderError() ?>
          <?php echo $form['modalidad_d'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['diabetes']->renderLabel() ?></th>
        <td>
          <?php echo $form['diabetes']->renderError() ?>
          <?php echo $form['diabetes'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['imc']->renderLabel() ?></th>
        <td>
          <?php echo $form['imc']->renderError() ?>
          <?php echo $form['imc'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['origen']->renderLabel() ?></th>
        <td>
          <?php echo $form['origen']->renderError() ?>
          <?php echo $form['origen'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['pbr']->renderLabel() ?></th>
        <td>
          <?php echo $form['pbr']->renderError() ?>
          <?php echo $form['pbr'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['hta']->renderLabel() ?></th>
        <td>
          <?php echo $form['hta']->renderError() ?>
          <?php echo $form['hta'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['obesidad']->renderLabel() ?></th>
        <td>
          <?php echo $form['obesidad']->renderError() ?>
          <?php echo $form['obesidad'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['dislipemia']->renderLabel() ?></th>
        <td>
          <?php echo $form['dislipemia']->renderError() ?>
          <?php echo $form['dislipemia'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['tabaquismo']->renderLabel() ?></th>
        <td>
          <?php echo $form['tabaquismo']->renderError() ?>
          <?php echo $form['tabaquismo'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['iam']->renderLabel() ?></th>
        <td>
          <?php echo $form['iam']->renderError() ?>
          <?php echo $form['iam'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['ave']->renderLabel() ?></th>
        <td>
          <?php echo $form['ave']->renderError() ?>
          <?php echo $form['ave'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['revasc_cardio']->renderLabel() ?></th>
        <td>
          <?php echo $form['revasc_cardio']->renderError() ?>
          <?php echo $form['revasc_cardio'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['meses_en_lista']->renderLabel() ?></th>
        <td>
          <?php echo $form['meses_en_lista']->renderError() ?>
          <?php echo $form['meses_en_lista'] ?>
        </td>
      </tr>
    </tbody>
  </table>
</form>
