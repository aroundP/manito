package org.probit.domain;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

/**
  * SessionUser
  *
  * @author sunghyun
  * @since 2016. 12. 07.
  */
public class SessionUser {
	private Integer userId;
	private String nickName;
	private String profileUrl;
	private String accessToken;
	private String refreshToken;

	public SessionUser() {
	}

	public SessionUser(Integer userId, String nickName, String profileUrl, String accessToken, String refreshToken) {
		this.userId = userId;
		this.nickName = nickName;
		this.profileUrl = profileUrl;
		this.accessToken = accessToken;
		this.refreshToken = refreshToken;
	}

	public SessionUser(Integer userId, String nickName, String profileUrl) {
		this.userId = userId;
		this.nickName = nickName;
		this.profileUrl = profileUrl;
	}

	public SessionUser(String authObj, String accessToken) {
		JsonObject jsonObject = new Gson().fromJson(authObj, JsonObject.class);
		this.userId = Integer.parseInt(jsonObject.get("id").toString());
		this.nickName = jsonObject.getAsJsonObject("properties").get("nickname").toString();
		this.profileUrl = jsonObject.getAsJsonObject("properties").get("thumbnail_image").toString();
		this.accessToken = accessToken;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	@Override
	public String toString() {
		return "SessionUser{" +
				"userId=" + userId +
				", nickName='" + nickName + '\'' +
				", profileUrl='" + profileUrl + '\'' +
				", accessToken='" + accessToken + '\'' +
				", refreshToken='" + refreshToken + '\'' +
				'}';
	}
}
