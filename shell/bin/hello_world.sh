#!/bin/bash

# My first shell script
. ../conf/hello_world.conf

echo "-----------$NEXTMONTHWITHZSH"

init_region_split_info()
{
    number=1

    while [ "$number" -le $1 ]; do
        if [ "$number" -lt 10 ]; then
            echo 00$number\| >> $2
        else
            echo 0$number\| >> $2
        fi
        number=$((number + 1))
    done
}
rm region_split_info10.txt region_split_info30.txt 
# pass param into function
init_region_split_info 10 region_split_info10.txt
init_region_split_info 30 region_split_info30.txt

# shell array and iterator
region_array=("100" "220" "311" "351" "471" "240" "431" "451" "210" "250" "571" "551")

for region in ${region_array[@]}
do
    echo "create  'aaa:table_"$NEXTMONTHWITHZSH"_"$region"', {NAME => 'vlt', COMPRESSION => 'SNAPPY', VERSIONS => '1'}" >> zzz.txt
done

echo $0
echo `basename $0`