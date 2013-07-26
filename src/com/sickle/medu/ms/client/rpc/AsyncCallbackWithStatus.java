/**
 * 
 */
package com.sickle.medu.ms.client.rpc;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * @author Administrator
 *
 */
public abstract class AsyncCallbackWithStatus<T> implements AsyncCallback<T> {
	
	LoadingHint loadinghint;
	
	public AsyncCallbackWithStatus(String hint){
		this.loadinghint = new LoadingHint(hint);
		loadinghint.show();
	}

	@Override
	public void onFailure(Throwable caught) {
		loadinghint.hide();
		Window.alert("系统出了个小问题:"+caught.getMessage());
	}

	@Override
	public void onSuccess(T result) {
		loadinghint.hide();
		call(result);
	}
	
	public abstract void call(T result);
	
	

}
