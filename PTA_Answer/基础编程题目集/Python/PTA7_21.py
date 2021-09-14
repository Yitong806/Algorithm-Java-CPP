def printSolution(n):
    hasSolution = False
    for i in range(1, int(n ** 0.5 + 1)):
        if (n - i ** 2) ** 0.5 == int((n - i ** 2) ** 0.5) and i <= (n - i ** 2) ** 0.5:
            print(i, int((n - i ** 2) ** 0.5))
            hasSolution = True

    if (not hasSolution):
        print('No Solution')
    pass

if __name__ == '__main__':
    n = int(input())
    printSolution(n)
    pass
