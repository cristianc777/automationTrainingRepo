package proyectoUno;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class tareaUnoTraining {

	@DataProvider
	public Object[][] dpTestUno() {
		return new Object[][] {
			new Object[] {"producto1", 12, 2},
			new Object[] {"producto2", 4, 2},
			new Object[] {"producto3", 8, 2}
		};
	}
	
	@DataProvider
	public Object[][] dpTestDos() {
		return new Object[][] {			
			new Object[] {randomString("abcdefghijklmnopqrstuvwxyz",5), randomString("abcdefghijklmnopqrstuvwxyz",10)},
			new Object[] {randomString("abcdefghijklmnopqrstuvwxyz",2), randomString("abcdefghijklmnopqrstuvwxyz",8)},
			new Object[] {randomString("abcdefghijklmnopqrstuvwxyz",5), randomString("abcdefghijklmnopqrstuvwxyz",4)},
			new Object[] {randomString("abcdefghijklmnopqrstuvwxyz",2), randomString("abcdefghijklmnopqrstuvwxyz",7)}
		};
	}


	@Test(dataProvider = "dpTestUno", groups = {"Smoke","Regression"}, priority = 1)
	public void primerTest(String nomMulti, int n1, int n2) {
		System.out.println("La operación: \"" + nomMulti + "\" de los números: " + n1 + " y " + n2 + " es igual a: " + (n1*n2));
	}

	@Test(dataProvider = "dpTestDos",groups = {"Smoke","Regression"}, priority = 2)
	public void segundoTest(String varUno, String varDos) {
		System.out.println("Concatenación: " + varUno + varDos + " de cadenas: " + varUno + " y " + varDos);
	}

	@Test(groups = {"Smoke"}, priority = 3)
	@Parameters("fecha")
	public void tercerTest(String fecha) {
		SimpleDateFormat formatter = new SimpleDateFormat("E, MMM dd yyyy");
		try {
			Date date = formatter.parse(fecha);
			System.out.println("La fecha recibida como parámetro es: " + (new SimpleDateFormat("yyyy/MM/dd").format(date)));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(groups = {"Smoke"}, priority = 4)
	@Parameters("parametro")
	public void cuartoTest(String parametro) {
		int i,j;
		if(parametro.equalsIgnoreCase("AMBIENTE1")) {
			System.out.println("La suma aleatoria de " + (i = (int) (Math.random()*100)) + " más " + (j = (int) (Math.random()*100)) + " es igual a " + (i+j));
		}
		if(parametro.equalsIgnoreCase("AMBIENTE2")) {
			System.out.println("La resta aleatoria de " + (i = (int) (Math.random()*100)) + " menos " + (j = (int) (Math.random()*100)) + " es igual a " + (i-j));
		}
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Se ejecutó: @BeforeMethod");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("Se ejecutó: @AfterMethod");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("Se ejecutó: @BeforeClass");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("Se ejecutó: @afterClass");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("Se ejecutó: @BeforeTest");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("Se ejecutó: @afterTest");
	}

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Se ejecutó: @BeforeSuite");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("Se ejecutó: @afterSuite");
	}
	
	//Método auxiliar de creación de String Random
	public String randomString(String chars, int length) {
		  Random rand = new Random();
		  StringBuilder buf = new StringBuilder();
		  for (int i=0; i<length; i++) {
		    buf.append(chars.charAt(rand.nextInt(chars.length())));
		  }
		  return buf.toString();
		}
	
	

}
