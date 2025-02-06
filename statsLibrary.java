import java.lang.Double;
import java.util.Arrays;

import static java.lang.Math.sqrt;

public class statsLibrary {

    //calculates the average by adding all elements and then dividing by array length
    public double getMean(int[] numbers) {
        int total = 0;
        for(int singleNumber: numbers) { //enhanced for loop (aka for-each loop)
            total = total + singleNumber;
        }
        double result = (double) total/ numbers.length; //careful int division
        return result;
    }

    //calculates the array element with the highest frequency, returns NaN if all values are equal
    public double getMode(int[] numbers) {
        int maxCount = 1;
        double maxElement = Double.NaN;
        for (int i = 0; i < numbers.length; i++) {
            int count = 0;
            for (int j = 0; j < numbers.length; j++) {
                if (numbers[i] == numbers[j]) {
                    count++;
                }
            }
            if (count > maxCount) {
                maxCount = count;
                maxElement = numbers[i];
            }
        }
        return maxElement;
    }

    //calculates the number at the middle of an array
    public double getMedian(int[] numbers) {
        Arrays.sort(numbers);
        double median = 0;

        if (numbers.length % 2 == 0) { //case for even number array
            int mid1 = numbers.length/2;
            int mid2 = mid1 - 1;
            median = (numbers[mid1] + numbers[mid2])/2.0;
        } else { //base case for odd number array
            int mid = (numbers.length-1)/2;
            median = numbers[mid];
        }
        return median;
    }

    //calculates the standard deviation of numbers within an array
    public double getStdDev(int[] numbers) {
        statsLibrary stats = new statsLibrary();
        double numMean = stats.getMean(numbers);

        //creates an array containing each element's deviation from the mean
        double[] deviation = new double[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            double singleDeviation = numbers[i] - numMean;
            deviation[i] = singleDeviation;
        }
        //squares each element in array deviation
        double sqsum = 0;
        for (int i = 0; i < deviation.length; i++) {
            double singleSquared = deviation[i]*deviation[i];
            deviation[i] = singleSquared;
            sqsum = sqsum + deviation[i];
        }
        //finds variance and square roots it
        double stdDev = sqrt(sqsum/(numbers.length-1));

        return stdDev;
    }
}
