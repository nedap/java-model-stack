package org.openehr.bmm.core;

/*
 * #%L
 * OpenEHR - Java Model Stack
 * %%
 * Copyright (C) 2016 - 2017 Cognitive Medical Systems
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
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
 * #L%
 * Author: Claude Nanjo
 */

import org.openehr.basetypes.structures.MultiplicityInterval;
import org.openehr.bmm.BmmConstants;
import org.openehr.bmm.BmmMultiplicityInterval;
import org.openehr.odin.CompositeOdinObject;
import org.openehr.odin.IntegerIntervalObject;
import org.openehr.odin.OdinAttribute;
import org.openehr.odin.utils.OdinSerializationUtils;

import java.io.Serializable;

/**
 * Created by cnanjo on 4/11/16.
 */
public class BmmProperty<T extends BmmType> extends BmmModelElement implements Serializable {

	public static final String P_BMM_GENERIC_PROPERTY = "P_BMM_GENERIC_PROPERTY";
	public static final String P_BMM_CONTAINER_PROPERTY = "P_BMM_CONTAINER_PROPERTY";

	/**
	 * Name of this property in the model.
	 */
	private String name;
	/**
	 * True if this property is mandatory in its class.
	 */
	private Boolean isMandatory;
	/**
	 * True if this property is computed rather than stored in objects of this class.
	 */
	private Boolean isComputed;
	/**
	 * Formal type of this property.
	 */
	private T type;
	/**
	 * True if this property is marked with info model 'im_runtime' property.
	 */
	private Boolean isImRuntime;
	/**
	 * True if this property was marked with info model 'im_infrastructure' flag.
	 */
	private Boolean isImInfrastructure;

	public BmmProperty() {
	}

	public BmmProperty(String name, T type) {
		this.name = name;
		this.type = type;
	}

	/**
	 * Returns the name of this property in the model.
	 *
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of this property in the model.
	 *
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns true if this property is mandatory in its class.
	 *
	 * @return
	 */
	public Boolean getMandatory() {
		return isMandatory;
	}

	/**
	 * Set to true if this property is mandatory in its class.
	 * @param mandatory
	 */
	public void setMandatory(Boolean mandatory) {
		isMandatory = mandatory;
	}

	/**
	 * Returns true if this property is computed rather than stored in objects of this class.
	 *
	 * @return
	 */
	public Boolean getComputed() {
		return isComputed;
	}

	/**
	 * Set to true if this property is computed rather than stored in objects of this class.
	 *
	 * @param computed
	 */
	public void setComputed(Boolean computed) {
		isComputed = computed;
	}

	/**
	 * Returns the formal type of this property.
	 *
	 * @return
	 */
	public T getType() {
		return type;
	}

	/**
	 * Sets the formal type of this property.
	 *
	 * @param type
	 */
	public void setType(T type) {
		this.type = type;
	}

	/**
	 * Returns true if this property is marked with info model 'im_runtime' property.
	 *
	 * @return
	 */
	public Boolean getImRuntime() {
		return isImRuntime;
	}

	/**
	 * Set to true if this property is marked with info model 'im_runtime' property.
	 *
	 * @param imRuntime
	 */
	public void setImRuntime(Boolean imRuntime) {
		isImRuntime = imRuntime;
	}

	/**
	 * Returns true if this property was marked with info model 'im_infrastructure' flag.
	 *
	 * @return
	 */
	public Boolean getImInfrastructure() {
		return isImInfrastructure;
	}

	/**
	 * Set to true if this property was marked with info model 'im_infrastructure' flag.
	 *
	 * @param imInfrastructure
	 */
	public void setImInfrastructure(Boolean imInfrastructure) {
		isImInfrastructure = imInfrastructure;
	}

	/**
	 * Method returns true if BMM Type argument is a container type.
	 *
	 * @param bmmType
	 * @return
	 */
	public static boolean isContainerType(String bmmType) {
		return bmmType.equals(BmmType.P_BMM_CONTAINER_TYPE) || bmmType.equals(BmmType.BMM_CONTAINER_TYPE);
	}

	/**
	 * Interval form of 0..1, 1..1 etc, generated from is_mandatory.
	 *
	 * @return
	 */
	public MultiplicityInterval getExistence() {
		MultiplicityInterval interval = null;
		if(isMandatory) {
			interval = MultiplicityInterval.createMandatory();
		} else {
			interval = MultiplicityInterval.createOptional();
		}
		return interval;
	}

	/**
	 * Returns the name of this attribute to display in UI.
	 *
	 * @return
	 */
	public String getDisplayName() {
		throw new UnsupportedOperationException("Not implemented yet"); // TODO To be implemented
	}

	public BmmProperty duplicate() {
		BmmProperty property = new BmmProperty();
		property.setName(this.name);
		property.setComputed(this.isComputed);
		property.setImInfrastructure(this.isImInfrastructure);
		property.setImRuntime(this.isImRuntime);
		property.setMandatory(this.isMandatory);
		property.setType(this.type);
		property.setDocumentation(this.getDocumentation());
		return property;
	}
}
