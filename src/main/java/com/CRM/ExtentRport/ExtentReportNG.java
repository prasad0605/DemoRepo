package com.CRM.ExtentRport;

import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReportNG implements IReporter{
	private ExtentReports extent;
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites,
		      String outputDirectory) {
			  extent=new ExtentReports(outputDirectory+File.separator+"Extent.html",true);
		      //Iterating over each suite included in the test
		      for (ISuite suite : suites) {
		            
		         //Following code gets the suite name
		         String suiteName = suite.getName();
		            
		         //Getting the results for the said suite
		         Map<String, ISuiteResult> suiteResults = suite.getResults();
		         for (ISuiteResult sr : suiteResults.values()) {
		            ITestContext tc = sr.getTestContext();
		            buildTestNodes(tc.getPassedTests(),LogStatus.PASS);
		            buildTestNodes(tc.getFailedTests(),LogStatus.FAIL);
		            buildTestNodes(tc.getSkippedTests(),LogStatus.SKIP);
		         }
		       }
		      extent.flush();
		      extent.close();

}

public void buildTestNodes(IResultMap tests,LogStatus status){
	ExtentTest test = null;
	if(tests.size()>0){
		for(ITestResult result:tests.getAllResults()){
			test=extent.startTest(result.getMethod().getMethodName());
			test.setStartedTime(getTime(result.getStartMillis()));
			test.setEndedTime(getTime(result.getEndMillis()));
			for(String group:result.getMethod().getGroups()){
				test.assignAuthor(group);
			}
			
			if(result.getThrowable()!=null){
				test.log(status, result.getThrowable());
			}else{
					test.log(status,"Test"+status.toString().toLowerCase()+"ed");
				}
		extent.endTest(test);
		}
	}
}
	private Date getTime(long millis){
		
		Calendar calender=Calendar.getInstance();
		calender.setTimeInMillis(millis);
		return calender.getTime();
		
	}
}
