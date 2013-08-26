/*******************************************************************************
 * Copyright 2011 Google Inc. All Rights Reserved.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.sickle.medu.ms.server.rpc;

import java.util.List;

import javax.servlet.ServletException;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.sickle.dao.DaoServiceFactory;
import com.sickle.exception.CodeException;
import com.sickle.medu.ms.client.rpc.MessageService;
import com.sickle.pojo.website.Message;
import com.sickle.service.itf.IMessageService;

public class MessageServiceImpl extends RemoteServiceServlet implements MessageService {

	private static final long serialVersionUID = -1967904900496749968L;
	
	private static IMessageService service = null;
	

	@Override
	public void init( ) throws ServletException
	{
		super.init( );
		try
		{
			service = DaoServiceFactory.getService( IMessageService.class );
		}
		catch ( CodeException e )
		{
			e.printStackTrace();
		}
	}

	@Override
	public List<Message> listMessages( Integer userid )
	{
		return service.getMessageByUserId( userid );
	}

	@Override
	public Message addMessage( Message message ) throws Exception
	{
		return service.addMessage( message );
	}

	@Override
	public Message deleteMessage( Message message ) throws Exception
	{
		 service.removeMessageById( message.getId( ) );
		 return message;
	}
}
