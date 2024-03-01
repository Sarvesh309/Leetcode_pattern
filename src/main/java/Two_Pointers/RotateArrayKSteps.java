package Two_Pointers;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class RotateArrayKSteps {
    public static void main(String[] args) {
        /*
        Input  [1, 2, 3, 4, 5, 6, 7]
         ```````` k = 4``````
         `````````````````````
        Output [4, 5, 6, 7, 1, 2, 3]
        */
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};
        int k = 4;
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        LinkedList<Integer> stack = new LinkedList<>(list);

        //7 6 5 4 3 2 1
        Collections.reverse(stack);

        //4 5 6 7 3 2 1
        Collections.reverse(stack.subList(0, k));

        //4 5 6 7 1 2 3
        Collections.reverse(stack.subList(k, arr.length));
        System.out.println(stack);
    }
}
