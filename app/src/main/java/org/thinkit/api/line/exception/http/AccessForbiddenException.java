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

package org.thinkit.api.line.exception.http;

/**
 * Thrown to indicate that the access is forbidden.
 *
 * @author Kato Shinya
 * @since 1.0.0
 */
public final class AccessForbiddenException extends RuntimeException {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 0L;

    /**
     * Constructs an <code>AccessForbiddenException</code> with no detail message.
     */
    public AccessForbiddenException() {
        super();
    }

    /**
     * Constructs an <code>AccessForbiddenException</code> with the specified detail
     * message.
     *
     * @param s the detail message.
     */
    public AccessForbiddenException(String s) {
        super(s);
    }

    /**
     * Constructs a new exception with the specified detail message and cause.
     *
     * <p>
     * Note that the detail message associated with <code>cause</code> is <i>not</i>
     * automatically incorporated in this exception's detail message.
     *
     * @param message the detail message (which is saved for later retrieval by the
     *                {@link Throwable#getMessage()} method).
     * @param cause   the cause (which is saved for later retrieval by the
     *                {@link Throwable#getCause()} method). (A nullvalue is
     *                permitted, and indicates that the cause is nonexistent or
     *                unknown.)
     */
    public AccessForbiddenException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new exception with the specified cause and a detail message of
     * (cause==null ? null : cause.toString())(which typically contains the class
     * and detail message of cause. This constructor is useful for exceptions that
     * are little more than wrappers for other throwables (for example,
     * {@link java.security.PrivilegedActionException}).
     *
     * @param cause the cause (which is saved for later retrieval by the
     *              {@link Throwable#getCause()} method). (A nullvalue is permitted,
     *              and indicates that the cause is nonexistent or unknown.)
     */
    public AccessForbiddenException(Throwable cause) {
        super(cause);
    }
}
