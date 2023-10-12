package com.multipolar.bootcamp.kyc.repository;

import com.multipolar.bootcamp.kyc.domain.Kyc;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface KycRepository extends MongoRepository<Kyc,String>{

Optional<Kyc> findByNik(String nik);

@Query("{'firstName' :  {$regex: ?0, $options: 'i'}}")
List<Kyc> findByNameCaseInsensitive(String name);
}
