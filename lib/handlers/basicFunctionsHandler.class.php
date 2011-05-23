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
  
    public static function calculateDifferenceInMonth($startDate, $endDate)
    {
      $anno_inicio =substr($startDate, 0, 4);
      $mes_inicio =substr($startDate, 5, 2);
      $dia_inicio = substr($startDate, 8, 2);      

      $anno_fin =substr($endDate, 0, 4);
      $mes_fin =substr($endDate, 5, 2);
      $dia_fin = substr($endDate, 8, 2);
      
      $begin = array ('year' => $anno_inicio, 'month' => $mes_inicio, 'day' => $dia_inicio);
      $end = array ('year' => $anno_inicio, 'month' => $mes_fin, 'day' => $dia_fin);
      $return = self::date_difference ($begin, $end);
      return $return;
    
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

  /*
      function date_difference calculates the difference between two dates in
      years, months, and days.  There is a ColdFusion funtion called, I
      believe, date_diff() which performs a similar function.
      
      It does not make use of 32-bit unix timestamps, so it will work for dates
      outside the range 1970-01-01 through 2038-01-19.  This function works by
      taking the earlier date finding the maximum number of times it can
      increment the years, months, and days (in that order) before reaching
      the second date.  The function does take yeap years into account, but does
      not take into account the 10 days removed from the calendar (specifically
      October 5 through October 14, 1582) by Pope Gregory to fix calendar drift.
      
      As input, it requires two associative arrays of the form:
      array (    'year' => year_value,
              'month' => month_value.
              'day' => day_value)
      
      The first input array is the earlier date, the second the later date.  It
      will check to see that the two dates are well-formed, and that the first
      date is earlier than the second.
      
      If the function can successfully calculate the difference, it will return
      an array of the form:
      array (    'years' => number_of_years_different,
              'months' => number_of_months_different,
              'days' => number_of_days_different)
              
      If the function cannot calculate the difference, it will return FALSE.
      
  */

  public static function date_difference ($first, $second)
  {
      $month_lengths = array (31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31);

      $retval = FALSE;

      if (    checkdate($first['month'], $first['day'], $first['year']) &&
              checkdate($second['month'], $second['day'], $second['year'])
          )
      {
          $start = self::smoothdate ($first['year'], $first['month'], $first['day']);
          $target = self::smoothdate ($second['year'], $second['month'], $second['day']);
                              
          if ($start <= $target)
          {
              $add_year = 0;
              while (self::smoothdate ($first['year']+ 1, $first['month'], $first['day']) <= $target)
              {
                  $add_year++;
                  $first['year']++;
              }
                                                                                                              
              $add_month = 0;
              while (self::smoothdate ($first['year'], $first['month'] + 1, $first['day']) <= $target)
              {
                  $add_month++;
                  $first['month']++;
                  
                  if ($first['month'] > 12)
                  {
                      $first['year']++;
                      $first['month'] = 1;
                  }
              }
                                                                                                                                                                              
              $add_day = 0;
              while (self::smoothdate ($first['year'], $first['month'], $first['day'] + 1) <= $target)
              {
                  if (($first['year'] % 100 == 0) && ($first['year'] % 400 == 0))
                  {
                      $month_lengths[1] = 29;
                  }
                  else
                  {
                      if ($first['year'] % 4 == 0)
                      {
                          $month_lengths[1] = 29;
                      }
                  }
                  
                  $add_day++;
                  $first['day']++;
                  if ($first['day'] > $month_lengths[$first['month'] - 1])
                  {
                      $first['month']++;
                      $first['day'] = 1;
                      
                      if ($first['month'] > 12)
                      {
                          $first['month'] = 1;
                      }
                  }
                  
              }
                                                                                                                                                                                                                                                          
              $retval = array ('years' => $add_year, 'months' => $add_month, 'days' => $add_day);
          }
      }
                                                                                                                                                                                                                                                                                  
      return $retval;
  }


  public static function smoothdate ($year, $month, $day)
  {
      return sprintf ('%04d', $year) . sprintf ('%02d', $month) . sprintf ('%02d', $day);
  }
}
