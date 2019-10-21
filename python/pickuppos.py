import csv
import os
import xml.etree.ElementTree as ET

sitedetails = os.path.abspath(os.path.join(os.path.dirname(__file__), "ignorebutusing/sitedetails.xml"))
tree = ET.parse(sitedetails)
settingNodeList = tree.getroot()

result = []

for settingnode in settingNodeList:
    site_info = settingnode.attrib
    pos_info = settingnode[0][0].attrib

    result.append({**site_info, **pos_info})

result = sorted(result, key = lambda i: i['tpid'])

rows = dict()
allcsv = os.path.abspath(os.path.join(os.path.dirname(__file__), "ignorebutusing/all.csv"))
with open(allcsv, newline='') as f:
    reader = csv.reader(f)

    for row in reader:
        rows[f"{row[2]}-{row[1]}"] = {"siteid": row[0], "eapid": row[1], "tpid": row[2], "domain": row[3], "locale": row[4], "brand": row[9]}

aaa = []
for val in result:
    key = f"{val['tpid']}-{val['eapid']}"
    if key in rows.keys():
        locale = rows[key]['locale']
        if 'locale' in val.keys():
            locale = val['locale']
        aaa.append((rows[key]['brand'], rows[key]['domain'], rows[key]['siteid'], locale, val['value']))
        
def takeThird(ele):
    return int(ele[2])

aaa.sort(key=takeThird)

for i, val in enumerate(aaa):
    print((i+1, val[0], val[1], int(val[2]), val[3], val[4]))