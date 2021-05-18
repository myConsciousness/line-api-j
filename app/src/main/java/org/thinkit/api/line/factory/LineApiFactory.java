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

import lombok.NonNull;

/**
 * The interface that manages factory process for Line API.
 *
 * @author Kato Shinya
 * @since 1.0.0
 */
public interface LineApiFactory {

    /**
     * Returns the new instance of {@link LineNotify} .
     *
     * @param token The token for Line Notify
     * @return The new instance of {@link LineNotify}
     *
     * @exception NullPointerException If {@code null} is passed as an argument
     */
    public LineNotify createLineNotify(@NonNull final String token);
}
