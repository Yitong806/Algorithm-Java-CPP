if __name__ == '__main__':
    allChar=input()
    count=[0 for i in range(0,10)]
    for c in allChar:
        count[int(c)]+=1
    for i in range(0,10):
        if count[i]!=0:
            print('%d:%d'%(i,count[i]))
    pass