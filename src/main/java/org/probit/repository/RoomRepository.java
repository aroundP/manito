package org.probit.repository;

import org.probit.domain.Room;
import org.springframework.data.jpa.repository.JpaRepository;

/**
  * RoomRepository
  *
  * @author sunghyun
  * @since 2016. 12. 06.
  */
public interface RoomRepository extends JpaRepository<Room, Integer> {
}