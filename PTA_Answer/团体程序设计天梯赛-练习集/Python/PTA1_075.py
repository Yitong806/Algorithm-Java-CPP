if __name__ == '__main__':
    info = int(input())
    if info<10000:
        month = info % 100
        year = info//100+(1900 if info//100 >= 22 else 2000)
        print('%d-%02d'%(year,month))
    else:
        print('%d-%02d'%(info//100,info%100))