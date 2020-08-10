package Misc;

public class Main {
    public static void main(String[] args) {
        //int T =Integer.parseInt(args[0]) ;
        int T = 2000 ;
        VisualAccumulator A = new VisualAccumulator(T, 1.0) ;
        for(int i=0 ; i< T ; i++){
            A.addDateValue(Math.random());
        }


        StdOut.println(A);
    }
}
