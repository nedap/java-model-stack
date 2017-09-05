package org.openehr.bmm.util;

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

import org.apache.commons.lang.NotImplementedException;
import org.openehr.basetypes.structures.MultiplicityInterval;
import org.openehr.bmm.core.BmmProperty;

public class ReferenceModelPropertyMultiplicityImpl implements ReferenceModelPropertyMultiplicity {

    @Override
    public MultiplicityInterval objectMultiplicity(String rmTypeName, String rmPropertyPath) {
//        MultiplicityInterval returnValue = new MultiplicityInterval();
//        BmmProperty rmPropertyDefinition = getReferenceModelPropertyDefinition(rmTypeName, rmPropertyPath);
//        if(rmPropertyDefinition.isContainerType(rmTypeName)) {
//            if(rmPropertyDefinition.getCardinality().isExcludeUpperBound()) {
//                returnValue.setUpperUnbounded(true);
//            } else {
//                returnValue.setUpperUnbounded(false);
//                returnValue.setUpper(rmPropertyDefinition.getCardinality().getHigh());
//            }
//        } else {
//            returnValue = rmPropertyDefinition.getExistence();
//        }
//        return returnValue;
        throw new NotImplementedException();//TODO Need to implement
    }

    protected BmmProperty getReferenceModelPropertyDefinition(String rmTypeName, String rmPropertyPath) {
        throw new NotImplementedException();//TODO Need to implement
    }
}
