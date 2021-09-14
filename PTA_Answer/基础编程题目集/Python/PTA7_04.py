def bcd(x):
    return hex(int(x))[2::]


if __name__ == '__main__':
    x=input()
    print(bcd(x))
