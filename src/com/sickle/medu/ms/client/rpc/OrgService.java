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
package com.sickle.medu.ms.client.rpc;

import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.sickle.pojo.edu.Org;

@RemoteServiceRelativePath("OrgService")
public interface OrgService extends RemoteService {
	/**
	 * Utility class for simplifying access to the instance of async service.
	 */
	public static class Util {
		private static OrgServiceAsync instance;
		public static OrgServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(OrgService.class);
			}
			return instance;
		}
	}
	
	public List<Org> listAllOrg(int startIndex);
	
	public Org addOrg(Org org) throws Exception;
	
	public Org deleteOrg(Org org)throws Exception;
}
