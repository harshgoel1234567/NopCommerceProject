package utility;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    public static ExtentSparkReporter sparkReporter;
    public static ExtentReports extent;
	public static ExtentTest test;
    public static void setExtent() {

        sparkReporter = new ExtentSparkReporter(
                System.getProperty("user.dir") + "/test-output/ExtentReport/MyReport.html"
        );

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        extent.setSystemInfo("HostName", "MyHost");
        extent.setSystemInfo("ProjectName", "MyStoreProject");
        extent.setSystemInfo("Tester", "Harsh Goel");
        extent.setSystemInfo("OS", "Windows 10");
        extent.setSystemInfo("Browser", "Chrome");
    }

    public static void endReport() {
        extent.flush();
    }
}
