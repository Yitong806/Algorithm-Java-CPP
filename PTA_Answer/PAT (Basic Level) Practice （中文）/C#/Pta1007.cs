using System;
using System.Diagnostics.Contracts;
using System.Xml.Xsl;

namespace PTASolution
{
    public class Pta1007
    {
        public void Solution()
        {
            int n = Convert.ToInt32(Console.ReadLine());
            int[] primeNumbers = new int[n];
            int index = 0;

            for (int i = 2; i <= n; i += 2)
            {
                if (i == 2)
                {
                    primeNumbers[index] = i;
                    index++;
                    i = 1;
                }
                else
                {
                    if (i % 2 == 0)
                    {
                        continue;
                    }

                    for (int j = 3; j <= Math.Sqrt(i); j += 2)
                    {
                        if (i % j == 0)
                        {
                            goto fail;
                        }
                    }

                    primeNumbers[index] = i;
                    index++;
                    continue;

                    fail:
                    continue;
                }
            }

            int result = 0;
            for (int i = 0; i < primeNumbers.Length - 1; i++)
            {
                //Console.WriteLine(primeNumbers[i]);
                if (primeNumbers[i + 1] - primeNumbers[i] == 2)
                {
                    result++;
                }
            }

            Console.WriteLine(result);
        }
    }
}