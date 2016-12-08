package org.probit.service;

import org.probit.domain.Relation;
import org.probit.domain.Room;
import org.probit.domain.User;
import org.probit.repository.RelationRepository;
import org.probit.repository.RoomRepository;
import org.probit.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
  * RoomService
  *
  * @author sunghyun
  * @since 2016. 12. 06.
  */
@Service
public class RoomService {
	@Autowired
	private RoomRepository roomRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RelationRepository relationRepository;

	public Room createRoom(Room room) {
		User user = userRepository.findOne(room.getOwner());
		Room newRoom = roomRepository.save(room);
		Relation relation = new Relation();
		relation.setUser(user);
		relation.setRoom(newRoom);
		relationRepository.saveAndFlush(relation);
		return roomRepository.findOne(room.getId());
	}

	public Room readRoom(Integer roomId) {
		return roomRepository.findOne(roomId);
	}

	public Room joinRoom(Integer roomId, Integer newUserId) {
		Room room = roomRepository.findOne(roomId);
		User user = userRepository.findOne(newUserId);
//		room.addUser(user);
		return roomRepository.saveAndFlush(room);
	}

	public List<Room> findRoomList() {
		return roomRepository.findAll();
	}
}
