import java.util.Scanner;
public class cowGraph{


    public static int HEIGHT;
    public static int WIDTH;
    public static char[][] screen;

    public static void main(String[] args) {    
        System.out.println("Enter graph height");
        Scanner sc = new Scanner(System.in);
        HEIGHT = sc.nextInt();
        System.out.println("Enter graph width");
        WIDTH = sc.nextInt();
        sc.close();
        screen =  new char[HEIGHT][WIDTH];

        // Initialize screen with spaces
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                screen[y][x] = ' ';
            }
    }
        
        
        setScreen();
        

        // Print screen
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                System.out.print(screen[y][x]);
            }
            System.out.println();
        }

        //create string of spaces to properly space cow
        String spaceBuffer = new String("");
        for(int i = 0;i<WIDTH/2;i++){
            spaceBuffer=spaceBuffer+" ";
        }
        System.out.println(spaceBuffer+"\\   ^__^");
        System.out.println(spaceBuffer+" \\  (oo)\\_______");
        System.out.println(spaceBuffer+"    (__)\\       )\\/\\");
        System.out.println(spaceBuffer+"         ||----w |");
        System.out.println(spaceBuffer+"         ||     ||");

    }

    public static void setScreen() {
        int midY = HEIGHT / 2;
        int midX = WIDTH / 2;

        for (int x = 0; x < WIDTH; x++) {
            screen[midY][x] = '-';
        }
        for (int y = 0; y < HEIGHT; y++) {
            screen[y][midX] = '|';
        }
        screen[midY][midX] = '+';
        
    }  
}
