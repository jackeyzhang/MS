package com.sickle.medu.ms.client.iportal.dialog;

import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Random;
import com.sickle.medu.ms.client.datasource.MemberDataSource;
import com.sickle.medu.ms.client.iportal.IPageConst;
import com.sickle.medu.ms.client.iportal.page.IndexPage;
import com.sickle.medu.ms.client.iportal.panel.RegisterPanel;
import com.sickle.medu.ms.client.ui.dialog.AbstractDialog;
import com.sickle.medu.ms.client.ui.util.ScreenUtil;
import com.sickle.medu.ms.client.ui.widget.button.MButton;
import com.sickle.pojo.edu.Member;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.VerticalAlignment;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;


public class ModifyMemberDialog extends AbstractDialog
{
	
	private static final String TITLE = "修改个人资料";
	
	private RegisterPanel registerpanel;

	private Member mem ; 
	
	public ModifyMemberDialog( Member member )
	{
		super( TITLE, true,true,true );
		mem = member;
		registerpanel.edit( mem );
	}

	@Override
	public Canvas getView( )
	{
		VLayout mainpanel = getDefaultVLayout();
		mainpanel.setWidth100( );
		
	    registerpanel = new RegisterPanel( 1 );
		mainpanel.addMember( registerpanel );
		
		HLayout buttonpanel = new HLayout();
		buttonpanel.setPadding( 10 );
		buttonpanel.setMembersMargin( 10 );
		buttonpanel.setAlign( Alignment.CENTER );
		
		VLayout warp = new VLayout();
		warp.setWidth( ScreenUtil.getWidthInt( IPageConst.REGISTER_WIDTH_PER )  );
		warp.setAlign( VerticalAlignment.CENTER );
		
		MButton okbutton = new MButton("确定修改"){
			@Override
			public void handleClick( )
			{
				registerpanel.precommit( );
				boolean isValidate = registerpanel.getRegisterform().validate( );
				if( isValidate == false)
				{
					return;
				}
				registerpanel.getRegisterform().submit( new DSCallback(){
					@Override
					public void execute( DSResponse dsResponse, Object data,
							DSRequest dsRequest )
					{
						SC.say( "修改成功" );
						Member returnmember =  new Member();
						ListGridRecord rec = new ListGridRecord( dsRequest.getData( ) );
						MemberDataSource.getInstance( ).recopyValues( rec  , returnmember);
						IndexPage.getInstance( ).getTopbar( ).setMember( returnmember );
						History.newItem( IPageConst.PAGE_MS + Random.nextDouble( ) );
						ModifyMemberDialog.this.hide();
					}
				} );
			
			}
			
		};
		okbutton.setWidth( 50 );
		
		MButton cancelbutton = new MButton("取消"){
			@Override
			public void handleClick( )
			{
				registerpanel.getRegisterform().reset( );
				ModifyMemberDialog.this.hide();
			}
		};
		cancelbutton.setWidth( 50 );
		
		buttonpanel.addMember( okbutton );
		buttonpanel.addMember( cancelbutton );
		
		warp.addMember( buttonpanel );
		
		mainpanel.addMember( warp );
		return mainpanel;
	}

	
	/**
	 * @return the registerpanel
	 */
	public RegisterPanel getRegisterpanel( )
	{
		return registerpanel;
	}
	

}
