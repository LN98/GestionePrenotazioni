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
	


	@Override
	public String toString() {

		return n + " "  + orario + " "+ nome;

	}
	
	public String toStringP() {
		return n + " " + orario.substring(8) + " "+ nome;
	}
	
	
	


	
	
	
	
	
	

}
