if __name__ == '__main__':
    x = int(input())
    s1 = ''
    while True:
        s1 += '1'
        if int(s1) % x == 0:
            print(int(s1) // x, len(s1))
            break