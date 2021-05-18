/*
 * Copyright 2021 Kato Shinya.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package org.thinkit.api.line.util;

import java.util.StringJoiner;

import org.apache.commons.lang3.StringUtils;
import org.thinkit.api.line.catalog.RequestParameterKey;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 * The util class that manages request parameter.
 *
 * @author Kato Shinya
 * @since 1.0.0
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class RequestParameterUtils {

    /**
     * Returns the request parameter based on the value passed as an argument.
     *
     * @param requestParameterKey The request parameter key
     * @param value               The request parameter value
     * @return The request parameter based on the value passed as an argument
     *
     * @exception NullPointerException If {@code null} is passed as an argument
     */
    public static String create(@NonNull final RequestParameterKey requestParameterKey, @NonNull final String value) {

        if (StringUtils.isEmpty(value)) {
            return "";
        }

        final StringJoiner messageJoiner = new StringJoiner("=");
        messageJoiner.add(requestParameterKey.getTag());
        messageJoiner.add(value);

        return messageJoiner.toString();
    }
}
