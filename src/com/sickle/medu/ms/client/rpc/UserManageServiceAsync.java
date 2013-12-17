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

	/**
	 * 根据用户名，发送用户密码到用户的注册邮箱。如果邮箱为空或信息不对，则返回false
	 * @param name
	 * @param callback
	 */
	void sendMail(String name, AsyncCallback<Boolean> callback);
}
