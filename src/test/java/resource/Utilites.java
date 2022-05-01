package resource;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utilites {
	public static RequestSpecification req;

	public RequestSpecification requestSpecification() throws Exception {
		if (req == null) {
			PrintStream log = new PrintStream(new FileOutputStream("loggin.txt"));
			req = new RequestSpecBuilder().setBaseUri(getGlobalValue("baseURI")).addQueryParam("key", "qaclick123")
					.addFilter(RequestLoggingFilter.logRequestTo(log))
					.addFilter(ResponseLoggingFilter.logResponseTo(log)).setContentType(ContentType.JSON).build();

			return req;
		}

		return req;

	}

	public static String getGlobalValue(String str) throws Exception {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"F:\\selenium_compete_program\\Rest_Assured\\APIframework\\src\\test\\java\\resource\\global.properties");
		prop.load(fis);
		return prop.getProperty(str);

	}

	public static String getJson(Response response, String str) {
		String str1 = response.asString();

		JsonPath js = new JsonPath(str1);
		return js.get(str).toString();
	}

}
