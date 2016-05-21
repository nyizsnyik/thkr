package thkr.view;

import thkr.Main;

public class RootPanelViewController {
	private Main main;
	
	
	
	public Main getMain() {
		return main;
	}
	public void setMain(Main main) {
		this.main = main;
	}
	public void kill(){
		Runtime.getRuntime().exit(0);
	}
	public void kamatAction(){
		main.createKamatEditView();
	}
}
