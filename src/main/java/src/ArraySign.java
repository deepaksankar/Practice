public class ArraySign {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1};
        System.out.println(arraySign(nums));
    }
    public static int arraySign(int[] nums) {
        int sign = 1;
        for (int num: nums) {
            if (num == 0) {
                return 0;
            } else if (num < 0) {
                sign = -sign;
            }
        }
        return sign;
    }
}
