# [('HKG', 'SZH'), ('DEL', 'PEK'), ('AWK', 'DEL'), ('SZH', 'AWK')]
# result: [('HKG', 'SZH'), ('SZH', 'AWK'), ('AWK', 'DEL'), ('DEL', 'PEK')]

flight_paths = [('HKG', 'SZH'), ('DEL', 'PEK'), ('AWK', 'DEL'), ('SZH', 'AWK')]
flight_paths_copy = [('HKG', 'SZH'), ('DEL', 'PEK'), ('AWK', 'DEL'), ('SZH', 'AWK')]

result = []

for item in flight_paths:
    item_is_not_in = True
    for item2 in flight_paths:
        if item != item2 and item[0] in item2:
            item_is_not_in = False

    if item_is_not_in:
        result.insert(0, item)
        break

while len(flight_paths) > 0:
    for item in flight_paths:
        if item == result[-1]:
            flight_paths.remove(item)
            continue
        
        if item[0] == result[-1][1]:
            result.append(item)
            flight_paths.remove(item)


print(result)
