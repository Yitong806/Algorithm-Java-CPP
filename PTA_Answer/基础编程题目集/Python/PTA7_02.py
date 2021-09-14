
def getTime(time1,delta):
    mins=int(time1/100)*60+time1%100
    mins+=delta
    return [int(mins/60),mins%60]

if __name__ == '__main__':
    time1,deltaTime=map(int,input().split())
    list1=getTime(time1,deltaTime)
    print( '%d%02d' % (list1[0],list1[1]))
    pass
