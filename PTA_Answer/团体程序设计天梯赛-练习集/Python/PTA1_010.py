if __name__ == '__main__':
    lis=list(map(int,input().split()))
    lis.sort()
    lis=list(map(str,lis))
    print('->'.join(lis))