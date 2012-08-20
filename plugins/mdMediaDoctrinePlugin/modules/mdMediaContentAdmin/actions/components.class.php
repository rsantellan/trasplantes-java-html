<?php
class mdMediaContentAdminComponents extends sfComponents {

    public function executeShowAlbums(sfWebRequest $request)
    {
        mdMediaManager::$LOAD_ON_DEMAND_CONTENT = true;
        $this->manager = mdMediaManager::getInstance(mdMediaManager::ALL, $this->object)->load();

        try{
            $this->album_title = $this->manager->getTitle();
        } catch(Exception $e){
            $this->album_title = null;
        }

    }

}
