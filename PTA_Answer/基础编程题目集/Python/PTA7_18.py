def f(a3, a2, a1, a0, x):
    return a3*(x**3)+a2*(x**2)+a1*x+a0


def getRoot(a3, a2, a1, a0, a, b):
    while abs(a-b)>0.001:
        fa=f(a3,a2,a1,a0,a)
        fb=f(a3,a2,a1,a0,b)
        if fa==0:
            return a
        if fb==0:
            return b
        if fa*fb<0:
            fab=f(a3,a2,a1,a0,(a+b)/2)
            if fab==0:
                return (a+b)/2
            elif fab*fa>0:
                a=(a+b)/2
            elif fab*fb>0:
                b=(a+b)/2

    return a


if __name__ == '__main__':
    a3, a2, a1, a0 = map(float, input().split())
    a, b = map(float, input().split())
    print('%.2f'%getRoot(a3, a2, a1, a0, a, b))
