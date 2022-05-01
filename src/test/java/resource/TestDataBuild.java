package resource;

import java.util.ArrayList;
import java.util.List;

import pojo.AddPlace;
import pojo.Location;

public class TestDataBuild {
	
	public AddPlace addPlacePayload(String name,String address,String language)
	{
		AddPlace  p=new AddPlace();
		  p.setAccuracy(50);
		  p.setName(name);
		  p.setPhone_number("(+91) 983 893 3937");
		  p.setAddress(address);
		  p.setWebsite("http://google.com");
		  p.setLanguage(language);
		  List<String> ls=new ArrayList<String>();
		  ls.add("shoe park");
		  ls.add("shop");
		  Location loc=new Location();
		  loc.setLat(-38.383494);
		  loc.setLng(33.427362);
		  p.setLocation(loc);
		  return p;
		  
	}
	
	public String deletePlace(String place_id)
	{
		return "{\r\n"
				+ "    \"place_id\":\""+place_id+"\"\r\n"
				+ "}";
	}

}
