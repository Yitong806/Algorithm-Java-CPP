using System;
using System.Text;

namespace PTASolution
{
    public class Pta1008
    {
        public void Solution()
        {
            string[] nmStr = Console.ReadLine().Split(' ');
            int n = Convert.ToInt32(nmStr[0]);
            int m = Convert.ToInt32(nmStr[1]);

            int moved = m % n;
            int[] array = new int[n];
            string[] strArray = Console.ReadLine().Split(' ');
            for (int i = 0; i < n; i++)
            {
                array[i] = Convert.ToInt32(strArray[i]);
            }

            StringBuilder finalAnswer = new StringBuilder();
            for (int i = n-moved; i < n; i++)
            {
                finalAnswer.Append(array[i]).Append(" ");
            }

            for (int i = 0; i < n-moved; i++)
            {
                finalAnswer.Append(array[i]).Append(" ");
            }
            
            Console.WriteLine(finalAnswer.ToString().Trim());
        }
    }
}