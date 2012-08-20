<?php slot('mdUserManagement',':D') ?>
<?php
use_helper('mdAsset');
use_plugin_javascript('mdUserDoctrinePlugin', 'mdUserManagement.js','last');

if( sfConfig::get( 'sf_plugins_user_media', false ) )
{
  include_partial('mdMediaContentAdmin/javascriptInclude');
}

if( sfConfig::get( 'sf_plugins_user_groups_permissions', false ) )
{
  use_plugin_javascript('mdUserGroupsAndPermissionDoctrinePlugin', 'mdUserGroupPermission.js','last');

}
use_javascript('tiny_mce/tiny_mce.js', 'last');
?>
<?php
    if( sfConfig::get('sf_plugins_user_relation_content_manage', false)){
        use_plugin_stylesheet('mdUserDoctrinePlugin', 'flexigrid/flexigrid.css');
        use_plugin_javascript('mdUserDoctrinePlugin', 'flexigrid.js', 'last');
        use_plugin_javascript('mdUserDoctrinePlugin', 'mdRelationContent.js', 'last');
    }
?>
<?php
include_component('backendBasic', 'backendTemplate', array(
    'module' => 'mdUserManagement',
    'objects' => $pager,
    'formFilter' => $formFilter
));
?>
<script type="text/javascript">
    
        mastodontePlugin.UI.BackendBasic.getInstance().setSortable(false);
    
</script>
