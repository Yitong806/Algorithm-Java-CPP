if __name__ == '__main__':
    happy = list(map(int,input().split()))
    while True:
        t = int(input())
        if t < 0 or t > 23:
            break
        print(happy[t],'Yes' if happy[t]>50 else 'No')