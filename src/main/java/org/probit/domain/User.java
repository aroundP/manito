package org.probit.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
  * User
  *
  * @author sunghyun
  * @since 2016. 12. 06.
  */
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "id")
public class User {
	@Id
	@Column(name = "USER_ID")
	private Integer id;
	private String nickName;
	private String profileUrl;

	@OneToMany(mappedBy = "user")
	private List<Relation> relationList = new ArrayList<>();

	public User() {
	}

	public User(SessionUser sessionUser) {
		this.id = sessionUser.getUserId();
		this.nickName = sessionUser.getNickName();
		this.profileUrl = sessionUser.getProfileUrl();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getProfileUrl() {
		return profileUrl;
	}

	public void setProfileUrl(String profileUrl) {
		this.profileUrl = profileUrl;
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
		return "User{" +
			"id=" + id +
			", nickName='" + nickName + '\'' +
			", profileUrl='" + profileUrl + '\'' +
			'}';
	}
}
