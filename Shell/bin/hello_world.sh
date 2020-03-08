#!/bin/bash

# # My first shell script
# . ../conf/hello_world.conf
# provcd="XXX"

# echo "-----------$NEXTMONTHWITHZSH"

# init_region_split_info()
# {
#     number=1

#     while [ "$number" -le $1 ]; do
#         if [ "$number" -lt 10 ]; then
#             echo 00$number\| >> $2
#         else
#             echo 0$number\| >> $2
#         fi
#         number=$((number + 1))
#     done
# }
# rm region_split_info10.txt region_split_info30.txt 
# # pass param into function
# init_region_split_info 10 region_split_info10.txt
# init_region_split_info 30 region_split_info30.txt

# # shell array and iterator
# region_array=("100" "220" "311" "351" "471" "240" "431" "451" "210" "250" "571" "551")
# a=1
# b=2
# for region in ${region_array[@]}
# do
#     if [ $a -ne $b ];
#     then
#         echo "create  'aaa:table_"$NEXTMONTHWITHZSH"_"$region"', {NAME => 'vlt', COMPRESSION => 'SNAPPY', VERSIONS => '1'}" >> zzz.txt
#     fi
# done

# echo "---------------------------"
# REGINSPLITINFO10=("001|" "002|" "003|" "004|" "005|" "006|" "007|" "008|" "009|" "010|")

# echo "['${REGINSPLITINFO10[*]}']"
# XXX="dafsdfasdfasdfasdfa"

# print_log()
# {
#     echo "$(date "+%Y-%m-%d %H:%M:%S"): $1 $XXX"
# }

# date "+%d/%m/%Y" -d "09/99/2013" > /dev/null  2>&1
# if [ $? -eq 1 ];
# then
#     print_log "date is validated"
# else
#     print_log "date is not validated"
# fi



# cat XXX.txt | while read LINE
# do
#     echo $LINE | egrep '[0-9]{4}VLTCG02_' > /dev/null       #输出到空设备，这样不会打印grep出来的结果，同时$?结果也能符合需要
#     if [ $? -eq 0 ]; then
#         echo "yes - $LINE"
#     fi
# done

# XXX='000'
# msg_level=0
# msg_level_name=(info alarm warning serious)

# echo "----$msg_level"
# echo "++++${msg_level_name[msg_level]}"

# msg_level_name=(INFO ALARM WARNING SERIOUS)
# get_text()
# {
#     echo `[ -z "$1" ] && echo "#" || echo $1`
# }

# # log 2
# str1='aaa'
# str2=''
# if [ -z "$str1" ] || [ -z "$str2" ]; then
#     echo "str is empty"
# else
#     echo $str1
# fi

# echo $(get_text)

if echo "201901" | egrep "^[0-9]{4}((0[1-9]{1})|(1[0-2]{1}))$" > /dev/null 2>&1; then
    echo "adfasdfasdfasdfasdfasdf"
else
  echo "请提供正确的月份参数，格式：YYYYMM";
fi;