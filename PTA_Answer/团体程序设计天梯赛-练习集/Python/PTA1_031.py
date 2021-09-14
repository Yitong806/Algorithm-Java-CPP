if __name__ == '__main__':
    n=int(input())
    for i in range(0,n):
        h,w=map(int,input().split())
        standard=(h-100)*0.9*2
        if abs(w-standard)<0.1*standard:
            print('You are wan mei!')
        elif w>standard:
            print('You are tai pang le!')
        else:
            print('You are tai shou le!')