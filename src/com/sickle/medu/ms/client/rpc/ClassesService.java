/*******************************************************************************
 * Copyright 2011 Google Inc. All Rights Reserved.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.Cls/legal/epl-v10.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.sickle.medu.ms.client.rpc;

import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.sickle.pojo.edu.Cls;
import com.sickle.pojo.edu.Member;

@RemoteServiceRelativePath("ClassesService")
public interface ClassesService extends RemoteService {
	/**
	 * Utility class for simplifying access to the instance of async service.
	 */
	public static class Util {
		private static ClassesServiceAsync instance;
		public static ClassesServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(ClassesService.class);
			}
			return instance;
		}
	}
	
	public List<Cls> listAllClasses(int startIndex,int length );
	
	public Cls findClass(int classid);
	
	public Cls addClasses(Cls Cls) throws Exception;
	
	public Cls modifyClasses(Cls Cls) throws Exception;
	
	public Cls deleteClasses(Cls Cls)throws Exception;
	
	public List<Member> findStudents(int classid)throws Exception;
}
