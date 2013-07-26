/**
 * 
 */
package com.sickle.medu.ms.client.rpc;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.sickle.pojo.website.Message;


/**
 * @author chenhao
 *
 */
public interface MessageServiceAsync
{

	void listAllMessages( AsyncCallback<List<Message>> callback );

}
