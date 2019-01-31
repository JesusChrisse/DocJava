package view.winbar;

import java.util.LinkedList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;


public class WindowBar extends HBox {
	private static final String SBL_MINIMIZE = "\uD83D\uDDD5";
	private static final String SBL_MAXIMIZE = "\uD83D\uDDD6"; // to put on fullscreen when it's not
	private static final String SBL_OVERLAP = "\uD83D\uDDD7"; // to put the dimension it was before fullscreen
	private static final String SBL_EXIT = "\uD83D\uDDD9";
	
	private List<ObserverWinBar> listObserver;
	
	private double xOffset, yOffset;
	
	private Label title;
	private ImageView icon;
	private Button btnMinimize, btnToggleMaximize, btnExit;
	
	public WindowBar(String pTitle, Image pIcon, WinBarToolsMaximizeOption screenMode) {
		this.getStyleClass().addAll("windowsBar", "layer1");
		this.getChildren().addAll(buildTitle(pTitle, pIcon), buildTools(screenMode));
		
		initListeners();
		listObserver = new LinkedList<>();
	}
	
	private HBox buildTitle(String pTitle, Image pIcon) {
		HBox subroot = new HBox();
		icon = new ImageView(pIcon);
		title = new Label(pTitle);
		
		subroot.getChildren().addAll(icon, title);
		return subroot;
	}
	
	private HBox buildTools(WinBarToolsMaximizeOption screenMode) {
		HBox subroot = new HBox();
		
		btnMinimize = new Button(SBL_MINIMIZE);
		subroot.getChildren().add(btnMinimize);
		
		switch (screenMode) {
			case MAXIMIZE:
				btnToggleMaximize = new Button(SBL_MAXIMIZE);
				subroot.getChildren().add(btnToggleMaximize);
				break;
			case OVERLAP:
				btnToggleMaximize = new Button(SBL_OVERLAP);
				subroot.getChildren().add(btnToggleMaximize);
				break;
			default:
				btnToggleMaximize = null;
				break;
		}
		
		
		btnExit = new Button(SBL_EXIT);
		subroot.getChildren().add(btnExit);
		
		return subroot;
	}
	
	private void initListeners() {
		btnMinimize.setOnAction(e -> callMinimize());
		
		if (btnToggleMaximize != null)
			btnToggleMaximize.setOnAction(e -> callToggleMaximize());
		
		btnExit.setOnAction(e -> callExit());
		
		this.setOnMousePressed(e -> {
			xOffset = e.getSceneX();
            yOffset = e.getSceneY();
		});
		
		this.setOnMouseDragged(e -> callWindowDragged(e.getSceneX() - xOffset, e.getSceneY() - yOffset));
	}
	
	public void addObserver(ObserverWinBar observer) {
		listObserver.add(observer);
	}
	
	public List<ObserverWinBar> getObservers() {
		return listObserver;
	}
	
	private void callExit() {
		for (ObserverWinBar observer : listObserver) {
			observer.exit();
		}
	}
	
	private void callToggleMaximize() {
		if (btnToggleMaximize.getText() == SBL_MAXIMIZE) {
    		btnToggleMaximize.setText(SBL_OVERLAP);
		} else {
			btnToggleMaximize.setText(SBL_MAXIMIZE);
		}
		
		for (ObserverWinBar observer : listObserver) {
			observer.toggleMaximize();
		}
	}
	
	private void callMinimize() {
		for (ObserverWinBar observer : listObserver) {
			observer.minimize();
		}
	}
	
	private void callWindowDragged(double xDraggedAt, double yDraggedAt) {
		for (ObserverWinBar observer : listObserver) {
			observer.windowDraggedAt(xDraggedAt, yDraggedAt);
		}
	}
	
	public void setTitle(String pTitle) {
		title.setText(pTitle);
	}
	
	public void setIcon(Image pIcon) {
		icon.setImage(pIcon);
	}
}
