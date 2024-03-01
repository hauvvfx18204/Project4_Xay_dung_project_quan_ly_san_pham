import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Algorithm {

    public  final String INPUT = "INPUT.TXT";
    public  final String OUTPUT1 = "OUTPUT1.TXT";
    public  final String OUTPUT2 = "OUTPUT2.TXT";
    public  final String OUTPUT3 = "OUTPUT3.TXT";
    public  final String OUTPUT4 = "OUTPUT4.TXT";
    public  final String OUTPUT5 = "OUTPUT5.TXT";


    // ham ghi data vao file
    public void writeFile(String name, double a[], int n) {

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(name, false);  // false: ghi de len file cu, true: ghi them noi dung vao file da ton tai
            DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream);    // cho phep ghi du lieu thuoc kieu double

            for(int i=0;i<n;i++){
                dataOutputStream.writeDouble(a[i]);
            }

            dataOutputStream.close();
            fileOutputStream.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ham doc data tu file
    public ArrayList<Double> readFile(String name) {
        ArrayList<Double> list = new ArrayList<Double>();   // tao Arraylist

        try {
            FileInputStream fileInputStream = new FileInputStream(name);
            DataInputStream dataInputStream = new DataInputStream(fileInputStream);

            while(true) {
                try {
                    list.add(dataInputStream.readDouble()); // them du lieu vao array
                } catch (EOFException e) {
                    break;
                } catch (IOException e) {
                }
            }

            dataInputStream.close();
            fileInputStream.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;  // tra ve arraylist
    }

    // ham hien thi du lieu da doc duoc tu file
    public void displayFile(){
        ArrayList<Double> list = new ArrayList<Double>();
        list = readFile(INPUT);

        Iterator<Double> itr = list.iterator();
        while (itr.hasNext()){
            System.out.print(itr.next() + " ");
        }
    }

    // ham hien thi du lieu tu mot array
    public void output(double a[], int n){
        for(int i=0;i<n;i++){
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    // ham trao doi
    public void swap(double a[], int x, int y){
        double temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }

    // ham sap xep theo kieu noi bot
    public void bubbleSort(){
        ArrayList<Double> list = new ArrayList<Double>();
        list = readFile(INPUT);     // luu du lieu doc tu file vao arraylist

//        Integer[] temp = (Integer[]) list.toArray();
        int n = list.size();
        double temp[] = new double[n];

        for(int i =0;i<n;i++){
            temp[i] = list.get(i);      // chuyen du lieu tu arraylist sang array
        }

        // thuat toan bubble sort
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-1-i;j++){
                if(temp[j] > temp[j+1]){
                    swap(temp,j,j+1);
                }
            }
            output(temp, n);
        }

        writeFile(OUTPUT1, temp, n);    // ghi du lieu da duoc sap xep vao file
    }

    // ham sap xep theo kieu lua chon
    public void selectionSort(){
        ArrayList<Double> list = new ArrayList<Double>();
        list = readFile(INPUT);     // luu du lieu doc tu file vao arraylist

//        Integer[] temp = (Integer[]) list.toArray();
        int n = list.size();
        double temp[] = new double[n];

        for(int i =0;i<n;i++){
            temp[i] = list.get(i);     // chuyen du lieu tu arraylist sang array
        }

        // thuat toan selection sort
        for(int i=0;i<n-1;i++){
            int minIndex = i;
            for(int j=i+1;j<n;j++){
                if(temp[j] < temp[minIndex]){
                    minIndex = j;
                }
            }
            if(minIndex != i){
                swap(temp,i,minIndex);
            }
            output(temp,n);
        }

        writeFile(OUTPUT2, temp, n);    // ghi du lieu da duoc sap xep vao file
    }

    // ham sap xep theo kieu chen
    public void insertionSort(){
        ArrayList<Double> list = new ArrayList<Double>();
        list = readFile(INPUT);         // luu du lieu doc tu file vao arraylist

        int n = list.size();
        double temp[] = new double[n];

        for(int i =0;i<n;i++){
            temp[i] = list.get(i);     // chuyen du lieu tu arraylist sang array
        }

        // thuat toan insertion sort
        for(int i=1;i<n;i++){
            for(int j=i;j>0;j--){
                if(temp[j] < temp[j-1]){
                    swap(temp,j,j-1);
                }
            }
            output(temp,n);
        }

        writeFile(OUTPUT3, temp, n);    // ghi du lieu da duoc sap xep vao file
    }

    // ham tim kiem tuyen tinh
    public void linearSearch(double x){
        ArrayList<Double> list = new ArrayList<Double>();
        list = readFile(INPUT);         // luu du lieu doc tu file vao arraylist

        int n = list.size();
        double temp[] = new double[n];

        for(int i =0;i<n;i++){
            temp[i] = list.get(i);     // chuyen du lieu tu arraylist sang array
        }

        double a[] = new double[n]; // tao array a de luu index cac p.tu co gia tri > x
        int count = 0;

        // thuat toan tim kiem tuyen tinh
        for(int i=0;i<n;i++){
            if(temp[i] > x){
                System.out.print(i + " ");
                a[count++] = i;     // them index thoa dk vao array a
            }
        }

        writeFile(OUTPUT4, a, count); // viet vao file output4
    }

    // ham tim kiem nhi phan
    public void binarySearch(double x){
        ArrayList<Double> list = new ArrayList<Double>();
        list = readFile(OUTPUT1);        // luu du lieu doc tu file vao arraylist

        int n = list.size();
        double temp[] = new double[n];

        for(int i =0;i<n;i++){
            temp[i] = list.get(i);     // chuyen du lieu tu arraylist sang array
        }

        double a[] = new double[1];

        int left = 0;
        int right = n-1;

        // thuat toan tim kiem nhi phan
//        for(int i=left;i<=right;i++){
        while(left <= right){
            int mid = (left + right) / 2;

            if(temp[mid] == x){
                for(int j=mid;j>0;j--){
                    if(temp[j] == temp[j-1]){
                        mid = j-1;
                    }else{
                        break;
                    }
                }

                System.out.print("index: " + mid);
                a[0] = mid;
                writeFile(OUTPUT5, a, 1);   // ghi du lieu vao file
                break;
            }

            if(temp[mid] > x){
                right = mid - 1;
            }

            if(temp[mid] < x){
                left = mid + 1;
            }
        }

    }


}
