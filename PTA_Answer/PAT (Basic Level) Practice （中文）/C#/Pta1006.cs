using System;
using System.Collections.Generic;
using System.Linq;

namespace PTASolution
{
    public class Pta1006
    {
        public void Solution()
        {
            int x = Convert.ToInt32(Console.ReadLine());
            int[] eachPlaces = {x/100,x%100/10,x%10};
            for (int i = 0; i < eachPlaces[0]; i++)
            {
                Console.Write("B");
            }

            for (int i = 0; i < eachPlaces[1]; i++)
            {
                Console.Write("S");
            }

            for (int i = 0; i < eachPlaces[2]; i++)
            {
                Console.Write(Convert.ToString(i+1));
            }
            Console.WriteLine();
        }
    }
}