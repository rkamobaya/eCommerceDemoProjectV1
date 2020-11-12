package com.DemoProjecteCommerce2TestCases;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.DemoProjecteCommerce4Utilities.Reporting;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class ListernersForParallelExecution extends BaseClass implements ITestListener{
	
	//we may not get consistent result with parallel testing for Extent Report. Why???
	//Whenever a test start an execution, onTestStart() is the 1st method it executes before other methods. In onTestStart(), with the 
	//test=test.createTest(result.getMethod().getMethodName()) it creates an entry, an object that listens to everything that is going on with 
	//the test execution and reports to Extent Report. 
	//But in the same time, other test cases starts executing (if we are in parallel mode). They also start with onTestStart(). So other entries
	//or test objects are also created for them to report their test execution to extent report. As the test cases are executing, confusion are 
	//created among the objects when the objects are listening to the other methods (onSuccess(), onSkipped() and onTestFailure()). 
	//Wrong object to listen to the wrong test case. So when getting the result we get lot of inconsistency.
	//So how to solve this problem in the case of parallel execution ?????
	//Solution---------->In Java, there is class ThreadLocal. That class is responsible to make all your execution Thread safe. ThreadLocal is responsible 
	//to give you the right object for the execution. So it allows us to avoid confusion between the objects.
	
	
	ExtentTest test;
	ExtentReports extent =Reporting.getReportObject();
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();   //to permit parallel execution. We are telling to the ThreadLocal to maintain thread
															            //safe for this class ExtentTest. We don't need that in the single execution.
															//this object extentTest of ThreadLocal class will now store your test object
		public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);                                         //you set your test object into this object extentTest (of ThreadLocal class)
		//you are basically sending all your test objects created by your test cases in the ThreadLocal pool. And ThreadLocal pool is responsible to give you
		//the right object when you are reporting FAILURE or PASS. And to access the right test object to report FAILURE or PASS, you need to 
		//write in the onTestSuccess(), onTestSkipped() and onTestFailure() methods
		// extentTest.get().log(Status.PASS, "Test Passed") in parallel execution  instead of test.log(Status.PASS, "Test Passed") in single execution.
		
	}

	
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		//test.log(Status.PASS, "Test passed");                 in single execution 
		extentTest.get().log(Status.PASS, "Test passed");         //becomes this in parallel execution
		
	}
	
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		//test.log(Status.SKIP, "Test skipped");                  in single execution
		extentTest.get().log(Status.SKIP, "Test skipped");     //becomes this in parallel execution
		
	}
	
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		//test.log(Status.FAIL, "Test failed");                  in parallel execution
		//test.fail(result.getThrowable());				          in parallel execution
		extentTest.get().log(Status.FAIL, "Test failed");      // in parallel execution     you report a failure
		extentTest.get().fail(result.getThrowable());         // in parallel execution     and you extract the error or exception message
		
		String testMethodName = result.getMethod().getMethodName();
		
		
			try {
				//to add screenshot to the extent report. We use the method addScreenCaptureFormatPath(). As arguments, this method
				//has imagePath and method name as arguments. Since getScreenShotPath is a static method, we can can that method 
				//directly without creating an object of its class------> getScreenShotPath(testMethodName,driver) and get the method name
				//dynamically------> result.getMethod().getMethodName
				extentTest.get().addScreenCaptureFromPath(getScreenShotPath(testMethodName,driver), result.getMethod().getMethodName());  //extentTest.get() is added instead of test
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
	}

	
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}


	
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
		
	}

	//Now your framework is thread safe. No matter how many tests run in parallel, the test objects will not override. It will safely place
	//extentTest in mapping and it will give the right test object in runtime.
	//----->This concept is very important to know since everyone now in Agile environment want to run their test cases in parallel execution.
	//----->This is also a famous interview question
	//IQ--->I run many (10 for ex) test cases together, how should I prepare an consolidate report without overriding???
	//answer----->there is a concept called ThreadLocal where I will set it and it will give me from the pool the right test object in runtime.
	
	
	

}
