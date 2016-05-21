package thkr.model;

import java.time.*;
import java.util.HashMap;
import java.util.Map;

public class Futes {
	private String ajtoSzam;
	private int aktualisOsszeg;
	private LocalDate lejaratiDatum;
	private int lejartTartozas;
	private LocalDate utorsoKatamtozas;

	public boolean lejartE(LocalDate localDate) {
		if (this.aktualisOsszeg > 0) {
			if (localDate.isAfter(this.lejaratiDatum))
				return true;
		}
		return false;
	}

	public boolean lejartE() {
		if (this.aktualisOsszeg > 0) {
			if (LocalDate.now().isAfter(this.lejaratiDatum))
				return true;
		}
		return false;
	}

	public boolean kelleKamatozni() {

		if (this.lejartTartozas > 0) {
			if (LocalDate.now().isAfter(utorsoKatamtozas.plusMonths(1))) {
				return true;
			}
		}

		return false;
	}

	public void kamatozas(int evesKamatlab) {

		while (this.kelleKamatozni()) {
			if(lejartE(utorsoKatamtozas))
				this.lejatr();
			this.lejartTartozas += this.lejartTartozas * ((evesKamatlab / 12.0) / 100.0);
			this.utorsoKatamtozas=this.utorsoKatamtozas.plusMonths(1);
		}
	}
	
	public void lejatr(){
		if(this.lejartE()){
			this.lejartTartozas+=this.aktualisOsszeg;
			this.aktualisOsszeg=0;
		}
	}
	
	
	

	public int getAktualisOsszeg() {
		return aktualisOsszeg;
	}

	public void setAktualisOsszeg(int aktualisOsszeg) {
		this.aktualisOsszeg = aktualisOsszeg;
	}

	public LocalDate getLejaratiDatum() {
		return lejaratiDatum;
	}

	public void setLejaratiDatum(LocalDate lejaratiDatum) {
		this.lejaratiDatum = lejaratiDatum;
	}

	public int getLejartTartozas() {
		return lejartTartozas;
	}

	public void setLejartTartozas(int lejartTartozas) {
		this.lejartTartozas = lejartTartozas;
	}

	public LocalDate getUtorsoKatamtozas() {
		return utorsoKatamtozas;
	}

	public void setUtorsoKatamtozas(LocalDate utorsoKatamtozas) {
		this.utorsoKatamtozas = utorsoKatamtozas;
	}
	
	public String getAjtoSzam() {
		return ajtoSzam;
	}

	public Futes(String lakas, int aktualisOsszeg, LocalDate lejaratiDatum, int lejartTartozas, LocalDate utorsoKatamtozas) {
		this.ajtoSzam = lakas;
		this.aktualisOsszeg = aktualisOsszeg;
		this.lejaratiDatum = lejaratiDatum;
		this.lejartTartozas = lejartTartozas;
		this.utorsoKatamtozas = utorsoKatamtozas;
	}
	
	

}
