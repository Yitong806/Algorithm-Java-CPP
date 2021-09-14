if __name__ == '__main__':
    n = int(input())


    def dfs(n, path, res):
        for i in range(1, n + 1):
            if len(path) != 0 and i < path[-1]:
                continue
            else:
                path.append(i)
            if sum(path) > n:
                path.pop()
                break
            elif sum(path) == n:
                res.append(path[:])
                path.pop()
                break
            else:
                dfs(n, path, res)
            path.pop()


    res = []
    path = []
    dfs(n, path, res)
    i = 1
    for t in res[:-1]:
        t = list(map(str, t))
        if i % 4 == 0:
            print("{}={}".format(n, "+".join(t)))
        else:
            print("{}={}".format(n, "+".join(t)), end=";")
        i += 1
    t = list(map(str, res[-1]))
    print("{}={}".format(n, "+".join(t)))

