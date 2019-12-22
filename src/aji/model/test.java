package aji.model;


import java.time.LocalDate;


public class test {

	public static void main(String[] args) {

		
		GestionePrenotazioni ges =new GestionePrenotazioni();
		ges.caricaPrenitazioni();
//		
//		Prenotazione p=new Prenotazione("lina","3209589668",5,"201912252030");
//		
//		ges.addPrenotazione(p.toString());
//		

		ges.addPrenotazione("1230 2 linza 4444",LocalDate.of(2019, 12, 25));
		ges.caricaPrenitazioni();
//		System.out.println(ges.prenotazioni.size());
//		ges.addPrenotazione("lina 3209589668 5 2030",LocalDate.of(2019, 12, 25));
//		
//		System.out.println(ges.prenotazioni.size());
//		
//		System.out.println(ges.primo(LocalDate.of(2019, 12, 25)).size());
	
//		if(p.equals(p1)) {
//			System.out.println("ok");
//		}
//		Prenotazione p=new Prenotazione("lina 320959555 5 2000", LocalDate.of(2019, 12, 25));
//		ges.elimina("LINA 3209589668 2 1230", LocalDate.of(2019, 12, 25));
//		System.out.println(p.toString());
//		System.out.println(ges.prenotazioni.get(0).toString());
	}

}
