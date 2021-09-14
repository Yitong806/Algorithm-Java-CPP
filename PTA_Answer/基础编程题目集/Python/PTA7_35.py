import math as ma

class MyNumber(object):
    divider = 0
    dividend = 1

    def __init__(self, divider=0, dividend=1):
        self.divider = divider
        self.dividend = dividend

    def add(self, divider, dividend):
        der = self.dividend * divider + self.divider * dividend
        dend = self.dividend * dividend
        self.divider = der
        self.dividend = dend
        self.simplify()

    def __str__(self):
        self.simplify()
        if self.dividend == 1:
            return str(int(self.divider))
        else:
            return str(int(self.divider)) + '/' + str(int(self.dividend))

    def simplify(self):
        if self.divider == 0:
            self.divider = 0
            self.dividend = 1
            return

        gcd = ma.gcd(int(self.divider),int(self.dividend))
        self.divider /= gcd
        self.dividend /= gcd


if __name__ == '__main__':
    x = int(input())
    listIn = input().split(' ')

    result = MyNumber(0, 1)

    dividerList = []
    dividendList = []
    for st in listIn:
        subList = st.split('/')
        dividerList.append(int(subList[0]))
        dividendList.append(int(subList[1]))

    for i in range(0, len(dividerList)):
        result.add(dividerList[i], dividendList[i])

    result.dividend*= len(dividendList)

    print(result)
    exit(0)