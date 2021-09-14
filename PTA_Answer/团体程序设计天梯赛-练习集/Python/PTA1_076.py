if __name__ == '__main__':
    info,price= map(float,input().split())
    for i in range(0,int(info)):
        val = float(input())
        if val < price:
            print('On Sale! %.1f'%val)