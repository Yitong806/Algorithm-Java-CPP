def getAnswer(n, u, d):
    time = 0
    height = 0
    while True:
        time += 1
        if time % 2 == 1:
            height += u
        else:
            height -= d
        if height >= n:
            return time


if __name__ == '__main__':
    n, u, d = map(int, input().split())
    print(getAnswer(n, u, d))
