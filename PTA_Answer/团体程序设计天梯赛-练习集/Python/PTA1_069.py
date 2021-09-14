if __name__ == '__main__':
    vals = list(map(int,input().split()))
    maxVal= max(vals[0:4])
    minVal = min(vals[0:4])
    warningIndex = -1
    doubleWarning = False
    for i in range(0,4):
        if abs(vals[i]-maxVal)> vals[5] or vals[i] < vals[4]:
            doubleWarning = (warningIndex != -1)
            warningIndex = i

    if doubleWarning:
        print('Warning: please check all the tires!')
    elif warningIndex != -1:
        print('Warning: please check #%d!'%(warningIndex+1))
    else:
        print('Normal')
