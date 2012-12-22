/*
 * Copyright (c) 2008 - 2012 10gen, Inc. <http://10gen.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package org.mongodb;

import org.bson.types.Document;

public class MongoQueryFailureException extends MongoException {
    private final Document errorDocument;

    public MongoQueryFailureException(final ServerAddress address, final Document errorDocument) {
        super("Query failed with error code " + errorDocument.get("code") + " and error message + '" +
                errorDocument.get("$err") + "' on server " + address, address);
        this.errorDocument = errorDocument;
    }

    // TODO: Create bean for the error document similar to CommandResult
    public Document getErrorDocument() {
        return errorDocument;
    }

    public int getErrorCode() {
        return (Integer) errorDocument.get("code");
    }
}
