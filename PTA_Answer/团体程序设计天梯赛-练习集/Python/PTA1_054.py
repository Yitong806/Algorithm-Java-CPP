if __name__ == '__main__':
    ch, n = input().split()
    dic={'@':ch,' ':' '}
    n = int(n)
    myMap = [['' for _ in range(0,n)] for _ in range(0,n)]
    for i in range(0, n):
        ss = input()
        for j in range(0, n):
            myMap[i][j] = ss[j]

    # check is reflexive
    isReflexive = True
    for i in range(0,n):
        for j in range(0,n):
            if myMap[i][j]!= myMap[n-i-1][n-j-1]:
                isReflexive = False
                break
        if not isReflexive:
            break

    print('bu yong dao le\n' if isReflexive else'',end='')

    for i in range(0,n):
        for j in range(0,n):
            print(dic[myMap[n-i-1][n-j-1]],end='')
        print()
    pass