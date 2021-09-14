
if __name__ == '__main__':
    n = int(input())
    nodes = []
    for i in range(1, n + 1):
        nodes.append(i)

    index = 0
    count = 0
    while len(nodes)>1:
        index+=1
        count+=1
        index %= len(nodes)
        if count==2:
            del nodes[index]
            count=0
    print(nodes[0])
