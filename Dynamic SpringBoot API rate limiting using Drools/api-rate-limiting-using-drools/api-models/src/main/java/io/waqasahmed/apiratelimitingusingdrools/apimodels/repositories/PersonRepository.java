package io.waqasahmed.apiratelimitingusingdrools.apimodels.repositories;

import io.waqasahmed.apiratelimitingusingdrools.apimodels.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>
{
  Person findByName(String name);
}
