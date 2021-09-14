if __name__ == '__main__':
    weight=[7,9,10,5,8,4,2,1,6,3,7,9,10,5,8,4,2]
    check=['1','0','X','9','8','7','6','5','4','3','2']
    allPass=True
    n = int(input())
    passed=[False for k in range(0,n)]
    vals=[]
    for i in range(0,n):
        s = input()
        vals.append(s)
        inValid=False
        t = 0

        counter=-1
        for k in s[0:17]:
            counter+=1
            # print(k,end='')
            if k>='0' and k<='9':
                t+=weight[counter]*int(k)
            else:
                passed[i]=False
                inValid=True
                break
        if inValid:
            passed[i]=False
        else:
            # print(check[t%11])
            passed[i]=(check[t%11]==s[17])
            if not passed[i]:
                allPass=False

    if allPass:
        print('All passed')
    else:
        for k in range(0,n):
            if not passed[k]:
                print(vals[k])
