package solucao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Predicate;

interface PerformOperation {
    boolean check(int a);
}

class MyMath {
    public static PerformOperation isOdd() {
        return x -> x % 2 != 0;
    }

    public static PerformOperation isPrime() {
        return x -> {
            if (x <= 1) return false;
            for (int i = 2; i <= Math.sqrt(x); i++) {
                if (x % i == 0) return false;
            }
            return true;
        };
    }

    public static PerformOperation isPalindrome() {
        return x -> {
            String s = String.valueOf(x);
            return s.equals(new StringBuilder(s).reverse().toString());
        };
    }

    public boolean checker(PerformOperation p, int num) {
        return p.check(num);
    }
}

public class Solucao {
    public static void main(String[] args) throws IOException {
        MyMath ob = new MyMath();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String[] input = br.readLine().split(" ");
            int choice = Integer.parseInt(input[0]);
            int number = Integer.parseInt(input[1]);
            PerformOperation op;
            boolean result = false;
            String answer = "";
            switch (choice) {
                case 1:
                    op = MyMath.isOdd();
                    result = ob.checker(op, number);
                    answer = result ? "ODD" : "EVEN";
                    break;
                case 2:
                    op = MyMath.isPrime();
                    result = ob.checker(op, number);
                    answer = result ? "PRIME" : "COMPOSITE";
                    break;
                case 3:
                    op = MyMath.isPalindrome();
                    result = ob.checker(op, number);
                    answer = result ? "PALINDROME" : "NOT PALINDROME";
                    break;
            }
            System.out.println(answer);
        }
    }
}

