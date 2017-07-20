import junit.*;
//import io.*;
//
public class TestFileChecker extends TestCase{
	private String[] wrong = {"teeeeest.txt", "222.txt", "dsfdfgdf.txt"};
	private String[] right = {"test.txt", "111.txt", "333.txt"};
	//public TestFileChecker(testcheck());
	public void testcheck(){
		FileChecker chck1 = new FileChecker(wrong);
		assertEquals(false, chck1.isOk());
		FileChecker chck2 = new FileChecker(right);
		assertEquals(true, chck2.isOk()); 
	}
	public static void main(String[] args) throws Exception {
        JUnitCore runner = new JUnitCore();
        Result result = runner.run(TestFileChecker.class);
        System.out.println("run tests: " + result.getRunCount());
        System.out.println("failed tests: " + result.getFailureCount());
        System.out.println("ignored tests: " + result.getIgnoreCount());
        System.out.println("success: " + result.wasSuccessful());
    }
}