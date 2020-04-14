strs = ["eat", "tea", "tan", "ate", "nat", "bat"]

def group_anagrams(strs):
    ans = {}
    for s in strs:
        sorted_s = tuple(sorted(s))
        if sorted_s not in ans:
            ans[sorted_s] = []
        ans[sorted_s].append(s)

    return list(ans.values())


print(group_anagrams(strs))