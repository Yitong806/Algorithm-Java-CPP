if __name__ == '__main__':
    n = int(input())
    label = [0 for i in range(0, 1000 + 1)]
    for i in range(0, n):
        nums = list(map(int, input().split()))
        for j in range(0, nums[0]):
            label[nums[j + 1]] += 1

    maxLabel = 1000
    for k in range(1000,0,-1):
        if label[k] > label[maxLabel]:
            maxLabel = k
    print(maxLabel,label[maxLabel])
