import java.util.*;

public class ExercisesTwo {
    public static void main(String[] args) {

        int[] arr = {1,2,3,5,6,7};


    }
    // Write a Program to remove duplicates in an ArrayList
    static int recursiveFibonacci(int number){
        if (number == 0){
            return 0;
        }else if (number == 1){
            return 1;
        }else {
            return recursiveFibonacci(number - 1) + recursiveFibonacci(number - 2);
        }
    }

    static int findSecondHighest(ArrayList<Integer> arrayList){
        int max = 0;
        int second = 0;

        for (int number : arrayList){
            if (number > second){
                second = max;
                max = number;
            }else if (number > second && number != second){
                second = number;
            }
        }
        return second;
    }
    static void bracketChecker(String str){
        if (str != null && !str.isEmpty()){
            while (str.contains("()") || str.contains("[]") || str.contains("{}")){
                str = str.replace("()","");
                str = str.replace("[]","");
                str = str.replace("{}","");
            }
            if (str.isEmpty()){
                System.out.println("Correct");
            }else {
                System.out.println("Not Correct");
            }
        }
    }
    static boolean hasAllUniqueChars(String word){
        HashSet al = new HashSet();

        for (int index = 0;index<word.length(); index++){
            char c = word.charAt(index);
            // if hashset's add method return false, that means it is already present in HashSet
            if (!al.add(c)){
                return false;
            }
        }
        return true;
    }
    static int fibonacci(int num){
        if (num <= 1){
            return num;
        }
        int fib = 1;int prev = 1;
        for (int i = 2;i<num;i++){
            int temp = fib;
            fib += prev;
            prev = temp;
        }
        return fib;
    }
    static String longestString(String[] str){
        int max = 0;
        String longest = null;

        for (String s : str){
            if (s.length() > max){
                max = s.length();
                longest = s;
            }
        }
        return longest;
    }
    static void reverseArray(int[] arr){
        int start = 0;
        int end = arr.length - 1;
        while (start < end){
            int temp = start;
            start = end;
            end = temp;

            start++;
            end--;
        }
    }
    static int findMissingNumber(int[] arr){
        int length = arr.length + 1;
        int total = (length * (length + 1)) / 2;
        int sum = 0;

        for (int a : arr){
            sum += a;
        }
        int missingNumber = total - sum;

        return missingNumber;
    }
    static int findMiddle(int[] arr){
        int length = arr.length;
        int middle = length / 2;

        if (length % 2 != 0){
            return arr[middle];
        }else {
            return (arr[middle - 1] + arr[middle]) / 2;
        }
    }
    static void findCommondTwoStrings(String s1,String s2){
        Set<Character> set1 = new HashSet<>();
        Set<Character> set2 = new HashSet<>();

        for (char c : s1.toCharArray()){
            set1.add(c);
        }

        for (char c : s2.toCharArray()){
            set2.add(c);
        }
        set1.retainAll(set2);

        for (char c : set1){
            System.out.println(c);
        }
    }
    static void findDuplicateCharacter(String str){
        Map<Character,Integer> duplicates = new HashMap<>();

        for (char c : str.toCharArray()){
            if (duplicates.containsKey(c)){
                duplicates.put(c,duplicates.get(c)+1);
            }else {
                duplicates.put(c,1);
            }
        }

        for (Map.Entry<Character,Integer> entry: duplicates.entrySet()){
            if (entry.getValue() > 1){
                System.out.println("Character "+entry.getKey()+ " "+ entry.getValue() + " times repeats itself");
            }
        }
    }
    static void isPalindrome(int number){
        int reverse = 0;

        while (number != 0){
            reverse = reverse*10 + number%10;
            number /= 10;
        }

        if (reverse == number){
            System.out.println("is palindrome");
        }else {
            System.out.println("not palindrome");
        }
    }
    static int reverseNum(int number){
        int reverse = 0;
        while (number != 0){
            reverse = reverse*10 + number%10;
            number /= 10;
        }
        return reverse;
    }
    static void isArmstrongNumber(int number){
        int sum = 0;

        while (number != 0){
            int remainder = number%10;
            sum += remainder*remainder*remainder;
            number /= 10;
        }

        if (sum == number){
            System.out.println("is armstrong");
        }else {
            System.out.println("is not");
        }
    }
    static void maxOfDigit(int number){
        int max = number%10;

        while (number != 0){
            if (max < number%10){
                max = number%10;
            }
            number /= 10;
        }
        System.out.println("Max -> "+max);
    }
    static void sumOfDigit(int number){
        int sum = 0;

        while (number != 0){
            sum += number%10;
            number /= 10;
        }
        System.out.println("Sum -> "+sum);
    }
    static void countDigit(int number){
        int count = 0;
        while (number != 0){
            count++;
            number /= 10;
        }
        System.out.println("Count -> "+count);
    }
    static void separateEachNumber(int number){
        while (number != 0){
            System.out.println(number%10);
            number /= 10;
        }
    }
    static void findVowelAndConsonant(String text){
        text = text.toLowerCase();
        int countConsonant = 0;
        int countVowel = 0;

        for (int i = 0;i<text.length();i++){
            if (text.charAt(i) >= 'a' && text.charAt(i) <= 'z'){
                if (text.charAt(i) == 'a' || text.charAt(i) == 'e' || text.charAt(i) == 'u' || text.charAt(i) == 'i' || text.charAt(i) == 'o'){
                    countVowel++;
                }else {
                    countConsonant++;
                }
            }
        }
        System.out.println("Consonant Count : "+countConsonant);
        System.out.println("Vowel Count : "+countVowel);
    }
    static void reverseEachWorb(String str){
        String rev= "";
        String[] each_worb = str.split(" ");
        for (int i = 0;i<each_worb.length;i++){
            String worb = each_worb[i];
            String reversed = "";
            for (int j = worb.length()-1;j>=0;j--){
                reversed += worb.charAt(j);
            }
            rev += reversed + " ";
        }
        System.out.println(rev);
    }
    static void reverseWord(String str){
        String rev = "";
        String[] word = str.split("");

        for (int i = str.length()-1;i>=0;i--){
            rev+= word[i];
        }
        System.out.println(rev);
    }
    static void reverseString(String str){
        String rev = "";
        for (int i = str.length()-1;i>=0;i--){
            rev+=str.charAt(i);
        }
        System.out.println(rev);
    }
    static boolean isPalindrome(String str){
        int left = 0;
        int rigth = str.length()-1;

        while (left < rigth){
            if (str.charAt(left) != str.charAt(rigth)){
                return false;
            }
            left++;
            rigth--;
        }

        return true;
    }
}
