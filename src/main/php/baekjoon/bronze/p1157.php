<?php
    $input = fgets(STDIN);
    
    $string = strtoupper(trim($input));
    
    $array = str_split($string);
    
    $storage = array();
    
    foreach($array as $char){
        if(isset($storage[$char])){
            $storage[$char]++;
        }else{
            $storage[$char] = 1;
        }
    }
    
    $max = -1;
    $maxChar = '';
    $flag = false;
    foreach($storage as $char => $count){
        if($max < $count){
            $max = $count;
            $maxChar = $char;
            $flag = false;
        }else if($max === $count){
            $flag = true;
        }
    }
    
    if($flag === true){
        echo '?';
    }else{
        echo $maxChar;
    }
?>
