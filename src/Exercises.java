import java.lang.reflect.Array;
import java.util.*;

public class Exercises {
    public static void main(String[] args) {


        duplicateChar("mustafa");
    }

    static void duplicateCheckerInList(List<Integer> list){
        if (list != null && !list.isEmpty()){
            Set<Integer> duplicate = new HashSet<>();

            for (int i = 0;i<list.size();i++){
                for (int j = i + 1;j<list.size();j++){
                    if (list.get(i) == list.get(j)){
                        duplicate.add(list.get(j));
                    }
                }
            }
            System.out.println("There are "+duplicate.size()+ " duplicate item : "+duplicate);
        }
    }

    // Write a Java Program to check if any number is a magic number or not. A number is said to be a magic number if after doing the sum of digits in each step and in turn doing the sum of digits of that sum, the ultimate result (when there is only one digit left) is 1.
    public static boolean isMagicNumber(int number) {
        while (number > 9) { // Continue the process until there is only one digit left
            int sum = 0;
            while (number > 0) { // Calculate the sum of digits
                sum += number % 10;
                number /= 10;
            }
            number = sum; // Update the number with the sum
        }
        return number == 1; // Check if the final result is 1
    }
    // write a Comparator in Java to compare two employees based upon name,age and address

    // Given an array of non-duplicating numbers from 1 to n where one number is missing, write an efficient java program to find that missing number.
    public static int findMissingNumberTwo(int[] array) {
        int n = array.length + 1; // Expected length of array including the missing number
        int expectedSum = (n * (n + 1)) / 2; // Sum of numbers from 1 to n

        int actualSum = 0;
        for (int num : array) {
            actualSum += num;
        }

        return expectedSum - actualSum;
    }
    // Write a Java program to rotate arrays 90 degree clockwise by taking matrices from user input.
    public static int[][] rotateMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] rotatedMatrix = new int[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                rotatedMatrix[j][rows - 1 - i] = matrix[i][j];
            }
        }

        return rotatedMatrix;
    }
    // Write a Java program to create and throw custom exceptions.
    static void writeCustom(){
        try {
            int age = 10;
            if (age < 18){
                throw new CustomeException("Age must be 18 or above");
            }
            System.out.println("Age is: "+age);
        } catch (CustomeException e) {
            e.printStackTrace();
        }
    }
   // Write a java program to check if any number given as input is the sum of 2 prime numbers.
    static boolean isPrime(int num){
        if (num <= 1){
            return false;
        }
        for (int i = 2;i<=Math.sqrt(num);i++){
            if (num % i == 0){
                return false;
            }
        }
        return true;
    }
    static boolean isSumOfTwoPrimes(int num){
        for (int i = 2;i<= num/2;i++){
            if (isPrime(i) && isPrime(num - i)){
                return true;
            }
        }
        return false;
    }
    // Write a Java program for solving the Tower of Hanoi Problem.
    public static void solveTowerOfHanoi(int numDiscs, char source, char auxiliary, char destination) {
        if (numDiscs == 1) {
            System.out.println("Move disc 1 from " + source + " to " + destination);
            return;
        }

        solveTowerOfHanoi(numDiscs - 1, source, destination, auxiliary);
        System.out.println("Move disc " + numDiscs + " from " + source + " to " + destination);
        solveTowerOfHanoi(numDiscs - 1, auxiliary, source, destination);
    }
    // Implement Binary Search in Java using recursion.
    static int binarySearch(int[] arr,int target,int low,int high){
        if (low > high){
            return -1; // element not found
        }
        int mid = low + (high-low) / 2;
        if (arr[mid] == target){
            return mid; // element found at mid index
        }else if (arr[mid] < target){
            return binarySearch(arr,target,mid + 1,high); // Search in the right half
        }else {
            return binarySearch(arr,target,low,mid - 1); // Search in the left half
        }
    }
    // Write a Java Program to find the factorial of a given number.
    public static long calculateFactorial(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers");
        }

        // Base case: factorial of 0 is 1
        if (number == 0) {
            return 1;
        }

        // Recursive case: factorial(n) = n * factorial(n-1)
        return number * calculateFactorial(number - 1);
    }
    // Write a Java program to check if the two strings are anagrams
    static boolean areAnagrams(String s1,String s2){
        // remove spaces and convert strings to lowercase
        s1 = s1.replaceAll("\\s","").toLowerCase();
        s2 = s2.replaceAll("\\s","").toLowerCase();

        // check if the lengths are equal
        if (s1.length() != s2.length()){
            return false;
        }

        // convert strings to char arrays and sort them
        char[] chr1 = s1.toCharArray();
        char[] chr2 = s2.toCharArray();
        Arrays.sort(chr1);
        Arrays.sort(chr2);

        // compare sorted char arrays
        return Arrays.equals(chr1,chr2);
    }
    // Write a Java Program to print Fibonacci Series using Recursion.
    static int fiboRecursive(int n){
        if (n == 0){
            return 0;
        }else if (n == 1){
            return 1;
        }else {
            return fiboRecursive(n - 1) + fiboRecursive(n -2);
        }
    }
    // Write a program to find the square root of a number.
    static int squareRoot(int number){
        return (int) Math.sqrt(number);
    }
    // Write a program that detects the duplicate characters in a string.
    static void duplicateChar(String str){
        Map<Character,Integer> duplicates = new HashMap<>();

        for (char c : str.toCharArray()){
            if (duplicates.containsKey(c)){
                // If the character is already in the map, increase its number by one
                duplicates.put(c,duplicates.get(c)+1);
            }else {
                // If the character is not in the map, add it to the map and set the number to 1
                duplicates.put(c,1);
            }
        }
        // Looks at each entry in the map to find repeating characters
        for (Map.Entry<Character,Integer> entry : duplicates.entrySet()){
            if (entry.getValue() > 1){
                System.out.println("Character "+ entry.getKey() + " " + entry.getValue() +" times repeats itself");
            }
        }

    }
    // Write a Program to remove duplicates in an ArrayList
    static <T> List<T> removeDuplicates(List<T> list){
        HashSet<T> set = new HashSet<>();
        // list to store unique elements in order
        List<T> uniqueList = new ArrayList<>();

        for (T element: list){
            if (set.add(element)){
                uniqueList.add(element);
            }
        }
        return uniqueList;
    }
    // Find the word count in a string using HashMap Collection
    static HashMap<String,Integer> getWordCount(String input){
        HashMap<String,Integer> wordCount = new HashMap<>();
        String[] words = input.split("\\s+");

        for (String word: words){
            word = word.toLowerCase();
            wordCount.put(word,wordCount.getOrDefault(word,0) + 1);
        }

        for (String w: wordCount.keySet()){
            System.out.println(w + ": "+wordCount.get(w));
        }
        return wordCount;
    }
    // Write a program to find the Second Highest number in an ArrayList
    static int findSecondHighest(ArrayList<Integer> arrayList){
        int max = 0;
        int secondMax = 0;

        for (int number : arrayList){
            if (number > secondMax){
                secondMax = max;
                max = number;
            }else if (number > secondMax && number != secondMax){
                secondMax = number;
            }
        }
        return secondMax;
    }


    /*
     * This method uses bitwise AND (&) operator to check if a number is
     * even or odd in Java
     */
    static void isOddOrEven(int number){
        if((number & 1) == 0){
            System.out.println("Using bitwise operator: "  + number  + " is Even number");
        }else{
            System.out.println("Using bitwise operator: "  + number  + " is Odd number");
        }
    }
    /*
     * checking even and odd number without using modulus or remainder operator, Instead
     * this method uses division operator.
     */
    static void isEvenOrOdd(int number){
        int quotient = number / 2;

        if(quotient*2== number){
            System.out.println("Using division operator: "  + number + " is Even number");

        }else{
            System.out.println("Using division operator: "  + number  + " is Odd number");
        }
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
        int total = (n * (n + 1)) / 2;
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

        if (arr[n - 1] < arr[n - 2]){
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



















