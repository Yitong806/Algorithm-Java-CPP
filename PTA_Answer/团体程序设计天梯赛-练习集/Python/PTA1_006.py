if __name__ == '__main__':
    res = 0
    start = 0
    num = int(input())
    i = 2
    while i**2<num+1:
        if num%i!=0:
            i+=1
            continue
        temp=num
        len=0

        j=i
        while temp%j==0:
            temp/=j
            len+=1
            j+=1

        if len>res:
            res=len
            start = i
        i+=1

    if res==0:
        print(1)
        print(num)
    else:
        print(res)
        isFirst=True
        for i in range(0,res):
            if isFirst:
                print(start+i,end='')
                isFirst=False
            else:
                print('*%d'%(start+i),end='')
