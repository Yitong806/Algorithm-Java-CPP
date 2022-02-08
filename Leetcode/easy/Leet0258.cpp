class Solution {
public:
    int addDigits(int num) {
        while (!only1(num)){
            num = sum(num);
        }

        return num;
    }

    static inline int sum(int n){
        int s = 0;
        while (n != 0){
            s += n % 10;
            n /= 10;
        }

        return s;
    }

    static inline bool only1(int n){
        return 0 <= n && n < 10;
    }
};