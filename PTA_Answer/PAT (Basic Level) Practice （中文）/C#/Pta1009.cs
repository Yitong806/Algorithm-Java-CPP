using System;

namespace PTASolution
{
    public class Pta1009
    {
        public void Solution()
        {
            string[] lines = Console.ReadLine().Split(" ");
            Array.Reverse(lines);
            Console.WriteLine(String.Join(" ",lines));
        }
    }
}