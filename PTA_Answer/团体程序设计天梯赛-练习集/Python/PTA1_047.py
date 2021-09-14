if __name__ == '__main__':
    k = int(input())
    for i in range(0,k):
        name,t1,t2=map(str,input().split())
        t1,t2=map(int,(t1,t2))
        print((name+"\n") if (t1<15 or t1 >20) or(t2<50 or t2>70) else '',end='')