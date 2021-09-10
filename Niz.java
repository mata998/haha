package main;

import labis.niz.ANiz;

public class Niz extends ANiz{
	
	
	// NASLEDJENA
	void metoda3a(int a, int b) {
		if (niz == null || niz.length == 0) {
			return;
		}
		
		 
		int[] novi = new int[niz.length];
		int nNovog = 0;
		
		for (int i = 0; i<niz.length; i++) {
			if (niz[i] <= a) {
				
				novi[nNovog++] = niz[i];
			}
		}
		
		for (int i = 0; i<niz.length; i++) {
			if (niz[i] > a && niz[i] <= b) {
				
				novi[nNovog++] = niz[i];
			}
		}
		
		
		for (int i = 0; i<niz.length; i++) {
			if (niz[i] > b) {
				
				novi[nNovog++] = niz[i];
			}
		}
		
		niz = novi;
	}
	
	


}
