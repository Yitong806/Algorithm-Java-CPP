def transform(n):
    sv = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j']
    st = ['S', 'B', 'Q', 'W', 'S', 'B', 'Q', 'Y']

    w = int(len(str(n)))
    j = pow(10, w - 1)

    z_c = False

    if n == 0:
        print('a')
        exit(0)
    else:
        while n != 0:
            h = int(n / j)
            if h != 0:
                print('%s%s' % (sv[h], st[w - 2]), end='')
                z_c = False
            else:
                if not z_c:
                    if w == 5:
                        print('W', end='')
                        z_c = False
                    else:
                        print('a', end='')
                        z_c = True

            n %= j
            j /= 10
            w -= 1
            if j == 1:
                n = int(n)
                if n == 0:
                    break
                print('%s' % sv[n], end='')
                break


if __name__ == '__main__':
    n = int(input())
    transform(n)
    pass
