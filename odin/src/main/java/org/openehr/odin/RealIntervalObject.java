package org.openehr.odin;

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

import org.openehr.odin.antlr.odinParser;

import java.io.Serializable;

/**
 * Created by cnanjo on 4/8/16.
 */
public class RealIntervalObject extends IntervalObject<RealObject, odinParser.Real_valueContext> implements Serializable {

    @Override
    protected RealObject extractFromContext(odinParser.Real_valueContext ctx) {
        return RealObject.extractRealObject(ctx);
    }

}
