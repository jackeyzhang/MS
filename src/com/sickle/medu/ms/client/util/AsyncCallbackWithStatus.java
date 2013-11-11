/**
 * 
 */
package com.sickle.medu.ms.client.util;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.sickle.medu.ms.client.ui.dialog.LoadingHintDialog;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;

/**
 * 带状态的异步返回
 * 
 * @author chenhao
 *
 */
public abstract class AsyncCallbackWithStatus<T> implements AsyncCallback<T> {
	
	LoadingHintDialog loadinghint;
	
	public AsyncCallbackWithStatus(){
		this("操作中......");
	}
	
	public AsyncCallbackWithStatus(Canvas can){
		callingshow();
	}
	
	public AsyncCallbackWithStatus(String hint){
		this.loadinghint = new LoadingHintDialog();
		loadinghint.getHintlabel( ).setContents( hint );
		loadinghint.show();
	}

	@Override
	public void onFailure(Throwable caught) {
		if( loadinghint != null)
		{
			loadinghint.hide();
		}
		SC.say("系统出了个小问题:"+caught.getMessage());
	}

	@Override
	public void onSuccess(T result) {
		if( loadinghint != null)
		{
			loadinghint.hide();
		}
		call(result);
	}
	
	public abstract void call(T result);
	
	protected void callingshow(){}

}
