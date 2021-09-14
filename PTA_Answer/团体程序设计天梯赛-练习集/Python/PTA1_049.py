if __name__ == '__main__':
    n = int(input())
    members = list(map(int, input().split()))
    rest = 0
    for i in range(0, n):
        members[i] *= 10
        rest += 1 if members[i] != 0 else 0
    places = [[-1 for _ in range(0, 100)] for _ in range(0, n)]
    havePlaced = [0 for _ in range(0, n)]
    answerPlace = 1
    groupCount = 0

    while rest > 0:
        if havePlaced[groupCount] >= members[groupCount]:
            groupCount = (groupCount + 1) % n
            continue
        # print('Here!')
        if rest!=1:
            places[groupCount][havePlaced[groupCount]] = answerPlace
            answerPlace += 1
            havePlaced[groupCount] += 1

            if havePlaced[groupCount] >= members[groupCount]:
                rest -= 1
            groupCount = (groupCount + 1) % n
        else:
            places[groupCount][havePlaced[groupCount]] = answerPlace
            answerPlace += 2
            havePlaced[groupCount] += 1
            if havePlaced[groupCount] >= members[groupCount]:
                rest -= 1

        pass

    for i in range(0,n):
        print('#%d'%(i+1))
        count = 0
        for j in range(0,len(places[i])):
            if places[i][j]==-1:
                break
            print(places[i][j],end='')
            if (j+1) % 10 == 0:
                print()
            else:
                print(' ',end='')