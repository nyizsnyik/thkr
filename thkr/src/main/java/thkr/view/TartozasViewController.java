package thkr.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import thkr.Main;
import thkr.Vezerlo;
import thkr.jpa.XmlService;
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
		futes.kamatozas(XmlService.getKamat());
		Vezerlo.setFutes(futes);
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
	
	public void ujTartozas(){
		if(this.futes.getAktualisOsszeg()<=0){
		main.createUjTartozasView(futes);
		setFutes(futes);}
		else{
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Hiba");
			alert.setHeaderText(null);
			alert.setContentText("Nem adhat hozzá új összeget még nem lejárt tartozása van");

			alert.showAndWait();
		}
	}
	

}
