import java.util.Random;


public class lodymc {
    final static int N = 10000;
    private static int[][] tab =
            {{0,6,4,5,1000},
                    {4,0,2,1000,7},
                    {2,1000,0,9,4},
                    {3,8,1000,0,4},
                    {5,9,1,1000,0}};
    private static int[] storage = new int[7];
    private static int bestSolution = 10000000;
    private static int currentSolution;
    private static int check;
    private static int timeCost = 0;

    public static void main(String[] args){
        Random random = new Random();

        for(int i = 0; i < N; i++){
            for(int a = 0; a < 6; a++) {
                storage[ a ] = random.nextInt( 5 ) + 1;
            }
            storage[5] = storage[ 0 ];

            for (int j = 0; j < 5; j++) {
                timeCost = tab[storage[j] - 1][storage[j+1] - 1] + timeCost;
            }

            timeCost = timeCost+ tab[storage[5] - 1][storage[0] - 1 ];
            currentSolution = timeCost;
            timeCost = 0;

            int q = 0;
            for(int k = 0; k < 6; k++){
                int temp = k + 1;
                while(temp < 6){
                    if(storage[k] == storage[temp]){
                        q++;
                        break;
                    }
                    temp++;
                }
            }

            if(currentSolution < bestSolution && q == 1 && currentSolution<1000 ){
                System.out.print( "Smaki: " );
                for(int a = 0; a < 6; a++) {
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