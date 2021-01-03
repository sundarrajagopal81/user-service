package com.service.user.repository;

import com.service.user.model.UserDomain;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CouchbaseRepository<UserDomain,Integer> {
}
