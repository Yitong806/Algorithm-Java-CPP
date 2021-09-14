using System;
using System.Collections.Generic;
using System.Linq;

namespace PTASolution
{
    public class Pta1005
    {
        public void Solution()
        {
            int n = Convert.ToInt32(Console.ReadLine());
            string[] nums = Console.ReadLine().Split(' ');
            int[] array = new int[n];
            for (int i = 0; i < n; i++)
            {
                array[i] = Convert.ToInt32(nums[i]);
            }

            HashSet<int> usedNumbers = new HashSet<int>();
            HashSet<int> unusedNumbers = new HashSet<int>();

            foreach (int num in array)
            {
                int nx = num;
                int count = 0;
                while (true)
                {
                    if (usedNumbers.Contains(nx))
                    {
                        break;
                    }

                    if (count != 0)
                    {
                        usedNumbers.Add(nx);
                    }

                    if (nx % 2 == 0)
                    {
                        nx = nx / 2;
                    }
                    else
                    {
                        nx = (3 * nx + 1) / 2;
                    }

                    if (usedNumbers.Contains(nx))
                    {
                        break;
                    }

                    count++;
                }
            }

            foreach (int nx in array)
            {
                if (!usedNumbers.Contains(nx))
                {
                    unusedNumbers.Add(nx);
                }
            }

            int[] elements = unusedNumbers.ToArray();
            Array.Sort(elements);
            Array.Reverse(elements);
            for (int i = 0; i < elements.Length; i++)
            {
                Console.Write(elements[i]);
                if (i != elements.Length - 1)
                {
                    Console.Write(' ');
                }
            }
        }
    }
}