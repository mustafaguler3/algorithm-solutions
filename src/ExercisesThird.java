public class ExercisesThird {
    public static void main(String[] args) {
        System.out.println(reverseString("mustafa"));
    }


    static String reverseString(String str) {
        String rev = "";
        for (int i = str.length()-1;i>=0;i--){
            rev += str.charAt(i);
        }

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
