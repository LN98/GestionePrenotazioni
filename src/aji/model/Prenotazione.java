package aji.model;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Prenotazione {
	
	public String nome; //nome
	public int n;//numero posti

	public String orario;
	
	
	public Prenotazione(int n, String orario,String nome) {
		this.nome = nome;
		this.n = n;
		this.orario=orario;

	}
	
	public Prenotazione(String s,LocalDate d) {
		DateTimeFormatter formatterr = DateTimeFormatter.ofPattern("yyyyMMdd");
		String[] l;
		l=s.split(" "); //nome tel n orario attivo
		
		int n=Integer.parseInt(l[1]);
		this.nome=l[2]+" "+l[3];
		this.n=n;
		this.orario=d.format(formatterr)+l[0];
		
	}


	@Override
	public String toString() {

		return n + " "  + orario + " "+ nome;

	}
	
	public String toStringP() {
		return n + " " + orario.substring(8) + " "+ nome;
	}
	
	
	


	
	
	
	
	
	

}
