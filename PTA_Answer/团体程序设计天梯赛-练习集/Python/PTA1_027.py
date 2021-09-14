def getSortedArr(phone) ->[]:
    nums = set()
    for s in phone:
        nums.add(int(s))
    arr=[]
    for n in nums:
        arr.append(n)
    arr.sort(reverse=True)
    return arr


def getChangedDic(arr)->[]:
    dic = {}
    for i in range(0, len(arr)):
        dic[arr[i]] = i
    phoneChanged = []
    for s in phone:
        phoneChanged.append(dic[int(s)])
    return phoneChanged


if __name__ == '__main__':
    phone = input()
    arr=getSortedArr(phone)
    changed=getChangedDic(arr)
    arr=map(str,arr)
    changed=map(str,changed)

    print('int[] arr = new int[]{'+(','.join(arr))+'};')
    print('int[] index = new int[]{'+(','.join(changed))+'};')