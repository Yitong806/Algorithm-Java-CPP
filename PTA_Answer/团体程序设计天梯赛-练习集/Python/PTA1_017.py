def get2(s) -> float:
    start = 1 if s[0] == '-' else 0
    length = len(s) if s[0] !='-' else len(s)-1
    two = 0
    for i in range(start,len(s)):
        two += 1 if s[i]=='2' else 0
    count = two/length
    count *= 1.5 if s[0] == '-' else 1
    count *= 2 if int(s[len(s)-1])%2 == 0 else 1
    return count*100


if __name__ == '__main__':
    s = input()
    print('%.2f'%get2(s)+'%')
