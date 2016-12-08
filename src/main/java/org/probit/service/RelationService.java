package org.probit.service;

import org.probit.domain.Relation;
import org.probit.domain.Room;
import org.probit.domain.User;
import org.probit.repository.RelationRepository;
import org.probit.repository.RoomRepository;
import org.probit.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
  * RelationService
  *
  * @author sunghyun
  * @since 2016. 12. 08.
  */
@Service
public class RelationService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoomRepository roomRepository;
	@Autowired
	private RelationRepository relationRepository;

	public List<Relation> findRelationByRoomId(Integer roomId) {
		return relationRepository.findByRoomId(roomId);
	}

	public List<Relation> findRelationList() {
		return relationRepository.findAll();
	}

	public Room addRelation(Integer roomId, Integer userId) {
		User user = userRepository.findOne(userId);
		Room room = roomRepository.findOne(roomId);
		if (user == null || room == null) {
			return null;
		}
		Relation relation = new Relation(user, room);
		relationRepository.saveAndFlush(relation);
		return roomRepository.findOne(roomId);
	}
}
