if __name__ == '__main__':
    kg,m=map(float,input().split())
    val = float('%.1f'%(kg/(m**2)))
    print(val)
    print('PANG' if val>25 else'Hai Xing')