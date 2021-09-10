package main;


import labis.cvorovi.CvorDSListe;
import labis.exception.LabisException;
import labis.liste.ADSLista;


public class DSLista extends ADSLista{
	
	
	// nasledjena metoda
	void metoda1(int podatak) {

		CvorDSListe novi = new CvorDSListe(podatak, null, null);
		
		if (prvi == null) {
			prvi = novi;
			return;
		}
		
		
		novi.sledeci = prvi.sledeci;
		
		if (prvi.sledeci != null) {
			prvi.sledeci.prethodni = novi;
		}
		
		
		prvi.sledeci = novi;
		novi.prethodni = prvi;
		
	}


	
	
}
