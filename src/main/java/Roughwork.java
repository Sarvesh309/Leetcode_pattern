import java.util.*;
import java.util.stream.Collectors;

public class Roughwork {

    public static void main(String[] args) {
//        List<Integer> answer = new ArrayList<>();
//        int [][] arr = new int[][]{{3,4},{2,3},{1,2}};
//        Arrays.sort(arr, Comparator.comparing((int[]arr1)->arr1[0]));
//        Arrays.stream(arr).forEach(System.out::println);
//        HashSet<Integer> set = new LinkedHashSet<>();
//        String str = "hello";
//        char c = str.charAt(2);
//        str.replace(Character.toString(str.charAt(2)),"");
//        System.out.println(str);
//        HashMap<Character, Integer> mp = new HashMap<>();
//        Integer ans = mp.getOrDefault("a", 2);
        System.out.println(Integer.parseInt("22nd"));
        Queue<Integer> queue = new LinkedList<>();
        Map<Integer, String> temp= new HashMap<>();
        temp.entrySet().stream().sorted(Map.Entry.comparingByKey()).collect(HashMap::new,
                (m, e) -> m.put(e.getKey(), e.getValue()),
                HashMap::putAll
        );
    }
    static void binarySearch(int first_index, int last_index, int[] citations, int[] answer){
        if(first_index>last_index){
            return;
        }
        int mid = (first_index+last_index)/2;

    }
}
