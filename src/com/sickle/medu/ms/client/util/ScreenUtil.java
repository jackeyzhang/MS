/**
 * 
 */
package com.sickle.medu.ms.client.util;

import com.google.gwt.user.client.Window;


/**
 * @author Administrator
 *
 */
public class ScreenUtil {
	
	public static double getWidthNum(double percent){
		return Window.getClientWidth() * percent;	
	}
	
	public static double getHeightNum(double percent){
		return Window.getClientHeight() * percent;
	}
	
	public static int getWidthInt(double percent){
		return (int) ( Window.getClientWidth() * percent );	
	}
	
	public static int getHeightInt(double percent){
		return (int) ( Window.getClientHeight() * percent );
	}
	
	public static String getWidth(double percent){
		return (Window.getClientWidth() * percent) + "px";	
	}
	
	public static String getHeight(double percent){
		return (Window.getClientHeight() * percent)+ "px";
	}

}
