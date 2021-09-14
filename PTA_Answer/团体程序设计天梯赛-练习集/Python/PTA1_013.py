if __name__ == '__main__':
    n=int(input())
    an=0
    tem=1
    for i in range(1,n+1):
        tem*=i
        an+=tem
    print(an)