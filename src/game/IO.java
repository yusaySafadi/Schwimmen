package game;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class IO {
    private static Scanner scanner = new Scanner(System.in);

    private static int count = 0;
    /**
     * TODO: implement me
     * DOne
     * @param options
     */
    private static void printOptions(String[] options) {
        if(options.length == 0){
            count = 0;
            System.out.printf("Auswahl: (def: 0) :%n" );
            return;
        }
        int optionNum = options.length;

        if(options.length == 1){
            System.out.printf("%d: %s%n",count, options[0]);
        }else{
            System.out.printf(" %d: %s ",count, options[0]);
        }

        count++;

        options = Arrays.copyOfRange(options,1, options.length);//Arrays.copyOf(options, options.length-1);

        printOptions(options);
    }

    /**
     * TODO: implement me
     * DONE
     * @param header
     * @param options is an array of strings, containing the possible options
     */
    private static void printMenu(String header, String[] options) {
        // ...
        String line="";
        for(int i = 0; i<= header.length(); i++ ){
            line+="-";
        }
        System.out.printf("%s%n", line);
        System.out.printf("%s%n", header);
        System.out.printf("%s%n", line);

        printOptions(options);
    }

    /**
     * Print a menu with options, return a 0-based selection or fallbackDigit.
     *
     * @param menuHeader is the title of the menu.
     * @param options is an array of strings, containing the possible options.
     * @param fallbackDigit is returned for incorrect inputs.
     */
    public static int menuSelection(String menuHeader, String[] options, int fallbackDigit) {
        printMenu(menuHeader, options);
        return 0;
    }

    public static int menuSelection(String menuHeader, String[] options) {
        return menuSelection(menuHeader, options, 0);
    }

    public static int selectHandInput(){
        String input = scanner.nextLine().trim();

        try{
            int InputValue = Integer.parseInt(input);
            return InputValue;
        }catch (Exception e){
            return 0;
        }

    }
    public static int getActivityInput(){
        String input = scanner.nextLine().trim();

        try{
            int InputValue = Integer.parseInt(input);
            return InputValue;
        }catch (Exception e){
            return 0;
        }
    }

}
