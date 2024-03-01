import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class StreamsPractice {

    public static boolean isSafe(int [][] board, int column, int row, int size){
        int i,j;
        //To check side ways horizontally on the lef side
        for(i = row, j = column; i>=0; i--){
            if(board[i][j]==1){
                return false;
            }
        }
        //to check diagonally upwards on the left side
        for(i=row, j=column;i>=0 && j>=0; i--, j--){
            if(board[i][j]==1){
                return false;
            }
        }
        //to check diagonally downwards on the left side
        for(i = row;i<=size && j>=0; i++, j--){
            if(board[i][j]==1){
                return false;
            }
        }
        return true;
    }

    public static boolean findNQueens(int column, int size, int[][] board){

        if(column>=size)
            return true;

        for(int row = 0; row < size; row++){
            for(int j = column; column < size; j++){

                if(isSafe(board,j,row,size)){
                    board[row][j]=1;
                    if(findNQueens(j+1, size, board)){
                        return true;
                    }
                    board[row][j]= 0;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
            int n=4;
            int [][] board = new int[n][n];
            Arrays.stream(board).forEach(val->Arrays.fill(val,0));
            ArrayList<ArrayList<Integer>> arrayListOfArrayList = new ArrayList<>();
            if(findNQueens(0,n,board)){
                for (int[] subArray : board) {
                    ArrayList<Integer> arrayList = new ArrayList<>();
                    for (int value : subArray) {
                        arrayList.add(value);
                    }
                    arrayListOfArrayList.add(arrayList);
                }
            }
            arrayListOfArrayList.forEach(System.out::println);

//        int[][] arr = {{1,3},{2,6},{8,10},{15,18}};
//        Arrays.sort(arr, Comparator.comparingInt(temp -> temp[0]));
//
//        Arrays.sort(arr, Comparator.comparingInt((int[] sub)-> sub[0])
//                .thenComparing((int[] sub)->sub[1]));
//        List<List<Integer>> result = new ArrayList<>();
//
//
//        for (int i = 0; i < arr.length; i++) {
//
//            for(int j = i+1; j< arr.length;j++) {
//                if (arr[i][1] >= arr[j][0]) {
//                    List<Integer> sublist = Arrays.asList(arr[i][0], arr[j][1]);
//                    result.add(sublist);
//                }
//                else
//                    break;
//            }
//        }
//        int[][] intArray = new int[result.size()][2];
//
//        for (int i = 0; i < result.size(); i++) {
//            List<Integer> sublist = result.get(i);
//            intArray[i][0] = sublist.get(0);
//            intArray[i][1] = sublist.get(1);
//        }
//
//        for (int[] subArray : intArray) {
//            for (int value : subArray) {
//                System.out.print(value + " ");
//            }
//            System.out.println();
//        }
//        int[][] matrix = new int[4][4];
//        List<List<Integer>> result= new ArrayList<>();
//        Arrays.stream(matrix).forEach(subarray-> Arrays.stream(subarray).forEach(result.));
//        Arrays.stream(matrix).forEach(val->Arrays.fill(val,0));
//        for (int[] subArray : matrix) {
//            for (int value : subArray) {
//                System.out.println(value);
//            }
//        }

        //        Arrays.sort(arr, (a, b) -> {
//            if (a[0] != b[0]) {
//                return Integer.compare(a[0], b[0]);
//            } else {
//                return Integer.compare(a[1], b[1]);
//            }
//        });

//        int minIndex = IntStream.range(0, arr.length)
//                .reduce((i, j) -> arr[i] < arr[j] ? i : j)
//                .orElse(-1);


//        List<String> stringList2 = Arrays.asList("abc", "def", "xyz", "xyz");
//        List<String> stringList3 = Arrays.asList("abc", "def", "xyz", "xyz");
//        List<List<String>> list2 = new ArrayList<>();
//        list2.add(stringList);
//        list2.add(stringList2);
//        list2.add(stringList3);
//        String collect = list2.stream().flatMap(Collection::stream)
//                                .sorted(Comparator.comparing(str->{
//                                    if(str.startsWith("a"))
//                                        return str;
//                                    return null;
//                                }))
//                                .findFirst()
//                                .orElse(null);

//        Deque<Integer> queue= new ArrayDeque<>();

    }

    private static void computeIfaabsent(HashMap<Integer, String> testingMap) {

    }

    public static void concurrencyTest() {
        Runnable runnable = () -> System.out.println("This is thread " + (Thread.currentThread().getId()));
        ExecutorService service = Executors.newFixedThreadPool(5);

        new Thread(()->{
          for (int i = 0; i <5;i++){
              System.out.println(i);
          }
        }).start();
    }
}
