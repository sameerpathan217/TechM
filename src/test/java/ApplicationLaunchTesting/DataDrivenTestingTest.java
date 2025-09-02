package ApplicationLaunchTesting;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDrivenTestingTest {
	
	@Test(dataProvider="travelTest")
	public void BookTicket(String src,String dest) {
		System.out.println("I must go this city for job in 2k26 "+src+"  and "+dest);
	}
	
    @DataProvider
	public Object[][] travelTest() {
		
		Object[][] obj=new Object[4][2];
		obj[0][0]="Pune";
		obj[0][1]="Mumbai";
		
		obj[1][0]="Hydrabad";
		obj[1][1]="Dubai";
		
		obj[2][0]="London";
		obj[2][1]="Germany";
		
		obj[3][0]="China";
		obj[3][1]="Japan";
		
		return obj;
	}
	
}
