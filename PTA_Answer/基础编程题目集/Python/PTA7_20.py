def printN_N(n):
    for i in range(1,n+1):
        for j in range(1,i+1):
            print('%d*%d=%-4d'%(j,i,j*i),end='')
        print()


if __name__ == '__main__':
    n = int(input())
    printN_N(n)