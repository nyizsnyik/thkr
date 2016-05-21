package thkr.test;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

import thkr.model.Futes;

public class FutesTest {

	@Test
	public void testLejaetE() {

		// csak 2016.05.11. után megy át a teszt
		Futes futes1 = new Futes("1", 10000, LocalDate.of(2016, 5, 11), 20000, LocalDate.of(2016, 4, 11));
		assertEquals(true, futes1.lejartE());

		Futes futes2 = new Futes("2", 0, LocalDate.of(2016, 5, 11), 20000, LocalDate.of(2016, 4, 11));
		assertEquals(false, futes2.lejartE());

		// csak 2016.7.11.-ig meg át a teszten
		Futes futes3 = new Futes("3", 10200, LocalDate.of(2016, 7, 11), 20000, LocalDate.of(2016, 4, 11));
		assertEquals(false, futes3.lejartE());

		Futes futes4 = new Futes("4", 0, LocalDate.of(2016, 7, 21), 20000, LocalDate.of(2016, 4, 11));
		assertEquals(false, futes4.lejartE());

		Futes futes5 = new Futes("5", 0, LocalDate.of(2016, 5, 21), 20000, LocalDate.of(2016, 4, 11));
		assertEquals(false, futes5.lejartE());

		// csak 2016.05.21.-ig megy át a teszt
		Futes futes6 = new Futes("6", 1002550, LocalDate.of(2016, 5, 21), 20000, LocalDate.of(2016, 4, 11));
		assertEquals(false, futes6.lejartE());
	}

	@Test
	public void testKelleKamatozni() {

		// csak 2016.05.11. után megy át a teszt
		Futes futes1 = new Futes("1", 10000, LocalDate.of(2016, 5, 11), 20000, LocalDate.of(2016, 4, 11));
		assertEquals(true, futes1.kelleKamatozni());

		Futes futes2 = new Futes("2", 10000, LocalDate.of(2016, 5, 11), 0, LocalDate.of(2016, 4, 11));
		assertEquals(false, futes2.kelleKamatozni());

		// csak 2016.07.11-ig megy át a teszt
		Futes futes3 = new Futes("3", 10000, LocalDate.of(2016, 5, 11), 203000, LocalDate.of(2016, 6, 11));
		assertEquals(false, futes3.kelleKamatozni());

		Futes futes4 = new Futes("4", 10000, LocalDate.of(2016, 5, 11), 0, LocalDate.of(2016, 6, 11));
		assertEquals(false, futes4.kelleKamatozni());

		// csak 2016.05.21.-ig megy át a teszt
		Futes futes5 = new Futes("5", 10000, LocalDate.of(2016, 5, 11), 120000, LocalDate.of(2016, 4, 21));
		assertEquals(false, futes5.kelleKamatozni());

		Futes futes6 = new Futes("6", 10000, LocalDate.of(2016, 5, 11), 0, LocalDate.of(2016, 4, 21));
		assertEquals(false, futes6.kelleKamatozni());

		// csak 2016.06.15-ig megy át a teszt
		Futes futes7 = new Futes("7", 10000, LocalDate.of(2016, 5, 11), 120000, LocalDate.of(2016, 5, 15));
		assertEquals(false, futes7.kelleKamatozni());

		Futes futes8 = new Futes("8", 10000, LocalDate.of(2016, 5, 11), 0, LocalDate.of(2016, 5, 15));
		assertEquals(false, futes8.kelleKamatozni());
	}

	@Test
	public void testKamatozasMindenOsszegNullaKamatNulla() {
		int kamat = 0;
		Futes futes1 = new Futes("1", 0, LocalDate.of(2016, 5, 11), 0, LocalDate.of(2016, 4, 11));
		futes1.kamatozas(kamat);
		assertEquals(0, futes1.getAktualisOsszeg());
		assertEquals(0, futes1.getLejartTartozas());
		assertEquals(LocalDate.of(2016, 5, 11), futes1.getLejaratiDatum());
		assertEquals(LocalDate.of(2016, 4, 11), futes1.getUtorsoKatamtozas());

		Futes futes2 = new Futes("2", 0, LocalDate.of(2016, 7, 11), 0, LocalDate.of(2016, 7, 11));
		futes2.kamatozas(kamat);
		assertEquals(0, futes2.getAktualisOsszeg());
		assertEquals(0, futes2.getLejartTartozas());
		assertEquals(LocalDate.of(2016, 7, 11), futes2.getLejaratiDatum());
		assertEquals(LocalDate.of(2016, 7, 11), futes2.getUtorsoKatamtozas());

		Futes futes3 = new Futes("3", 0, LocalDate.of(2016, 5, 11), 0, LocalDate.of(2016, 7, 11));
		futes3.kamatozas(kamat);
		assertEquals(0, futes3.getAktualisOsszeg());
		assertEquals(0, futes3.getLejartTartozas());
		assertEquals(LocalDate.of(2016, 5, 11), futes3.getLejaratiDatum());
		assertEquals(LocalDate.of(2016, 7, 11), futes3.getUtorsoKatamtozas());

		Futes futes4 = new Futes("4", 0, LocalDate.of(2016, 7, 11), 0, LocalDate.of(2016, 4, 11));
		futes4.kamatozas(kamat);
		assertEquals(0, futes4.getAktualisOsszeg());
		assertEquals(0, futes4.getLejartTartozas());
		assertEquals(LocalDate.of(2016, 7, 11), futes4.getLejaratiDatum());
		assertEquals(LocalDate.of(2016, 4, 11), futes4.getUtorsoKatamtozas());
	}

	@Test
	public void testKamatozasAktualisOsszegNullaKamatNulla() {
		int kamat = 0;
		Futes futes1 = new Futes("1", 0, LocalDate.of(2016, 5, 11), 1000, LocalDate.of(2016, 4, 11));
		futes1.kamatozas(kamat);
		assertEquals(0, futes1.getAktualisOsszeg());
		assertEquals(1000, futes1.getLejartTartozas());
		assertEquals(LocalDate.of(2016, 5, 11), futes1.getLejaratiDatum());
		// csak 2016.06.11.-ig megy át a teszten
		assertEquals(LocalDate.of(2016, 5, 11), futes1.getUtorsoKatamtozas());

		Futes futes2 = new Futes("2", 0, LocalDate.of(2016, 7, 11), 1000, LocalDate.of(2016, 7, 11));
		futes2.kamatozas(kamat);
		assertEquals(0, futes2.getAktualisOsszeg());
		assertEquals(1000, futes2.getLejartTartozas());
		assertEquals(LocalDate.of(2016, 7, 11), futes2.getLejaratiDatum());
		// csak 2016.08.11.-ig megy át a teszten
		assertEquals(LocalDate.of(2016, 7, 11), futes2.getUtorsoKatamtozas());

		Futes futes3 = new Futes("3", 0, LocalDate.of(2016, 5, 11), 1000, LocalDate.of(2016, 7, 11));
		futes3.kamatozas(kamat);
		assertEquals(0, futes3.getAktualisOsszeg());
		assertEquals(1000, futes3.getLejartTartozas());
		assertEquals(LocalDate.of(2016, 5, 11), futes3.getLejaratiDatum());
		// csak 2016.08.11.-ig megy át a teszten
		assertEquals(LocalDate.of(2016, 7, 11), futes3.getUtorsoKatamtozas());

		Futes futes4 = new Futes("4", 0, LocalDate.of(2016, 7, 11), 1000, LocalDate.of(2016, 4, 11));
		futes4.kamatozas(kamat);
		assertEquals(0, futes4.getAktualisOsszeg());
		assertEquals(1000, futes4.getLejartTartozas());
		assertEquals(LocalDate.of(2016, 7, 11), futes4.getLejaratiDatum());
		// csak 2016.06.11.-ig megy át a teszten
		assertEquals(LocalDate.of(2016, 5, 11), futes4.getUtorsoKatamtozas());
	}

	@Test
	public void testKamatozasLejartTartozasNullaKamatNulla() {
		int kamat = 0;
		Futes futes1 = new Futes("1", 1000, LocalDate.of(2016, 5, 11), 0, LocalDate.of(2016, 4, 11));
		futes1.kamatozas(kamat);
		assertEquals(0, futes1.getAktualisOsszeg());
		assertEquals(1000, futes1.getLejartTartozas());
		// csak 2016.06.11.-ig megy át a teszten
		assertEquals(LocalDate.of(2016, 5, 11), futes1.getLejaratiDatum());
		// csak 2016.06.11.-ig megy át a teszten
		assertEquals(LocalDate.of(2016, 4, 11), futes1.getUtorsoKatamtozas());

		Futes futes2 = new Futes("2", 1000, LocalDate.of(2016, 7, 11), 0, LocalDate.of(2016, 7, 11));
		futes2.kamatozas(kamat);
		// csak 2016.07.11.-ig megy át a teszten
		assertEquals(1000, futes2.getAktualisOsszeg());
		// csak 2016.07.11.-ig megy át a teszten
		assertEquals(0, futes2.getLejartTartozas());
		// csak 2016.07.11.-ig megy át a teszten
		assertEquals(LocalDate.of(2016, 7, 11), futes2.getLejaratiDatum());
		// csak 2016.08.11.-ig megy át a teszten
		assertEquals(LocalDate.of(2016, 7, 11), futes2.getUtorsoKatamtozas());

		Futes futes3 = new Futes("3", 1000, LocalDate.of(2016, 5, 11), 0, LocalDate.of(2016, 7, 11));
		futes3.kamatozas(kamat);
		assertEquals(0, futes3.getAktualisOsszeg());
		assertEquals(1000, futes3.getLejartTartozas());
		// csak 2016.07.11.-ig megy át a teszten
		assertEquals(LocalDate.of(2016, 7, 11), futes3.getLejaratiDatum());
		// csak 2016.08.11.-ig megy át a teszten
		assertEquals(LocalDate.of(2016, 7, 11), futes3.getUtorsoKatamtozas());

		Futes futes4 = new Futes("4", 1000, LocalDate.of(2016, 7, 11), 0, LocalDate.of(2016, 4, 11));
		futes4.kamatozas(kamat);
		// csak 2016.07.11.-ig megy át a teszten
		assertEquals(1000, futes4.getAktualisOsszeg());
		// csak 2016.07.11.-ig megy át a teszten
		assertEquals(0, futes4.getLejartTartozas());
		// csak 2016.07.11.-ig megy át a teszten
		assertEquals(LocalDate.of(2016, 7, 11), futes4.getLejaratiDatum());
		// csak 2016.07.11.-ig megy át a teszten
		assertEquals(LocalDate.of(2016, 4, 11), futes4.getUtorsoKatamtozas());
	}

	@Test
	public void testKamatozasEgyikSeNullaKamatNulla() {
		int kamat = 0;
		Futes futes1 = new Futes("1", 1000, LocalDate.of(2016, 5, 11), 1000, LocalDate.of(2016, 4, 11));
		futes1.kamatozas(kamat);
		assertEquals(0, futes1.getAktualisOsszeg());
		assertEquals(2000, futes1.getLejartTartozas());
		// csak 2016.06.11.-ig megy át a teszten
		assertEquals(LocalDate.of(2016, 5, 11), futes1.getLejaratiDatum());
		// csak 2016.06.11.-ig megy át a teszten
		assertEquals(LocalDate.of(2016, 5, 11), futes1.getUtorsoKatamtozas());

		Futes futes2 = new Futes("2", 1000, LocalDate.of(2016, 7, 11), 1000, LocalDate.of(2016, 7, 11));
		futes2.kamatozas(kamat);
		// csak 2016.07.11.-ig megy át a teszten
		assertEquals(1000, futes2.getAktualisOsszeg());
		// csak 2016.07.11.-ig megy át a teszten
		assertEquals(1000, futes2.getLejartTartozas());
		// csak 2016.08.11.-ig megy át a teszten
		assertEquals(LocalDate.of(2016, 7, 11), futes2.getLejaratiDatum());
		// csak 2016.08.11.-ig megy át a teszten
		assertEquals(LocalDate.of(2016, 7, 11), futes2.getUtorsoKatamtozas());

		Futes futes3 = new Futes("3", 1000, LocalDate.of(2016, 5, 11), 1000, LocalDate.of(2016, 7, 11));
		futes3.kamatozas(kamat);
		assertEquals(0, futes3.getAktualisOsszeg());
		assertEquals(2000, futes3.getLejartTartozas());
		// csak 2016.08.11.-ig megy át a teszten
		assertEquals(LocalDate.of(2016, 7, 11), futes3.getLejaratiDatum());
		// csak 2016.08.11.-ig megy át a teszten
		assertEquals(LocalDate.of(2016, 7, 11), futes3.getUtorsoKatamtozas());

		Futes futes4 = new Futes("4", 1000, LocalDate.of(2016, 7, 11), 1000, LocalDate.of(2016, 4, 11));
		futes4.kamatozas(kamat);
		// csak 2016.07.11.-ig megy át a teszten
		assertEquals(1000, futes4.getAktualisOsszeg());
		// csak 2016.07.11.-ig megy át a teszten
		assertEquals(1000, futes4.getLejartTartozas());
		// csak 2016.08.11.-ig megy át a teszten
		assertEquals(LocalDate.of(2016, 7, 11), futes4.getLejaratiDatum());
		// csak 2016.06.11.-ig megy át a teszten
		assertEquals(LocalDate.of(2016, 5, 11), futes4.getUtorsoKatamtozas());

	}

	@Test
	public void testKamatozasEgyikSeNullaKamatNemNulla() {
		int kamat = 10;
		Futes futes1 = new Futes("1", 1000, LocalDate.of(2016, 5, 11), 1000, LocalDate.of(2016, 4, 11));
		futes1.kamatozas(kamat);
		assertEquals(0, futes1.getAktualisOsszeg());
		// csak 2016.06.11.-ig megy át a teszten
		assertEquals(2008, futes1.getLejartTartozas());
		// csak 2016.06.11.-ig megy át a teszten
		assertEquals(LocalDate.of(2016, 5, 11), futes1.getLejaratiDatum());
		// csak 2016.06.11.-ig megy át a teszten
		assertEquals(LocalDate.of(2016, 5, 11), futes1.getUtorsoKatamtozas());

		Futes futes2 = new Futes("2", 1000, LocalDate.of(2016, 7, 11), 1000, LocalDate.of(2016, 7, 11));
		futes2.kamatozas(kamat);
		// csak 2016.07.11.-ig megy át a teszten
		assertEquals(1000, futes2.getAktualisOsszeg());
		// csak 2016.07.11.-ig megy át a teszten
		assertEquals(1000, futes2.getLejartTartozas());
		// csak 2016.08.11.-ig megy át a teszten
		assertEquals(LocalDate.of(2016, 7, 11), futes2.getLejaratiDatum());
		// csak 2016.08.11.-ig megy át a teszten
		assertEquals(LocalDate.of(2016, 7, 11), futes2.getUtorsoKatamtozas());

		Futes futes3 = new Futes("3", 1000, LocalDate.of(2016, 5, 11), 1000, LocalDate.of(2016, 7, 11));
		futes3.kamatozas(kamat);
		assertEquals(0, futes3.getAktualisOsszeg());
		// csak 2016.08.11.-ig megy át a teszten
		assertEquals(2016, futes3.getLejartTartozas());
		// csak 2016.08.11.-ig megy át a teszten
		assertEquals(LocalDate.of(2016, 7, 11), futes3.getLejaratiDatum());
		// csak 2016.08.11.-ig megy át a teszten
		assertEquals(LocalDate.of(2016, 7, 11), futes3.getUtorsoKatamtozas());

		Futes futes4 = new Futes("4", 1000, LocalDate.of(2016, 7, 11), 1000, LocalDate.of(2016, 4, 11));
		futes4.kamatozas(kamat);
		// csak 2016.07.11.-ig megy át a teszten
		assertEquals(1000, futes4.getAktualisOsszeg());
		// csak 2016.06.11.-ig megy át a teszten
		assertEquals(1008, futes4.getLejartTartozas());
		// csak 2016.08.11.-ig megy át a teszten
		assertEquals(LocalDate.of(2016, 7, 11), futes4.getLejaratiDatum());
		// csak 2016.06.11.-ig megy át a teszten
		assertEquals(LocalDate.of(2016, 5, 11), futes4.getUtorsoKatamtozas());

	}

}
