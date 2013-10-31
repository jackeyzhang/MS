/*******************************************************************************
 * Copyright 2011 Google Inc. All Rights Reserved.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.notice/legal/epl-v10.html
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
import com.sickle.medu.ms.client.rpc.NoticeService;
import com.sickle.pojo.edu.Notice;
import com.sickle.service.itf.INoticeService;

public class NoticeServiceImpl extends RemoteServiceServlet implements NoticeService {

	private static final long serialVersionUID = -3779445533342577760L;
	
	private static INoticeService service = null;
	

	@Override
	public void init( ) throws ServletException
	{
		super.init( );
		try
		{
			service = DaoServiceFactory.getService( INoticeService.class );
		}
		catch ( CodeException e )
		{
			e.printStackTrace();
		}
	}



	@Override
	public List<Notice> listAllNotice(int startIndex, int length)
	{
		List<Notice> notices = service.listAllNotice( );
		return  notices;
	}



	@Override
	public Notice addNotice( Notice notice ) throws Exception
	{
		Notice onotice = service.addNotice( notice );
		return  onotice ;
	}



	@Override
	public Notice deleteNotice( Notice notice ) throws Exception
	{
		if( service.removeNoticeById( notice.getId( ) ))
		{
			return  notice ;
		}
		return null;
	}

}
