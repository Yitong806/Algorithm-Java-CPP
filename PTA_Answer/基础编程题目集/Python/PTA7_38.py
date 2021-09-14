if __name__ == '__main__':
    a,n=map(int,input().split())
    resultList=[0 for i in range(0,300000)]

    countA = n
    resultIndex=300000-1

    carry=0

    while countA>=0:
        sum=countA*a+carry
        resultList[resultIndex]=sum%10
        carry=int(sum/10)
        resultIndex-=1
        countA-=1
        pass

    no0=False
    for n in resultList:
        if n!=0 :
            no0=True
        if no0:
            print(n,end='')

    if not no0:
        print('0')