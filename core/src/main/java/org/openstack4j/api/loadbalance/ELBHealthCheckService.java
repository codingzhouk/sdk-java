/*******************************************************************************
 * 	Copyright 2017 HuaWei Tld                                     
 * 	                                                                                 
 * 	Licensed under the Apache License, Version 2.0 (the "License"); you may not      
 * 	use this file except in compliance with the License. You may obtain a copy of    
 * 	the License at                                                                   
 * 	                                                                                 
 * 	    http://www.apache.org/licenses/LICENSE-2.0                                   
 * 	                                                                                 
 * 	Unless required by applicable law or agreed to in writing, software              
 * 	distributed under the License is distributed on an "AS IS" BASIS, WITHOUT        
 * 	WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the         
 * 	License for the specific language governing permissions and limitations under    
 * 	the License.                                                                     
 *******************************************************************************/
package org.openstack4j.api.loadbalance;

import org.openstack4j.common.RestService;
import org.openstack4j.model.common.ActionResponse;
import org.openstack4j.model.loadbalance.HealthCheck;
import org.openstack4j.model.loadbalance.HealthCheckCreate;
import org.openstack4j.model.loadbalance.HealthCheckUpdate;

public interface ELBHealthCheckService extends RestService {
	HealthCheck create(HealthCheckCreate healthCheck);
	
	ActionResponse delete(String healthCheckId);
	
	HealthCheck update(String healthCheckId, HealthCheckUpdate healthCheck);
	
	HealthCheck get(String healthCheckId);
}
