using System;
using System.Collections.Generic;
using System.Linq;

namespace PTASolution
{
    public class Pta1012
    {
        public void Solution()
        {
            List<int> a1 = new List<int>();
            List<int> a2 = new List<int>();
            List<int> a3 = new List<int>();
            List<int> a4 = new List<int>();
            List<int> a5 = new List<int>();

            string[] line = Console.ReadLine().Split(' ');
            int number = Convert.ToInt32(line[0]);
            for (int i = 1; i <= number; i++)
            {
                int x = Convert.ToInt32(line[i]);
                if (x % 2 == 0 && x % 5 == 0)
                {
                    a1.Add(x);
                }

                if (x % 5 == 1)
                {
                    a2.Add(x);
                }

                if (x % 5 == 2)
                {
                    a3.Add(x);
                }

                if (x % 5 == 3)
                {
                    a4.Add(x);
                }

                if (x % 5 == 4)
                {
                    a5.Add(x);
                }
            }

            List<string> result = new List<string>();
            result.Add(a1.Count==0?"N":GetA1Sum(a1).ToString());
            result.Add(a2.Count==0?"N":GetA2Sum(a2).ToString());
            result.Add(a3.Count==0?"N":GetA3Count(a3).ToString());
            result.Add(a4.Count==0?"N":GetA4Average(a4).ToString());
            result.Add(a5.Count==0?"N":GetA5Max(a5).ToString());
            
            Console.WriteLine(string.Join(" ",result));
            
        }

        private int GetA1Sum(List<int>list)
        {
            return list.Sum();
        }

        private int GetA2Sum(List<int> list)
        {
            int sum = 0;
            for (int i = 0; i < list.Count; i++)
            {
                sum += (int)(Math.Pow(-1, i) * list[i]);
            }

            return sum;
        }

        private int GetA3Count(List<int> list)
        {
            return list.Count;
        }

        private double GetA4Average(List<int> list)
        {
            return Double.Parse(string.Format("{0:f1}",list.Average()));
        }

        private int GetA5Max(List<int> list)
        {
            return list.Max();
        }
    }
}