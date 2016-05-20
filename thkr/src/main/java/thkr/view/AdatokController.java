package thkr.view;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn.CellDataFeatures;
import thkr.model.Lakas;
import thkr.Main;
public class AdatokController {
	Main main;
	@FXML
	private TableView<Lakas> lakasTable;
	
	@FXML
	private TableColumn<Lakas, String> lakasOszlop;
	
	@FXML
	private TableColumn<Lakas, String> nevOszlop;
	
	@FXML
	private Label ajtoLabel;
	
	@FXML
	private Label nevLabel;
	
	@FXML
	private Label szSzamLabel;

	@FXML
	private Label telLabel;
	public Main getMain() {
		return main;
	}

	public void setMain(Main main2) {
		this.main = main2;
		//System.out.println(main.getLakasList().get(1).getLakoNev());
		lakasTable.setItems(main2.getLakasList());
		
//		ObservableList<Lakas> lakasList2 = FXCollections.observableArrayList();
//		lakasList2.add(new Lakas("1","Nathan Summers","12345","06305554466"));
//		lakasList2.add(new Lakas("2","asd asd","1332345","06305444554466"));
//		lakasList2.add(new Lakas("3","asdn Summers","12345","06305554466"));
//		lakasList2.add(new Lakas("4","Nat asd","12dddddddd345","063055444444454466"));
//		lakasTable.setItems(lakasList2);
	}
	
	@FXML
	private void initialize(){
		lakasOszlop.setCellValueFactory(a -> a.getValue().getAjtoSzamProperty());
		nevOszlop.setCellValueFactory(a -> a.getValue().getLakoNevProperty());
		
		showAdatok(null);
		lakasTable.getSelectionModel().selectedItemProperty()
		.addListener((observable, oldValue, newValue) -> showAdatok(newValue));
	}
	
	private void showAdatok(Lakas lakas){
		if (lakas==null) {
			ajtoLabel.setText("");
			nevLabel.setText("");
			szSzamLabel.setText("");
			telLabel.setText("");
		}
		else{
			ajtoLabel.setText(lakas.getAjtoSzam());
			nevLabel.setText(lakas.getLakoNev());
			szSzamLabel.setText(lakas.getSzSzam());
			telLabel.setText(lakas.getTel());
		}
	}
	
	@FXML
	private void editAdatok(){
		Lakas data= lakasTable.getSelectionModel().getSelectedItem();
		main.createAdatokEditView(data);
	}
	
	@FXML
	private void tartozas(){
		Lakas data= lakasTable.getSelectionModel().getSelectedItem();
		main.createTartozasView(data);
	}

}
