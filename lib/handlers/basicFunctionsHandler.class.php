<?php

class basicFunction 
{

    /**
     * Calcula la diferencia de anios entre dos fechas dadas como strings. 
     * El string tiene que tener el siguiente formato yyyy-mm-dd o yyyy/mm/dd
     * @param String $string
     */
    public static function calculateDifferenceInYears($startDate, $endDate)
    {
      $startDate = new DateTime($startDate);
      $endDate = new DateTime($endDate);
      $interval = $startDate->diff($endDate);
      return $interval->y;
      
      $anno_inicio =substr($startDate, 0, 4);
      $mes_inicio =substr($startDate, 5, 2);
      $dia_inicio = substr($startDate, 8, 2);      

      $anno_fin =substr($endDate, 0, 4);
      $mes_fin =substr($endDate, 5, 2);
      $dia_fin = substr($endDate, 8, 2);
      
      if($mes_inicio>$mes_fin){
          $calc_edad= $anno_fin-$anno_inicio-1;
      }else{
          if($mes_fin==$mes_inicio AND $dia_inicio>$dia_fin){
              $calc_edad= $anno_fin-$anno_inicio-1;
          }else{
              $calc_edad= $anno_fin-$anno_inicio;
          }
      }
      return $calc_edad;      
    }
  
    public static function calculateDifferenceInDays($startDate, $endDate)
    {
      $startDate = new DateTime($startDate);
      $endDate = new DateTime($endDate);
      $interval = $startDate->diff($endDate);
      return $interval->days;
    }
    
    public static function calculateDifferenceInMonth($startDate, $endDate)
    {
      
      $years = self::calculateDifferenceInYears($startDate, $endDate);
      $startDate = new DateTime($startDate);
      $endDate = new DateTime($endDate);
      $interval = $startDate->diff($endDate);
      return $interval->m + ((int)$years * 12);
      
      
      $anno_inicio =substr($startDate, 0, 4);
      $mes_inicio =substr($startDate, 5, 2);
      $dia_inicio = substr($startDate, 8, 2);      

      $anno_fin =substr($endDate, 0, 4);
      $mes_fin =substr($endDate, 5, 2);
      $dia_fin = substr($endDate, 8, 2);
      
      if($anno_inicio > $anno_fin)
      {
        return false;
      }
      
      if($anno_inicio == $anno_fin && $mes_inicio > $mes_fin)
      {
        return false;
      }

      if($anno_inicio == $anno_fin && $mes_inicio == $mes_fin && $dia_inicio > $dia_fin)
      {
        return false;
      }
      $months = 0;
      if($mes_inicio>$mes_fin){
          $calc_edad= $anno_fin-$anno_inicio-1;
      }else{
          if($mes_fin==$mes_inicio AND $dia_inicio>$dia_fin){
              $calc_edad= $anno_fin-$anno_inicio-1;
          }else{
              $calc_edad= $anno_fin-$anno_inicio;
          }
      }
      if($dia_inicio>$dia_fin)
      {
        $months++;
      }
      $months = $months + self::calculateDifferenceBetweenMonth($mes_inicio, $mes_fin);
      $months = $months + ($calc_edad * 12);
      return $months;
    }
  
    public static function calculateDifferenceBetweenMonth($mes_inicio, $mes_fin, $difference = 0)
    {
      if($mes_inicio == $mes_fin)
      {
        return $difference;
      }
      $mes_inicio++;
      if($mes_inicio == 13)
      {
        $mes_inicio = 1;
      }
      $difference++;
      return self::calculateDifferenceBetweenMonth($mes_inicio, $mes_fin, $difference);
    }

    /**
     * Calcula la edad dado un string.
     * El string tiene que tener el siguiente formato dd-mm-yyyy o dd/mm/yyyy
     * @param String $string
     */
    public static function calculateAge($string, $inverso = true)
    {
        $dia=date("j");
        $mes=date("n");
        $anno=date("Y");
        //fecha_nac ="1973/06/01";
        if($inverso)
        {
            $anno_nac=substr($string, 0, 4);
            $mes_nac=substr($string, 5, 2);
            $dia_nac=substr($string, 8, 2);
        }
        else
        {
            $dia_nac=substr($string, 0, 2);
            $mes_nac=substr($string, 3, 2);
            $anno_nac=substr($string, 6, 4);
        }

        if($mes_nac>$mes){
            $calc_edad= $anno-$anno_nac-1;
        }else{
            if($mes==$mes_nac AND $dia_nac>$dia){
                $calc_edad= $anno-$anno_nac-1;
            }else{
                $calc_edad= $anno-$anno_nac;
            }
        }
        return $calc_edad;

    }
    
    public static function retrieveFilesArrayOfDirectory($path)
    {
      $salida = array();
      $path = MdFileHandler::checkPathFormat($path);
      if (is_dir($path)) 
      {
        if ($dh = opendir($path)) 
        {
          while (($file = readdir($dh)) !== false) 
          {
            if (is_dir($path . $file) AND $file != '.' AND $file != '..' AND $file != '.svn')
            {
              $aux = array();
              $aux["name"] = $file;
              $aux["path"] = $path . $file;
              $aux["isDir"] = true;
              $aux["contents"] = self::retrieveFilesArrayOfDirectory($path . $file);
              array_push($salida, $aux);
            }
            else
            {
              if($file != '.' AND $file != '..' AND $file != '.svn')
              {
                $aux = array();
                $aux["name"] = $file;
                $aux["path"] = $path . $file;
                $aux["time"] = filemtime ($path . $file);
                $aux["isDir"] = false;
                $aux["contents"] = null;
                array_push($salida, $aux);
              }
            }
          }
        }
      }
      return $salida;
    }
}
