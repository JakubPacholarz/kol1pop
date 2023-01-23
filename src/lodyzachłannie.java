public class lodyzachłannie {

    public static void lody() {

        final int[][] koszty = {
                {0, 7, 20, 21, 12, 23},
                {27, 0, 13, 16, 46, 5},
                {53, 15, 0, 25, 27, 6},
                {16, 2, 35, 0, 47, 10},
                {31, 29, 5, 1, 0, 4},
                {28, 24, 5, 17, 5, 0}
        };
        boolean[] bylo = new boolean[koszty.length];
        for (int i = 0; i < bylo.length; i++) {
            bylo[i] = false;
        }
        int wiersz = 0;
        int min = Integer.MAX_VALUE;

        //Sprawdzamy pierwszy smak
        for (int i = 0; i < koszty.length; i++) {
            for (int j = 0; j < koszty.length; j++) {
                if (koszty[i][j] > 0 && koszty[i][j] < min) {
                    wiersz = i;
                    min = koszty[i][j];
                }
            }
        }
        System.out.println("Smaki:");
        System.out.println(wiersz + 1);
        bylo[wiersz] = true;
        int minIndex = -1;

        //Sprawdzamy na jakie smaki kolejno przerobić
        for (int i = 0; i < koszty.length - 1; i++) {
            min = Integer.MAX_VALUE;
            for (int j = 0; j < koszty.length; j++) {
                if (koszty[wiersz][j] < min && koszty[wiersz][j] > 0 && bylo[j] == false) {
                    min = koszty[wiersz][j];
                    minIndex = j;
                }
            }
            wiersz = minIndex;
            bylo[minIndex] = true;
            System.out.println(wiersz + 1);
        }

        //Sprawdzamy na jaki smak przestroić na końcu
        for (int i = 0; i < koszty.length; i++) {
            if (koszty[wiersz][i] < min && koszty[wiersz][i] > 0) {
                min = koszty[wiersz][i];
                minIndex = i;
            }
        }
        System.out.println(minIndex + 1);
    }
}