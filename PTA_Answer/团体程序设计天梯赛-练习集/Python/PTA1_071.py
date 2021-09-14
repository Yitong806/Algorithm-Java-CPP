if __name__ == '__main__':
    n, m =map(int,input().split())
    for _ in range(0,m):
        binaryList = []
        s = input()
        for val in s:
            binaryList.append('1' if val=='n'else '0')
        print(int(''.join(binaryList),2)+1)