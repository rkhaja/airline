/**
 * Copyright (C) 2010-15 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.rvesse.airline.utils.predicates.restrictions;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Predicate;

import com.github.rvesse.airline.model.OptionMetadata;

public class RequiredTagOptionFinder implements Predicate<OptionMetadata> {

    private final String tag;

    public RequiredTagOptionFinder(String tag) {
        this.tag = tag;
    }

    @Override
    public boolean evaluate(OptionMetadata arg0) {
        return CollectionUtils.exists(arg0.getRestrictions(), new RequiredFromFinder(tag));
    }

}