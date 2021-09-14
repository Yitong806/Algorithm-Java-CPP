import math as ma

if __name__ == '__main__':
    a1,b1 = map(int,input().split('/'))
    x = ma.gcd(a1,b1)
    print(str(int(a1/x))+'/'+str(int(b1/x)))
    pass