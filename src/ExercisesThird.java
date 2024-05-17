public class ExercisesThird {
    public static void main(String[] args) {

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
