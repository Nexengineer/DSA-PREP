import java.util.*;

public class Main {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String args[]) {
        int n = sc.nextInt();
        String s = sc.next();
        char arr[] = new char[n];

        for (int i = 0; i < n; i++){
            arr[i] = s.charAt(i);
        }

        for (int i = 1; i <= n; i++){
            if (n % i == 0){
                for (int j = 0; j < i / 2; j++){
                    char tmp = arr[j];
                    arr[j] = arr[i-j-1];
                    arr[i-j-1] = tmp;
                }
            }
        }

        for (int i = 0; i < n; i++){
            System.out.print(arr[i]);
        }
    }
}
