package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class TTTController implements Initializable {

	//----------------------------
	// Attribute
	
	@FXML
	GridPane gridPane;

	@FXML
	Pane pane00;

	@FXML
	Pane pane01;

	@FXML
	Pane pane02;

	@FXML
	Pane pane10;

	@FXML
	Pane pane11;
	
	@FXML
	Pane pane12;
	
	@FXML
	Pane pane20;
	
	@FXML
	Pane pane21;
	
	@FXML
	Pane pane22;
	
	@FXML
	Text textWhoWins;

	private TTTModel dasSpiel = null;

	//----------------------------
	// Methoden

	private void gitterAktualisieren() {
		// Zelle fuer Zelle durchlaufen
		for (int i = 0; i < 3; i++) {
			// Zelle-Pane durch Scene zugreifen
			for(int j = 0; j < 3; j++) {
				Pane paneZelle = (Pane) gridPane.lookup("#pane" + i + "" + j);
				// Symbol ablesen
				char c = dasSpiel.getCell(i,j);

				// Fortsetzen, nur wenn die Zelle
				// noch leer ist UND ein Kreuz
				// gemalt werden muss
				if (paneZelle.getChildren().isEmpty() &&
						c != ' ') {

					// Text-Darstellung des Symbols vorbereiten
					Text text = new Text();
					if(c == 'X')text.setText("X");
					else if(c == 'O')text.setText("O");
					Font font = new Font(50);
					text.setFont(font);
					text.setFill(Color.MEDIUMSEAGREEN);
					text.setX(50);
					text.setY(75);

					// Der Text in die Zelle einfuegen
					paneZelle.getChildren().add(text);
				}
			}
		}

		if (!(dasSpiel.getWinner() == ' ')) {
			textWhoWins.setText("Gewonnen!");
			textWhoWins.setDisable(true);
		}
		else if(dasSpiel.getWinner() == ' ' && dasSpiel.getEmptyCells()==0) {
			textWhoWins.setText("Unentschieden!");
			textWhoWins.setDisable(true);
		}
		
	
		
		
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		pane00.setOnMouseClicked(this::handlePaneZelle);
		pane01.setOnMouseClicked(this::handlePaneZelle);
		pane02.setOnMouseClicked((e)->handlePaneZelle(e));
		pane10.setOnMouseClicked(this::handlePaneZelle);
		pane11.setOnMouseClicked(this::handlePaneZelle);
		pane12.setOnMouseClicked(this::handlePaneZelle);
		pane20.setOnMouseClicked(this::handlePaneZelle);
		pane21.setOnMouseClicked(this::handlePaneZelle);
		pane22.setOnMouseClicked(this::handlePaneZelle);

		dasSpiel = new TTTModel();

		textWhoWins.setText("");
		textWhoWins.setFill(Color.ORANGE);
	}

	public void handlePaneZelle(MouseEvent event) {
		if(dasSpiel.gameFinished)return;
		Node zelle = (Node) event.getSource();
		String fxId = zelle.getId();
		int length = fxId.length();
		int i = Integer.parseInt(fxId.substring(length - 2, length - 1));
		int j = Integer.parseInt(fxId.substring(length -1, length));
		dasSpiel.playersTurn(i,j);
		zelle.setDisable(true);
		gitterAktualisieren();		
		
		PauseTransition pause = new PauseTransition(Duration.seconds(2));
		pause.setOnFinished(e->{
			String position = dasSpiel.computersTurn();
			textWhoWins.setText("Computer hat entschieden.");
			gitterAktualisieren();
			gridPane.setDisable(false);
			disablePane(position);
		});
		pause.play();
		gridPane.setDisable(true);
		if(!dasSpiel.gameFinished) {
		textWhoWins.setText("Computer überlegt..");
		}
		
		}
	
	private void disablePane(String position) {
		switch(position) {
		case "0|0" : pane00.setDisable(true);break;
		case "0|1" : pane01.setDisable(true);break;
		case "0|2" : pane02.setDisable(true);break;
		case "1|0" : pane10.setDisable(true);break;
		case "1|1" : pane11.setDisable(true);break;
		case "1|2" : pane12.setDisable(true);break;
		case "2|0" : pane20.setDisable(true);break;
		case "2|1" : pane21.setDisable(true);break;
		case "2|2" : pane22.setDisable(true);break;
		default : break;
		}
	}
	}

