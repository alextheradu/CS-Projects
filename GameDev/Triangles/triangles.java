package GameDev.Triangles;

public class triangles {
    public static void main(String[] args) {
        System.out.println("Lower Left Triangle:");
        lowerLeftTriangle(4);
        System.out.println("Upper Left Triangle:");
        upperLeftTriangle(4);
        System.out.println("Lower Right Triangle:");
        lowerRightTriangle(4);
        System.out.println("Upper Right Triangle:");
        upperRightTriangle(4);
    }
// it goes from 1 to n
    public static void lowerLeftTriangle(int n){
        for (int r = 1; r <= n; r++) {
            for (int c = 1; c <= r; c++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void upperLeftTriangle(int n) {
        for (int r = n; r >= 1; r--) {
            for (int c = 1; c <= r; c++) {
                System.out.print("*");
            } 
            System.out.println();
        }
    }

    public static void lowerRightTriangle(int n) {
        for (int r = 1; r <= n; r++) {
            for (int c = n; c > r; c--) {
                System.out.print(" ");
            }
            for (int c = 1; c <= r; c++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void upperRightTriangle(int n) {
        for (int r = n; r >= 1; r--) {
            for (int c = n; c > r; c--) {
            System.out.print(" ");
            }
            for (int c = 1; c <= r; c++) {
            System.out.print("*");
            }
            System.out.println();
        }
    }
}
