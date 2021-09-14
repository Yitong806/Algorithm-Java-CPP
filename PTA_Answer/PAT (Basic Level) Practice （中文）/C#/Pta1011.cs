using System;

namespace PTASolution
{
    public class Pta1011
    {
        public void Solution()
        {
            int t = Convert.ToInt32(Console.ReadLine());
            for (int i = 1; i <= t; i++)
            {
                string[] numStrings = Console.ReadLine().Split(' ');
                long a = Convert.ToInt64(numStrings[0]);
                long b = Convert.ToInt64(numStrings[1]);
                long c = Convert.ToInt64(numStrings[2]);
                Console.WriteLine("Case #"+i+": "+(a+b>c?"true":"false"));
            }
        }
    }
}