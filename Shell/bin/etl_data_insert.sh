#!/bin/bash
# get Parameter
SRC_ID=$0
TARGET_ID=$1

UUID=$(uuidgen)

BASE_DIR=$(cd $(dirname $0)/..;pwd)
echo "BASE_DIR:"$BASE_DIR
LAST_DATE=`date -d "-1 days" + '%Y-%m-%d'`
CURR_DATE=`date -d "$LAST_DATE + 1days" + '%Y-%m-%d'`
echo CURR_DATE:$CURR_DATE
data_anal_config=$BASE_DIR"/config/object_loss.cfg"
LogFile="${BASE_DIR}/log/object_${LAST_DATE}.log"
echo "data_anal_config:"$data_anal_config

if[ ! -f ${data_anal_config}]; then
	echo "config file ./config/data_anal.cfg Not FUND"
	exit 1
else 
	source ${data_anal_config}

	#mysql配置
	MYSQL_URL=$(echo $MYSQL_URL | sed 's/\r//')
	MYSQL_USER=$(echo $MYSQL_USER | sed 's/\r//')
	MYSQL_PASS=$(echo $MYSQL_PASS | sed 's/\r//')

fi

echo MYSQL_URL:$MYSQL_URL, MYSQL_USER:$MYSQL_USER, MYSQL_PASS:$MYSQL_PASS

MYSQL_PASS=$(java -jar $BASE_DIR/encode.jar 1 sagjkagjshgka28398 ${MYSQL_PASS} | cut -d ':' -f2)

# insert data
mysql -u ${MYSQL_USER} -P ${MYSQL_PASS} -h ${MYSQL_URL} sync_db -s -e "insert into etl_manager(id,src_id,target_id) values(${UUID}, ${SRC_ID}, ${TARGET_ID});"

cat tmp_list.txt | while read id file_path
do
    mysql -u ${MYSQL_USER} -P ${MYSQL_PASS} -h ${MYSQL_URL} sync_db -s -e "insert into etl_file_path(id,file_path) values(${UUID}, ${file_path});"
done


