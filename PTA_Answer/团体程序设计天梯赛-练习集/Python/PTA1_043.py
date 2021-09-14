if __name__ == '__main__':
    n = int(input())
    cnt = sum = 0
    day = 0

    bookDic=[False for _ in range(0,1010)]
    timeDic=[0 for _ in range(0,1010)]
    while day < n:
        num,key,hm=input().split()
        num=int(num)
        key = str(key)
        h,m=map(int,hm.split(':'))
        if num == 0:
            print('0 0' if cnt ==0 else '%d %d'%(cnt,int(sum/cnt+0.5)))
            cnt = sum = 0
            day += 1
        elif key=='S':
            bookDic[num]=True
            timeDic[num]=h*60+m
        elif key =='E' and bookDic[num] == True:
            bookDic[num]=False
            cnt +=1
            sum +=h*60+m -timeDic[num]
