import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        boolean flag = true;
        Algorithm db = new Algorithm();

        while (flag){
            display();

            int number = -1;

            while (number < 0 || number > 7 ) {
                System.out.print("Chuc nang: ");
                try {
                    number = input.nextInt();
                    input.nextLine();          // su ly troi lenh
                } catch (Exception e) {
                    input.nextLine();
                    System.out.println("Error: " + e.getMessage());
                }
            }

            // su ly logic
            switch (number){
                case 1:
//                    db.inputArray();
                    input();
                    break;
                case 2:
                    db.displayFile();
                    break;
                case 3:
                    db.bubbleSort();
                    break;
                case 4:
                    db.selectionSort();
                    break;
                case 5:
                    db.insertionSort();
                    break;
                case 6:
                    while(true){
                        System.out.print("Nhap x: ");
                        try {
                            double x = input.nextDouble();
                            input.nextLine();
                            db.linearSearch(x);
                            break;
                        }catch (Exception e){
                            input.nextLine();
                            System.out.println("Error: " + e.getMessage());
                        }
                    }
                    break;
                case 7:
                    while(true){
                        System.out.print("Nhap x: ");
                        try {
                            double x = input.nextDouble();
                            input.nextLine();
                            db.binarySearch(x);
                            break;
                        }catch (Exception e){
                            input.nextLine();
                            System.out.println("Error: " + e.getMessage());
                        }
                    }
                    break;
                default:
                    System.out.println("Good bye, have a nice day!");
                    flag = false;

            }
        }


        input.close();
    }

    // ham nhap du lieu tu ban phim
    public static void input(){
        Scanner input = new Scanner(System.in);
        Algorithm db = new Algorithm();

        System.out.print("Nhap n: ");
        int n = input.nextInt();

        double a[] = new double[n];
        System.out.print("Nhap mang: ");
        for(int i=0;i<n;i++){
            a[i] = input.nextDouble();
        }

        db.writeFile(db.INPUT,a,n);
    }
    public static void display(){
        System.out.println();
        System.out.println("+-------------------Menu------------------+");
        System.out.println("|      1.Input                            |");
        System.out.println("|      2.Output                           |");
        System.out.println("|      3.Bubble sort                      |");
        System.out.println("|      4.Selection sort                   |");
        System.out.println("|      5.Insertion sort                   |");
        System.out.println("|      6.Search > value                   |");
        System.out.println("|      7.Search = value                   |");
        System.out.println("|      0.Exit                             |");
        System.out.println("+-----------------------------------------+");
    }
}

//    9 3 5 6 1 2 4 8

//9 3 2 2 5 6 1 2 4 8
