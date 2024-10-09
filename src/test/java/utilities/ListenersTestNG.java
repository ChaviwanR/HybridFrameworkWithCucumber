package utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenersTestNG implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("New Test Started" + result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Successfully Executed" + result.getName());
	}
	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("The test has failed" + result.getName());
		
		CommonMethods.takeScreenShot(BaseClass.getDriver());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("The test has skipped");
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("on Start started");
		
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("on Finish ");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
