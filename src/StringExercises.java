import java.util.*;

public class StringExercises {
    public static void main(String[] args) {

    }

    // Palindrome kontrolü yapan metod
    static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false; // Karakterler eşleşmiyorsa palindrome değil
            }
            left++;
            right--;
        }
        return true; // Tüm karakterler eşleşiyorsa palindrome
    }

    //fibonacci
    static int fibonacci(int num) {
        if (num <= 1) {
            return num;
        }
        int fib = 1, prevFib = 1;
        for (int i = 2; i < num; i++) {
            int temp = fib;
            fib += prevFib;
            prevFib = temp;
        }
        return fib;
    }

    //tekrar etmeyen değer
    static void noRepeating(String str){
        for (int i = 0;i<str.length();i++){
            boolean unique = true;
            for (int j = 0;j < str.length(); j++){
                if (i != j && str.charAt(i) == str.charAt(j)){
                    unique = false;
                    break;
                }
            }
            if (unique){
                System.out.println("Unique value -> "+str.charAt(i));
                break;
            }
        }
    }

    // string de tekrar eden değerleri bul
    static void findDuplicateInString(String str){
        HashMap<Character,Integer> countMap = new HashMap<>();

        for (char c : str.toCharArray()){
            if (countMap.containsKey(c)){
                countMap.put(c,countMap.get(c) + 1);
            }else {
                countMap.put(c,1);
            }
        }

        for (Map.Entry<Character,Integer> entry : countMap.entrySet()){
            if (entry.getValue() > 1){
                System.out.println("Karakter '" + entry.getKey() + "' " + entry.getValue() + " kez tekrar ediyor.");
            }
        }

    }

    //asal sayı kontrolü
    static boolean primeNumber(int number){
        boolean isPrime = true;
        for (int i = 2;i < number;i++){
            if (number % i == 0){
                isPrime = false;
                break;
            }
        }
        return isPrime;
    }

    //recursive fonkiyon ile factoriyel hesabı
    static int recursiveFactorial(int number){
        if (number == 1 || number == 0){
            return 1;
        }
        return number * recursiveFactorial(number - 1);
    }

    // string kelime ters çevirme
    static void reverseEWord(String str){
        if (!str.isEmpty() && str != null){
            String rev = "";
            String[] arr = str.split("");

            for (int i = str.length()-1;i>=0;i--){
                rev += arr[i] ;
            }

            System.out.println("Reversed word : "+rev);
        }
    }
    //string ifadeyi ters çevirme
    static void reverseString(String str){
        String rev = "";
        for (int i = str.length() - 1;i>=0; i--){
            char ch = str.charAt(i);
            rev += ch;
        }
        System.out.println(rev);
    }
    // listedeli aynı elemanları bulma
    static void duplicate(List<Integer> list){
        if (!list.isEmpty() && list != null){
            HashSet<Integer> duplicates = new HashSet<>();
            for (int i = 0;i<list.size(); i++){
                for (int j = i + 1; j < list.size(); j++){
                    if (list.get(i).equals(list.get(j))){
                        duplicates.add(list.get(i));
                    }
                }
            }
            System.out.println("Duplicates : "+duplicates);
        }else {
            System.out.println("list is empty");
        }
    }
    // parantez kontrolü (bracketChecker)
    static void bracketChecker(String str){
        if (str != null && !str.isEmpty()){
            while (str.contains("()") || str.contains("[]") || str.contains("{}")){
                str = str.replace("()","");
                str = str.replace("[]","");
                str = str.replace("{}","");
            }
            if (str.isEmpty()){
                System.out.println("correct");
            }else {
                System.out.println("not correct");
            }
        }
    }
    // perfect number (muhteşem sayı)
    static void perfectNumber(int number){
        if (number > 1){
            int sum = 0;

            for (int i = 1;i<number;i++){
                if (number % i == 0){
                    sum += i;
                }
            }
            if (sum == number){
                System.out.println("it's a perfect number");
            }else {
                System.out.println("it's not a perfect number");
            }
        }
    }
    // üçüncü değişken kullanmadan sayıların değerini değiştirme
    static void changeValues(){
        int x = 5;
        int y = 7;

        System.out.println("x= "+ x +" y=" +y);

        x = x + y;
        y = x - y;
        x = x - y;

        System.out.println("after : x="+x + " y="+y);
    }
    // listede en büyük en küçük değeri bulma
    static void biggest(List<Integer> list){
        if (!list.isEmpty() && list != null){
            int biggest = list.get(0);

            for (int i = 0;i < list.size(); i++){
                if(list.get(i) > biggest){
                    biggest = list.get(i);
                }
            }
            System.out.println("Biggest : "+biggest);
        }else {
            System.out.println("list is empty");
        }
    }
    static void smallest(List<Integer> list){
        if (!list.isEmpty() && list != null){
            int smallest = list.get(0);

            for (int i = 0;i<list.size(); i++){
                if (smallest > list.get(i)){
                    smallest = list.get(i);
                }
            }
            System.out.println("Smallest value : "+smallest);

        }else {
            System.out.println("list is empty");
        }
    }
    //
    //
    //
    public static String LetterCount(String str) {

        int count =0,temp=0;
        String[] wordList = str.split(" ");
        String word = wordList[0];

        for(int i=0;i<wordList.length;i++){
            for(int j=0;j<wordList[i].length();j++){
                temp = 0;
                for(int k=0;k<wordList[i].length();k++){
                    if(wordList[i].charAt(j) == wordList[i].charAt(k)){
                        temp++;
                    }
                }
                if(count < temp){
                    count = temp;
                    word = wordList[i];
                    temp=0;
                }
            }
        }
        if(count == 1){
            return "-1";
        }
        str = word;

        return str;
    }

    public static String SwapCase(String str) {

        for(int i=0;i<str.length();i++){
            if(str != null){
                str.toUpperCase();
            }else{
                str.toLowerCase();
            }
        }

        return str;
    }

    public static void findDuplicates(String str) {
        // Karakterlerin sayısını saklamak için bir HashMap kullanılır
        Map<Character, Integer> charCountMap = new HashMap<>();

        // String içindeki her bir karakter için döngü
        for (char c : str.toCharArray()) {
            // Eğer karakter zaten harita içinde varsa, sayısını bir artır
            if (charCountMap.containsKey(c)) {
                charCountMap.put(c, charCountMap.get(c) + 1);
            } else {
                // Eğer karakter harita içinde yoksa, haritaya ekle ve sayısını 1 yap
                charCountMap.put(c, 1);
            }
        }

        // Tekrar eden karakterleri bulmak için haritadaki her bir girdiye bakılır
        for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println("Karakter '" + entry.getKey() + "' " + entry.getValue() + " kez tekrar ediyor.");
            }
        }
    }

    public static String letterCapitalize(String str) {
        char[] temp = str.toCharArray();
        boolean foundSpace = true;
        for (int i=0;i<temp.length;i++){
            if(Character.isLetter(temp[i])){
                if (foundSpace){
                    temp[i] = Character.toUpperCase(temp[i]);
                    foundSpace = false;
                }
            }else {
                foundSpace = true;
            }
            str = String.valueOf(temp);
        }
        return str;
    }

    public static void reverseEachWord(String str){
        String[] each_word = str.split(" ");
        String rev = "";
        for(int i=0;i<each_word.length;i++){
            String word = each_word[i];
            String revWord = "";
            for(int j = word.length()-1;j>=0;j--){
                revWord += word.charAt(j);
            }
            rev += revWord + " ";
        }
        System.out.println(rev);
    }

    public static String reverseWord(String word){
        StringBuilder sb = new StringBuilder(word);
        String rev = sb.reverse().toString();
        String[] words = rev.split("");
        StringBuilder reverseWord = new StringBuilder();
        for(String temp : words){
            sb = new StringBuilder(temp);
            reverseWord.append(sb.reverse()+" ");
        }
        return reverseWord.toString();
    }

    public static char maxOccuringChar(String message){
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

    static boolean hasAllUniqueChars(String word){
        HashSet alphaset = new HashSet();
        for (int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(!alphaset.add(c)){
                return false;
            }
        }
        return true;
    }

    public static void noRepeatingValue(String message){
        for (int i=0;i<message.length();i++){
            boolean unique = true;
            for (int j = 0;j<message.length();j++){
                if(i!=j && message.charAt(i) == message.charAt(j)){
                    unique = false;
                    break;
                }
            }
            if(unique){
                System.out.print("unique => "+message.charAt(i));
                break;
            }
        }

    }
    static void longestSubstring(String input){
        char[] arr = input.toCharArray();
        String long_str = null;
        int str_length = 0;

        LinkedHashMap<Character,Integer> charPost = new LinkedHashMap<>();
        for (int i=0;i<arr.length;i++){
            char ch = arr[i];
            if(!charPost.containsKey(ch)){
                charPost.put(ch,i);
            }else{
                i = charPost.get(ch);
            }
        }
        if(charPost.size() > str_length){
            str_length = charPost.size();
            long_str = charPost.keySet().toString();
        }


        System.out.println("Input String : "+input);
        System.out.println("The longest substring : "+long_str);
        System.out.println("The longest substring length : "+str_length);
    }

    static String longestStringInStringArray(String[] strs){
        int max = 0;
        String longest = null;
        for (String s : strs){
            if(s.length() > max){
                max = s.length();
                longest = s;
            }
        }
        return longest;
    }

    static String reverseStringRecursive(String str){
        if(str.length() == 1){
            return str;
        }
        return str.charAt(str.length()-1) + reverseStringRecursive(str.substring(0,str.length()-1));
    }
    static void reverseString2(String str){
        StringBuilder builder = new StringBuilder(str);

        System.out.print(builder.reverse());
    }
    static void reverseString1(String str){
        String rev = "";
        for (int i=str.length()-1;i>=0;i--){
            char ch = str.charAt(i);
            System.out.print(ch);
        }
    }
}
