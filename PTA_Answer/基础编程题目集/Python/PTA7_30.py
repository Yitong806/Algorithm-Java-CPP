if __name__ == '__main__':
    n,k = map(int,input().split())
    allStr=[]

    for i in range(0,n):
        allStr.append(input())

    for i in range(0,n):
        for y in range(0,n-1-i):
            if(allStr[y]>allStr[y+1]):
                temp=allStr[y]
                allStr[y]=allStr[y+1]
                allStr[y+1]=temp

        if(i==k-1):
            print('\n'.join(allStr))
            break