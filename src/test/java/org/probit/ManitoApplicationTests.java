package org.probit;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.probit.domain.Relation;
import org.probit.domain.Room;
import org.probit.domain.User;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
//@SpringBootTest
public class ManitoApplicationTests {

	@Test
	public void contextLoads() throws JsonProcessingException {
		User user = new User();
		user.setId(1);

		Room room = new Room();
		room.setId(11);

		Relation relation = new Relation();
		relation.setId(222);
		relation.setUser(user);
		relation.setRoom(room);

		user.addRelation(relation);
		room.addRelation(relation);

		String result = new ObjectMapper().writeValueAsString(user);
		System.out.println(result);
	}

}
