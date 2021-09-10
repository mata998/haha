package main;


import labis.cvorovi.CvorDSListe;
import labis.liste.ADSLista;

public class DSLista extends ADSLista{
	
	public void printListu() {
		if (prvi == null) {
			System.out.println("Prazna lista");
			return;
		}
		
		CvorDSListe pom = prvi;
		
		System.out.print("Lista: ");
		while (pom != null) {
			System.out.print(pom.podatak + " ");
			
			pom = pom.sledeci;
		}
		
		System.out.println();
	}
	
	public void printUnazad() {
		if (prvi == null) {
			System.out.println("Prazna lista");
			return;
		}
		
		CvorDSListe pom = prvi;
		
		while (pom.sledeci != null) {
			
			pom = pom.sledeci;
		}
		
		System.out.print("Unazad: ");
		while (pom != null) {
			System.out.print(pom.podatak + " ");
			
			pom = pom.prethodni;
		}
		
		System.out.println();
	}

	///////////////////////////////////////////////
	
	public void printListuCiklicnu() {
		if (prvi == null) {
			System.out.println("Prazna lista");
			return;
		}
		
		CvorDSListe pom = prvi;
		
		System.out.print("Lista: ");
		do {
			System.out.print(pom.podatak + " ");
			
			pom = pom.sledeci;
		} while (pom != prvi);
		
		System.out.println();
	}
	
	public void printUnazadCiklicnu() {
		if (prvi == null) {
			System.out.println("Prazna lista");
			return;
		}
		
		CvorDSListe poslednji = prvi.prethodni;
		CvorDSListe pom = poslednji;
		
		System.out.print("Unazad: ");
		do {
			System.out.print(pom.podatak + " ");
			
			pom = pom.prethodni;
		}while (pom != poslednji);
		
		System.out.println();
	}

	public void izbaciSveNegativne() {
		if (prvi == null) {
			return;
		}
		
		CvorDSListe poslednji;
		
		while (prvi.podatak < 0) {
			if (prvi.sledeci == prvi) {
				prvi = null;
				return;
			}
			
			poslednji = prvi.prethodni;
			prvi = prvi.sledeci;
			
			prvi.prethodni = poslednji;
			poslednji.sledeci = prvi;
		}
		
		CvorDSListe pom = prvi;
		
		do {
			
			if (pom.sledeci.podatak < 0) {
				pom.sledeci = pom.sledeci.sledeci;
				pom.sledeci.prethodni = pom;
			}
			else {
				pom = pom.sledeci;
			}
			
			
		} while (pom.sledeci != prvi);
		
	}
	
	////////////////////////////////////////////////
	
	public void izbaciSledeci(CvorDSListe neki) {
		if (neki == null) {
			return;
		}
		
		if (neki == null || neki.sledeci == null) {
			return;
		}
		
		neki.sledeci = neki.sledeci.sledeci;
		if (neki.sledeci != null) {
			neki.sledeci.prethodni = neki;
		}
	}
	
	public void preskociMIzbaciN(int m, int n) {
		if (prvi == null) {
			return;
		}
		  
		if (m < 0 || n < 0) {
			return;
		}
		
		if (m == 0) {
			prvi = null;
			return;
		}
		
		if (n == 0) {
			return;
		}
		
		CvorDSListe pom = prvi;
		
		while (true) {
			
			for (int i = 0; i<m-1; i++) {
				pom = pom.sledeci;
				
				if (pom == null) {
					return;
				}
			}
			 
			for (int i = 0; i<n; i++) {
				izbaciSledeci(pom);
			}
			
			pom = pom.sledeci;
			if (pom == null) {
				return;
			}
		}
		
	}
	
	
}
