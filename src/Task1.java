package PACKAGE_NAME;

public class Task1 {

    public static void main (String args []) {

    // используя %
    private static int gcd1(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

    // используя floorMod
    private static int gcd2(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

    // используя rem()
    private static int gcd3(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }
}
}
