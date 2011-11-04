<?php use_stylesheets_for_form($form) ?>
<?php use_javascripts_for_form($form) ?>

<form action="<?php echo url_for('EvolucionTrasplanteNutricion/'.($form->getObject()->isNew() ? 'create' : 'update').(!$form->getObject()->isNew() ? '?id='.$form->getObject()->getId() : '')) ?>" method="post" <?php $form->isMultipart() and print 'enctype="multipart/form-data" ' ?>>
<?php if (!$form->getObject()->isNew()): ?>
<input type="hidden" name="sf_method" value="put" />
<?php endif; ?>
  <table>
    <tfoot>
      <tr>
        <td colspan="2">
          <?php echo $form->renderHiddenFields(false) ?>
          &nbsp;<a href="<?php echo url_for('EvolucionTrasplanteNutricion/index') ?>">Back to list</a>
          <?php if (!$form->getObject()->isNew()): ?>
            &nbsp;<?php echo link_to('Delete', 'EvolucionTrasplanteNutricion/delete?id='.$form->getObject()->getId(), array('method' => 'delete', 'confirm' => 'Are you sure?')) ?>
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
        <th><?php echo $form['talla']->renderLabel() ?></th>
        <td>
          <?php echo $form['talla']->renderError() ?>
          <?php echo $form['talla'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['peso_deseado']->renderLabel() ?></th>
        <td>
          <?php echo $form['peso_deseado']->renderError() ?>
          <?php echo $form['peso_deseado'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['estructura_osea']->renderLabel() ?></th>
        <td>
          <?php echo $form['estructura_osea']->renderError() ?>
          <?php echo $form['estructura_osea'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['impresion']->renderLabel() ?></th>
        <td>
          <?php echo $form['impresion']->renderError() ?>
          <?php echo $form['impresion'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['peso_real']->renderLabel() ?></th>
        <td>
          <?php echo $form['peso_real']->renderError() ?>
          <?php echo $form['peso_real'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['p_tricipital']->renderLabel() ?></th>
        <td>
          <?php echo $form['p_tricipital']->renderError() ?>
          <?php echo $form['p_tricipital'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['p_tricipital_p']->renderLabel() ?></th>
        <td>
          <?php echo $form['p_tricipital_p']->renderError() ?>
          <?php echo $form['p_tricipital_p'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['p_subescapular']->renderLabel() ?></th>
        <td>
          <?php echo $form['p_subescapular']->renderError() ?>
          <?php echo $form['p_subescapular'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['p_subescapular_p']->renderLabel() ?></th>
        <td>
          <?php echo $form['p_subescapular_p']->renderError() ?>
          <?php echo $form['p_subescapular_p'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['sum_pliegues']->renderLabel() ?></th>
        <td>
          <?php echo $form['sum_pliegues']->renderError() ?>
          <?php echo $form['sum_pliegues'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['p_sum_pliegues']->renderLabel() ?></th>
        <td>
          <?php echo $form['p_sum_pliegues']->renderError() ?>
          <?php echo $form['p_sum_pliegues'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['cf_brazo']->renderLabel() ?></th>
        <td>
          <?php echo $form['cf_brazo']->renderError() ?>
          <?php echo $form['cf_brazo'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['p_cf_brazo']->renderLabel() ?></th>
        <td>
          <?php echo $form['p_cf_brazo']->renderError() ?>
          <?php echo $form['p_cf_brazo'] ?>
        </td>
      </tr>
      
      <tr>
        <th><?php echo $form['cf_musc_brazo']->renderLabel() ?></th>
        <td>
          <?php echo $form['cf_musc_brazo']->renderError() ?>
          <?php echo $form['cf_musc_brazo'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['p_cf_musc_brazo']->renderLabel() ?></th>
        <td>
          <?php echo $form['p_cf_musc_brazo']->renderError() ?>
          <?php echo $form['p_cf_musc_brazo'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['area_brazo']->renderLabel() ?></th>
        <td>
          <?php echo $form['area_brazo']->renderError() ?>
          <?php echo $form['area_brazo'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['area_musc_brazo']->renderLabel() ?></th>
        <td>
          <?php echo $form['area_musc_brazo']->renderError() ?>
          <?php echo $form['area_musc_brazo'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['p_area_musc_brazo']->renderLabel() ?></th>
        <td>
          <?php echo $form['p_area_musc_brazo']->renderError() ?>
          <?php echo $form['p_area_musc_brazo'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['area_grasa_brazo']->renderLabel() ?></th>
        <td>
          <?php echo $form['area_grasa_brazo']->renderError() ?>
          <?php echo $form['area_grasa_brazo'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['p_area_grasa_brazo']->renderLabel() ?></th>
        <td>
          <?php echo $form['p_area_grasa_brazo']->renderError() ?>
          <?php echo $form['p_area_grasa_brazo'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['r_cintura_cadera']->renderLabel() ?></th>
        <td>
          <?php echo $form['r_cintura_cadera']->renderError() ?>
          <?php echo $form['r_cintura_cadera'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['diag_nutricional']->renderLabel() ?></th>
        <td>
          <?php echo $form['diag_nutricional']->renderError() ?>
          <?php echo $form['diag_nutricional'] ?>
        </td>
      </tr>
    </tbody>
  </table>
</form>
