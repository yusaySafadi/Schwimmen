package schwimmen;

public enum Activity {
    SKIP("Aussetzen"), SWAP("Tauschen"), SWAP_ALL("Alle Tauschen"), CLOSE("Schliessen");

    private String activity;

    Activity(String act) {
        activity = act;
    }

    @Override
    public String toString() {
        return activity;
    }

    public static String[] asStringArray() {
        return new String[] { Activity.SKIP.toString(), Activity.SWAP.toString(), Activity.SWAP_ALL.toString(),
                Activity.CLOSE.toString() };
    }
}
