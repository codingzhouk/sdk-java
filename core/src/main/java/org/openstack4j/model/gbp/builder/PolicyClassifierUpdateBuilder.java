/*******************************************************************************
 * 	Copyright 2016 ContainX and OpenStack4j                                          
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
package org.openstack4j.model.gbp.builder;

import org.openstack4j.common.Buildable.Builder;
import org.openstack4j.model.gbp.Direction;
import org.openstack4j.model.gbp.PolicyClassifierUpdate;
import org.openstack4j.model.gbp.Protocol;
/**
 * A builder which produces a Policy Classifier Update object
 * 
 * @author vinod borole
 */
public interface PolicyClassifierUpdateBuilder extends Builder<PolicyClassifierUpdateBuilder, PolicyClassifierUpdate> {
    PolicyClassifierUpdateBuilder name(String name);
    PolicyClassifierUpdateBuilder description(String description);
    PolicyClassifierUpdateBuilder shared(boolean shared);
    PolicyClassifierUpdateBuilder portRangeMin(int min);
    PolicyClassifierUpdateBuilder portRangeMax(int max);
    PolicyClassifierUpdateBuilder direction(Direction direction);
    PolicyClassifierUpdateBuilder protocol(Protocol protocol);
}
 