import math


class Fraction:
    divider = 0
    dividend = 1

    def __init__(self, er, end):
        self.divider = er
        self.dividend = end

    def __add__(self, other):
        return Fraction(self.divider * other.dividend + self.dividend * other.divider, self.dividend * other.dividend)

    def simiplify(self):
        if self.divider == 0:
            self.dividend = 1
            return
        gcd = math.gcd(self.divider, self.dividend)
        self.divider /= gcd
        self.dividend /= gcd

    def __str__(self):
        intPart = int(self.divider / self.dividend)
        restPart = int(self.divider % self.dividend)

        if intPart == 0:
            if restPart == 0:
                return '0'
            else:
                self.simiplify()
                return str(int(self.divider)) + '/' + str(int(self.dividend))
        else:
            if restPart == 0:
                return str(intPart)
            else:
                return str(intPart) + ' ' + Fraction(restPart, self.dividend).__str__()


if __name__ == '__main__':
    n = int(input())
    strs = input().split()
    f = Fraction(0, 1)
    for s in strs:
        sub = s.split('/')
        f += Fraction(int(sub[0]), int(sub[1]))
    print(f)
    pass
