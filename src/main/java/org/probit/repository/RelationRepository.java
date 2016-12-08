package org.probit.repository;

import org.probit.domain.Relation;
import org.probit.domain.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
  * RelationRepository
  *
  * @author sunghyun
  * @since 2016. 12. 08.
  */
public interface RelationRepository extends JpaRepository<Relation, Integer> {
	List<Relation> findByRoomId(Integer roomId);
}
