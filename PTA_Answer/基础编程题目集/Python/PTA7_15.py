if __name__ == '__main__':
    x = float(input())
    i = 2
    d = 3
    temp = 1
    n = 1
    n1 = 2
    sum = 1
    while temp >= x:
        temp = n / d
        sum += temp
        n *= n1
        n1 += 1
        d *= (2 * i + 1)
        i += 1

    sum *= 2
    print('%.6f' % sum)
