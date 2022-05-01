package hooks;

import io.cucumber.java.Before;
import stepDefination.StepDefination;

public class Hooks {
	@Before("@s2")
	public void setup() throws Exception
	{
	
		StepDefination m=new StepDefination();
		if(StepDefination.palce_id==null)
		{
		m.add_place_payload("sachin", "french", "kannadiga");
		m.user_call_with_the_request("addPlaceAPI", "post");
		m.verify_place_id_creadted_maps_to_using("sachin","getplaceAPI");
		}
	}

}
