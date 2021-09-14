
def printAnswer(cm):
    foot = int(12*cm/(100*0.3048)/12)
    inch = int(12*cm/(100*0.3048)-12*foot)
    print(foot,inch)
    return

# Press the green button in the gutter to run the script.
if __name__ == '__main__':
    cm=float(input())
    printAnswer(cm)
    pass

