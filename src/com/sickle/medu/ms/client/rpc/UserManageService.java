/**
 * 
 */
package com.sickle.medu.ms.client.rpc;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;


/**
 * @author chenhao
 *
 */
@RemoteServiceRelativePath("UserManageService")
public interface UserManageService extends RemoteService
{
	
	boolean login(String name,String password) throws Exception;
	
	boolean logout(String name) throws Exception;

}
