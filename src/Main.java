import java.util.*;

public class Main {

    public static void main(String[] args) {
        boolean isAnagram = validAnagram("rat", "tar");
        System.out.println("validAnagram(rat, tar): " + isAnagram);
        isAnagram = validAnagram("rat", "cat");
        System.out.println("validAnagram(rat, cat): " + isAnagram);

    }

    /**
     * method checks to see if two strings are anagrams, meaning they have the same letters in any order
     * @param s first string
     * @param t second string
     * @return true if valid anagram, else false
     */
    public static boolean validAnagram(String s, String t) {
        //example: rat, tar == true
        //example: rat, cat == false

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

}

