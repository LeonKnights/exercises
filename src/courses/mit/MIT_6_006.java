package courses.mit;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * MIT [6.006] OpenCourseWare Problem Sets
 **/
public class MIT_6_006 {

/////////////////// Problem Set 0 ////////////////////

    /**
     * Entering and Printing your name.
     */
    public void problem_0_1() {
        String last;
        String first;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your last name:");
        last = scanner.nextLine();
        System.out.println("Enter your first name:");
        first = scanner.nextLine();
        System.out.println(first + " " + last);
    }

    ////////////////// Problem Set 1 ///////////////////

    /**
     * Computing Prime Numbers - Compute and print 1000th prime number.
     */
    public void problem_1_1() {
        int candidate;
        int count;
        int n = 1000;
        for (candidate = 2, count = 0; count < n; ++candidate) {
            if (isPrime(candidate)) {
                ++count;
            }
        }
        System.out.println("1000th prime: " + (candidate - 1));
    }


    /**
     * Compute the sum of the logarithms of all the primes from 2 to N,
     * and print out the sum of the logs of the primes, the number N,
     * and the ratio of these two quantities.
     */
    public void problem_1_2() {
        int n = 100;
        int sum = 0;
        int sumDivByN = 0;
        double logDivByN = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime(i)) {
                sum += Math.log(i);
                sumDivByN = sum / n;
                logDivByN = Math.log(i) / n;
                System.out.println("Ratio: " + getGreatestCommonFactor(sum, Math.log(i)));
            }
        }
        System.out.println("Sum of Log of primes: " + sum);
        System.out.println("N: " + n);
    }

    ////////////////////////Helper Methods////////////////////////////

    /**
     * @param candidate .
     * @return isPrime
     */
    private boolean isPrime(int candidate) {
        for (int i = 2; i < candidate; ++i) {
            if (candidate % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Make
     *
     * @param num numerator
     * @param den denominator
     * @return
     */
    public Map<String, Double> makeRationale(double num, double den) {
        Map<String, Double> map = new HashMap<>();
        double gcf = getGreatestCommonFactor(num, den);
        map.put("num", num / gcf);
        map.put("den", den / gcf);
        return map;
    }

    public double getGreatestCommonFactor(double num, double den) {
        if (den == 0) {
            return num;
        }
        double tempNum = makeRationale(num, den).get("num");
        double tempDen = makeRationale(num, den).get("den");
        return getGreatestCommonFactor(tempDen, tempNum % tempDen);
    }
}
