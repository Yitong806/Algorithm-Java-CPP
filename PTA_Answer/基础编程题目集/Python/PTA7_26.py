if __name__ == '__main__':
    info = []
    s = input()
    st = list(s[0:s.find('.')].split(' '))
    answer=''
    for i in range(0, len(st)):
        if len(st[i]) != 0:
            answer+=str(len(st[i]))
            if i != len(st) - 1:
                answer+=' '
    print(answer.strip())