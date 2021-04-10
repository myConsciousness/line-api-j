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

package org.thinkit.bot.instagram.catalog;

import org.thinkit.api.catalog.Catalog;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * The catalog that manages record type.
 *
 * @author Kato Shinya
 * @since 1.0.0
 */
@RequiredArgsConstructor
public enum RECORD_TYPE implements Catalog<RECORD_TYPE> {

    /**
     * The like
     */
    LIKE(0),

    /**
     * The follow
     */
    FOLLOW(1),

    /**
     * The unfollow
     */
    UNFOLLOW(2),

    /**
     * The comment
     */
    COMMENT(3);

    /**
     * The code
     */
    @Getter
    private final int code;
}
