if __name__ == '__main__':
    n = int(input())
    li = list(map(float,input().split()))
    sum = 0
    for val in li:
        sum += 1/val
    print('%.2f'%(1/(sum/n)))