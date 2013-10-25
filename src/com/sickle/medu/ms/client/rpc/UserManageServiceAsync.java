/**
 * 
 */
package com.sickle.medu.ms.client.rpc;

import com.google.gwt.user.client.rpc.AsyncCallback;


/**
 * @author chenhao
 *
 */
public interface UserManageServiceAsync
{

	void login( String name, String password, AsyncCallback<Boolean> callback );

	void logout( String name, AsyncCallback<Boolean> callback );

}
