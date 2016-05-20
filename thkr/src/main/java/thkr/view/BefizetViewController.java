package thkr.view;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import thkr.model.Futes;

public class BefizetViewController {

	@FXML
	private TextField osszeg;

	Futes futes;

	private Stage stage;

	public Futes getFutes() {
		return futes;
	}

	public void setFutes(Futes futes) {
		this.futes = futes;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	public void mentesAction() {
		if (futes.getLejartTartozas() > Integer.parseInt(osszeg.getText()))
			futes.setLejartTartozas(futes.getLejartTartozas() - Integer.parseInt(osszeg.getText()));
		else
			futes.setLejartTartozas(0);
			stage.close();
	}

	public void megseAction() {
		stage.close();
	}

}
