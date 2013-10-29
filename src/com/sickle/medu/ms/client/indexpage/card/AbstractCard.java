package com.sickle.medu.ms.client.indexpage.card;

import com.sickle.medu.ms.client.ui.dialog.HintRegisterDialog;
import com.smartgwt.client.widgets.layout.VLayout;

/**
 * 抽象card
 * 
 * 提供操作是否登录校验功能
 * 
 * @author chenhao
 *
 */
public class AbstractCard extends VLayout
{
	
	protected boolean valid()
	{
		if( validLogin() == false)
		{
			new HintRegisterDialog("提示").show( );
			return false;
		}
		return true;
	}
	
	private boolean validLogin()
	{
		return false;
	}

}
