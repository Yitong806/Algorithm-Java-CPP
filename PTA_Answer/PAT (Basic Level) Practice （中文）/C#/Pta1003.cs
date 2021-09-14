using System;

namespace PTASolution
{
    public class Pta1003
    {
        public void Solution()
        {
            int n = Convert.ToInt32(Console.ReadLine());
            for (int i = 0; i < n; i++)
            {
                string s = Console.ReadLine();
                Console.WriteLine(IsAC(s)?"YES":"NO");
            }
        }

        private bool IsAC(string s)
        {
            int countA = 0, countP = 0, countT = 0;
            int indexP = -1, indexT = -1;
            for (int i = 0; i < s.Length; i++)
            {
                switch (s[i])
                {
                    case 'A':
                    {
                        countA++;
                        break;
                    }
                    case 'P':
                    {
                        countP++;
                        indexP = i;
                        break;
                    }
                    case 'T':
                    {
                        countT++;
                        indexT = i;
                        break;
                    }
                    default:
                    {
                        return false;
                    }
                }
            }

            if (indexP > indexT || countP != 1 || countT != 1)
            {
                return false;
            }

            int leftA = indexP;
            int rightA = s.Length - indexT - 1;
            int middleA = indexT - indexP - 1;
            
            return middleA != 0 && leftA * middleA == rightA;


        }
    }
}