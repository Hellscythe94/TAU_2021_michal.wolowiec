package pl.pjwstk.s13119.tau;

import org.junit.jupiter.api.Test;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import org.junit.jupiter.api.BeforeAll;
import org.joda.time.DateTime;
import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

public class NewDependenciesTest {

	private static OkHttpClient client;
	private static DateTime dt;
	
	@BeforeAll
	public static void setUp(){
		client = new OkHttpClient();
		dt = new DateTime();
		System.out.println("Before");
	}
	
	@AfterAll
	public static void tearDown(){
		client = null;
		System.out.println("After");
	}
	
	@Test
	public void testOkHttp() throws IOException {
		Request request = new Request.Builder()
		        .url("https://raw.githubusercontent.com/square/okhttp/master/samples/guide/src/main/java/okhttp3/guide/GetExample.java")
		        .build();

		try (Response response = client.newCall(request).execute()) {
		      assertNotNull(response.body());
		}
	}
	
	@Test
	public void testCurrentMonth() {
		int currentMonth = 12;
		assertEquals(currentMonth, dt.getMonthOfYear());
	}
	
	@Test
	public void testcurrentYear() {
		int currentYear = 2021;
		assertEquals(currentYear, dt.getYear());
	}
	
}
