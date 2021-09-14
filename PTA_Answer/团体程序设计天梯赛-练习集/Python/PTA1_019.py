if __name__ == '__main__':
    sizeA,sizeB=map(int,input().split())
    drinkA=drinkB=0
    n=int(input())
    for i in range(0,n):
        shoutA,playA,shoutB,playB=map(int,input().split())
        if playA==shoutA+shoutB and playB!=shoutA+shoutB:
            drinkA+=1
        if playA!=shoutA+shoutB and playB==shoutA+shoutB:
            drinkB+=1
        if drinkA>sizeA or drinkB>sizeB:
            break

    print('A' if drinkA>sizeA else 'B')
    print(drinkA if drinkA<=sizeA else drinkB)