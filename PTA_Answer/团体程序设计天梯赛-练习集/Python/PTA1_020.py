if __name__ == '__main__':
    appearTime = [0 for i in range(0, 99999 + 1)]
    n = int(input())
    for i in range(0, n):
        li = list(map(int, input().split()))
        if li[0]==1:
            continue
        for j in range(1, li[0] + 1):
            appearTime[li[j]] += 1

    m = int(input())
    lk = list(map(int, input().split()))

    an = []
    for i in range(0, m):
        if appearTime[lk[i]] == 0:
            an.append('%05d'%(lk[i]))
            appearTime[lk[i]]+=1

    print('No one is handsome' if len(an) == 0 else ' '.join(an))
