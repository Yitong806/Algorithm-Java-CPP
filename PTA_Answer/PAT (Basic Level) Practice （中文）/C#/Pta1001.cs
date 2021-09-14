using System;

namespace PTASolution
{
    public class Pta1001
    {
        public void Solution()
        {
            var n = Convert.ToInt32(Console.ReadLine());
            var step = 0;
            while (n!= 1)
            {
                if (n % 2 == 0)
                {
                    n /= 2;
                }
                else
                {
                    n = (3 * n + 1) / 2;
                }

                step++;
                
            }
            Console.WriteLine(step);
        }
    }
}