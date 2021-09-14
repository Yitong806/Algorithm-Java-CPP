def printAnswer(hour, minute):
    if (hour > 12):
        print('%d:%d PM' % (hour - 12, minute))
    elif (hour == 12):
        print('%d:%d PM' % (hour, minute))
    else:
        print('%d:%d AM' % (hour, minute))

    pass


if __name__ == '__main__':
    time = input().split(':')
    hour = int(time[0])
    minute = int(time[1])

    printAnswer(hour, minute)
    pass
