package com.sickle.medu.ms.client.rpc.util;
import com.google.gwt.event.logical.shared.ResizeEvent;
import com.google.gwt.event.logical.shared.ResizeHandler;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.Window;

/**
 * 提示
 * @author Administrator
 *
 */
public class LoadingHint implements ResizeHandler{
	
	private Window pop;
	
	public LoadingHint(String hint){
		pop = new Window();
		pop.addMember( new Label(hint) );
	}

	@Override
	public void onResize(ResizeEvent event) {
	}

	public void show(){
		pop.draw( );
		pop.centerInPage( );
	}
	
	public void hide(){
		pop.hide();
	}
}
