using System;

namespace PTASolution
{
    public class Pta1004
    {
        public void Solution()
        {
            int n = Convert.ToInt32(Console.ReadLine());
            string minName = null;
            string maxName = null;
            string minId = null;
            string maxId = null;
            int min = Int32.MaxValue;
            int max = -1;

            for (int i = 0; i < n; i++)
            {
                string s = Console.ReadLine();
                string[] strs = s.Split(' ');
                int score = Convert.ToInt32(strs[2]);
                if (score > max)
                {
                    maxName = strs[0];
                    maxId = strs[1];
                    max = score;
                }
                if (score < min)
                {
                    minName = strs[0];
                    minId = strs[1];
                    min = score;
                }
            }
            
            Console.WriteLine(maxName+" "+maxId);
            Console.WriteLine(minName+" "+minId);
        }
    }
}