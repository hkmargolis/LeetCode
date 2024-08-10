import java.util.*;

public class Main {

    public static void main(String[] args) {
        //---------------------------------------------------
        boolean isAnagram = validAnagram("rat", "tar");
        System.out.println("validAnagram(rat, tar): " + isAnagram);
        isAnagram = validAnagram("rat", "cat");
        System.out.println("validAnagram(rat, cat): " + isAnagram);
        //---------------------------------------------------
        int[] twoSumSolution = twoSum(new int[]{2,1,5,3}, 4);
        System.out.println("twoSum({2,1,5,3}, 4): " + "indices [" +  twoSumSolution[0] + ", " + twoSumSolution[1] + "]");
        //---------------------------------------------------
        int maxSubArray = maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4});
        System.out.println("maxSubArray({-2,1,-3,4,-1,2,1,-5,4}) sum: " + maxSubArray);
    }

    /**
     * method checks to see if two strings are anagrams, meaning they have the same letters in any order
     * @param s first string
     * @param t second string
     * @return true if valid anagram, else false
     */
    public static boolean validAnagram(String s, String t) {
        //method 1---------------------------------------------------
        //time complexity: O(s+t)
        //memory complexity: O(s+t)
//        boolean isAnagram = false;
//        HashMap<Character, Integer> lettersInS = new HashMap<Character, Integer>();
//        HashMap<Character, Integer> lettersInT = new HashMap<Character, Integer>();
//
//        //if strings are the same length, count occurrence of each letter
//        if(s.length() == t.length()) {
//            for (int i = 0; i < s.length(); i++) {
//                //string s
//                if (!lettersInS.containsKey(s.charAt(i))) {
//                    lettersInS.put(s.charAt(i), 0);
//                }else {
//                    int count = lettersInS.get(s.charAt(i));
//                    count++;
//                    lettersInS.put(s.charAt(i), count);
//                }
//                //string t
//                if (!lettersInT.containsKey(t.charAt(i))) {
//                    lettersInT.put(t.charAt(i), 0);
//                }else {
//                    int count = lettersInT.get(t.charAt(i));
//                    count++;
//                    lettersInT.put(t.charAt(i), count);
//                }
//            }
//            //check if occurrences are equals in both s and t
//           for(int i = 0; i < s.length(); i++) {
//               char current = s.charAt(i);
//               if(!Objects.equals(lettersInS.get(current), lettersInT.get(current))) {
//                   return false;
//               }
//           }
//        } else{
//            //strings are not equal in length --> not anagrams
//            return false;
//        }
//        return true;

        //method 2---------------------------------------------------
        //time complexity: O(1)
        //memory complexity: O(1)
        //string s
        char[] sArr = s.toCharArray();
        //sort s array
        Arrays.sort(sArr);

        //string t
        char[] tArr = t.toCharArray();
        Arrays.sort(tArr);

        //return if they are equal
        return Arrays.equals(sArr, tArr);

    }

    /**
     * method solves two sum problem
     * @param values an integer array
     * @param target an integer value
     * @return an integer array of two indices
     */
    public static int[] twoSum(int[] values, int target) {
        //given an array of integers, return indices of the two numbers such that they add up to a certain target
        //can assume exactly one solution

        //method 1---------------------------------------------------
        //worst case time complexity: O(n^2)
        //compare every two digits

        //method 2---------------------------------------------------
        //create a hashmap int val: index in int[]
        HashMap<Integer, Integer> vals = new HashMap<>();
        for(int i = 0; i < values.length; i++) {
            if(vals.containsKey(target-values[i])) {
                return new int[]{i, vals.get(target-values[i])};
            }else{
                vals.put(values[i], i);
            }
        }
        return null;
    }

    /**
     * method returns sum of max sub array of integers
     * @param array of integers
     * @return integer sum
     */
    public static int maxSubArray(int[] array) {
        //find the contiguous subarray that has the largest sum
        //can assume array is not empty

        //method 1---------------------------------------------------
        //time complexity: O(n^3) 3 for loops
        //for loop i (start of array)
        //nested for loop j (end of array)
        //nested for loop k (i-->j) sums subarray

        //method 2---------------------------------------------------
        //time complexity: O(n^2)
        //for loop i (start of array)
        //nested for loop j (end of array) within this loop add j to sum

        //method 3---------------------------------------------------
        //time complexity: O(n)
        //"sliding window" problem
        int maxSub = array[0];
        int sum = 0;
        for(int num : array) {
            if(sum < 0) {
                sum = 0;
            }
            sum += num;
            if(maxSub < sum) {
                maxSub = sum;
            }
        }return maxSub;
    }

}

