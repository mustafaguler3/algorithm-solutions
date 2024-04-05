public class Exercises {
    public static void main(String[] args) {

        int[] arr = {1,3,6,2,8};

        maxOfDigit(395456);
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


















