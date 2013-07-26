package com.sickle.medu.ms.client.rpc;
import com.google.gwt.event.logical.shared.ResizeEvent;
import com.google.gwt.event.logical.shared.ResizeHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;

/**
 * 提示
 * @author Administrator
 *
 */
public class LoadingHint implements ResizeHandler{
	
	private PopupPanel pop;
	
	public LoadingHint(String hint){
		pop = new PopupPanel();
		pop.setModal(true);
		pop.setGlassEnabled(true);
		pop.add(new Label(hint));
		Window.addResizeHandler(this);
	}

	@Override
	public void onResize(ResizeEvent event) {
	}

	public void show(){
		pop.center();
	}
	
	public void hide(){
		pop.hide(true);
	}
}
