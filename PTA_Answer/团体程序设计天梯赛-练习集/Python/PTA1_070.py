if __name__ == '__main__':
    infos = 0
    huoguoFirst = -1
    huoguoCount = 0

    count = 0
    while True:
        s = input()
        if s=='.':
            break
        count += 1

        huoguoFirst = count if huoguoFirst == -1 and 'chi1 huo3 guo1' in s else huoguoFirst
        huoguoCount += 1 if 'chi1 huo3 guo1' in s else 0

    print(count)
    print('-_-#' if huoguoFirst==-1 else '%d %d'%(huoguoFirst,huoguoCount))
