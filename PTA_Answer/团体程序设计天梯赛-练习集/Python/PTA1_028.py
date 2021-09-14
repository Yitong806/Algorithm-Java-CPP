import math


def isPrime(n) -> bool:
    if n == 2:
        return True
    if n <= 1 or n % 2 == 0:
        return False

    for j in range(3, int(math.sqrt(n) + 1), 2):
        if n % j == 0:
            return False
    return True


if __name__ == '__main__':
    n = int(input())
    for i in range(0, n):
        print('Yes' if isPrime(int(input())) else 'No')
