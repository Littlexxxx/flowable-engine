/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.flowable.variable.service.impl.persistence.entity;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.flowable.common.engine.impl.persistence.entity.EntityManager;
import org.flowable.variable.api.persistence.entity.VariableInstance;
import org.flowable.variable.service.InternalVariableInstanceQuery;
import org.flowable.variable.service.impl.VariableInstanceQueryImpl;

/**
 * @author Joram Barrez
 */
public interface VariableInstanceEntityManager extends EntityManager<VariableInstanceEntity> {

    /**
     * Creates a variable instance for the given tenant, name and value.
     * @param tenantId the tenant id of the variable instance
     * @param name the name of the variable instance
     * @param value the value of the variable instance
     * @return the {@link VariableInstanceEntity} to be used
     */
    VariableInstanceEntity create(String tenantId, String name, Object value);

    /**
     * The {@link HistoricVariableInstanceEntity} is the historic counterpart of the {@link VariableInstanceEntity}.
     * Changes to the variable data are normally only propagated when a value changes on the {@link VariableScopeImpl} implementation.
     * This is normally all that is needed. There are however certain use cases where a direct synchronization
     * is needed when the value remains the same.
     *
     * @param variableInstanceEntity The variable instance to update.
     */
    void updateWithHistoricVariableSync(VariableInstanceEntity variableInstanceEntity);

    InternalVariableInstanceQuery createInternalVariableInstanceQuery();
    
    List<VariableInstance> findVariableInstancesByQueryCriteria(VariableInstanceQueryImpl variableInstanceQuery);
    
    long findVariableInstanceCountByQueryCriteria(VariableInstanceQueryImpl variableInstanceQuery);

    List<VariableInstance> findVariableInstancesByNativeQuery(Map<String, Object> parameterMap);
    
    long findVariableInstanceCountByNativeQuery(Map<String, Object> parameterMap);

    void deleteVariablesByTaskId(String taskId);

    void deleteVariablesByExecutionId(String executionId);
    
    void deleteByScopeIdAndScopeType(String scopeId, String scopeType);

    void deleteByScopeIdAndScopeTypes(String scopeId, Collection<String> scopeTypes);

    void deleteBySubScopeIdAndScopeTypes(String subScopeId, Collection<String> scopeTypes);

}