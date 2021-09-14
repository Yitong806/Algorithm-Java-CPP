if __name__ == '__main__':
    prizeDic = {6: 10000, 7: 36, 8: 720, 9: 360, 10: 80, 11: 252, 12: 108,
                13: 72, 14: 54, 15: 180, 16: 72, 17: 180, 18: 119,
                19: 36, 20: 306, 21: 1080, 22: 144, 23: 1800, 24: 3600}

    appear = [False for _ in range(0, 9)]
    map3x3 = [[0 for _ in range(0, 3)] for _ in range(0, 3)]
    for i in range(0, 3):
        nums = list(map(int, input().split()))
        map3x3[i] = nums
        for j in range(0, 3):
            if nums[j] != 0:
                appear[nums[j] - 1] = True

    first0number = -1
    for i in range(0, 9):
        if not appear[i]:
            first0number = i
            break

    for i in range(0,3):
        for j in range(0,3):
            if map3x3[i][j]==0:
                map3x3[i][j]=first0number+1
                break

    for i in range(0, 3):
        x, y = map(int, input().split())
        print(map3x3[x - 1][y - 1])

    sum3 = 0
    operation = int(input())
    if 1 <= operation <= 3:
        sum3 = sum(map3x3[operation - 1])
    elif 4 <= operation <= 6:
        sum3 = sum(map3x3[i][operation - 1] for i in range(0, 3))
    elif operation == 7:
        sum3 = sum(map3x3[i][i] for i in range(0, 3))
    else:
        sum3 = sum(map3x3[i][2 - i] for i in range(0, 3))
    print(prizeDic[sum3])
