/*
 *  Copyright 2015 LG CNS.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License"); 
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License. 
 */
package scouter.agent.netio.request.handle;

import java.util.Enumeration;
import java.util.Properties;

import scouter.agent.netio.request.anotation.RequestHandler;
import scouter.lang.pack.MapPack;
import scouter.lang.pack.Pack;
import scouter.lang.value.TextValue;
import scouter.net.RequestCmd;

public class HostAgentEnv {

	@RequestHandler(RequestCmd.OBJECT_ENV)
	public Pack getAgentEnv(Pack param) {
		MapPack m = new MapPack();
		Properties p = System.getProperties();
		@SuppressWarnings("rawtypes")
		Enumeration en = p.keys();
		while (en.hasMoreElements()) {
			String key = (String) en.nextElement();
			String value = p.getProperty(key);
			m.put(key, new TextValue(value));
		}
		return m;
	}

}