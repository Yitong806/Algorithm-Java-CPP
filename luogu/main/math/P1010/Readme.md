# Explanation to P1010 in Luogu
### 幂次方
难度：普及-    
要求：将给定整数转化为2的幂次方表示的字符串形式。    
做法：本题的本质是递归思想在字符串中的应用。本题经过多次手推，规律大体如下伪代码所示：  
```java
answer(n):    
    when n is:   
        1 -> answer += "2(0)"    
        2 -> answer += "2"
        4 -> answer += "2(2)" // optional
        other -> running the following codes   
            while n is not 0:    
                n is 1 or 2 or 4:
                    answer(n) //recursively answer(n)
                maxPow <- ... //find 2(maxPow)<= answer
                if maxPow = 1:    
                    answer += "2"
                else:
                    answer += "2("
                    answer(n) //recursively answer(n)
                    answer += ")"
                rest <- ...(get answer - 2(maxPow))
                if rest != 0:
                    answer += "+" //build connection with the rest part
                n <- rest
