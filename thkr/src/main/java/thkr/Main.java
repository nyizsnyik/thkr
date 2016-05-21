package thkr;
import java.io.IOException;


import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.converter.LocalDateStringConverter;
import thkr.view.*;
import thkr.model.*;
import java.time.*;
import java.util.ArrayList;
import java.util.List;
import thkr.jpa.XmlService;

public class Main extends Application{
	
	private List<Lakas> lakasList = new ArrayList<Lakas>();
	private Stage primaryStage;
	private BorderPane rootPane;
	
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("..::THKR::..");
		
		createRootPane();
		createAdatokView();
	}
	public Main(){
		lakasList= XmlService.getAllLakas();
	}
	
	public static void main(String[] args) {
		launch(args);

	}
	
	private void createRootPane(){
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("view/RootPanelView.fxml"));
		try {
			rootPane = (BorderPane)loader.load();
			RootPanelViewController rpvc=loader.getController();
			rpvc.setMain(this);
			Scene scene = new Scene(rootPane);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	private void createAdatokView(){
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("view/AdatokView.fxml"));
		try {
			AnchorPane adatokView = (AnchorPane)loader.load();
			rootPane.setCenter(adatokView);
			
			AdatokController controller = loader.getController();
			controller.setMain(this);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void createAdatokEditView(Lakas lakas){
		
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("view/AdatokEditView.fxml"));
		try {
			AnchorPane adatokEditView = (AnchorPane)loader.load();
			Stage stage = new Stage();
			stage.setTitle("Kiválasztott lakás adatainak szerkeztése");
			stage.initModality(Modality.WINDOW_MODAL);
			stage.initOwner(primaryStage);
			
			Scene scene = new Scene(adatokEditView);
			stage.setScene(scene);
			
			AdatokEditController controller = loader.getController();
			controller.setLakas(lakas);
			controller.setStage(stage);
			stage.showAndWait();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
public void createTartozasView(Lakas lakas){
		
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("view/TartozasView.fxml"));
		try {
			AnchorPane tartozasView = (AnchorPane)loader.load();
			Stage stage = new Stage();
			stage.setTitle("Kiválasztott lakás számlája");
			stage.initModality(Modality.WINDOW_MODAL);
			stage.initOwner(primaryStage);
			
			Scene scene = new Scene(tartozasView);
			stage.setScene(scene);
			
			TartozasViewController controller = loader.getController();
			controller.setMain(this);
			controller.setFutes(XmlService.getFutes(lakas));
			controller.setStage(stage);
			stage.showAndWait();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public List<Lakas> getLakasList() {
		return lakasList;
	}


	public void setLakasList(ObservableList<Lakas> lakasList) {
		this.lakasList = lakasList;
	}

	public void createBefizetView(Futes futes) {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("view/BefizetView.fxml"));
		try {
			AnchorPane befizetView = (AnchorPane)loader.load();
			Stage stage = new Stage();
			stage.setTitle("Összeg befizetése");
			stage.initModality(Modality.WINDOW_MODAL);
			stage.initOwner(primaryStage);
			
			Scene scene = new Scene(befizetView);
			stage.setScene(scene);
			
			BefizetViewController controller = loader.getController();
			controller.setFutes(futes);
			controller.setStage(stage);
			stage.showAndWait();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void createKamatEditView() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("view/KamatEditView.fxml"));
		try {
			AnchorPane kamatEditView = (AnchorPane)loader.load();
			Stage stage = new Stage();
			stage.setTitle("Kamat módosítás");
			stage.initModality(Modality.WINDOW_MODAL);
			stage.initOwner(primaryStage);
			
			Scene scene = new Scene(kamatEditView);
			stage.setScene(scene);
			
			KamatEditViewController controller = loader.getController();
			controller.setRegikamat(XmlService.getKamat());
			controller.setStage(stage);
			stage.showAndWait();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
public void createUjTartozasView(Futes futes){
		
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("view/UjTartozasView.fxml"));
		try {
			AnchorPane ujTartozasView = (AnchorPane)loader.load();
			Stage stage = new Stage();
			stage.setTitle("Új tartozás hozzáadása");
			stage.initModality(Modality.WINDOW_MODAL);
			stage.initOwner(primaryStage);
			
			Scene scene = new Scene(ujTartozasView);
			stage.setScene(scene);
			
			UjTartozasViewController controller = loader.getController();
			controller.setFutes(futes);
			controller.setStage(stage);
			stage.showAndWait();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
}
