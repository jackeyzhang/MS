/**
 * 
 */
package com.sickle.medu.ms.client.rpc;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.sickle.pojo.edu.Member;


/**
 * @author chenhao
 *
 */
public interface UserManageServiceAsync
{


	void logout( String name, AsyncCallback<Boolean> callback );

	void login( String name, String password, AsyncCallback<Member> callback );

}
