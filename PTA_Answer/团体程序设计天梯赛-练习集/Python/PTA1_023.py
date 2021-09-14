if __name__ == '__main__':
    st=input()
    dic={'G':0,'P':1,'L':2,'T':3}
    s='GPLT'
    count=[0,0,0,0]
    cnt=0
    index = 0
    for c in st:
        if c.upper() in dic.keys():
            count[dic[c.upper()]]+=1
            cnt += 1

    while cnt!=0:
        if count[index]==0:
            index=(index+1)%4
            continue
        else:
            print(s[index],end='')
            count[index]-=1
            index = (index + 1) % 4
            cnt-=1

