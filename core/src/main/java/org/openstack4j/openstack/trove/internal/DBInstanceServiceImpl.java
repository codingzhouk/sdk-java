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
package org.openstack4j.openstack.trove.internal;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.List;

import org.openstack4j.api.trove.InstanceService;
import org.openstack4j.model.common.ActionResponse;
import org.openstack4j.model.trove.Instance;
import org.openstack4j.model.trove.InstanceCreate;
import org.openstack4j.openstack.trove.domain.TroveInstance;
import org.openstack4j.openstack.trove.domain.TroveInstance.DBInstances;

/**
 * InstanceService API Implementation
 *
 * @author Shital Patil
 */
public class DBInstanceServiceImpl extends BaseTroveServices implements InstanceService {

    /**
     * {@inheritDoc}
     */
    @Override
    public List<? extends Instance> list() {
        return get(DBInstances.class, uri("/instances")).execute().getList();

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Instance get(String instanceId) {
        checkNotNull(instanceId);
        TroveInstance instance = get(TroveInstance.class, uri("/instances/%s", instanceId)).execute();
        return instance;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Instance create(InstanceCreate instanceCreate) {
        return post(TroveInstance.class, uri("/instances")).entity(instanceCreate).execute();

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ActionResponse delete(String id) {
        checkNotNull(id);
        return deleteWithResponse(uri("/instances/%s", id)).execute();
    }
}
