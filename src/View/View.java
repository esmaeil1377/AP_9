package View;

import Controller.RequestAnalyzer;

import java.util.ArrayList;
import java.util.Scanner;



public class View {
    private static View view=new View();
    private static Scanner input = new Scanner(System.in);
    private static ArrayList<String> OutPutToPrint=new ArrayList<>();


    private View(){}


    public static View getInstance(){
        return view;
    }

    public static String getCommand()
    {
         return(input.nextLine());
    }


    public static void AddtoOutPut(String output){
        OutPutToPrint.add(output);
    }

    public static ArrayList<String> getOutPutToPrint() {
        return OutPutToPrint;
    }
}
