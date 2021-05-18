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

package org.thinkit.api.line.factory;

import org.thinkit.api.line.notify.LineNotify;
import org.thinkit.api.line.notify.LineNotifyJ;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

/**
 * The factory class that manages Line API object.
 *
 * @author Kato Shinya
 * @since 1.0.0
 */
@ToString
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class LineApiJFactory implements LineApiFactory {

    /**
     * Returns the singleton instance of {@link LineApiJFactory} .
     *
     * @return The singleton instance of {@link LineApiJFactory} .
     */
    public static LineApiFactory getInstance() {
        return SingletonInstanceHolder.INSTANCE;
    }

    /**
     * The inner class that manages singleton instance of {@link LineApiJFactory} .
     *
     * @author Kato Shinya
     * @since 1.0.0
     */
    private static class SingletonInstanceHolder {

        /**
         * The singleton instance
         */
        private static final LineApiFactory INSTANCE = new LineApiJFactory();
    }

    @Override
    public LineNotify createLineNotify(@NonNull final String token) {
        return LineNotifyJ.from(token);
    }
}
