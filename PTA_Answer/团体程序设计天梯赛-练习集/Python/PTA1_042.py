import datetime

if __name__ == '__main__':
    print(datetime.datetime.strptime(input(),'%m-%d-%Y').strftime('%Y-%m-%d'))