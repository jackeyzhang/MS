/**
 * 
 */
package com.sickle.medu.ms.server.rpc;

import javax.servlet.ServletException;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.sickle.dao.DaoServiceFactory;
import com.sickle.dto.MemberDTO;
import com.sickle.exception.CodeException;
import com.sickle.medu.ms.client.rpc.UserManageService;
import com.sickle.pojo.edu.Member;
import com.sickle.service.itf.IMemberService;


/**
 * @author chenhao
 *
 */
public class UserManageServiceImpl extends RemoteServiceServlet implements UserManageService
{

	private static final long serialVersionUID = -4206777572957949158L;
	
	private static IMemberService service = null;
	

	@Override
	public void init( ) throws ServletException
	{
		super.init( );
		try
		{
			service = DaoServiceFactory.getService( IMemberService.class );
		}
		catch ( CodeException e )
		{
			e.printStackTrace();
		}
	}

	@Override
	public Member login( String name, String password ) throws Exception
	{
		Member member = service.getMemberByLoginName( name );
		if( member == null )
		{
			return null;
		}
		boolean loginok =  member.getPassword( ).equals( password );
		if( loginok )
		{
			getThreadLocalRequest().getSession( ).setMaxInactiveInterval( 30*60 );
			getThreadLocalRequest().getSession( ).setAttribute( "loginname", name );
		}
		return new MemberDTO().to( member );
	}

	@Override
	public boolean logout( String name ) throws Exception
	{
		getThreadLocalRequest().getSession( ).removeAttribute( "loginname" );
		return true;
	}

}
