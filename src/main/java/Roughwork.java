import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;


public class Roughwork {

    public static void main(String[] args) {

        Integer n = 12345;
        String string = "12 3 4 5";
        String string1 = string + " " + "22";
        char[] arr = new char[]{'1', '2', '3', '4'};

        List<Integer> collected = Arrays.stream(string1.split(" ")).
                map(Integer::parseInt).
                collect(Collectors.toCollection(LinkedList::new));

        int [] arr1 = new int[]{1,2,3,4,5};
        int num1 = 3;

        boolean b = Arrays.stream(arr1).boxed().anyMatch(element -> element == num1);

        Integer x = Integer.MAX_VALUE;
        Integer y = Integer.MAX_VALUE;


    }

}
