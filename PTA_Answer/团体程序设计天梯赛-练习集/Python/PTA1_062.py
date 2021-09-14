if __name__ == '__main__':
    n = int(input())
    for _ in range(0,n):
        nums = list(map(int,input()))
        print('You are lucky!' if nums[0]+nums[1]+nums[2]==nums[3]+nums[4]+nums[5] else 'Wish you good luck.')