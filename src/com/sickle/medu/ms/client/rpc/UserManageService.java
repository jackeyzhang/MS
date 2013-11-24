/**
 * 
 */
package com.sickle.medu.ms.client.rpc;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.sickle.pojo.edu.Member;


/**
 * @author chenhao
 *
 */
@RemoteServiceRelativePath("UserManageService")
public interface UserManageService extends RemoteService
{
	/**
	 * Utility class for simplifying access to the instance of async service.
	 */
	public static class Util {
		private static UserManageServiceAsync instance;
		public static UserManageServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(UserManageService.class);
			}
			return instance;
		}
	}
	
	Member login(String name,String password) throws Exception;
	
	boolean logout(String name) throws Exception;
	
	boolean sendMail(String to)throws Exception;

}
