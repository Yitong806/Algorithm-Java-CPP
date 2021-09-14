if __name__ == '__main__':
    n = int(input())
    name = ['' for _ in range(0,n)]
    values = [0 for _ in range(0,n)]
    sum = 0
    for i in range(0,n):
        na,v=input().split()
        name[i]=na
        values[i]=int(v)
        sum += values[i]

    avg_2 = sum / n / 2
    index = 0
    minDiff = 999999
    for i in range(0,n):
        if abs(values[i] - avg_2)<minDiff:
            index=i
            minDiff = abs(values[i] - avg_2)

    print(int(avg_2), name[index])