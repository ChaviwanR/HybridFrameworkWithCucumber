package utilities;

import pageObject.AdminPage;
import pageObject.DashboardPage;
import pageObject.LoginPage;

public class PageInitializer extends BaseClass{
	public static DashboardPage dp;
	public static AdminPage ap;
	public static LoginPage lp;
	
	
	
	public static void initialize() {
		dp = new DashboardPage();
		ap = new AdminPage();
		lp = new LoginPage();
	}
}
