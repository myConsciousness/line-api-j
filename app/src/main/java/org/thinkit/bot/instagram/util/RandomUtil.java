package org.thinkit.bot.instagram.util;

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

import java.io.Serializable;
import java.util.Random;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * The class that resolve process to generate random number.
 *
 * @author Kato Shinya
 * @since 1.0.0
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class RandomUtil implements Serializable {

    /**
     * The serial version UID
     */
    private static final long serialVersionUID = 3291150816726238730L;

    /**
     * The random
     */
    private static final Random RANDOM = new Random();

    public static int createWaitTime() {
        return RANDOM.nextInt(10000) + 50000;
    }
}
