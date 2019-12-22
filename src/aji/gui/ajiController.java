/**
 * Sample Skeleton for 'aji.fxml' Controller Class
 */

package aji.gui;

import java.net.URL;
import java.util.ResourceBundle;

import aji.model.GestionePrenotazioni;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class ajiController {

	private GestionePrenotazioni ges;

	public void setModel(GestionePrenotazioni p) {
		ges = p;
	}

	@FXML // ResourceBundle that was given to the FXMLLoader
	private ResourceBundle resources;

	@FXML // URL location of the FXML file that was given to the FXMLLoader
	private URL location;

	@FXML // fx:id="date"
	private DatePicker date; // Value injected by FXMLLoader

	@FXML // fx:id="info"
	private TextField info; // Value injected by FXMLLoader

	@FXML // fx:id="add"
	private Button add; // Value injected by FXMLLoader

	@FXML // fx:id="remove"
	private Button remove; // Value injected by FXMLLoader

	@FXML // fx:id="mattina"
	private ListView<String> mattina; // Value injected by FXMLLoader

	@FXML // fx:id="nMattina"
	private Text nMattina; // Value injected by FXMLLoader

	@FXML // fx:id="primo"
	private ListView<String> primo; // Value injected by FXMLLoader

	@FXML // fx:id="nPrimo"
	private Text nPrimo; // Value injected by FXMLLoader

	@FXML // fx:id="secondo"
	private ListView<String> secondo; // Value injected by FXMLLoader

	@FXML // fx:id="nSecondo"
	private Text nSecondo; // Value injected by FXMLLoader

	@FXML // fx:id="messaggio"
	private Text messaggio; // Value injected by FXMLLoader

	private void clear() {
		mattina.getItems().clear();
		primo.getItems().clear();
		secondo.getItems().clear();
		agg();
		
	}
	
	private void ok() {
		messaggio.setText("OK");
	}
	
	private void errore() {
		messaggio.setText("ERRORE");
	}

	private void agg() {
		for (int i = 0; i < ges.mattina(date.getValue()).size(); i++) {

			mattina.getItems().add(ges.mattina(date.getValue()).get(i).toStringP());
		}
		nMattina.setText(ges.postiM(date.getValue())+"");

		for (int i = 0; i < ges.primo(date.getValue()).size(); i++) {
			primo.getItems().add(ges.primo(date.getValue()).get(i).toStringP());
			

		}
		nPrimo.setText(ges.postiP(date.getValue())+"");

		for (int i = 0; i < ges.secondo(date.getValue()).size(); i++) {

			secondo.getItems().add(ges.secondo(date.getValue()).get(i).toStringP());

		}
		nSecondo.setText(ges.postiS(date.getValue())+"");

	}

	@FXML
	void onAdd(ActionEvent event) {

		try {
			
			ges.addPrenotazione(info.getText(), date.getValue());
			clear();
			
			ok();

		} catch (Exception e) {
			errore();
		}
	}

	@FXML
	void onDate(ActionEvent event) {

		try {
			
			ges.caricaPrenitazioni();
			clear();
			ok();

		} catch (Exception e) {
			errore();
		}
	}

	@FXML
	void onRemove(ActionEvent event) {
		try {
			
			if(mattina.getSelectionModel().getSelectedItem()!=null)
			ges.elimina(mattina.getSelectionModel().getSelectedItem(), date.getValue());
			
			else if(primo.getSelectionModel().getSelectedItem()!=null)
				ges.elimina(primo.getSelectionModel().getSelectedItem(), date.getValue());
			
			else if (secondo.getSelectionModel().getSelectedItem()!=null)
				ges.elimina(secondo.getSelectionModel().getSelectedItem(), date.getValue());
			
			clear();
			

		} catch (Exception e) {
			errore();
		}

	}

	@FXML // This method is called by the FXMLLoader when initialization is complete
	void initialize() {
		assert date != null : "fx:id=\"date\" was not injected: check your FXML file 'aji.fxml'.";
		assert info != null : "fx:id=\"info\" was not injected: check your FXML file 'aji.fxml'.";
		assert add != null : "fx:id=\"add\" was not injected: check your FXML file 'aji.fxml'.";
		assert remove != null : "fx:id=\"remove\" was not injected: check your FXML file 'aji.fxml'.";
		assert mattina != null : "fx:id=\"mattina\" was not injected: check your FXML file 'aji.fxml'.";
		assert nMattina != null : "fx:id=\"nMattina\" was not injected: check your FXML file 'aji.fxml'.";
		assert primo != null : "fx:id=\"primo\" was not injected: check your FXML file 'aji.fxml'.";
		assert nPrimo != null : "fx:id=\"nPrimo\" was not injected: check your FXML file 'aji.fxml'.";
		assert secondo != null : "fx:id=\"secondo\" was not injected: check your FXML file 'aji.fxml'.";
		assert nSecondo != null : "fx:id=\"nSecondo\" was not injected: check your FXML file 'aji.fxml'.";
		assert messaggio != null : "fx:id=\"messeggio\" was not injected: check your FXML file 'aji.fxml'.";

	}
}
