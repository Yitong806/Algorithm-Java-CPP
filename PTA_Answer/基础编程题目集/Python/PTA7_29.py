if __name__ == '__main__':
    s1=input()
    s2=input()
    while s1.__contains__(s2):
        s1=s1.replace(s2,'')
    print(s1)