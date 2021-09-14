if __name__ == '__main__':
    l,n=map(int,input().split())
    n = n-1
    arr=[25 for _ in range(0,l)]
    for k in range(l-1,-1,-1):
        divided = 26**k
        arr[l-1-k] -= n//divided
        n %= divided
    st='abcdefghijklmnopqrstuvwxyz'
    for i in range(0,l):
        print(st[arr[i]],end='')
    pass