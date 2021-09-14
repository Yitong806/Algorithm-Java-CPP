if __name__ == '__main__':
    strA=input()
    strB=input()
    for c in strA:
        if c not in strB:
            print(c,end='')