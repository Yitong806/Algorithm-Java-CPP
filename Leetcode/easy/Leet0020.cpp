#include "string"
#include "stack"
using namespace std;

class Solution {
public:
    bool isValid(string s) {
        stack<char>* st = new stack<char>();
        for(char& c:s){
            switch (c) {
                case '(':
                case '[':
                case '{':
                    st->push(c);
                    break;
                case ')':

                    if(st->empty()||st->top() != '('){
                        delete st;
                        st = nullptr;
                        return false;
                    }else{
                        st->pop();
                    }

                    break;
                case ']':
                    if(st->empty()||st->top() != '['){
                        delete st;
                        st = nullptr;
                        return false;
                    }else{
                        st->pop();
                    }
                    break;
                case '}':
                    if(st->empty()||st->top() != '{'){
                        delete st;
                        st = nullptr;
                        return false;
                    }else{
                        st->pop();
                    }
                    break;
            }
        }

        bool isOK =st->empty();

        delete st;
        st = nullptr;
        return isOK;
    }
};