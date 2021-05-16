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

package org.thinkit.bot.instagram.batch.data.mongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.DeleteQuery;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.thinkit.bot.instagram.batch.data.mongo.entity.UserFollower;

/**
 * The interface that manages user follower repository.
 *
 * @author Kato Shinya
 * @since 1.0.0
 */
@Repository
public interface UserFollowerRepository extends MongoRepository<UserFollower, String> {

    public List<UserFollower> findByChargeUserName(String chargeUserName);

    public UserFollower findByUserNameAndChargeUserName(String userName, String chargeUserName);

    @DeleteQuery
    public void deleteByChargeUserName(String chargeUserName);
}
