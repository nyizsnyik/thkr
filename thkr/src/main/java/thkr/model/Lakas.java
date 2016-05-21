package thkr.model;



import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Lakas {
	

	private StringProperty ajtoSzam;
	private StringProperty lakoNev;
	private StringProperty szSzam;
	private StringProperty tel;
	public String getAjtoSzam() {
		return ajtoSzam.get();
	}
	public void setAjtoSzam(String ajtoSzam) {
		this.ajtoSzam.set(ajtoSzam);
	}
	public String getLakoNev() {
		return lakoNev.get();
	}
	public void setLakoNev(String lakoNev) {
		this.lakoNev.set(lakoNev);
	}
	public String getSzSzam() {
		return szSzam.get();
	}
	public void setSzSzam(String szSzam) {
		this.szSzam.set(szSzam);
	}
	public String getTel() {
		return tel.get();
	}
	public void setTel(String tel) {
		this.tel.set(tel);
	}
	
	public StringProperty getAjtoSzamProperty(){
		return ajtoSzam;
	}
	
	
	public StringProperty getLakoNevProperty(){
		return lakoNev;
	}
	public StringProperty getSzSzamProperty(){
		return szSzam;
	}
	public StringProperty getTelProperty(){
		return tel;
	}
	
	
	
	
	
	
	public Lakas(String ajtoSzam, String lakoNev, String szSzam, String tel) {
		this.ajtoSzam = new SimpleStringProperty(ajtoSzam);
		this.lakoNev = new SimpleStringProperty(lakoNev);
		this.szSzam = new SimpleStringProperty(szSzam);
		this.tel = new SimpleStringProperty(tel);
	}
	@Override
	public String toString() {
		return "Lakas [ajtoSzam=" + ajtoSzam + ", lakoNev=" + lakoNev + ", szSzam=" + szSzam + ", tel=" + tel + "]";
	}
	
	

}
