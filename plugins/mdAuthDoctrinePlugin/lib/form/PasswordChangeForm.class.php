<?php

/**
 * mdUser form.
 *
 * @package    mdBasicPlugin
 * @subpackage form
 * @author     Your name here
 * @version    0.2
 * @author Rodrigo Santellan
 */
class PasswordChangeForm extends sfForm {

    public function configure() {
        $this->setWidgets(
                array(
                    'password' => new sfWidgetFormInputPassword ( )
                )
        );

        $this->setValidators(
                array(
                    'password' => new sfValidatorPass(
                            array(
                                'required' => true
                            )
                    )
                )
        );

        $this->widgetSchema ['password_confirmation'] = new sfWidgetFormInputPassword ( );
        $this->validatorSchema ['password_confirmation'] = clone $this->validatorSchema ['password'];

        $this->widgetSchema->moveField('password_confirmation', 'after', 'password');

        $this->mergePostValidator(new sfValidatorSchemaCompare('password', sfValidatorSchemaCompare::EQUAL, 'password_confirmation', array(), array('invalid' => 'The two passwords must be the same.')));

        $this->widgetSchema->setNameFormat('md_change_password[%s]');

        $this->errorSchema = new sfValidatorErrorSchema($this->validatorSchema);
    }

}
