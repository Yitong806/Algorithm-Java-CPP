if __name__ == '__main__':
    n=int(input())
    dic={}
    for i in range(0,n):
        nu,tr,rea=input().split()
        dic[tr]=(nu,rea)
    m=int(input())
    info=input().split()
    for i in range(0,m):
        print(dic[info[i]][0],dic[info[i]][1])