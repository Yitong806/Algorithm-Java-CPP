def getSolution(n):
    y=0
    f=0

    for i in range(0,50):
        if (i*199+n)%98 == 0:
            y=int(i)
            f=int((i*199+n)/98)
            return str(y)+'.'+str(f)

    pass
    return 'No Solution'


if __name__ == '__main__':
    n=int(input())
    print(getSolution(n))
    pass
