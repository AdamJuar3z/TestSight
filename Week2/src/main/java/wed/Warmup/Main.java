package wed.Warmup;

public class Main {
    public static void main(String[] args) {
        System.out.println("All even numbers from 1 to 20:");
        //System.out.println("\nAll even numbers from 1 to 20:");
        //for(int i = 1; i <= 20; i++)
        for (int i = 1; i <= 20; i++) {
            //if(i %2 == 0)
            if (i % 2 == 0) {
                //sout(i + " ")
                System.out.print(i + " ");
            }
        }
        //sout("\nAll Odd numbers from 1 to 19:");
        System.out.println("\nAll Odd numbers from 1 to 19:");
        //int i = 1;
        int j = 1;
        //while(i <=19)
        while (j <= 19) {
            //sout(i + " ");
            System.out.print(j + " ");
            // i += 2;
            j += 2;
        }
        //sout("\nNumbers between 1 and 100 divisible by both 7 and 9:")
        System.out.println("\nNumbers between 1 and 100 divisible by both 7 and 9:");
        int c = 0;
        for (int n = 1; n <= 100; n++) {
            if (n % 7 == 0 && n % 9 == 0) {
                System.out.print(n + " ");
                c++;
            }
            if (c == 3) {
                break;
            }
        }
    }
}
