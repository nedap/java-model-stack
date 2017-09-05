package org.openehr.basetypes.structures;

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

import org.openehr.basetypes.Any;
import org.openehr.basetypes.primitivetypes.Ordered;

/**
 * Type representing a keyed table of values. T is the value type, and U the type of the keys.
 *
 * Created by cnanjo on 5/20/16.
 */
public interface Hash<K extends Ordered, V> extends Any {
}
