def printSpeed(speed):
    print('Speed: %d - %s' % (speed, 'Speeding' if speed > 60 else 'OK'))
    pass

if __name__ == '__main__':
    speed=int(input())
    printSpeed(speed)
    pass
