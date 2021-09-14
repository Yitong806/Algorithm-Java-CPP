if __name__ == '__main__':
    x,y=map(int,input().split())
    print(int(100*100/2-x*y/2-(100-x)*(100-y)/2-y*(100-x)))