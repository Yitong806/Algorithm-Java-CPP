def run(time):
    turtleDistance = 0
    rabbitDistance = 0
    rabbitRunTime = 0
    rabbitSleepTime = 0

    while time > 0:
        if rabbitRunTime == 0 and rabbitSleepTime == 0:
            if rabbitDistance > turtleDistance:
                rabbitRunTime = 0
                rabbitSleepTime = 30
            else:
                rabbitSleepTime = 0
                rabbitRunTime = 10

        if rabbitRunTime != 0:
            rabbitDistance += 9
            rabbitRunTime -= 1
        elif rabbitSleepTime != 0:
            rabbitDistance += 0
            rabbitSleepTime -= 1
        turtleDistance += 3
        time -= 1

    if turtleDistance > rabbitDistance:
        print('@_@ %d' % turtleDistance)
    elif turtleDistance < rabbitDistance:
        print('^_^ %d' % rabbitDistance)
    else:
        print('-_- %d' % turtleDistance)


if __name__ == '__main__':
    time=int(input())
    run(time)
    exit(0)