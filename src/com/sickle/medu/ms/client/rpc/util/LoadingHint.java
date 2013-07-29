package com.sickle.medu.ms.client.rpc.util;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.Window;

/**
 * 提示
 * 
 * @author chenhao
 *
 */
public class LoadingHint{
	
	private Window pop;
	
	public LoadingHint(String hint){
		pop = new Window();
		pop.addMember( new Label(hint) );
	}

	public void show(){
		pop.draw( );
		pop.centerInPage( );
	}
	
	public void hide(){
		pop.hide();
	}
}
