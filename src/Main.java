import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        String str = "Test"; // return tEST
        String word = "I like CODing";

        String result = swapCase(word);

        System.out.println(result);
    }

    // rotate array to the right
    public static void rotateRight(int[] arr, int k) {
        int length = arr.length;
        if (length == 0) {
            return;
        }
        k = k % length; // Döndürme miktarını dizinin uzunluğuna mod alarak sınırlayalım
        reverse(arr, 0, length - 1); // Tüm diziyi tersine çevir
        reverse(arr, 0, k - 1); // İlk k elemanı tersine çevir
        reverse(arr, k, length - 1); // Geri kalan elemanları tersine çevir
    }

    public static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    // well formed brackets
    static boolean isWellFormed(String s){
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()){
            if (c == '(' || c == '[' || c == '{'){
                stack.push(c);
            }else {
                if (stack.isEmpty()){
                    return false;// Closing bracket encountered without corresponding opening bracket
                }
                char top = stack.pop();
                if ((c == ')' && top != '(') ||
                        (c == ']' && top != '[') ||
                        (c == '}' && top != '{')) {
                    return false; // Mismatched opening and closing brackets
                }
            }
        }
        return stack.isEmpty(); // All opening brackets have been matched
    }

    // Swap cases of characters
    // M -> m , mustafa -> MUSTAFA
    static String swapCase(String str){
        StringBuilder swappedStr = new StringBuilder();
        for (int i = 0;i<str.length();i++){
            char c = str.charAt(i);

            if (Character.isUpperCase(c)){
                swappedStr.append(Character.toLowerCase(c));
            }else if(Character.isLowerCase(c)){
                swappedStr.append(Character.toUpperCase(c));
            }else {
                swappedStr.append(c);
            }
        }
        return swappedStr.toString();
    }

    // Generate Random Number - PrintRange method
    static int printRange(int start,int end){
        int distance = end - start + 1;

        return (int) ((Math.random() * distance) + start);
    }
    static void generateRandomNumber(){
        Random random = new Random();

        System.out.println(random.nextInt(10));

        int[] array = new int[10];
        for (int i = 0; i < 10; i++) {
            array[i] = random.nextInt(10);
        }
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

        int start = 1;int end = 10;

        System.out.println(printRange(start, end));

        int[] array2 = new int[10];
        for (int i = 0; i < array2.length; i++) {
            array2[i] = printRange(start, end);
        }
        System.out.println(Arrays.toString(array2));
        for (int i = 0; i < array2.length; i++) {
            System.out.print(array2[i] + " ");
        }
    }

    // reverse arraylist without using Collections.reverse()
    static void reverseArrayList(ArrayList<Integer> arrayList){
        int start = 0;
        int end = arrayList.size()-1;

        while (start < end){
            // Başlangıç ve bitiş indekslerini kullanarak elemanları yer değiştir
            int temp = arrayList.get(start);
            arrayList.set(start,arrayList.get(end));
            arrayList.set(end,temp);

            // update index
            start++;
            end--;
        }
    }

    // reverse arraylist siple
    static void reverseArraylistSimple(){
        // Örnek bir ArrayList oluşturalım
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);

        // ArrayList'i tersine çevirelim
        Collections.reverse(arrayList);

        // Tersine çevrilmiş ArrayList'i yazdıralım
        System.out.println("Tersine çevrilmiş ArrayList: " + arrayList);
    }

    //reverse an array
    static void reverseArray(int[] arr){
        int start = 0;
        int end = arr.length-1;

        while (start < end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] =temp;

            start++;
            end--;
        }
    }

    // Reverse int value and int or char array
    static int reverseInteger(int num){
        int rev = 0;
        while (num != 0){
            int digit = num % 10;
            rev = rev*10 + digit;
            num /= 10;
        }
        return rev;
    }

    //  Swap even and odd, make left fill with evven, make right fill with odd
    static void swapEven(int[] arr)
    {

        for(int i=0; i < arr.length; i++)
        {
            for(int j=0; j<arr.length; j++)
            {
                if(arr[i] % 2 == 0)
                {

                    swapOnly(arr, i, j);

                }
            }

        }

    }
    static void swapOnly(int[] arr){
        int temp = arr[0];
        arr[0] = arr[1];
        arr[1] = temp;
    }
    static void swapOnly(int []arr, int first, int next){
        int temp = arr[first];
        arr[first] = arr[next];
        arr[next] = temp;
    }
    // Swap values in arrays lowest to highest via temp variable
    static void swapValue(int[] arr){
        for (int i = 0;i < arr.length; i++){
            for (int j = 0;j <arr.length;j++){
                if (arr[j] > arr[i]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    // Remove repeated characters of a string
    static String removeDuplicates(String text){
        String temp = "";

        for (int i=0;i<text.length();i++){
            if (!temp.contains(text.charAt(i)+ "")){
                temp += text.charAt(i)+"";
            }
        }
        return temp;
    }


    // Longest Binary Gap between 1s and 0s
    // örn 10000010001 -> 5
    public static int findLongestBinaryGap(int number) {
        String binaryString = Integer.toBinaryString(number);

        int longestGap = 0;
        int currentGap = 0;
        boolean gapStarted = false;

        for (int i = 0; i < binaryString.length(); i++) {
            char bit = binaryString.charAt(i);

            if (bit == '1') {
                if (!gapStarted) {
                    gapStarted = true;
                } else {
                    longestGap = Math.max(longestGap, currentGap);
                }
                currentGap = 0;
            } else {
                if (gapStarted) {
                    currentGap++;
                }
            }
        }

        return longestGap;
    }

    // Find Missing Number
    public static int findMissingNumber(int[] array) {
        int n = array.length + 1; // Eksik sayı dahil toplam eleman sayısı
        int totalSum = n * (n + 1) / 2; // Tüm elemanların toplamı
        int arraySum = 0; // Dizideki elemanların toplamı

        // Dizideki elemanların toplamını hesapla
        for (int num : array) {
            arraySum += num;
        }

        // Toplamdan dizideki elemanların toplamını çıkararak eksik sayıyı bul
        int missingNumber = totalSum - arraySum;
        return missingNumber;
    }

    // find duplicates

    // HashMap Algoritması:
    //
    //Bu algoritma, array'deki her değeri bir HashMap'e ekler. Bir değer tekrar ediyorsa, HashMap'deki değerin sayısı birer birer artırılır.

    public static int[] findDuplicatesTwo(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> duplicates = new ArrayList<>();

        for (int num : arr) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                duplicates.add(entry.getKey());
            }
        }

        return duplicates.stream().mapToInt(Integer::intValue).toArray();
    }
    /*
    Brute-Force Algoritması:

    Bu algoritma, array'deki her bir değeri diğer tüm değerlerle karşılaştırır. Bir değer tekrar ediyorsa, tekrar sayısı birer birer artırılır
     */
    static int[] findDuplicates(int[] arr){
        int[] duplicates = new int[arr.length];

        for (int i = 0;i<arr.length;i++){
            for (int j = i + 1; j<arr.length;j++){
                if (arr[i] == arr[j]){
                    duplicates[i]++;
                }
            }
        }
        return duplicates;
    }
    // find mid number in array
    static int findMidNumber(int[] arr){
        int length = arr.length;
        // Dizinin orta elemanının indeksi
        int midIndex = length / 2;

        // Eğer dizi tek uzunlukta ise, orta elemanı döndür
        if (length % 2 != 0){
            return arr[midIndex];
        }else {
            // Eğer dizi çift uzunlukta ise, ortadaki iki elemanın ortalamasını döndür
            return (arr[midIndex - 1] + arr[midIndex]) / 2;
        }

    }
    //Find middle number in given integers and decimals
    static String findMid(int num){
        // convert number into a String
        String text = String.valueOf(num);

        int textLength = text.length();

        if (textLength % 2 == 0){
            return text.substring(textLength/2 -1,textLength/2 +1);
        }

        return text.substring(textLength/2,textLength/2+1);
    }

    static String  findMid(float number)
    {
        // convert number into a String
        String text = String.valueOf(number);
        int textLength =0;
        // get the length of the String text
        if(text.charAt(0) == 0 || text.charAt(1) == '.'){
            text = text.substring(2); // skip 0 and .
            textLength = text.length(); // x number %2 == 0
            System.out.println("char count "+textLength);
        }

        // if the number is even, return two digits
        if(textLength % 2 == 0) {
            return text.substring(textLength/2 -1, textLength/2 +1);
        }

        // otherwise, the number is odd, return one digit
        return text.substring(textLength/2, textLength/2 +1);
    }



    // double
    static String findMid(double number)
    {
        // convert number into a String
        String text = String.valueOf(number);
        StringBuffer sb = new StringBuffer(); // to remove .

        // get the length of the String text
        int textLength =0;

        for(int i=0; i<text.length(); i++){
            if(Character.isDigit(text.charAt(i))){
                sb.append(text.charAt(i));
            }
        }
        text = sb.toString(); // sb has the digits
        System.out.println("Text: "+text);
        textLength = text.length(); // x number %2 == 0
        System.out.println("char count "+textLength);


        // if the number is even, return two digits
        if(textLength % 2 == 0) {
            return text.substring(textLength/2 -1, textLength/2 +1);
        }

        // otherwise, the number is odd, return one digit
        return text.substring(textLength/2, textLength/2 +1);
    }


    // IsLetter,getCount,find and separate characters
    //IsLetter
    static void letterFunction(){
        Object[] data = {1,2,54,76,"mustafa","güler",79};

        String str = String.valueOf(data[4]);

        if (Character.isLetter(str.charAt(0))){
            System.out.println(Arrays.toString(str.toCharArray()));
        }
    }
    // find and separate characters

    static Object[] data = {12,4,6,8,"mustafa","g"};

    static void getStrings(int index){
        String str = String.valueOf(data);

        if (Character.isLetter(str.charAt(0)) || Character.isDigit(str.charAt(0))){
            System.out.println(Arrays.toString(str.toCharArray()));
        }
    }
    // get count of given values
    static int getCount(String word){
        int count =0;
        //String str = String.valueOf(data[index]);

        for(int i=0; i< data.length; i++){
            if(String.valueOf(data[i]).equalsIgnoreCase(word)){
                count++; // add 1 more to count everytime you see the word
            }
        }
        return count;
    }

    //5 Analysis 1: Filter Numbers from parsed data via lambda or regex statement
    static ArrayList<Integer> filterNumbers(ArrayList<String> list){

        if(list.isEmpty()) return null; // odd case

        ArrayList<Integer> nums = new ArrayList<>();

        for(int i=0; i< list.size(); i++){
            String data = list.get(i);

            // lambda solution,
            // boolean numberCheck= data.chars().allMatch(Character::isDigit);

            // regex solution: replace or replaceAll
            String number = data.replaceAll("[^0-9]", "");
            // System.out.println(number);

            // handle Number Format Exception
            if(!number.equals(null)){
                try{
                    nums.add(Integer.parseInt(number));
                }catch(NumberFormatException nfe){

                }

            }
        }

        return nums;
    }

    //3b Read Input from stdin: Via Buffered Reader,
    static List<String> readStreamsTwo() throws IOException {
        // add the list
        List<String> list = new ArrayList<>();

        // access the stdin values via input stream reader class.
        InputStreamReader reader = new InputStreamReader(System.in);
        // run to see if we need other imports, we'll add it at line 2

        //Buffered Reader to throw everything inside the output. Stream of data
        BufferedReader stream = new BufferedReader(reader);

        String line; // this will be each line feeding from stdin

        // add the while loop to visit each line.
        while( (line = stream.readLine() ) != null ){
            list.add(line);
            // System.out.println(line);
        }

        return list;

    }
    //3a Store stdin values inside a list
    // this method parses stdin and stores values inside a list
    static ArrayList<String> readInputTwo() {
        // add the list container here.
        ArrayList<String> list = new ArrayList<>();

        // Scanner object gets stdin from System class
        Scanner scanner = new Scanner(System.in); //input from stdin

        // Since there are multiple lines in the stdinput, visit all elements
        while(scanner.hasNextLine()){
            String data = scanner.nextLine(); // get each input in string format.
            list.add(data);
            // System.out.println(data); // input values prints to console/output.
        }
        // close scanner since we are done checking for inputs.
        scanner.close();

        return list; // returning empty list as of now.
    }
    //2 Read Input from stdin via BufferedReader
    static void readStreams() throws IOException {
        // InputStreamReader sınıfıyla standart giriş akışına (System.in) erişim sağla.
        InputStreamReader reader = new InputStreamReader(System.in);
        // BufferedReader, veriyi tutmak için kullanılır ve veriyi belleğe tamponlar.
        // Standart giriş akışını (InputStream) tamponlamak için kullanacağız.
        BufferedReader stream = new BufferedReader(reader);

        String line; // Her satırı tutacak değişken

        // Her satırı okuyarak işleyen bir while döngüsü oluştur.
        while ((line = stream.readLine()) != null) {
            System.out.println(line); // Her satırı ekrana yazdır.
        }

        // IOException'ı yakalamak veya throws anahtar kelimesini kullanmak gereklidir.
    }

    //1 Read input data from stdin, via Scanner class
    static void readInput() {
        // Scanner object gets stdin from System class
        Scanner scanner = new Scanner(System.in); //input from stdin

        // Since there are multiple lines in the stdinput, visit all elements
        while(scanner.hasNextLine()){
            String data = scanner.nextLine(); // get each input in string format.
            System.out.println(data); // input values prints to console/output.
        }
        // close scanner since we are done checking for inputs.
        scanner.close();
    }

    //bir dizinin sıralı olup olmadığını özyinelemeli (recursive) bir yöntemle kontrol eden bir
    static boolean isSorted(int[] arr,int n){
        // Dizinin boyutu 0 veya 1 ise sıralı kabul edilir
        if (n == 0 || n == 1) {
            return true;
        }

        // Eğer son eleman küçükse sıralı değil
        if (arr[n - 1] < arr[n - 2]) {
            return false;
        }

        // Son elemanın öncesinden başlayarak kontrol et
        return isSorted(arr, n - 1);
    }

    public static Map<Character, Integer> getUniqueDuplicateValue(String str1, String str2) {
        Map<Character, Integer> valueCounts = new HashMap<>();

        // str1'deki her bir karakterin sayısını say
        for (char ch : str1.toCharArray()) {
            valueCounts.put(ch, valueCounts.getOrDefault(ch, 0) + 1);
        }

        // str2'deki her bir karakterin sayısını say
        for (char ch : str2.toCharArray()) {
            valueCounts.put(ch, valueCounts.getOrDefault(ch, 0) + 1);
        }

        // Tekrar eden karakterleri ve toplam sayılarını içeren bir harita oluştur
        Map<Character, Integer> duplicateCounts = new HashMap<>();
        for (Map.Entry<Character, Integer> entry : valueCounts.entrySet()) {
            if (entry.getValue() > 1) { // Karakterin toplam sayısı 1'den büyükse, yinelenen karakterdir
                duplicateCounts.put(entry.getKey(), entry.getValue());
            }
        }

        return duplicateCounts;
    }
    public static Map<Integer, Integer> getDuplicateValuesAndCounts(int[] arr) {
        Map<Integer, Integer> valueCounts = new HashMap<>();

        // Dizideki her bir elemanın sayısını say
        for (int num : arr) {
            if (valueCounts.containsKey(num)) {
                valueCounts.put(num, valueCounts.get(num) + 1); // Değer zaten varsa sayısını bir artır
            } else {
                valueCounts.put(num, 1); // Değer yoksa 1 olarak başlat
            }
        }

        // Yinelenen değerleri ve toplam sayılarını içeren bir harita oluştur
        Map<Integer, Integer> duplicateCounts = new HashMap<>();
        for (Map.Entry<Integer, Integer> entry : valueCounts.entrySet()) {
            if (entry.getValue() > 1) { // Değerin toplam sayısı 1'den büyükse, yinelenen değerdir
                duplicateCounts.put(entry.getKey(), entry.getValue());
            }
        }

        return duplicateCounts;
    }
    //Greatest ascending difference - en büyük artan fark
    public static int findGreatestAscendingDifference(int[] arr) {
        int greatestDifference = Integer.MIN_VALUE; // Başlangıçta en küçük değer olarak atanır

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] > arr[i]) { // Ardışık iki eleman arasında artış varsa
                int difference = arr[i + 1] - arr[i]; // Fark hesaplanır
                if (difference > greatestDifference) { // Mevcut fark, en büyük farktan büyükse güncellenir
                    greatestDifference = difference;
                }
            }
        }

        return greatestDifference;
    }
    // iki string de ki ortak olan değerleri bulan
    static void findCommonCharacterBetweenTwoString(String str1,String str2){
        Set<Character> set1 = new HashSet<>();
        Set<Character> set2 = new HashSet<>();

        for (char c : str1.toCharArray()){
            set1.add(c);
        }
        for (char c : str2.toCharArray()){
            set2.add(c);
        }

        Set<Character> commonCharacters = new HashSet<>(set1);
        commonCharacters.retainAll(set2);

        for (Character ent : commonCharacters){
            System.out.println("Tekrar eden değerler : "+ent);
        }
    }

    static void findDuplicateCharacter(String str){
        HashMap<Character,Integer> countMap = new HashMap<>();

        for (char c : str.toCharArray()){
            if (countMap.containsKey(c)){
                countMap.put(c,countMap.get(c)+1);
            }else {
                countMap.put(c,1);
            }
        }
        for (Map.Entry<Character,Integer> enrty : countMap.entrySet()){
            if (enrty.getValue() > 1){
                System.out.println("Karakter : "+enrty.getKey()+ " "+enrty.getValue()+ " kez tekrar ediyor");
            }
        }
    }

    static void diamondPattern(){
        for (int i = 1;i<=4;i++){

            for (int s = 1;s <= 5-i;s++){
                System.out.print(" ");
            }
            for (int j = 1;j<=i*2-1;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    static void reverseFullTriaglePattern(){
        for (int i = 5;i>=1;i--){

            for (int s = 1;s <= 5-i;s++){
                System.out.print(" ");
            }
            for (int j = 1;j<=i*2-1;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void fullTriaglePattern(){
        for (int i = 1;i<=5;i++){

            for (int s = 1;s <= 5-i;s++){
                System.out.print(" ");
            }
            for (int j = 1;j<=i*2-1;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void leftSideTriagle(){
        for (int i = 1;i<=5;i++){
            for (int j = 1;j<=i;j++){
                System.out.print(j);
            }
            System.out.println();
        }
    }

    static void rightSidePattern(){
        for (int i = 1;i<=5;i++){

            for (int s = 1;s <= 5-i;s++){
                System.out.print(" ");
            }
            for (int j = 1;j<=i;j++){
                System.out.print(i);
            }
            System.out.println();
        }

    }

    static void patternOne(){
        for (int i = 1; i <= 5; i++){
            for (int j = 1; j <=5; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void checkPalindrome(int num){
        int temp = num;
        int rev = 0;

        while (num > 0){
            rev = rev * 10 + num % 10;
            num /= 10;
        }
        if (temp == rev){
            System.out.println("Palindrome");
        }else {
            System.out.println("not palindrome");
        }
    }

    //find reverse of given number
    // 123 -> 321 , 521 -> 125
    static void reverseNumber(int num){
        int rev = 0;
        while (num > 0){
            rev = rev*10 + num%10;
            num /= 10;
        }
        System.out.println(rev);
    }

    //armstrong or not
    // 153 -> 1^3 + 5^3 + 3^3  -> 153
    static void armstrongTwo(int num){
        int temp = num;
        int sum = 0;

        while (temp > 0){
            int digit = temp % 10;
            sum += digit*digit*digit;
            num /= 10;
        }

        if (sum == temp){
            System.out.println("Armstrong");
        }else {
            System.out.println("Not armstrong");
        }
    }

    static void armstrongOne(int num){
        int temp = num;
        int digitNum = String.valueOf(num).length();
        int sum = 0;

        while (temp > 0){
            int digit = temp % 10;
            sum += Math.pow(digit,digitNum);
            temp /= 10;
        }

        if (sum == num){
            System.out.println("Armstrong");
        }else {
            System.out.println("Not armstrong");
        }
    }

    //find maximum digit from the given number
    // 36458 - > max -> 8
    static void maxDigitOfNumber(int number){
        int max = number%10;

        while (number > 0){
            if (number%10 > max){
                max = number%10;
            }
            number /= 10;
        }
        System.out.println(max);
    }

    //find sum of digit from the given number
    // 123 - 1 + 2 + 3 -> 6
    static void sumOfDigitNumber(int number){
        int sum = 0;
        while (number > 0){
            sum += number % 10;
            number /= 10;
        }
        System.out.println(sum);
    }

    // count number of digit in the given number
    // 123 - count -> 3
    // 12456 - count -> 5
    static void countDigit(int number){
        int count = 0;

        while (number > 0){
            number /= 10;
            count++;
        }
        System.out.println(count);
    }

    //separate Each digit from the number
    static void separateEachNumber(int number){

        while (number != 0){
            System.out.println(number % 10);
            number /= 10;
        }
    }

    //find wovel and constant
    static int[] vowelAndConsonant(String text){
        text = text.toLowerCase();
        int countVowel = 0;
        int countConsonant = 0;

        for (int i = 0;i < text.length(); i++){
            char character = text.charAt(i);
            if (character >= 'a' && character <= 'z'){
                if (character == 'a' || character == 'e' || character == 'i' || character == 'o' || character == 'u'){
                    countVowel++;
                }else {
                    countConsonant++;
                }
            }
        }
        return new int[]{countVowel,countConsonant};
    }

    //To Find Maximum Number Out Of Three Numbers
    static void findMaximuminThreeNumbers(int a,int b,int c){
        if (a > b && a > c){
            System.out.println(a);
        }else if(b > c){
            System.out.println(b);
        }else {
            System.out.println(c);
        }
    }

    //swap values of two numbers without using third variable
    static void swapWithoutUsingThird(){
        int a = 5;
        int b = 6;
        System.out.println("a : "+a);
        System.out.println("b : "+b);

        a = a + b;
        b = a - b;
        a = a - b;

        System.out.println("a : "+a);
        System.out.println("b : "+b);
    }

    //swap two of number
    static void swapTwoNumber(){
        int x = 10;
        int y = 20;
        int temp;

        System.out.println("x: "+x);
        System.out.println("y: "+y);

        temp = x;
        x = y;
        y = temp;

        System.out.println("x: "+x);
        System.out.println("y: "+y);
    }

    static int maxSecondNumber(int[] arr){

        for (int i = 0;i<=arr.length-1;i++){
            for (int j = i + 1;j<arr.length-1;j++){
                if (arr[i] > arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        return arr[arr.length - 3];
    }

    static void reverseEachWorb(String str){
        String rev = "";
        String[] each_worb = str.split(" ");

        for (int i = 0;i<each_worb.length;i++){
            String worb = each_worb[i];
            String revWorb = "";

            for (int j = worb.length()-1;j>=0;j--){
                revWorb += worb.charAt(j);
            }

            rev += revWorb + " ";
        }
        System.out.println(rev);
    }

    static void reverseWorb(String str){
        String rev = "";
        String[] word = str.split("");

        for (int i = str.length()-1;i>=0;i--){
            rev += word[i];
        }
        System.out.println(rev);
    }

    static String reverseString(String str){
        String rev = "";
        for (int i = str.length()-1;i>=0;i--){
            rev += str.charAt(i);
        }
        System.out.println(rev);
        return rev;
    }

    static boolean isPalindrome(String str){
        int left = 0;
        int right = str.length() - 1;

        while (left < right){
            if (str.charAt(left) != str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
