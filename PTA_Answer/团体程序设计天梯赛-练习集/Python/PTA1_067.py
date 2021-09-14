if __name__ == '__main__':
    k3,kind,dist=map(float,input().split())
    lox=k3*(2.455 if kind==0 else 1.26)
    print('%.2f'%lox,'^_^' if dist>lox else'T_T')