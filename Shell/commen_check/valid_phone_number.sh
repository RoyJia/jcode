#!/bin/bash
txt="../conf/phone_numbers.txt"
cat ${txt} | while read line
do
    echo $line
done