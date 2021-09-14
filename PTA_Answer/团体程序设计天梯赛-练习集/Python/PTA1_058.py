if __name__ == '__main__':
    s6 = input()

    start6 = False
    count = 0
    rs = []
    for c in s6:
        if c == '6':
            if start6:
                count += 1
            else:
                start6 = True
                count = 1
        else:
            if start6:
                if count > 9:
                    rs.append('27')
                elif count > 3:
                    rs.append('9')
                else:
                    rs.append('6' * count)
            rs.append(c)
            count = 0
            start6 = False

    if start6:
        if count > 9:
            rs.append('27')
        elif count > 3:
            rs.append('9')
        else:
            rs.append('6' * count)
    print(''.join(rs))
