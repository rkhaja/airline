/**
 * Copyright (C) 2010-16 the original author or authors.
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
package com.github.rvesse.airline.restrictions.factories;

import java.lang.annotation.Annotation;
import java.util.Collections;
import java.util.List;

import com.github.rvesse.airline.annotations.restrictions.Path;
import com.github.rvesse.airline.restrictions.ArgumentsRestriction;
import com.github.rvesse.airline.restrictions.OptionRestriction;
import com.github.rvesse.airline.restrictions.common.PathRestriction;

public class PathRestrictionFactory implements OptionRestrictionFactory, ArgumentsRestrictionFactory {

    protected final PathRestriction createCommon(Annotation annotation) {
        if (annotation instanceof Path) {
            Path path = (Path) annotation;
            return new PathRestriction(path.mustExist(), path.readable(), path.writable(), path.executable(),
                    path.kind());
        }
        return null;
    }

    @Override
    public ArgumentsRestriction createArgumentsRestriction(Annotation annotation) {
        return createCommon(annotation);
    }

    @Override
    public OptionRestriction createOptionRestriction(Annotation annotation) {
        return createCommon(annotation);
    }
    
    protected List<Class<? extends Annotation>> supportedAnnotations() {
        return Collections.<Class<? extends Annotation>>singletonList(Path.class);
    }

    @Override
    public List<Class<? extends Annotation>> supportedArgumentsAnnotations() {
        return supportedAnnotations();
    }

    @Override
    public List<Class<? extends Annotation>> supportedOptionAnnotations() {
        return supportedAnnotations();
    }

}
