package RecursionAndBacktracking.recursion;

public class PrintMazeWithJumps {


    public static void main(String[] args) throws Exception {
        printMazePaths(0,0,2,2,"");
    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    //The number of times you call the function inside the recursive function, depicts the total number of branches in our recursive tree
    public static void printMazePaths(int sr, int sc, int dr, int dc, String psf) {

            if(sc==dc && sr==dr){
                System.out.println(psf);
                return;
            }
            for (int j = 1; j <= dc - sc; j++) {
                printMazePaths(sr, sc + j, dr, dc, psf + "h" + j);
            }
            for (int i = 1; i <= dr - sr; i++) {
                printMazePaths(sr + i, sc, dr, dc, psf + "v" + i);
            }
    }
}
