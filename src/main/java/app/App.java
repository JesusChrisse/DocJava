package app;

import javafx.application.Application;
import javafx.stage.Stage;
import view.ObserverView;
import view.View;


public class App extends Application implements ObserverView {
	
	private View view;
	private Stage stage;
	
	@Override
	public void start(Stage pStage) throws Exception {
		stage = pStage;
		view = new View(stage);
		view.addObserver(this);
		stage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void exit() {
		System.exit(0);
	}
}
