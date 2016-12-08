package org.probit.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
  * Room
  *
  * @author sunghyun
  * @since 2016. 12. 06.
  */
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "id")
public class Room {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ROOM_ID")
	private Integer id;
	private Integer owner;
	private String title;
	private boolean started;

	@OneToMany(mappedBy = "room")
	private List<Relation> relationList = new ArrayList<>();

	public Room() {
	}

	public Room(Integer owner, String title) {
		this.owner = owner;
		this.title = title;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getOwner() {
		return owner;
	}

	public void setOwner(Integer owner) {
		this.owner = owner;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isStarted() {
		return started;
	}

	public void setStarted(boolean started) {
		this.started = started;
	}

	public List<Relation> getRelationList() {
		return relationList;
	}

	public void setRelationList(List<Relation> relationList) {
		this.relationList = relationList;
	}

	public void addRelation(Relation relation) {
		this.relationList.add(relation);
	}

	@Override
	public String toString() {
		return "Room{" +
			"id=" + id +
			", owner=" + owner +
			", title='" + title + '\'' +
			", started=" + started +
			'}';
	}

	public boolean isMember(Integer userId) {
		if(userId == null) {
			return false;
		}

		for(Relation relation : relationList) {
			if (userId.equals(relation.getUser().getId())) {
				return true;
			}
		}
		return false;
	}
}