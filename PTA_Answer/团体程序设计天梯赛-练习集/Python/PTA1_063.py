if __name__ == '__main__':
    n = int(input())
    for _ in range(0,n):
        sex,height,weight=map(int,input().split())
        standard_h = 130 if sex == 1 else 129
        standard_w = 27 if sex == 1 else 25
        if height == standard_h:
            print('wan mei! ',end='')
        elif height > standard_h:
            print('ni li hai! ',end='')
        else:
            print('duo chi yu! ',end='')

        if weight == standard_w:
            print('wan mei!')
        elif weight > standard_w:
            print('shao chi rou!')
        else:
            print('duo chi rou!')

