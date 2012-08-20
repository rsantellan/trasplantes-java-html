<?php
define('DIR_SLASH', DIRECTORY_SEPARATOR);

/**
 * Stores all the required/useful information of a given image in an array
 * and provides accessor methods to that data.
 *
 * @author Gaston Caldeiro
 * @access public
 *
 */
class mdImageFile {
    /**
     * Used to store and retrieve all the image info.
     *
     * @var array stores all the image info
     * @access private
     */
    private $imageInfo      = array();

    /**
     * Stores the supported image formats.
     *
     * @var array image formats
     * @access private
     */
    private $supportedTypes = array(1 => 'gif', 'jpg', 'png');

    /**
     * Constructor.  Uses getimagesize() output as initial data.
     *
     * @param string $image full path of an image
     * @return void
     * @access public
     */
    public function  __construct($image) {
        $size                             = getimagesize($image);
        $stat                             = stat($image);
        $this->imageInfo['last_modification'] = $stat['mtime'];
        $this->imageInfo['width']         = $size[0];
        $this->imageInfo['height']        = $size[1];
        $this->imageInfo['type']          = $size[2];
        $this->imageInfo['mime']          = $size['mime'];
        $this->imageInfo['route']         = $image;
        $this->imageInfo['original_name'] = basename($image);
    }

    /**
     * Checks if image is of a supported format.
     *
     * @param void
     * @return void
     */
    public function validImage() {
        if (array_key_exists($this->imageInfo['type'], $this->supportedTypes)) {
            $this->imageInfo['ext']  = $this->supportedTypes[$this->imageInfo['type']];
            //$this->useNiceName();
            return true;
        }
        return false;
    }

    /**
     * Returns the last modification of file
     * @return <Unix timestamp>
     */
    public function getLastModification(){
        return $this->imageInfo['last_modification'];
    }

    /**
     * Returns the format of the image like GIF, JPG or PNG as an integer.
     *
     * @param void
     * @return string image format
     */
    public function getType() {
        return $this->imageInfo['type'];
    }

    /**
     * Returns the image extension.
     *
     * @param void
     * @return string image extension
     */
    public function getExtension() {
        return $this->imageInfo['ext'];
    }

    /**
     * Returns the image width.
     *
     * @param void
     * @return int image width
     */
    public function getWidth() {
        return $this->imageInfo['width'];
    }

    /**
     * Returns the image height.
     *
     * @param void
     * @return int image height
     */
    public function getHeight() {
        return $this->imageInfo['height'];
    }

    /**
     * Returns the image name after being converted to a nice version.
     *
     * @param void
     * @return string nice image filename
     */
    public function getName() {
        return $this->imageInfo['original_name'];
    }

    /**
     * Returns the image path
     *
     * @param void
     * @return string nice image filename
     */
    public function getRoute() {
        return $this->imageInfo['route'];
    }

    public function getRouteWithOutPath($path = null){
        if($path === null) $path = sfConfig::get('sf_upload_dir');
        return str_replace(array($path, "/"), array("", DIR_SLASH), $this->getRoute());
    }

    public function getPath(){
        return str_replace($this->getName(), '', $this->getRoute());
    }

}

/*
$path = __FILE__;

$name = 'logo_de_ubuntu.jpg';

//.echo $path;

$image = '/home/chugas/NetBeansProjects/images/pics/robot.jpg';

$imageInfo = new MdImageInfo($image);

//print_r($imageInfo);

echo '<br /><br />' . $imageInfo->customName('-image') . ' - ' . $imageInfo->height() . ' - ' . $imageInfo->width() . ' - ' . $imageInfo->extension() . ' - ' . $imageInfo->type() . ' - ' . $imageInfo->tempName();
*/