import java.util.Random;


public class katowicenoca {
    final static int N = 10000;
    private static int[][] tab =
            {{0,300,402,356,10000,10000,10000,10000,10000},
                    {300,0,10000,10000,440,474,10000,10000,10000},
                    {402,10000,0,10000,10000,330,10000,10000,10000},
                    {356,10000,10000,0,10000,10000,823,10000,10000},
                    {10000,440,10000,10000,0,10000,10000,430,10000},
                    {10000,474,330,10000,10000,0,813,365,774},
                    {10000,10000,10000,823,10000,813,0,10000,403},
                    {10000,10000,10000,10000,430,365,10000,0,768},
                    {10000,10000,10000,10000,10000,774,403,768,0}};
    private static int [] random;
    private static String[] tab1= {"Warszawa","Katowice","Zakopane","Lwow","Wieden","Budapeszt","Bukareszt","Zagrzeb","Sofia"};
    private static int[] storage = new int[9];
    private static String[] sstorage = new String[9];
    private static int bestSolution = 10000000;
    private static int currentSolution;
    private static int check;
    private static int timeCost = 0;

    public static void main(String[] args){
        Random random = new Random();
        for(int i = 0; i < N; i++){
            for(int a = 0; a < 9; a++) {
                storage[a]= random.nextInt(8)+1;
            }

            for (int j = 0; j < 5; j++) {
                timeCost = tab[storage[j] - 1][storage[j+1] - 1] + timeCost;
            }

            timeCost = timeCost+ tab[storage[8] - 1][storage[0] - 1 ];
            currentSolution = timeCost;
            timeCost = 0;

            int q = 0;
            for(int k = 0; k < 9; k++){
                int temp = k + 1;
                while(temp < 9){
                    if(storage[k] == storage[temp]){
                        q++;
                        break;
                    }
                    temp++;
                }
            }

            if(currentSolution < bestSolution && q == 1 && currentSolution<20000 ){
                System.out.print( "Miasta " );
                for(int a = 0; a < 9; a++) {
                    int n=storage[a];
                    System.out.print( tab1[n] + " ");
                }
                bestSolution = currentSolution;
                System.out.println( );
                System.out.println("Droga w km: " + currentSolution );
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