/**
 * 
 */
package application.view;

import observerPattern.MyObserver;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import application.Main;
import application.model.Photographe;

/**
 * A class that give the ids of the GUI components and implements their behaviors
 * @author Martin
 *
 */
public class MainInterfaceController implements MyObserver{

	@FXML
	private ScrollPane photoScroll;

	@FXML
	private ListView<Photographe> listPhotographe;

	@FXML
	private Button settings;

	@FXML
	private Button refresh;

	private Main main;
	private GridPane photoGridPane;

	

	//public static final ObservableList<String> names = FXCollections.observableArrayList();

	@FXML
	private void initialize(){

		photoGridPane = new GridPane(); //create a grid pane to display the pictures
		photoGridPane.setVgap(10); //create gaps to separate pictures
		photoGridPane.setHgap(10); //idem
		photoScroll.setContent(photoGridPane); //put the grid pane into the scrollpane (xml generated)

		settings.setOnMouseClicked(new EventHandler<MouseEvent>() { //load another scene

			@Override
			public void handle(MouseEvent event) {

				main.loadInterface(main.getLoaderSettings(), main.getSettingsInterfaceController(), main.getSceneSettings());
			}
		});


		refresh.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				update();
			}
		});


	}

	public void setMain(Main main){
		this.main=main;

		System.out.println("in main");
		listPhotographe.setItems(main.getPhotographeList());


	}

	@Override
	public void update() { //re-build the view

		//Photographe selectedPhotograph = listPhotographe.getSelectionModel().getSelectedItem();
		Photographe selectedPhotograph = main.getPhotographeList().get(0);
		System.out.println("nombre de photo "+selectedPhotograph.getPhotoList().size());
		int nb_ligne = selectedPhotograph.getPhotoList().size()/main.getNb_photo();
		System.out.println("nombre de ligne "+nb_ligne);
		for(int i = 0; i<nb_ligne; i++){ //create all the imageviews with the picture inside
			for(int j = 0; j<main.getNb_photo(); j++){
				Image image = new Image("file:\\"+selectedPhotograph.getPhotoList().get(i+j).getPath().getValue());
				System.out.println(selectedPhotograph.getPhotoList().get(i+j).getPath().getValue());
				ImageView imageView = new ImageView(image);
				imageView.setFitWidth(main.getLargeur_photo()); //set the width of the pictures
				imageView.setPreserveRatio(true);
				imageView.setOnMouseClicked(new EventHandler<MouseEvent>() {

					@Override
					public void handle(MouseEvent event) {
						System.out.println("clicked");						
					}
				});
				imageView.setCursor(Cursor.HAND); //change the cursor appearance
				photoGridPane.add(imageView, j, i); //add the imageView to the GUI
			}
		}
		int last_ligne = selectedPhotograph.getPhotoList().size()%main.getNb_photo();
		if(nb_ligne ==0){
			for(int i=0;i<selectedPhotograph.getPhotoList().size();i++){
				Image image = new Image("file:\\"+selectedPhotograph.getPhotoList().get(i).getPath().getValue());
				ImageView imageView = new ImageView(image);
				imageView.setFitWidth(main.getLargeur_photo()); //set the width of the pictures
				imageView.setPreserveRatio(true);
				imageView.setOnMouseClicked(new EventHandler<MouseEvent>() {

					@Override
					public void handle(MouseEvent event) {
						System.out.println("clicked");						
					}
				});
				imageView.setCursor(Cursor.HAND); //change the cursor appearance
				photoGridPane.add(imageView, i, 0); //add the imageView to the GUI
			}
		} else {
			for(int i=0;i<last_ligne;i++){
				Image image = new Image("file:\\"+selectedPhotograph.getPhotoList().get(i+nb_ligne).getPath().getValue());
				ImageView imageView = new ImageView(image);
				imageView.setFitWidth(main.getLargeur_photo()); //set the width of the pictures
				imageView.setPreserveRatio(true);
				imageView.setOnMouseClicked(new EventHandler<MouseEvent>() {

					@Override
					public void handle(MouseEvent event) {
						System.out.println("clicked");						
					}
				});
				imageView.setCursor(Cursor.HAND); //change the cursor appearance
				photoGridPane.add(imageView, nb_ligne, i); //add the imageView to the GUI
			}
		}
		

	}

}
