package thkr.view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import thkr.Main;
import thkr.model.Futes;

public class TartozasViewController {
	
	Main main;
	
	@FXML
	private Label actTart;
	
	@FXML
	private Label lejDatum;
	
	@FXML
	private Label lejTart;
	
	private Stage stage;
	
	private Futes futes;
	
	public void setFutes(Futes futes){
		this.futes=futes;
		actTart.setText( Integer.toString(futes.getAktualisOsszeg()));
		lejDatum.setText(futes.getLejaratiDatum().toString());
		lejTart.setText(Integer.toString(futes.getLejartTartozas()));
	}
	
	public Main getMain() {
		return main;
	}

	public void setMain(Main main2) {
		this.main = main2;	

	}
	
	public void setStage(Stage stage){
		this.stage=stage;
	}
	
	public void actBefizetAction(){
		this.futes.setAktualisOsszeg(0);
		setFutes(futes);
	}
	
	public void lejBefizetAction(){
		main.createBefizetView(this.futes);
		setFutes(futes);
	}
	
	public void bezarAction(){
		stage.close();
	}
	
	

}
