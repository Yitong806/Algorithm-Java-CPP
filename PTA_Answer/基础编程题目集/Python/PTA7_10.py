def getMoney(year, hour):
    if year >= 5:
        per = 50
    else:
        per = 30

    if hour > 40:
        money = per * 40 + 1.5 * per * (hour - 40)
    else:
        money = per * hour

    return money


if __name__ == '__main__':
    year, hour = map(int, input().split())
    print('%.2lf' % getMoney(year, hour))
    pass
