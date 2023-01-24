import java.util.Random;


public class lodymc {
    final static int N = 10000;
    private static int[][] tab =
            {{0,7,20,21,12,23},
                    {27,0,13,16,46,5},
                    {53,15,0,25,27,6},
                    {16,2,35,0,47,10},
                    {31,29,5,18,0,4},
                    {28,24,1,17,5,0}};
    private static int[] storage = new int[7];
    private static int bestSolution = 10000000;
    private static int currentSolution;
    private static int check;
    private static int timeCost = 0;

    public static void main(String[] args){
        Random random = new Random();

        for(int i = 0; i < N; i++){
            for(int a = 0; a < 7; a++) {
                storage[ a ] = random.nextInt( 6 ) + 1;
            }
            storage[6] = storage[ 0 ];

            for (int j = 0; j < 6; j++) {
                timeCost = tab[storage[j] - 1][storage[j+1] - 1] + timeCost;
            }

            timeCost = timeCost+ tab[storage[6] - 1][storage[0] - 1 ];
            currentSolution = timeCost;
            timeCost = 0;

            int q = 0;
            for(int k = 0; k < 7; k++){
                int temp = k + 1;
                while(temp < 7){
                    if(storage[k] == storage[temp]){
                        q++;
                        break;
                    }
                    temp++;
                }
            }

            if(currentSolution < bestSolution && q == 1 ){
                System.out.print( "Smaki: " );
                for(int a = 0; a < 7; a++) {
                    System.out.print( storage[a] );
                }
                bestSolution = currentSolution;
                System.out.println( );
                System.out.println("Koszt: " + currentSolution );
                check = 1;
                System.out.println( );
            }
            currentSolution = 0;
        }
        if( check != 1){
            System.out.println( "Nie znaleziono rozwiazania!" );
        }
    }
}