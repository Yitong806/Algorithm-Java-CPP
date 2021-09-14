if __name__ == '__main__':
    people=[]
    while True:
        s = input()
        if s=='.':
            break
        else:
            people.append(s)

    if len(people)<2:
        print('Momo... No one is for you ...')
    elif len(people)<14:
        print(people[1],'is the only one for you...')
    else:
        print(people[1],'and',people[13],'are inviting you to dinner...')