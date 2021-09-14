import math as ma

if __name__ == '__main__':
    hour,minute=map(int,input().split(':'))
    dang=ma.ceil(((hour-12)*60+minute)/60)
    print('Dang'*dang if dang > 0 else 'Only %02d:%02d  Too early to Dang.'%(hour,minute))
