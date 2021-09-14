import math as m

if __name__ == '__main__':
    n = int(input())
    s = input()
    bigMap = [[' ' for j in range(0, int(m.ceil(len(s) / n)))] for i in range(0, n)]

    count = 0

    for i in range(int(m.ceil(len(s) / n))-1, -1, -1):
        for j in range(0,n):
            bigMap[j][i]=s[count]
            count+=1
            if count >= len(s):
                break
        if count >= len(s):
            break

    for i in range(0,n):
        for j in range(0,len(bigMap[i])):
            print(bigMap[i][j],end='')
        print()