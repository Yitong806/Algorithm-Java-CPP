if __name__ == '__main__':
    odd = 0
    n = int(input())
    nums = list(map(int, input().split()))
    for i in range(0, n):
        odd += nums[i] % 2
    print(odd, n - odd)
