if __name__ == '__main__':
    dic={'ChuiZi':'Bu','JianDao':'ChuiZi','Bu':'JianDao'}
    k = int(input())
    count = 0
    while True:
        count += 1
        other = input()
        if other=='End':
            break
        print(other if count%(k+1)==0 else dic[other])