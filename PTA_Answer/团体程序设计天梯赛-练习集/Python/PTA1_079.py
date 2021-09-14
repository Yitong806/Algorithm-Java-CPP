if __name__ == '__main__':
    n = int(input())
    dic = {}
    nums = list(map(int,input().split()))
    num_max = max(nums)
    num_min = min(nums)
    for n in nums:
        if n in dic.keys():
            dic[n] += 1
        else:
            dic[n] = 1

    print(num_min,dic[num_min])
    print(num_max, dic[num_max])