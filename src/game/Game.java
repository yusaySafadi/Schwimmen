package game;

import cardgame.Card;
import cardgame.CardColor;
import cardgame.CardValue;
import cardgame.Stack;
import schwimmen.Activity;
import schwimmen.Hand;

import java.util.ArrayList;
import java.util.Arrays;

public class Game {
    //private int schiebeCount = 0;
    private ArrayList<Integer> schiebetrack;
    /**
     * The stack of 32 cards.
     */
    private Stack stack;

    /**
     * The 3 open cards available for card swaps.
     */
    private Hand openHand;

    /**
     * The players.
     */
    private Player[] players;

    /**
     *
     */
    private int dealer = 0;

    /**
     * Stops an ongoing round when set
     */
    boolean roundDone = false;


    /**
     * Construct a game for a set amount of players.
     * @param amountOfPlayers
     */
    Game(int amountOfPlayers) {
        stack = new Stack();
        players = new Player[amountOfPlayers];
        this.schiebetrack = new ArrayList<Integer>();
    }

    /**
     * TODO: implement me
     * @param player
     */
    private void deal(int player) {
        if(player == players.length){
            openHand = new Hand(this.stack.reveal(), this.stack.reveal(), this.stack.reveal());
            System.out.printf("--- Gebe Hand %s an Mitte %n", openHand.toString());
            System.out.printf("Spieler %d beginnt %n", players[dealer].getId());
            return;
        }
        players[player] = new Player(this.stack.reveal(), this.stack.reveal(),this.stack.reveal());

        System.out.printf("--- Gebe Hand %s an Spieler %d%n", players[player].getHand().toString(), players[player].getId());
        player+=1;
        deal(player);



    }

    /**
     * TODO: implement me
     * @param playerId
     */
    private void makeMove(int playerId) {
        // ...

        String menuHeader = String.format("Spieler %d, was willst du tun?", playerId);
        System.out.printf("--- Spieler %d ist dran%n", playerId);
        System.out.printf("--- Offene Hand: %s%n", openHand.toString());
        System.out.printf("--- Hand Spieler %d: %s%n", playerId,players[playerId-1].getHand().toString());
        String[] options = Activity.asStringArray();
        IO.menuSelection(menuHeader, options);

        int playerInput = IO.getActivityInput();

        switch (playerInput){
            case 0:
                //schiebeCount++;
                schiebetrack.add(0);
                break;
            case 1:
                String header = "Such dir eine neue Karte aus";
                String[] openCardOptions = this.openHand.getHand().toStringArray();
                IO.menuSelection(header, openCardOptions);

                int otherIndexInput = IO.selectHandInput();

                header = "Such dir eine Karte zum Weglegen aus";
                openCardOptions = players[playerId-1].getHand().getHand().toStringArray();
                IO.menuSelection(header, openCardOptions);

                int ownIndexInput = IO.selectHandInput();

                players[playerId-1].getHand().swapCard(this.openHand,otherIndexInput, ownIndexInput);
                schiebetrack.clear();
                break;
            case 2:
                players[playerId-1].getHand().swapAll(this.openHand);
                schiebetrack.clear();
                break;
            case 3:
                if(roundDone){
                    System.out.printf("Spiel ist bereits geschlossen (wird automatisch ausgesetzt) %n");
                    break;
                }
                schiebetrack.clear();
                roundDone = true;
                if(players[playerId-1].getId() == 1){
                    System.out.printf("Schliesse, sobald Spieler %d dran ist %n", players[players.length-1].getId());
                    for(int index = playerId+1; index<= players.length; index++){
                        makeMove(index);
                    }
                } else{
                    System.out.printf("Schliesse, sobald Spieler %d dran ist. %n", players[playerId-2].getId());
                    for(int index = playerId+1; ; index++){
                        if(index > players.length){
                            index = 1;
                        }
                        if(index == playerId){
                            break;
                        }
                        makeMove(index);
                    }
                }

                break;
            default:
                //schiebeCount++;
                schiebetrack.add(0);
                break;
        }
        if(this.schiebetrack.size() == 3){
            if(schiebetrack.get(0) == 0 && schiebetrack.get(1) == 0 && schiebetrack.get(2) == 0){
                if(this.stack.size() <=3){
                    System.out.printf("nicht genug Karten im Stack. BEENDE SPIEL");
                    roundDone = true;
                    return;
                }
                System.out.printf("Das offene Blatt wird erneuert%n");
                this.openHand.getHand().setCard(this.stack.reveal(), 0);
                this.openHand.getHand().setCard(this.stack.reveal(), 1);
                this.openHand.getHand().setCard(this.stack.reveal(), 2);
                //schiebeCount = 0;
                schiebetrack.clear();
            } else{
                schiebetrack.clear();
            }
        }
        /*if(schiebeCount == 3){
            if(this.stack.size() <=3){
                System.out.printf("nicht genug Karten im Stack. BEENDE SPIEL");
                roundDone = true;
                return;
            }
            System.out.printf("Das offene Blatt wird erneuert%n");
            this.openHand.getHand().setCard(this.stack.reveal(), 0);
            this.openHand.getHand().setCard(this.stack.reveal(), 1);
            this.openHand.getHand().setCard(this.stack.reveal(), 2);
            schiebeCount = 0;
        }*/


        //System.out.println(menuHeader);

        // ...
    }

    /**
     * TODO: implement me
     */
    private void playRound() {
        deal(0);
        openHand = players[dealer].selectHand(openHand);
        int nextplayer = dealer+1;
        while (!roundDone) {
            if(nextplayer == players.length){
                nextplayer = 0;
            }
            makeMove(players[nextplayer].getId());
            nextplayer+=1;
            //if(finalPaye!= null && nextplayer == finalPlayer){
            //    return;
            //}

            // ...
            //for(int i = 0; i<=players.length; i++){
            //    makeMove(players[i].getId());
            //}
        }

        // This would allow for multiple rounds, but it's not necessary to implement those.
        dealer = (dealer + 1) % 3;
    }

    private void printResults() {
        String playersAsString = Arrays.toString(players);
        // remove '[' and ']'
        playersAsString = playersAsString.substring(1, playersAsString.length()-1);
        playersAsString = playersAsString.replaceAll(", Pl", "%nPl");
        System.out.printf(playersAsString + "%n");
    }

    public static void main(String[] args) {
        // Please note that some functionality is already implemented.
        // For example, once you have implemented CardValue, completed Player and are able
        // to calculate the correct value of a held hand,
        // game.printResults() would function as expected for an initialized game.
        // It might be a good starting point to work on that.


        Game game = new Game(3);
        game.playRound();
        game.printResults();

    }
}
