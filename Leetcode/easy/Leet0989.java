package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class Leet0989 {
    public List<Integer> addToArrayForm(int[] num, int k) {
        int kArrayLength = intLength(k);
        if(kArrayLength >= num.length){
            int m = array2int(num);
            k += m;
            return int2List(k);
        }else {
            int[] arrayK = int2array(k);
            int[] added = addArray(num, arrayK);
            return array2List(added);
        }
    }

    private int intLength(int k){
        if(k < 10){
            return 1;
        }else if(k < 100){
            return 2;
        }else if(k < 1000){
            return 3;
        }else if(k < 10000){
            return 4;
        }else {
            return 5;
        }
    }

    private int array2int(int[] arr){
        int result = 0, pow = 1;
        for (int i = arr.length - 1; i >= 0 ; i--) {
            result += arr[i] * pow;
            pow *= 10;
        }
        return result;
    }

    private List<Integer> int2List(int k){
        List<Integer> result = new ArrayList<>();
        for (char c: String.valueOf(k).toCharArray()){
            result.add(c - '0');
        }
        return result;
    }

    private List<Integer> array2List(int[] arr){
        List<Integer> result = new ArrayList<>();
        boolean firstNon0 = false;
        for (int x: arr){
            if(x != 0){
                firstNon0 = true;
            }

            if(firstNon0){
                result.add(x);
            }
        }

        return result;
    }

    private int[] int2array(int k){
        return int2List(k).stream().mapToInt(Integer::intValue).toArray();
    }

    private int[] fitLength(int[] origin, int expectedLength){

        if(origin.length >= expectedLength){
            return origin;
        }

        int[] newArray = new int[expectedLength];
        System.arraycopy(origin, 0, newArray, expectedLength - origin.length, origin.length);
        return newArray;
    }

    private int[] addArray(int[] array1, int[] array2){
        int expectedLength = Math.max(array1.length, array2.length);
        int[] fit1 = fitLength(array1, expectedLength), fit2 = fitLength(array2, expectedLength);

        int[] result = new int[expectedLength + 1];
        int carry = 0, index = expectedLength - 1;
        while (index >= 0 || carry != 0){
            if(index < 0){
                result[0] = carry;
                carry = 0;
                break;
            }

            int value = (carry + fit1[index] + fit2[index]) % 10;
            carry = (carry + fit1[index] + fit2[index]) / 10;
            result[index + 1] = value;
            index--;
        }

        return result;
    }
}
