if __name__ == '__main__':
    a1,a2,n=map(int,input().split())
    arr = [int(a1),int(a2)]
    count = 0
    an = 0
    readIndex = 0
    index = 2
    while count<n:
        #print(arr[readIndex])
        an = arr[readIndex] * arr[readIndex+1]
        an = str(an)
        for i in range(0,len(an)):
            arr.append(int(an[i]))
            index += 1
        count += 1
        readIndex += 1

    print(' '.join(list(map(str,arr[0:n]))))
