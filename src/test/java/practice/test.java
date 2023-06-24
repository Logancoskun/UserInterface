package practice;

public class test {
    public static void main(String[] args) {
        double[] list = {1.2, 2.9, 3.4, 7.5};

        //print
        for (double element : list) {
            System.out.println("This is the result of each element:" + element);
        }
        //find total
        double total = 0;
        for (double element : list) {
            total += element;
        }
        System.out.println("This is total result:" + total);
        //find max
        double max = list[0];
        for (double element : list) {
            if (element > max) max = element;
        }
        System.out.println("This is max result:" + max);
        //find min
        double min = list[0];
        for (double element : list) {
            if (element < min) min = element;
        }
        System.out.println("This is min result:" + min);

    }
}