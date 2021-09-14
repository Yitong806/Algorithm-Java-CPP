if __name__ == '__main__':
    a,b=map(int,input().split())
    print(('%d/%d=' if b >= 0 else '%d/(%d)=') %(a,b),end='')
    print('Error' if b == 0 else '%.2f'%(a/b))