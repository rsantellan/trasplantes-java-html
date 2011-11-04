<?php use_stylesheets_for_form($form) ?>
<?php use_javascripts_for_form($form) ?>

<form action="<?php echo url_for('EvolucionTrasplanteParaclinica/'.($form->getObject()->isNew() ? 'create' : 'update').(!$form->getObject()->isNew() ? '?id='.$form->getObject()->getId() : '')) ?>" method="post" <?php $form->isMultipart() and print 'enctype="multipart/form-data" ' ?>>
<?php if (!$form->getObject()->isNew()): ?>
<input type="hidden" name="sf_method" value="put" />
<?php endif; ?>
  <table>
    <tfoot>
      <tr>
        <td colspan="2">
          <?php echo $form->renderHiddenFields(false) ?>
          &nbsp;<a href="<?php echo url_for('EvolucionTrasplanteParaclinica/index') ?>">Back to list</a>
          <?php if (!$form->getObject()->isNew()): ?>
            &nbsp;<?php echo link_to('Delete', 'EvolucionTrasplanteParaclinica/delete?id='.$form->getObject()->getId(), array('method' => 'delete', 'confirm' => 'Are you sure?')) ?>
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
        <th><?php echo $form['pas']->renderLabel() ?></th>
        <td>
          <?php echo $form['pas']->renderError() ?>
          <?php echo $form['pas'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['pad']->renderLabel() ?></th>
        <td>
          <?php echo $form['pad']->renderError() ?>
          <?php echo $form['pad'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['diuresis']->renderLabel() ?></th>
        <td>
          <?php echo $form['diuresis']->renderError() ?>
          <?php echo $form['diuresis'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['peso']->renderLabel() ?></th>
        <td>
          <?php echo $form['peso']->renderError() ?>
          <?php echo $form['peso'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['urea']->renderLabel() ?></th>
        <td>
          <?php echo $form['urea']->renderError() ?>
          <?php echo $form['urea'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['creatinina']->renderLabel() ?></th>
        <td>
          <?php echo $form['creatinina']->renderError() ?>
          <?php echo $form['creatinina'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['ht']->renderLabel() ?></th>
        <td>
          <?php echo $form['ht']->renderError() ?>
          <?php echo $form['ht'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['hb']->renderLabel() ?></th>
        <td>
          <?php echo $form['hb']->renderError() ?>
          <?php echo $form['hb'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['gb']->renderLabel() ?></th>
        <td>
          <?php echo $form['gb']->renderError() ?>
          <?php echo $form['gb'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['plaquetas']->renderLabel() ?></th>
        <td>
          <?php echo $form['plaquetas']->renderError() ?>
          <?php echo $form['plaquetas'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['sodio']->renderLabel() ?></th>
        <td>
          <?php echo $form['sodio']->renderError() ?>
          <?php echo $form['sodio'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['potasio']->renderLabel() ?></th>
        <td>
          <?php echo $form['potasio']->renderError() ?>
          <?php echo $form['potasio'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['cloro']->renderLabel() ?></th>
        <td>
          <?php echo $form['cloro']->renderError() ?>
          <?php echo $form['cloro'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['calcio']->renderLabel() ?></th>
        <td>
          <?php echo $form['calcio']->renderError() ?>
          <?php echo $form['calcio'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['fosforo']->renderLabel() ?></th>
        <td>
          <?php echo $form['fosforo']->renderError() ?>
          <?php echo $form['fosforo'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['glicemia']->renderLabel() ?></th>
        <td>
          <?php echo $form['glicemia']->renderError() ?>
          <?php echo $form['glicemia'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['uricemia']->renderLabel() ?></th>
        <td>
          <?php echo $form['uricemia']->renderError() ?>
          <?php echo $form['uricemia'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['prot_u']->renderLabel() ?></th>
        <td>
          <?php echo $form['prot_u']->renderError() ?>
          <?php echo $form['prot_u'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['ccreatinina']->renderLabel() ?></th>
        <td>
          <?php echo $form['ccreatinina']->renderError() ?>
          <?php echo $form['ccreatinina'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['curea']->renderLabel() ?></th>
        <td>
          <?php echo $form['curea']->renderError() ?>
          <?php echo $form['curea'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['na_u']->renderLabel() ?></th>
        <td>
          <?php echo $form['na_u']->renderError() ?>
          <?php echo $form['na_u'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['ku']->renderLabel() ?></th>
        <td>
          <?php echo $form['ku']->renderError() ?>
          <?php echo $form['ku'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['cya_pv']->renderLabel() ?></th>
        <td>
          <?php echo $form['cya_pv']->renderError() ?>
          <?php echo $form['cya_pv'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['cya_pp']->renderLabel() ?></th>
        <td>
          <?php echo $form['cya_pp']->renderError() ?>
          <?php echo $form['cya_pp'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['fk_p']->renderLabel() ?></th>
        <td>
          <?php echo $form['fk_p']->renderError() ?>
          <?php echo $form['fk_p'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['mfm_p']->renderLabel() ?></th>
        <td>
          <?php echo $form['mfm_p']->renderError() ?>
          <?php echo $form['mfm_p'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['eve_p']->renderLabel() ?></th>
        <td>
          <?php echo $form['eve_p']->renderError() ?>
          <?php echo $form['eve_p'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['bd']->renderLabel() ?></th>
        <td>
          <?php echo $form['bd']->renderError() ?>
          <?php echo $form['bd'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['bi']->renderLabel() ?></th>
        <td>
          <?php echo $form['bi']->renderError() ?>
          <?php echo $form['bi'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['tgo']->renderLabel() ?></th>
        <td>
          <?php echo $form['tgo']->renderError() ?>
          <?php echo $form['tgo'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['tgp']->renderLabel() ?></th>
        <td>
          <?php echo $form['tgp']->renderError() ?>
          <?php echo $form['tgp'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['gammagt']->renderLabel() ?></th>
        <td>
          <?php echo $form['gammagt']->renderError() ?>
          <?php echo $form['gammagt'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['f_alc']->renderLabel() ?></th>
        <td>
          <?php echo $form['f_alc']->renderError() ?>
          <?php echo $form['f_alc'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['t_prot']->renderLabel() ?></th>
        <td>
          <?php echo $form['t_prot']->renderError() ?>
          <?php echo $form['t_prot'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['kptt']->renderLabel() ?></th>
        <td>
          <?php echo $form['kptt']->renderError() ?>
          <?php echo $form['kptt'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['howell']->renderLabel() ?></th>
        <td>
          <?php echo $form['howell']->renderError() ?>
          <?php echo $form['howell'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['fibrinogeno']->renderLabel() ?></th>
        <td>
          <?php echo $form['fibrinogeno']->renderError() ?>
          <?php echo $form['fibrinogeno'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['colesterol']->renderLabel() ?></th>
        <td>
          <?php echo $form['colesterol']->renderError() ?>
          <?php echo $form['colesterol'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['hdl']->renderLabel() ?></th>
        <td>
          <?php echo $form['hdl']->renderError() ?>
          <?php echo $form['hdl'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['ldl']->renderLabel() ?></th>
        <td>
          <?php echo $form['ldl']->renderError() ?>
          <?php echo $form['ldl'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['r_at']->renderLabel() ?></th>
        <td>
          <?php echo $form['r_at']->renderError() ?>
          <?php echo $form['r_at'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['tg']->renderLabel() ?></th>
        <td>
          <?php echo $form['tg']->renderError() ?>
          <?php echo $form['tg'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['hna1c']->renderLabel() ?></th>
        <td>
          <?php echo $form['hna1c']->renderError() ?>
          <?php echo $form['hna1c'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['albumina']->renderLabel() ?></th>
        <td>
          <?php echo $form['albumina']->renderError() ?>
          <?php echo $form['albumina'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['globulinas']->renderLabel() ?></th>
        <td>
          <?php echo $form['globulinas']->renderError() ?>
          <?php echo $form['globulinas'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['pthi']->renderLabel() ?></th>
        <td>
          <?php echo $form['pthi']->renderError() ?>
          <?php echo $form['pthi'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['otros']->renderLabel() ?></th>
        <td>
          <?php echo $form['otros']->renderError() ?>
          <?php echo $form['otros'] ?>
        </td>
      </tr>
      <tr>
        <th><?php echo $form['numpthi']->renderLabel() ?></th>
        <td>
          <?php echo $form['numpthi']->renderError() ?>
          <?php echo $form['numpthi'] ?>
        </td>
      </tr>
    </tbody>
  </table>
</form>
