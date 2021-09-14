import math

if __name__ == '__main__':
    n,c=input().split()
    n=int(n)
    c=str(c)
    print((c*n+'\n')*int(math.ceil(n/2)),end='')