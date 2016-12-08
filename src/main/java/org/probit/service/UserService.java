package org.probit.service;

import org.probit.domain.SessionUser;
import org.probit.domain.User;
import org.probit.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
  * UserService
  *
  * @author sunghyun
  * @since 2016. 12. 07.
  */
@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	public User addUser(User user) {
		User oldUser = userRepository.findOne(user.getId());
		if (oldUser == null) {
			return userRepository.saveAndFlush(user);
		}

		oldUser.setNickName(user.getNickName());
		oldUser.setProfileUrl(user.getProfileUrl());
		return userRepository.saveAndFlush(oldUser);
	}

	public List<User> findUserList() {
		return userRepository.findAll();
	}
}
