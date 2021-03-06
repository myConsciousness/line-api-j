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

package org.thinkit.api.line.notify;

import java.io.Serializable;

import com.google.api.client.http.GenericUrl;

import org.thinkit.api.line.catalog.LineApi;
import org.thinkit.api.line.notify.http.LineNotifyCommunicator;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

/**
 * The class that implements the process of sending a message to Line Notify.
 *
 * @author Kato Shinya
 * @since 1.0.0
 */
@ToString
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(staticName = "from")
public final class LineNotifyJ implements LineNotify, Serializable {

    /**
     * The token
     */
    @ToString.Exclude
    private String token;

    @Override
    public void sendMessage(@NonNull final String message) {
        LineNotifyCommunicator.from(this.token).post(new GenericUrl(LineApi.LINE_NOTIFY.getTag()), message);
    }
}
