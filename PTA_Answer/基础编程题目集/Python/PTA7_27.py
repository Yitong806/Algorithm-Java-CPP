if __name__ == '__main__':
    n,k=map(int,input().split())
    li=list(input().split())
    for i in range(0,len(li)):
        li[i]=int(li[i])

    for j in range(0,n):
        for i in range(0,n-j-1):
            if li[i]>li[i + 1]:
                li[i+1],li[i]=li[i],li[i+1]
        if j==k-1:
            for k in range(0,n):
                print(li[k],end='')
                if(k!=n-1):
                    print(' ',end='')
            break