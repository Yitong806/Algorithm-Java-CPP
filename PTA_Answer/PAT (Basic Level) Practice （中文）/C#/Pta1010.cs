using System;
using System.Text;
using System.Text.RegularExpressions;

namespace PTASolution
{
    public class Pta1010
    {
        public void Solution()
        {
            string line = Console.ReadLine();
            
            if (line == null)
            {
                Console.WriteLine("0 0");
                return;
            }
            Regex replaceSpace = new Regex(@"\s{1,}", RegexOptions.IgnoreCase);
            line = replaceSpace.Replace(line, " ").Trim();
            string[] elementStrs = line.Split();
            int[] numbers = new int[elementStrs.Length];
            for (int i = 0; i < elementStrs.Length; i++)
            {
                numbers[i] = Convert.ToInt32(elementStrs[i]);
            }

            StringBuilder resultBuilder = new StringBuilder();
            for (int index = 0; index < numbers.Length; index+=2)
            {
                int coe = numbers[index];
                int exp = numbers[index + 1];
                if (exp >= 1)
                {
                    resultBuilder.Append(coe * exp).Append(" ").Append(exp - 1).Append(" ");
                }
            }

            if (resultBuilder.Length == 0)
            {
                Console.WriteLine("0 0");
            }
            else
            {
                Console.WriteLine(resultBuilder.ToString().Trim());
            }
            
            
        }
    }
}