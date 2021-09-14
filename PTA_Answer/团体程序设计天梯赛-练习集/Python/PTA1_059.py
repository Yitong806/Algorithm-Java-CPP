if __name__ == '__main__':
    n = int(input())
    li = []
    for _ in range(0,n):
        st = input().split(',')

        if st[0][len(st[0])-3:len(st[0])]==st[1][len(st[1])-4:len(st[1])-1] and st[0][len(st[0])-3:len(st[0])]=='ong':
            last3Index = 0
            count = 0
            for i in range(len(st[1])-1,-1,-1):
                if st[1][i]==' ':
                    count+=1
                if count>=3:
                    last3Index=i
                    break
            print(st[0]+','+st[1][0:last3Index]+' qiao ben zhong.')
        else:
            print('Skipped')
