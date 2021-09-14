
def printAnswer(x1,opra,x2):
    if opra=='+':
        print(x1 +x2)
    elif opra=='-':
        print(x1 -x2)
    elif opra=='*':
        print(x1 *x2)
    elif opra=='/':
        print(int(x1 /x2))
    elif opra=='%':
        print(int(x1)%int(x2))
    else:
        print('ERROR')
    pass

if __name__ == '__main__':
    op1 , opra , op2 =map(str, input().split())
    x1 =int(op1)
    x2 =int(op2)
    printAnswer(x1,opra,x2)
    pass
