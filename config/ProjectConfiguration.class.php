<?php

require_once dirname(__FILE__).'/../lib/vendor/symfony/lib/autoload/sfCoreAutoload.class.php';
sfCoreAutoload::register();

class ProjectConfiguration extends sfProjectConfiguration
{
  public function setup()
  {
    $this->enablePlugins('sfDoctrinePlugin');
    $this->enablePlugins('mastodontePlugin');
    $this->enablePlugins('mdAuthDoctrinePlugin');
    $this->enablePlugins('mdMediaDoctrinePlugin');
    $this->enablePlugins('mdContactPlugin');
    $this->enablePlugins('mdMediaManagerPlugin');
    $this->enablePlugins('mdUserDoctrinePlugin');
    $this->enablePlugins('mdBulkImportExportPlugin');
	$this->enablePlugins('mdTranslatorPlugin');
  }
}
