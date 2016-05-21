package thkr.view;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import thkr.Vezerlo;
import thkr.model.Lakas;
public class AdatokEditController {

	@FXML
	private Label ajtoLabel;
	
	@FXML
	private TextField nevField;
	
	@FXML
	private TextField szSzamField;
	
	@FXML
	private TextField telField;
	
	private Stage stage;
	
	private Lakas lakas;
	
	private AdatokController ac;
	
	public void setAC(AdatokController ac){
		this.ac=ac;
	}
	
	public void setLakas(Lakas lakas){
		this.lakas=lakas;
		
		ajtoLabel.setText(lakas.getAjtoSzam());
		nevField.setText(lakas.getLakoNev());
		szSzamField.setText(lakas.getSzSzam());
		telField.setText(lakas.getTel());
	}
	
	public void setStage(Stage stage){
		this.stage=stage;
	}
	@FXML
	private void megseAction(){
		stage.close();
	}
	
	@FXML
	private void mentesAction(){
		lakas.setLakoNev(nevField.getText());
		lakas.setSzSzam(szSzamField.getText());
		lakas.setTel(telField.getText());
		Vezerlo.setLakas(lakas);
		stage.close();
	}
}
