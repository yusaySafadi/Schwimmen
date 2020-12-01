package test;

interface Testrunner {
    /**
     * Gives a label or description for the test, printed before execution.
     * @return A test label/description.
     */
    String testname();

    /**
     * Executes the test and prints the results.
     */
    void run();
}
