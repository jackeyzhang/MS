/**
 * 
 */

package com.sickle.medu.ms.client.ui.widget;


/**
 * @author chenhao
 * 
 */
public class LabelWithYellow extends MouseChangeLabel
{
	public LabelWithYellow( String title )
	{
		super( title, true, "linklabel" , "linklabel-mousein");
	}
	
	public LabelWithYellow( String title,boolean change )
	{
		super( title, change, "linklabel" , "linklabel-mousein");
	}
}
