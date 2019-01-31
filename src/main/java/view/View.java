package view;

import java.util.LinkedList;
import java.util.List;

import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import view.main.MainView;
import view.winbar.ObserverWinBar;
import view.winbar.WinBarToolsMaximizeOption;
import view.winbar.WindowBar;

public class View implements ObserverWinBar {
	
	private static String TITLE = "DocJava";
	private static Image ICON = new Image("file:src/icon.png");
	private static String CSS = "style.css";
	
	private List<ObserverView> listObserver;
	
	private Stage stage;
	private VBox root;
	private WindowBar winbar;
	private MainView main;
	
	public View(Stage pStage) {
		stage = pStage;
		buildStage();
		initObservers();
	}
	
	private void buildStage() {
		root = new VBox();
		
		// adding component
		winbar = new WindowBar(TITLE, ICON, WinBarToolsMaximizeOption.DISABLE);
		main = new MainView();
		root.getChildren().addAll(winbar, main);
		
		Scene scene = new Scene(root);
		scene.getStylesheets().add(CSS);
//		stage.setM
		stage.initStyle(StageStyle.UNDECORATED);
		stage.setTitle(TITLE);
		stage.getIcons().add(ICON);
		stage.setResizable(false);
		stage.setScene(scene);
	}
	
	private void initObservers() {
		listObserver = new LinkedList<>();
		winbar.addObserver(this);
	}
	
	public void addObserver(ObserverView observer) {
		listObserver.add(observer);
	}
	
	public WindowBar getWinBar() {
		return winbar;
	}
	
	private Rectangle2D getSreenSize() {
		return Screen.getPrimary().getVisualBounds();
	}

	@Override
	public void exit() {
		for (ObserverView observer : listObserver) {
			observer.exit();
		}
	}

	@Override
	public void toggleMaximize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void minimize() {
		stage.setIconified(true);
	}

	@Override
	public void windowDraggedAt(double x, double y) {
		stage.setX(x);
		stage.setY(y);
	}
	
}
