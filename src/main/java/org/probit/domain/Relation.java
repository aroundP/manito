package org.probit.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

/**
  * Relation
  *
  * @author sunghyun
  * @since 2016. 12. 07.
  */
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "id")
public class Relation {
	@Id
	@GeneratedValue
	@Column(name = "RELATION_ID")
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "USER_ID")
	private User user;

	@ManyToOne
	@JoinColumn(name = "ROOM_ID")
	private Room room;

	private Integer opponentUserId;

	public Relation() {
	}

	public Relation(User user, Room room) {
		this.user = user;
		this.room = room;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Integer getOpponentUserId() {
		return opponentUserId;
	}

	public void setOpponentUserId(Integer opponentUserId) {
		this.opponentUserId = opponentUserId;
	}

	@Override
	public String toString() {
		return "Relation{" +
			"id=" + id +
			", user=" + user +
			", room=" + room +
			", opponentUserId=" + opponentUserId +
			'}';
	}
}
