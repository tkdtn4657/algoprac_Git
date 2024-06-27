<?php

    $arrOne = fgets(STDIN);
    $arrTwo = str_split(trim(fgets(STDIN)));
    $mul = 0;
    $int = 0;

    for($i = count($arrTwo)-1; $i >= 0; $i--){
        $sum = (int)$arrTwo[$i] * (int)$arrOne;
        echo $sum . "\n";
        $mul += $sum * pow(10, $int);
        $int++;
    }
    echo $mul;

?>
