if __name__ == '__main__':
    le, t=input().split()
    le=int(le)
    s=input()
    print()

    if len(s)>=le:
        print(s[len(s)-le:])
    else:
        t=str(t)
        print(t*(le-len(s))+s)
