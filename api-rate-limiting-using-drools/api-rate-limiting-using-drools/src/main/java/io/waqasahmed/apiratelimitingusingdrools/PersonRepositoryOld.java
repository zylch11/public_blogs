package io.waqasahmed.apiratelimitingusingdrools;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepositoryOld extends JpaRepository<PersonOld, Long> {
  PersonOld findByName(String name);
}
