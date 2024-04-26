public class ExercisesTwo {
    public static void main(String[] args) {

        reverseNum(123);
        System.out.println(reverseNum(678));
    }
    static int reverseNum(int number){
        int reverse = 0;
        while (number != 0){
            reverse = reverse*10 + number%10;
            number /= 10;
        }
        return reverse;
    }
    static void isArstrongNumber(int number){
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
