def print24(a):
    isOK = [False, False, False, False]
    numberOK = [a, a + 1, a + 2, a + 3]

    c6 = 0

    for i in range(100, 1000):
        hun = int(i / 100)
        ten = int(i % 100 / 10)
        fin = int(i % 10)

        if hun in numberOK:
            isOK[hun - a] = True
        if ten in numberOK:
            isOK[ten - a] = True
        if fin in numberOK:
            isOK[fin - a] = True

        counter = 0
        for j in range(0, 4):
            if isOK[j]:
                counter += 1
                isOK[j] = False

        if counter == 3:
            print(i, end='')
            c6 += 1
            if c6 == 6:
                c6 = 0
                print()
            else:
                print(' ', end='')
    pass


if __name__ == '__main__':
    a = int(input())
    print24(a)
