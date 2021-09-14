class Student:
    sex = None
    name = None
    paired = None
    rank = None
    partner = None

    def __init__(self, sex, name, rank):
        self.sex = sex
        self.name = name
        self.paired = False
        self.rank = rank
        self.partner = None

    def __str__(self) -> str:
        return ' '.join((self.name, self.partner.name)
                        if self.rank < self.partner.rank
                        else (self.partner.name, self.name))

    def pair(self, other) -> None:
        self.partner = other
        self.paired=True
        other.paired=True


if __name__ == '__main__':
    n = int(input())

    students = []

    for i in range(0, n):
        sex, name = input().split()
        sex = int(sex)
        students.append(Student(sex, name, i))

    count = len(students)

    for i in range(0,n):
        if students[i].paired:
            continue
        for j in range(n-1,-1,-1):
            if not students[j].paired and students[i].sex!=students[j].sex:
                students[i].pair(students[j])
                print(students[i])
                break

    pass
