
package com.sickle.medu.ms.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.History;
import com.sickle.medu.ms.client.iportal.IPageConst;
import com.sickle.medu.ms.client.iportal.page.ForgetPasswordPage;
import com.sickle.medu.ms.client.iportal.page.LoginPage;
import com.sickle.medu.ms.client.iportal.page.MSPage;
import com.sickle.medu.ms.client.iportal.page.ManageSelfPage;
import com.sickle.medu.ms.client.iportal.page.MeduIndexPage;
import com.sickle.medu.ms.client.iportal.page.MemberPage;
import com.sickle.medu.ms.client.iportal.page.OrgPage;
import com.sickle.medu.ms.client.iportal.page.RegisterPage;
import com.sickle.pojo.edu.Member;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class MS implements EntryPoint
{

	private static boolean isFirstVisit = true;
	
	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad( )
	{
		initHistoryMange( );
		History.newItem( IPageConst.PAGE_LOGIN );
	}

	public void initHistoryMange( )
	{
		History.addValueChangeHandler( new ValueChangeHandler<String>( ) {

			@Override
			public void onValueChange( ValueChangeEvent<String> event )
			{
				if ( event.getValue( ).equalsIgnoreCase( IPageConst.PAGE_MEDU ) )
				{
					isFirstVisit = false;
					LoginPage.getInstance( ).clear( );
					RegisterPage.getInstance( ).clear( );
					MemberPage.getInstance( ).clear( );
					OrgPage.getInstance( ).clear( );
					ManageSelfPage.getInstance( ).clear( );
					ForgetPasswordPage.getInstance( ).clear( );
					MSPage.getInstance( ).clear( );

					MeduIndexPage.getInstance( ).draw( );
				}
				else if ( event.getValue( ).equalsIgnoreCase(
						IPageConst.PAGE_LOGIN ) )
				{
					if ( isFirstVisit == false )
					{
						MeduIndexPage.getInstance( ).clear( );
					}
					RegisterPage.getInstance( ).clear( );
					MemberPage.getInstance( ).clear( );
					OrgPage.getInstance( ).clear( );
					ManageSelfPage.getInstance( ).clear( );
					ForgetPasswordPage.getInstance( ).clear( );
					MSPage.getInstance( ).clear( );

					LoginPage.getInstance( ).draw( );
				}
				else if ( event.getValue( ).equalsIgnoreCase(
						IPageConst.PAGE_REGISTER ) )
				{
					if ( isFirstVisit == false )
					{
						MeduIndexPage.getInstance( ).clear( );
					}
					LoginPage.getInstance( ).clear( );
					MemberPage.getInstance( ).clear( );
					OrgPage.getInstance( ).clear( );
					ManageSelfPage.getInstance( ).clear( );
					ForgetPasswordPage.getInstance( ).clear( );
					MSPage.getInstance( ).clear( );

					RegisterPage.getInstance( ).draw( );
				}
				else if ( event.getValue( ).startsWith( IPageConst.PAGE_MEMBER ) )
				{
					// TODO 提供memberid 显示对应member界面或提示先注册或登录
					MeduIndexPage.getInstance( ).clear( );
					LoginPage.getInstance( ).clear( );
					RegisterPage.getInstance( ).clear( );
					OrgPage.getInstance( ).clear( );
					ManageSelfPage.getInstance( ).clear( );
					ForgetPasswordPage.getInstance( ).clear( );
					MSPage.getInstance( ).clear( );

					MemberPage.getInstance( ).draw( );
					int id = Integer.parseInt( event.getValue( ).substring(
							IPageConst.PAGE_MEMBER.length( ) + 1 ) );
					MemberPage.getInstance( ).loadingMember( id );

				}
				else if ( event.getValue( ).startsWith(
						IPageConst.PAGE_MANAGESELF ) )
				{
					MeduIndexPage.getInstance( ).clear( );
					LoginPage.getInstance( ).clear( );
					RegisterPage.getInstance( ).clear( );
					OrgPage.getInstance( ).clear( );
					MemberPage.getInstance( ).clear( );
					ForgetPasswordPage.getInstance( ).clear( );
					MSPage.getInstance( ).clear( );

					ManageSelfPage.getInstance( ).draw( );
					ManageSelfPage.getInstance( ).loadingMember(
							MeduIndexPage.getInstance( ).getTopbar( )
									.getMember( ) );
				}
				else if ( event.getValue( ).startsWith( IPageConst.PAGE_ORG ) )
				{
					MeduIndexPage.getInstance( ).clear( );
					LoginPage.getInstance( ).clear( );
					RegisterPage.getInstance( ).clear( );
					MemberPage.getInstance( ).clear( );
					ManageSelfPage.getInstance( ).clear( );
					ForgetPasswordPage.getInstance( ).clear( );
					MSPage.getInstance( ).clear( );

					OrgPage.getInstance( ).draw( );
					int id = Integer
							.parseInt( event.getValue( ).substring(IPageConst.PAGE_ORG.length() +1) );
					OrgPage.getInstance( ).loadingOrg( id );
				}
				else if ( event.getValue( ).equals(
						IPageConst.PAGE_FORGETPASSWORD ) )
				{
					if ( isFirstVisit == false )
					{
						MeduIndexPage.getInstance( ).clear( );
					}
					LoginPage.getInstance( ).clear( );
					RegisterPage.getInstance( ).clear( );
					MemberPage.getInstance( ).clear( );
					ManageSelfPage.getInstance( ).clear( );
					OrgPage.getInstance( ).clear( );
					MSPage.getInstance( ).clear( );

					ForgetPasswordPage.getInstance( ).draw( );
				}
				else if ( event.getValue( ).startsWith(
						IPageConst.PAGE_MS ) )
				{
					clearIportal();
					
					Member _member = MeduIndexPage.getInstance( ).getTopbar( )
							.getMember( );
					/*Member _member = new Member("王小二","zhangchenhao@139.com","password");
					_member.setId( 12345 );
					_member.setSex( "男" );
					_member.setIcon( "icons/header/user_male1.png" );
					_member.setTitle( "title" );
					_member.setResume( "resume" );
					_member.setCharacter( "teacher" );*/
					
					MSPage.getInstance( ).getMemberpanel( ).fillpanel( _member );
					MSPage.getInstance( ).draw( );
					
				}
				else
				{
					History.newItem( IPageConst.PAGE_LOGIN );
				}

			}
		} );
	}

	private void clearIportal( )
	{
		MeduIndexPage.getInstance( ).clear( );
		LoginPage.getInstance( ).clear( );
		RegisterPage.getInstance( ).clear( );
		MemberPage.getInstance( ).clear( );
		ManageSelfPage.getInstance( ).clear( );
		OrgPage.getInstance( ).clear( );
		ForgetPasswordPage.getInstance( ).clear( );
	}
}
