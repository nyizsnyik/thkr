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

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
public class Main extends Application{
	
	private List<Lakas> lakasList = new ArrayList<Lakas>();
	private List<Futes> futesList = new ArrayList<Futes>();
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
		
		
//		this.lakasList.add(new Lakas("1","Nathan Summers","12345","06305554466"));
//		this.lakasList.add(new Lakas("2","asd asd","1332345","06305444554466"));
//		this.lakasList.add(new Lakas("3","asdn Summers","12345","06305554466"));
//		this.lakasList.add(new Lakas("4","Nat asd","12dddddddd345","063055444444454466"));
//		
//		this.futesList.add(new Futes("1",13000,LocalDate.of(2016,6,11),20000,LocalDate.of(2016, 02, 11)));
//		this.futesList.add(new Futes("2",14000,LocalDate.of(2016,7,1),20000,LocalDate.of(2016, 06, 11)));
//		this.futesList.add(new Futes("3",15000,LocalDate.of(2016,4,21),20000,LocalDate.of(2016, 05, 11)));
//		this.futesList.add(new Futes("4",11000,LocalDate.of(2016,8,5),20000,LocalDate.of(2016, 04, 11)));
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
			Futes kivLakas = XmlService.getFutes(lakas);
			kivLakas.kamatozas(XmlService.getKamat());
			Vezerlo.setFutes(kivLakas);
			controller.setFutes(kivLakas);
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


	public List<Futes> getFutesList() {
		return futesList;
	}


	public void setFutesList(ObservableList<Futes> futesList) {
		this.futesList = futesList;
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

	
}
