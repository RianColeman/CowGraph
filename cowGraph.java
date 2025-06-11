import java.util.Scanner;
public class cowGraph{

    // Constants
    public static final int WIDTH = 80;
    public static final int HEIGHT = 25;

    // 2D screen buffer
    public static char[][] screen = new char[HEIGHT][WIDTH];

    public static void main(String[] args) {
        System.out.println("Graph!");

        // Initialize screen with spaces
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                screen[y][x] = ' ';
            }
        }
        System.out.println("x and y bounds are equal");
        System.out.println("Enter bounds:");
        Scanner sc = new Scanner(System.in);
        int bounds = sc.nextInt();
        
        setScreen();


        // Print screen
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                System.out.print(screen[y][x]);
            }
            System.out.println();
        }
        System.out.println("                                         \\   ^__^");
        System.out.println("                                          \\  (oo)\\_______");
        System.out.println("                                             (__)\\       )\\/\\");
        System.out.println("                                                 ||----w |");
        System.out.println("                                                 ||     ||");

    }

    public static void setScreen() {
        int midY = HEIGHT / 2;
        int midX = WIDTH / 2;

        for (int x = 0; x < WIDTH; x++) {
            screen[midY][x] = '-';
        }        System.out.println("Enter bounds:")
        for (int y = 0; y < HEIGHT; y++) {
            screen[y][midX] = '|';
        }
        screen[midY][midX] = '+';
        
    }  
}
