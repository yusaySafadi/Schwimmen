import java.util.Arrays;

public class Maintest {

    private static int count =0;
    public static void main(String[] args){
        //CardValue value = CardValue.ACE;
        //CardValue vlue2 = CardValue.ACE;
        //System.out.println(vlue2.name().equals(value.name()));

        //Card card = new Card(CardColor.CLOVER, CardValue.EIGHT);

        //System.out.println(card.getColor().name().equals(CardColor.CLOVER.name()));

        String[] options = {"Hallo","bye", "tschüss" ,"bis dann", "oich hasse dich"};

        String header = "Fuck me DAdday";

        String header2 = "Spieler 2 was willst du tun";



        //System.out.println(CardValue.values()[0]);
        //Stack stack = new Stack();
        //System.out.println(stack.size());

        menuSelection(header, options);

        menuSelection(header2, options);


    }

    /**
     * TODO: implement me
     * DOne
     * @param options
     */
    private static void printOptions(String[] options) {
        if(options.length == 0){
            count = 0;
            return;
        }
        int optionNum = options.length;

        if(options.length == 1){
            System.out.printf("%d: %s%n",count, options[0]);
        }else{
            System.out.printf("%d: %s, ",count, options[0]);
        }

        count++;

        options = Arrays.copyOfRange(options,1, options.length);//Arrays.copyOf(options, options.length-1);

        printOptions(options);
    }

    /**
     * TODO: implement me
     * @param header
     * @param options is an array of strings, containing the possible options
     */
    private static void printMenu(String header, String[] options) {
        // ...
        String line="";
        for(int i = 0; i< header.length(); i++ ){
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



}
