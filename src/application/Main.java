package application;
	
import application.view.MainInterfaceController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

/**
 * Main class of the project
 * @author Martin
 *
 */
public class Main extends Application {
	
	private int nb_photogrpahe = 3;
	private int largeur_photo = 350;
	private int nb_photo = 5;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader(); //create a loader to load the GUI
            loader.setLocation(Main.class.getResource("view/MainInterface.fxml")); //find the GUI file
			AnchorPane root = loader.load(); //load the GUI in a AnchorPane
			Scene scene = new Scene(root); //create a scene with the GUI
			primaryStage.setScene(scene); //put the scene in a stage (window)
			primaryStage.setTitle("GALA printer Service by TN Studio"); //give a name to the window
			primaryStage.setFullScreen(true); //set the window in fullscreen mode
			MainInterfaceController mainInterfaceController = loader.getController();
			mainInterfaceController.setMain(this);
			primaryStage.show(); //display the window
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		int nb_photographe = 3;
		int largeur_photo = 350;
		int nb_photo = 5;

		if(args.length == 1){
			nb_photographe = Integer.parseInt(args[0]);
		}
		if(args.length == 2){
			largeur_photo = Integer.parseInt(args[1]);
		}
		if(args.length == 3){
			nb_photo = Integer.parseInt(args[2]);
		}
		launch(args); //invoke start method
	}

	public int getNb_photogrpahe() {
		return nb_photogrpahe;
	}

	public void setNb_photogrpahe(int nb_photogrpahe) {
		this.nb_photogrpahe = nb_photogrpahe;
	}

	public int getLargeur_photo() {
		return largeur_photo;
	}

	public void setLargeur_photo(int largeur_photo) {
		this.largeur_photo = largeur_photo;
	}

	public int getNb_photo() {
		return nb_photo;
	}

	public void setNb_photo(int nb_photo) {
		this.nb_photo = nb_photo;
	}
	
	
}
