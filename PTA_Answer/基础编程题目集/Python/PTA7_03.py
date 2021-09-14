def reverseX(x):
    x=x[::-1]
    y=''

    hasNo0=False
    for i in x:
        if(i != '0'):
            hasNo0=True
        if(hasNo0):
            y+=i
    pass
    return y



if __name__ == '__main__':
    x=input()
    print(reverseX(x))
    pass
