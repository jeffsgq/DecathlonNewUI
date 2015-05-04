package sendmail;

public class Test_Email {

	public static void main(String[] args) throws Exception{
			nc_desktop.screenshot("Regression_Report.jpg");
			nc_email.realmail(nc_desktop.getName1(),nc_desktop.getName2(),nc_desktop.getException1(),nc_desktop.getException2());
		}
}
