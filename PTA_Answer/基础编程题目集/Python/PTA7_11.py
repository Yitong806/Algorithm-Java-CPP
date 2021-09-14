def getFee(x):
    return 4 * x / 3 if x <= 15 else 2.5 * x - 17.5


if __name__ == '__main__':
    x = float(input())
    print('%.2f' % getFee(x))