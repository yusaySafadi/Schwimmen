package game;

import cardgame.Card;
import schwimmen.Hand;

public class Player {
    private Hand hand;
    private static int playercount= 0;
    private int id;
    public Player(Card card1, Card card2, Card card3){
        this.id = playercount+1;
        playercount+=1;
        this.hand = new Hand(card1,card2,card3);
    }
    /**
     * Prompts the user to select a hand for this player.
     *
     * Both the open hand and the currently held hand of this player are printed.
     * The user is then expected to select either of both hands by responding with 0 or 1.
     * If the openHand is selected, that becomes the players hand and his prior hand is returned.
     * Else, the openHand is returned.
     *
     * TODO: implement me
     * DONE
     * @param openHand is a hand not already assigned to this player.
     * @return the hand not selected for this player.
     */
    public Hand selectHand(Hand openHand) {
        final String header = "Mit welchem Blatt willst du spielen?";
        String[] options = {String.format("%s%n",this.getHand().toString() ), String.format("%s%n", openHand.toString()) };
        IO.menuSelection(header, options);
        //System.out.printf("0: %s%n", this.getHand().toString());
        //System.out.printf("1: %s%n", openHand.toString());


        int input = IO.selectHandInput();
        switch (input){
            case 0:
                return openHand;
            case 1:
                this.hand.swapHand(openHand);
                return openHand;
            default:
                return openHand;
        }

    }

    /**
     * Accesses the hand currently held by this player.
     * @return the hand held.
     */
    public Hand getHand() {
        return hand;
    }

    /**
     * Accesses the id of this player.
     * TODO: implement me
     * @return
     */
    public int getId() { return this.id; }

    @Override
    public String toString() {
        return "Player " + getId() + ": " + hand;
    }
}
