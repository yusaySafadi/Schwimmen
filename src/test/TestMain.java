package test;

public class TestMain {
    private static Testrunner[] testrunners = new Testrunner[] {
            new TestStack(),
            new TestHandValues()
    };

    private static void runTest(Testrunner tr) {
        try {
            tr.run();
        }
        catch (Exception e) {
          System.out.println("Failed with exception '" + e.getClass().getName() + "': " + e.getMessage());
        }
    }

    /**
     * This executes every configured Testrunner.
     * @param args ignored.
     */
    public static void main(String[] args) {
        for (Testrunner tr: testrunners) {
            String testname = tr.testname() + " in " + tr.getClass().getSimpleName();
            String line = new String(new char[testname.length()]).replace('\0', '-');
            System.out.printf("%s%n%s%n%s%n", line, testname, line);
            runTest(tr);
            System.out.printf("%s%n%n", line);
        }
    }
}
