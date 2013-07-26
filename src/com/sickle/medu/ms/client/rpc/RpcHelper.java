/**
 * 
 */

package com.sickle.medu.ms.client.rpc;

import com.google.gwt.core.client.GWT;

/**
 * @author chenhao
 * 
 * @param <T>
 * 
 */
public class RpcHelper
{

	public static <T, C> C getService( Class<T> cls )
	{
		C service = GWT.create( cls );
		return service;
	}

}
