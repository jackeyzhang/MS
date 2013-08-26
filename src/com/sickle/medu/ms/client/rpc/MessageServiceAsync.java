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

	void listMessages( Integer userid, AsyncCallback<List<Message>> callback );

	void addMessage( Message message, AsyncCallback<Message> callback );

	void deleteMessage( Message message, AsyncCallback<Message> callback );

}
