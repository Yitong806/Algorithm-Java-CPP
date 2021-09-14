if __name__ == '__main__':
    MyDic = {'0': 'ling', '1': 'yi', '2': 'er',
             '3': 'san', '4': 'si', '5': 'wu',
             '6': 'liu', '7': 'qi', '8': 'ba',
             '9': 'jiu', '-': 'fu'}
    chars = list(input())
    for i in range(0,len(chars)):
        chars[i]=MyDic.get(chars[i])
    print(' '.join(chars))