if __name__ == '__main__':
    n=int(input())
    for i in range(0,n):
        sex,height=input().split()
        print('%.2f'%(float(height)*1.09 if sex == 'F' else float(height)/1.09))