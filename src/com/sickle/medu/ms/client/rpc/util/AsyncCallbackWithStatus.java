/**
 * 
 */
package com.sickle.medu.ms.client.rpc.util;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.smartgwt.client.util.SC;

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
		SC.say("系统出了个小问题:"+caught.getMessage());
	}

	@Override
	public void onSuccess(T result) {
		loadinghint.hide();
		call(result);
	}
	
	public abstract void call(T result);
	
	

}
