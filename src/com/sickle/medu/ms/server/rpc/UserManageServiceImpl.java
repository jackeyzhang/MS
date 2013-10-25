/**
 * 
 */
package com.sickle.medu.ms.server.rpc;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.sickle.medu.ms.client.rpc.UserManageService;


/**
 * @author chenhao
 *
 */
public class UserManageServiceImpl extends RemoteServiceServlet implements UserManageService
{

	private static final long serialVersionUID = -4206777572957949158L;

	@Override
	public boolean login( String name, String password ) throws Exception
	{
		getThreadLocalRequest().getSession( ).setMaxInactiveInterval( 30*60 );
		getThreadLocalRequest().getSession( ).setAttribute( "loginname", name );
		return false;
	}

	@Override
	public boolean logout( String name ) throws Exception
	{
		return false;
	}

}
