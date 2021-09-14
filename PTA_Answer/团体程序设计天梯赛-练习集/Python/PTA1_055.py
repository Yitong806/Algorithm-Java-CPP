if __name__ == '__main__':
    pa,pb=map(int,input().split())
    judger=[0,0]
    li = list(map(int,input().split()))
    for i in li:
        judger[i] += 1
    if (pa>pb and judger[0]!=0) or (pa < pb and judger[1]==0):
        print('The winner is a: %d + %d'%(pa,judger[0]))
    else:
        print('The winner is b: %d + %d'%(pb,judger[1]))