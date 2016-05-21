package thkr.view;

import java.time.LocalDate;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import thkr.Vezerlo;
import thkr.model.Futes;

public class UjTartozasViewController {
	
	Futes futes;
	Stage stage;
	
	@FXML
	private TextField ev;
	
	@FXML
	private TextField honap;
	
	@FXML
	private TextField nap;
	
	@FXML
	private TextField osszeg;
	
	public void setFutes(Futes futes) {
		this.futes = futes;
	}
	
	public void setStage(Stage stage) {
		this.stage = stage;
	}
	

	public void mentesAction(){
		this.futes.setAktualisOsszeg(Integer.parseInt(osszeg.getText()));
		this.futes.setLejaratiDatum(LocalDate.of(Integer.parseInt(ev.getText()), Integer.parseInt(honap.getText()), Integer.parseInt(nap.getText())));	
		stage.close();
		
	}
	public void megseAction(){
		stage.close();
	}
	
	
}
