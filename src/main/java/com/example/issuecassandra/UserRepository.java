package com.example.issuecassandra;

import org.springframework.data.cassandra.repository.CassandraRepository;

public interface UserRepository  extends CassandraRepository<Users, String>{

}
