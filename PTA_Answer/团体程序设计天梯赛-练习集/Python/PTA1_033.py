if __name__ == '__main__':
    y,n=map(int,input().split())
    x=0

    while True:
        yearStr='%04d'%(x+y)
        distinct=len(set(yearStr))
        if distinct==n:
            print('%d %04d'%(x,x+y))
            break
        else:
            x+=1

    pass