public class Exercises {
    public static void main(String[] args) {


        System.out.println(isPalindrome("kazak"));
        System.out.println(reverseString("mustafa"));
        reverseEachWord("mustafa güler");
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



















