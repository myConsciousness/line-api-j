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

package org.thinkit.api.line.notify.http;

import java.io.IOException;
import java.io.Serializable;

import com.google.api.client.http.ByteArrayContent;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;

import org.thinkit.api.line.catalog.ContentType;
import org.thinkit.api.line.catalog.RequestParameterKey;
import org.thinkit.api.line.http.AbstractCommunicator;
import org.thinkit.api.line.util.RequestParameterUtils;
import org.thinkit.api.line.util.SecuritySchemeUtils;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;

/**
 * The class that provides the process of HTTP communication for Line Notify.
 *
 * @author Kato Shinya
 * @since 1.0.0
 */
@ToString
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor(staticName = "from")
public final class LineNotifyCommunicator extends AbstractCommunicator implements Serializable {

    /**
     * The token
     */
    @ToString.Exclude
    private String token;

    /**
     * Sends a POST request to the URL set in the URL object passed as an argument.
     *
     * @param genericUrl The API URL
     *
     * @exception NullPointerException If {@code null} is passed as an argument
     */
    @Override
    public void post(@NonNull final GenericUrl genericUrl, @NonNull final String message) {
        try {
            final HttpRequest httpRequest = super.getHttpRequestFactory().buildPostRequest(genericUrl,
                    ByteArrayContent.fromString(ContentType.APPLICATION_X_WWWW_FORM_URLENCODED.getTag(),
                            RequestParameterUtils.create(RequestParameterKey.MESSAGE, message)));

            httpRequest.getHeaders().setAuthorization(SecuritySchemeUtils.bearer(token));
            this.checkHttpStatus(httpRequest.execute());
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
}
