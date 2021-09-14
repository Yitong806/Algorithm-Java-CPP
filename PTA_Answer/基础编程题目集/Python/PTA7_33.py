def getSum(a1,b1,a2,b2):
    divider=a1*b2+a2*b1
    dividend=b1*b2

    large=max(divider,dividend)
    small=min(divider,dividend)

    while large%small!=0:
        temp=large
        large=small
        small=temp%small

    gcd=small
    divider/=gcd
    dividend/=gcd

    divider=int(divider)
    dividend=int(dividend)

    if(dividend==1):
        return str(int(divider))
    else:
        return str(divider)+'/'+str(dividend)


if __name__ == '__main__':
    line=input().split()
    a1_b1=line[0].split('/')
    a2_b2=line[1].split('/')

    a1=int(a1_b1[0])
    b1=int(a1_b1[1])

    a2=int(a2_b2[0])
    b2=int(a2_b2[1])

    print(getSum(a1,b1, a2, b2))