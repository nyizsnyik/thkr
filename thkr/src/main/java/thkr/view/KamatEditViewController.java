package thkr.view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import thkr.Vezerlo;

public class KamatEditViewController {
	@FXML
	private TextField kamat;
	@FXML
	private Label regikamat;
	private Stage stage;
	
	public void setRegikamat(int regikamat){
		this.regikamat.setText(String.valueOf(regikamat));
	}
	
	public Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	public void mentesAction(){
		Vezerlo.setKamat(Integer.parseInt(kamat.getText()));
		stage.close();
	}

	public void megseAction(){
		stage.close();
	}
}
