 <?php
  // lib/sfWidgetFormSchemaFormatterDefList.class.php
class sfWidgetFormSchemaFormatterDefList extends sfWidgetFormSchemaFormatter {
     protected
       $rowFormat                 = '<dt>%label%<dd>%error%%field%%help%%hidden_fields%</dd>',
       $helpFormat                = '<span class="help">%help%</span>',
       $errorRowFormat            = '<dt class="error">Errors:</dt><dd>%errors%</dd>',
       $errorListFormatInARow     = '<ul class="error_list">%errors%</ul>',
       $errorRowFormatInARow      = '<li>%error%</li>',
       $namedErrorRowFormatInARow = '<li>%name%: %error%</li>',
       $decoratorFormat           = '<dl id="formContainer">%content%</dl>';
       
   
   public function generateLabelName($name)
   {
     $auxName = parent::generateLabelName($name);
     sfContext::getInstance()->getConfiguration()->loadHelpers(array('I18N'));
     return __("form_".$auxName);
   }
}
