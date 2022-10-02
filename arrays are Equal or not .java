public class ArrayEqual {

    public static void main(String args[]) {
        int[] myFirstArray = { 12, 42, 34, 19 };
        int[] mySecondArray = { 12, 42, 34, 19 };
        int[] myThirdArray = { 12, 42, 33, 19 };

        System.out.println(Arrays.equals(myFirstArray, mySecondArray));
        System.out.println(Arrays.equals(myFirstArray, myThirdArray));

    }
}
