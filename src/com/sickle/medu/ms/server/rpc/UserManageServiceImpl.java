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
import com.sickle.pojo.mail.MailSenderInfo;
import com.sickle.service.SimpleMailSenderService;
import com.sickle.service.itf.IMailSenderService;
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

	@Override
	public boolean sendMail(String name) throws Exception {
		// 查询用户
		Member member = service.getMemberByLoginName(name);
		if (member == null) {
			return false;
		}

		String mail = member.getEmail();

		// 邮箱的格式，由注册界面统计判断，此处不做判断。只判断是否为空
		if (mail != null && !mail.isEmpty()) {
			IMailSenderService mailservice = new SimpleMailSenderService();
			MailSenderInfo info = new MailSenderInfo();
			info.setMailServerHost("smtp.139.com");
			info.setValidate(true);
			info.setUserName("zhangchenhao@139.com");
			info.setPassword("majinghua");// 您的邮箱密码
			info.setFromAddress("zhangchenhao@139.com");
			info.setToAddress(mail);
			info.setSubject("爱师网用户找回密码服务");
			info.setContent("您在爱师网注册的密码为：" + member.getPassword() +"</br>请尽快更改您有密码，以免密码泄露，谢谢配合！");
			return mailservice.sendHtmlMail(info);
		}
		return false;
	}
	

}
