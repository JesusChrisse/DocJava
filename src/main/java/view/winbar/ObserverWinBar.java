package view.winbar;

public interface ObserverWinBar {
	
	public void exit();
	
	public void toggleMaximize();
	
	public void minimize();
	
	public void windowDraggedAt(double x, double y);
}
