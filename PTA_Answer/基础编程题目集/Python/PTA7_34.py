class Record:
    name = ''
    birthday = ''
    gender = ''
    tell = ''
    mobile = ''

    def __init__(self, name, birthday, gender, tell, mobile):
        self.name = name
        self.birthday = birthday
        self.gender = gender
        self.tell = tell
        self.mobile = mobile

    def __str__(self):
        return self.name + ' ' + self.tell + ' ' + self.mobile + ' ' + self.gender + ' ' + self.birthday

    def __eq__(self, other):
        if(type(self)==type(other)):
            return self.name==other.name and self.birthday==other.birthday \
                   and self.gender==other.gender and self.tell==other.tell \
                    and self.mobile==other.mobile
        else:
            return False


if __name__ == '__main__':
    n = int(input())
    allInform = []

    for i in range(0, n):
        sub = input().split()
        allInform.append(Record(sub[0], sub[1], sub[2], sub[3], sub[4]))
        # print(allInform[i])


    restLine=input().split()
    k = int(restLine[0])

    for i in range(1,k+1):
        x = int(restLine[i])
        if x >= n or x < 0:
            print('Not Found')
        else:
            print(allInform[x])

    pass
