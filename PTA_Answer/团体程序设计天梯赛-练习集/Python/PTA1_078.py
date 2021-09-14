if __name__ == '__main__':
    n,m = map(int,input().split())
    cnt = 0
    for i in range(0,n):
        problem = input()
        if 'qiandao' not in problem and 'easy' not in problem:
            cnt += 1
            if cnt == m+1:
                print(problem)
    print('Wo AK le' if m>=cnt else'',end='' )