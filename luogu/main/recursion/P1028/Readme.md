# Explanation to P1028 in Luogu
### 数的计算
难度：普及-   
要求：  
![image](https://user-images.githubusercontent.com/64548919/129591842-302b3998-c7aa-42e3-80e5-3fbfd1a189b7.png)   
做法：循环迭代查询，因此关键在于找到状态转移方程。   
注意到状态转移方程为：   
f[0] = 0; f[1] = 1;    
f[i] = f[i-1] + f[i/2] if i is even else f[i-1];   
注意：本题的状态转移方程不太容易思考（也有可能是因为我菜），需要手动推几组发现规律。  
