package com.amazon.stepdefinition;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.ReportBuilder;

public class Reporting {

	public static void generateJVMReport(String json) {
		//1.Mention the report location
				File reportDirectory = new File(System.getProperty("user.dir")+"\\target");
		//2.Set Configuration for report
net.masterthought.cucumber.Configuration con = new net.masterthought.cucumber.Configuration(reportDirectory,"Project");	
		//3.Add Classifications for report
				con.addClassifications("platformName", "Windows");
				con.addClassifications("platformVersion", "11");
				con.addClassifications("environment", "QA");
				con.addClassifications("sprint","15");
				con.addClassifications("author", "Jansi");
		//4.Add json file into list
				List<String>jsonFiles = new ArrayList<String>();
				jsonFiles.add(json);
		//5.Create object for reportbuilder class
				ReportBuilder builder = new ReportBuilder(jsonFiles,con);
				builder.generateReports();		
			}
}
