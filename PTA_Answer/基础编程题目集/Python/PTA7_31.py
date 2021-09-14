if __name__ == '__main__':
    st = input()
    n = int(input())%len(st)
    print(st[n::]+st[0:n])