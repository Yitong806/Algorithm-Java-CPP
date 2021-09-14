class my_matrix:
    col = 0
    row = 0
    element = None

    def __init__(self,col,row):
        self.col=col
        self.row=row
        self.element = [[0 for _ in range(0, row)] for _ in range(0, col)]

    def __mul__(self, other):
        if self.row!=other.col:
            print('Error: %d != %d'%(self.row,other.col))
            exit(0)
            return None

        result=my_matrix(self.col,other.row)
        for i in range(0,self.col):
            for j in range(0,self.row):
                for k in range(0,other.row):
                    result.element[i][k]+=self.element[i][j]*other.element[j][k]

        return result


def inputMatrix()->my_matrix:
    ca, ra = map(int, input().split())
    m1 = my_matrix(ca, ra)

    for i in range(0, ca):
        ele = list(map(int, input().split()))
        for j in range(0, ra):
            m1.element[i][j] = ele[j]

    return m1



if __name__ == '__main__':
    m1=inputMatrix()
    m2=inputMatrix()
    m = m1*m2

    print(m.col,m.row)
    for i in range(0,m.col):
        for j in range(0,m.row):
            print(m.element[i][j],end='')
            print('' if j==m.row-1 else ' ',end='')
        print()
