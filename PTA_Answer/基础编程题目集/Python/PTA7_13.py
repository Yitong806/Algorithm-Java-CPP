def printAnswer(open1,high2,low3,close4):
    if close4<open1:
        print('BW-Solid',end='')
    elif close4>open1:
        print('R-Hollow',end='')
    else:
        print('R-Cross',end='')

    lowerShadow=low3<open1 and low3<close4
    upperShadow=high2>open1 and high2>close4

    if(lowerShadow and upperShadow):
        print(' with Lower Shadow and Upper Shadow')
    elif lowerShadow:
        print(' with Lower Shadow')
    elif upperShadow:
        print(' with Upper Shadow')
    pass


if __name__ == '__main__':
    open1,high2,low3,close4=map(float,input().split())
    printAnswer(open1, high2, low3, close4)

    pass