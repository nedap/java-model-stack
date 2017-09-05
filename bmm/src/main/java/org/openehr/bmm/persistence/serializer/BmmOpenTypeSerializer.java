package org.openehr.bmm.persistence.serializer;

/*
 * #%L
 * OpenEHR - Java Model Stack
 * %%
 * Copyright (C) 2016 - 2017  Cognitive Medical Systems, Inc (http://www.cognitivemedicine.com).
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

import org.openehr.bmm.BmmConstants;
import org.openehr.bmm.persistence.PersistedBmmOpenType;
import org.openehr.bmm.persistence.PersistedBmmType;
import org.openehr.odin.utils.OdinSerializationUtils;

public class BmmOpenTypeSerializer extends BmmTypeSerializer<PersistedBmmOpenType> {

    /**
     * No-arg constructor.
     */
    public BmmOpenTypeSerializer() {
    }

    /**
     * @param isSimpleStatement
     */
    public BmmOpenTypeSerializer(boolean isSimpleStatement) {
        super(isSimpleStatement);
    }

    /**
     * @param omitCast
     * @param parameterBound
     */
    public BmmOpenTypeSerializer(boolean omitCast, boolean parameterBound) {
        super(omitCast, parameterBound);
    }

    /**
     * @param persistedModel
     * @param omitCast
     * @param parameterBound
     */
    public BmmOpenTypeSerializer(PersistedBmmOpenType persistedModel, boolean omitCast, boolean parameterBound) {
        super(persistedModel, omitCast, parameterBound);
    }

    /**
     *
     * @param persistedModel
     * @param isSimpleStatement
     */
    public BmmOpenTypeSerializer(PersistedBmmOpenType persistedModel, boolean isSimpleStatement) {
        super(persistedModel, isSimpleStatement);
    }

    /**
     * Method serializes the object in BMM-ODIN syntax and returns the serialization as a string.
     *
     * @param indentationCount The indentation to use for the serialization.
     * @return
     */
    @Override
    public String serialize(int indentationCount) {
        StringBuilder builder = new StringBuilder();
        serialize(indentationCount, builder);
        return builder.toString();
    }

    /**
    * Method serializes the object in BMM-ODIN syntax and appends it to an existing string buffer.
    *
    * @param indentationCount The indentation to use for the serialization.
    * @param builder          The StringBuilder to append the serialization output.
    * @return
    */
    @Override
    public void serialize(int indentationCount, StringBuilder builder) {
        int indentCount = indentationCount;
        buildTypeDeclaration(builder, indentCount, getPersistedModel().P_BMM_OPEN_TYPE, getPersistedModel().getType());
        if(!isSimpleStatement()) {
            ++indentCount;
            indentByAndAppend(builder, indentCount, OdinSerializationUtils.buildOdinStringObjectPropertyInitialization(BmmConstants.BMM_PROPERTY_TYPE, getPersistedModel().getType()));
            --indentCount;
        }
        closeTypeDeclaration(builder, indentCount);
    }
}
