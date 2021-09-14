using System;
using System.Collections.Generic;
using System.Linq;

namespace PTASolution
{
    public class Pta1002
    {
        public void Solution()
        {
            string nums = Console.ReadLine();
            var sum = 0;
            for (int i = 0; i < nums.Length; i++)
            {
                sum += Convert.ToInt32(nums[i]-'0');
            }

            string result = Convert.ToString(sum);
            List<string> list = new List<string>();

            string[] numStr = new string[] {"ling", "yi", "er", "san", "si", "wu", "liu", "qi", "ba", "jiu"};
            for (int i = 0; i < result.Length; i++)
            {
                int value = Convert.ToInt32(result[i]-'0');
                //Console.WriteLine(value);
                list.Add(numStr[value]);
            }
            Console.WriteLine(String.Join(" ",list));
        }
    }
}