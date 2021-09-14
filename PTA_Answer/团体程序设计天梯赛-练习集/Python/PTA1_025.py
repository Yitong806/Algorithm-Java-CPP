def getNumStr(ls) -> str:
    try:
        a = int(ls)
        if a < 1 or a > 1000:
            raise Exception
        return str(a)
    except Exception:
        return '?'


if __name__ == '__main__':
    li = input().split()
    s1 = getNumStr(li[0])
    s2 = getNumStr(li[1])
    if len(li) != 2:
        print(s1 + ' + ? = ?')
    elif s1 == '?' or s2 == '?':
        print(s1 + ' + ' + s2 + ' = ?')
    else:
        print(s1 + ' + ' + s2 + ' = ' + str(int(s1) + int(s2)))
