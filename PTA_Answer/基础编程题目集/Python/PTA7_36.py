class MyComplex:
    image = 0.0
    real = 0.0

    def __init__(self,image,real):
        self.image=image
        self.real=real

    def __str__(self):
        if float(str('%.1f' % self.image)) == 0.0 and float(str('%.1f' % self.real)) == 0.0:
            return '0.0'
        elif float(str('%.1f' % self.image)) == 0.0:
            return '%.1f'%self.real
        elif float(str('%.1f' % self.real)) == 0.0:
            return '%.1fi'%self.image
        else:
            if self.image>0:
                return '%.1f+%.1fi'%(self.real,self.image)
            else:
                return '%.1f%.1fi' % (self.real, self.image)

    def __add__(self, other):
        return MyComplex(self.image+other.image,self.real+other.real)

    def __sub__(self, other):
        return MyComplex(self.image-other.image,self.real-other.real)

    def __mul__(self, other):
        return MyComplex(self.real*other.image+self.image*other.real,self.real*other.real-self.image*other.image)

    def __truediv__(self, other):
        re = (self.real* other.real +self.image* other.image)/(other.real**2+other.image**2)
        im = (self.image* other.real - self.real* other.image)/(other.real**2+other.image**2)
        return MyComplex(im,re)


if __name__ == '__main__':
    a1,b1,a2,b2=map(float,input().split())
    c1=MyComplex(b1,a1)
    c2=MyComplex(b2,a2)

    print('(%.1f%+.1fi) + (%.1f%+.1fi) = %s'%(a1,b1, a2,b2, c1+c2))
    print('(%.1f%+.1fi) - (%.1f%+.1fi) = %s'%(a1,b1, a2,b2,  c1 - c2))
    print('(%.1f%+.1fi) * (%.1f%+.1fi) = %s'%(a1,b1, a2,b2,  c1 * c2))
    print('(%.1f%+.1fi) / (%.1f%+.1fi) = %s'%(a1,b1, a2,b2,  c1 / c2))
