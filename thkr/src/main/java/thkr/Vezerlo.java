package thkr;
import thkr.jpa.XmlService;
import thkr.model.*;
public class Vezerlo {
	
	public static void setLakas(Lakas lakas){
		XmlService.setLakas(lakas);
	}
	
	public static void setFutes(Futes futes){
		XmlService.setFutes(futes);
	}

}
