if __name__ == '__main__':
    n, ch = input().split(' ')
    n = int(n)
    h = int(((n + 1) / 2) ** 0.5)
    for i in map(abs, range(1 - h, h)):
        print(' ' * (h - 1 - i) + ch * (2 * i + 1))
    print(n - (2 * h ** 2 - 1))