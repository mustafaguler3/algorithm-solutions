import java.util.*;

public class Exercises {
    public static void main(String[] args) {

        fibonacci(12);
    }

    static int fibonacci(int num){
        if (num <= 1){
            return num;
        }
        int f = 1,prev = 1;
        for (int i = 2;i<num;i++){
            int temp = f;
            f += prev;
            prev = temp;
        }
        return f;
    }
    static char maxOccuringChar(String message){
        int[] ctr = new int[256];
        int max = 0;
        char result = ' ';

        for(int i=0;i<message.length();i++){
            ctr[message.charAt(i)]++;
            for(int j = 0;j<message.length();j++){
                if(ctr[message.charAt(j)] > max){
                    max = ctr[message.charAt(j)];
                    result = message.charAt(j);
                }
            }
        }
        return result;
    }
    static void noRepeatingValueInString(String text){
        for (int i = 0;i<text.length();i++){
            boolean unique = true;
            for (int j = i + 1;j<text.length();j++){
                if (text.charAt(i) == text.charAt(j) && i != j){
                    System.out.println("not Uniqe : "+text.charAt(i));
                    break;
                }
            }
            if (unique){
                System.out.println("Unique : "+text.charAt(i));
                break;
            }
        }
    }

    static String longestString(String[] arr){
        int max = 0;
        String longest = null;
        for (String s: arr){
            if (s.length() > max){
                max = s.length();
                longest = s;
            }
        }
        System.out.println("Max :"+max);
        return longest;
    }

    static String swapStringChar(String str){
        StringBuilder swapped = new StringBuilder();
        for (int i = 0;i<str.length();i++){
            char c = str.charAt(i);

            if (Character.isUpperCase(c)){
                swapped.append(Character.toLowerCase(c));
            }else if (Character.isLowerCase(c)){
                swapped.append(Character.toUpperCase(c));
            }else {
                swapped.append(c);
            }
        }
        return swapped.toString();
    }

    static void randomNumber(Random random){
        int[] arr = new int[6];

        for (int i = 0;i<arr.length;i++){
            arr[i] = random.nextInt(10);
        }
        for (int i = 0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }

    static void reverseArraylist(ArrayList<Integer> arrayList){
        int start = 0;
        int end = arrayList.size()-1;

        while (start < end){
            int temp = arrayList.get(start);
            arrayList.set(start,arrayList.get(end));
            arrayList.set(end,temp);

            start++;
            end--;
        }
    }

    static void reverseArray(int[] arr){
        int start = 0;
        int end = arr.length-1;

        while (start < end){
            int temp = start;
            start = end;
            end = temp;

            start++;
            end--;
        }
        System.out.println(arr);
    }

    static void reverseValue(int num){
        int rev = 0;
        while (num != 0){
            rev = rev*10 + num % 10;
            num /= 10;
        }
        System.out.println("Reversed : "+rev);
    }

    static String removeDuplicate(String text){
        String temp = " ";

        for (int i = 0;i<text.length();i++){
            if (!temp.contains(text.charAt(i)+"")){
                temp += text.charAt(i)+"";
            }
        }
        return temp;
    }

    static int findMissingNumber(int[] arr){
        int n = arr.length + 1;
        int total = n * (n + 1) / 2;
        int arraySum = 0;

        for (int num : arr){
            arraySum += num;
        }

        int missing = total - arraySum;

        return missing;
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

    static boolean isSorted(int[] arr,int n){
        if (n == 0 || n == 1){
            return true;
        }

        if (arr[n - 1] < arr[n -2]){
            return false;
        }

        return isSorted(arr,n-1);
    }

    static void findDuplicatesInArray(int[] arr){
        HashMap<Integer,Integer> duplicates = new HashMap<>();

        for (Integer i : arr){
            if (duplicates.containsKey(i)){
                duplicates.put(i,duplicates.get(i)+1);
            }else {
                duplicates.put(i,1);
            }
        }

        for (Map.Entry<Integer,Integer> entry : duplicates.entrySet()){
            if (entry.getValue() > 1){
                System.out.println("the number "+entry.getKey() + " repeats " +entry.getValue()+ " times");
            }
        }
    }

    static int greatestDifference(int[] arr){
        int gFifference = 0;

        for (int i =0;i<arr.length-1;i++){
            if (arr[i + 1] > arr[i]){
                int difference = arr[i+1] - arr[i];

                if (difference > gFifference){
                    gFifference = difference;
                }
            }
        }
        return gFifference;
    }
    static void findCommonCharAmongTwoString(String str1,String str2){
        Set<Character> set1 = new HashSet<>();
        Set<Character> set2 = new HashSet<>();

        for (char c : str1.toCharArray()){
            set1.add(c);
        }

        for (char c: str2.toCharArray()){
            set2.add(c);
        }

        set1.retainAll(set2);

        System.out.println("Common Character");

        for (char c : set1){
            System.out.println(c);
        }
    }
    static void findDuplicateCharacter(String str){
        HashMap<Character,Integer> duplicates = new HashMap<>();

        for (char ch : str.toCharArray()){
            if (duplicates.containsKey(ch)){
                duplicates.put(ch,duplicates.get(ch)+1);
            }else {
                duplicates.put(ch,1);
            }
        }

        for (Map.Entry<Character,Integer> entry : duplicates.entrySet()){
            if (entry.getValue() > 1){
                System.out.println("Karakter "+entry.getKey()+ " " + entry.getValue() + " kez tekrar ediyor");
            }
        }

    }

    /*

     *********
      *******
       *****
        ***
         *

     */
    static void reverseFullTriagle(){
        for (int i = 5;i>=1;i--){

            for (int s = 1;s<=5-i;s++){
                System.out.print(" ");
            }

            for (int j = 1;j<=2*i-1;j++){
                System.out.print("*");
            }

            System.out.println();
        }
    }
    /*
       *
      ***
     *****
    *******
   *********
     */
    static void fullTriagle(){
        for (int i = 0;i<=5;i++){

            for (int s = 0;s<5-i;s++){
                System.out.print(" ");
            }

            for (int j = 1;j<=2*i-1;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    /*
    1
    12
    123
    1234
    12345
     */
    static void leftPattern(){
        for (int i = 0;i<=5;i++){

            for (int j = 1;j<=i;j++){
                System.out.print(j);
            }
            System.out.println();
        }
    }
    /*
        1
       22
      333
     4444
    55555
     */
    static void rigthPattern(){
        for (int i = 1;i<=5;i++){

            for (int s = 0;s<5-i;s++){
                System.out.print(" ");
            }

            for (int j = 0;j<i;j++){
                System.out.print(i);
            }
            System.out.println();
        }
    }
    static void isPalindrome(int num){
        int rev = 0;
        int temp = num;

        while (num != 0){
            rev = rev*10 + num%10;
            num /= 10;
        }

        if (rev == temp){
            System.out.println("is palindrome");
        }else {
            System.out.println("not palindrome");
        }
    }
    static void reverseNumber(int num){
        int rev = 0;

        while (num != 0){
            rev = rev*10 + num%10;
            num /= 10;
        }
        System.out.println(num +" Reversed is "+rev);
    }
    static void isArmstrong(int num){
        int sum = 0;
        int length = String.valueOf(num).length();
        int temp = num;

        while (temp != 0){
            int remainder = temp%10;
            sum += Math.pow(remainder,length);
            temp /= 10;
        }
        if (sum == num){
            System.out.println("is armstrong");
        }else {
            System.out.println("is not armstrong");
        }
    }
    static void maxOfDigit(int num){
        int max = num % 10;
        while (num > 0){
            if (max < num % 10){
                max = num % 10;
            }
            num /= 10;
        }
        System.out.println("Max Digit => "+max);
    }
    static void sumOfDigit(int num){
        int sum = 0;
        while (num > 0){
            sum += num%10;
            num /= 10;
        }
        System.out.println("sum of digits : "+sum);
    }
    static void countDigit(int num){
        int count = 0;

        while (num > 0){
            num /= 10;
            count++;
        }
        System.out.println("-> "+count);
    }
    static void seperateEachNumber(int num){

        while (num != 0){
            System.out.println(num%10);
            num /= 10;
        }

    }
    static int[] vowelAndConsonant(String text){
        text = text.toLowerCase();
        int countConsonant = 0;
        int countVowel = 0;

        for (int i = 0;i<text.length();i++){
            if (text.charAt(i) >= 'a' && text.charAt(i) <= 'z'){
                if (text.charAt(i) == 'a' || text.charAt(i) == 'e' || text.charAt(i) == 'u'){
                    countVowel++;
                }else {
                    countConsonant++;
                }
            }
        }
        return new int[]{countVowel,countConsonant};
    }
    static void findMaximumInThreeNumbers(int a,int b,int c){
        if (a > b && a > c){
            System.out.println(a);
        }else if (b > c){
            System.out.println(b);
        }else {
            System.out.println(c);
        }
    }
    static void swapWithoutUsingThird(int x,int y){
        System.out.println("x :"+x);
        System.out.println("y : "+y);

        x = x + y;
        y = x - y;
        x = x - y;

        System.out.println("x :"+x);
        System.out.println("y : "+y);
    }
    static void swapNumbers(int x,int y){
        System.out.println("x : "+x);
        System.out.println("y : "+y);

        int temp = x;
        x = y;
        y = temp;

        System.out.println("x : "+x);
        System.out.println("y : "+y);
    }
    static void maxSecondNumberInArray(int[] arr){

        for (int i = 0;i<arr.length-1;i++){
            for (int j = i+1;j<arr.length-1;j++){
                if (arr[i] > arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println("Second Max : "+arr[arr.length-2]);
    }
    static void reverseEachWord(String str){
        String rev = "";
        String[] each_word = str.split(" ");
        for (int i = 0;i<each_word.length;i++){

            String word = each_word[i];
            String revWorb = "";

            for (int j = word.length()-1;j>=0;j--){
                revWorb += word.charAt(j);
            }
            rev += revWorb + " ";
        }
        System.out.println(rev);
    }
    static String reverseEachWordSimp(String str){
        String rev = "";
        String[] word = str.split("");
        for (int i = str.length()-1;i>=0;i--){
            rev += word[i];
        }
        return rev;
    }
    static String reverseString(String str){
        String rev = "";
        for (int i =str.length()-1;i>=0;i--){
            rev += str.charAt(i);
        }
        return rev;
    }
    static boolean isPalindrome(String str){
        int left = 0;
        int rigth = str.length() - 1;

        while (left < rigth){
            if(str.charAt(left) != str.charAt(rigth)){
                return false;
            }
            left++;
            rigth--;
        }
        return true;
    }
}



















