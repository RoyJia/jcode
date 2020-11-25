uid_list = list();
with open("uids.csv") as file:
    for line in file:
        uid_list.append(line.rstrip('\n'))

premium_member_list = list()
with open("premium_members.csv") as file:
    for line in file:
        premium_member_list.append(line.rstrip('\n'))


def get_result(uids, premium_members):
    result = list()
    for uid in uids:
        if uid not in premium_members:
            result.append(uid)

    return result


result = get_result(uid_list, premium_member_list)
print(len(result))
# for uid in result:
#     print(uid)
