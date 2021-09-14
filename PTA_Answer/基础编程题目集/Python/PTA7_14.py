def printAnswer(a, b):
    small = min(a, b)
    large = max(a, b)
    counter = 0
    sum = 0

    for i in range(small, large + 1):
        print('%5s' % str(i), end='')
        counter += 1
        sum += i
        if counter == 5:
            print()
            counter = 0
        pass
    if counter!=0:
        print()

    print('Sum = %d'% sum)
    return


if __name__ == '__main__':
    a, b = map(int, input().split())
    printAnswer(a, b)
    pass
