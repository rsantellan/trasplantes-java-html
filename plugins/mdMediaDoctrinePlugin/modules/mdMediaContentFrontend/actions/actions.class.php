<?php

/**
 * mdMediaContentAdmin actions.
 *
 * @package    plugins
 * @subpackage mdMediaDoctrinePlugin
 * @author     Your name here
 * @version    SVN: $Id: actions.class.php 23810 2009-11-12 11:07:44Z Kris.Wallsmith $
 */
class mdMediaContentFrontendActions extends sfActions
{
    /**
     * Executes index action
     *
     * @param sfRequest $request A request object
     */
    public function executeIndex(sfWebRequest $request)
    {
        $this->forward('default', 'module');
    }


    public function executeChangeDefault(sfWebRequest $request)
    {
        if(!$this->getUser()->isAuthenticated())
        {
            return $this->renderText(mdBasicFunction::basic_json_response(false, array("message" => "Permission denied")));
        }
        $albumId = 0;
        try
        {
            $mdUserProfile = $this->getUser()->getProfile();
            mdMediaManager::$LOAD_ON_DEMAND_CONTENT = true;
            $instance = mdMediaManager::getInstance(mdMediaManager::IMAGES, $mdUserProfile)->load(mdMedia::$default);
            $albumId = $instance->getId();

        } catch(Exception $e){

            return $this->renderText(mdBasicFunction::basic_json_response(false, array("message" => $e->getMessage())));

        }

        $album = Doctrine::getTable('mdMediaAlbum')->find($albumId);
        $image = Doctrine::getTable("mdMediaImage")->find($request->getParameter('idImagen'));
        $album->addContent($image);
        $mediaContent = $image->retrieveMdMediaContent();
        $album->changeAvatar($mediaContent->getId());
        return $this->renderText(mdBasicFunction::basic_json_response(true, array()));
    }

    public function executeChangeAlbumDefault(sfWebRequest $request)
    {
        if(!$this->getUser()->isAuthenticated())
        {
            return $this->renderText(mdBasicFunction::basic_json_response(false, array("message" => "Permission denied")));
        }
        
        $albumId = $request->getParameter('idAlbum', -1);

        if($albumId == -1)
        {
            try
            {
                $mdUserProfile = $this->getUser()->getProfile();
                mdMediaManager::$LOAD_ON_DEMAND_CONTENT = true;
                $instance = mdMediaManager::getInstance(mdMediaManager::IMAGES, $mdUserProfile)->load(mdMedia::$default);
                $albumId = $instance->getId();

            } catch(Exception $e){

                return $this->renderText(mdBasicFunction::basic_json_response(false, array("message" => $e->getMessage())));

            }
        }

        $album = Doctrine::getTable('mdMediaAlbum')->find($albumId);
        $image = Doctrine::getTable("mdMediaImage")->find($request->getParameter('idImagen'));
        $mediaContent = $image->retrieveMdMediaContent();
        $album->changeAvatar($mediaContent->getId());
        return $this->renderText(mdBasicFunction::basic_json_response(true, array()));
    }

}
