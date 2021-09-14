import re

def aiSay(userSay)->str:
    aiSaid = ' '.join(re.sub(' +',' ',userSay).split())
    aiSaid = aiSaid.strip()
    reg = re.compile(r' +(\W)')
    aiSaid = reg.sub(r'\1',aiSaid)
    aiSaid = aiSaid.replace('I','α')
    aiSaid = aiSaid.lower()
    aiSaid = aiSaid.replace('α','I')
    reg = re.compile(r'^(I|me)(?= |\W)|(?<= |\W)(I|me)(?= |\W)|(?<= |\W)(I|me)$|^(I|me)$')
    aiSaid = reg.sub(r'/*/', aiSaid)
    reg = re.compile(r'^can you(?= |\W)|(?<= |\W)can you(?= |\W)|(?<= |\W)can you$|^can you$')
    aiSaid = reg.sub(r'I can', aiSaid)
    reg = re.compile(r'^could you(?= |\W)|(?<= |\W)could you(?= |\W)|(?<= |\W)could you$|^could you$')
    aiSaid = reg.sub(r'I could', aiSaid)
    reg = re.compile(r'^/\*/(?= |\W)|(?<= |\W)/\*/(?= |\W)|(?<= |\W)/\*/$|^/\*/$')
    aiSaid = reg.sub(r'you', aiSaid)
    aiSaid = aiSaid.replace('?', '!')
    aiSaid = 'AI: '+aiSaid
    return aiSaid


if __name__ == '__main__':
    n = int(input())
    for i in range(0,n):
        userSay = input()
        print(userSay)
        print(aiSay(userSay),end='\n' if i!=n-1 else '')