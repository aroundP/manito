package org.probit.controller;

import org.probit.domain.Relation;
import org.probit.domain.Room;
import org.probit.domain.SessionUser;
import org.probit.service.RelationService;
import org.probit.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
  * RoomController
  *
  * @author sunghyun
  * @since 2016. 12. 06.
  */
@Controller
public class RoomController {
	@Autowired
	private RoomService roomService;
	@Autowired
	private RelationService relationService;

	@RequestMapping(value = "/rooms", method = RequestMethod.POST)
	public String createRoom(@RequestParam String title, Model model, HttpSession session) {
		SessionUser sessionUser = (SessionUser)session.getAttribute("account");
		Room newRoom = roomService.createRoom(new Room(sessionUser.getUserId(), title));
		return "redirect:/rooms/" + newRoom.getId();
	}

	@RequestMapping(value = "/rooms/{roomId}", method = RequestMethod.GET)
	public String roomPage(@PathVariable Integer roomId, Model model, HttpSession session) {
		SessionUser sessionUser = (SessionUser)session.getAttribute("account");
		Room joinRoom = roomService.readRoom(roomId);
		if (joinRoom == null) {
			model.addAttribute("errorMessage", "방이 없습니다.");
			return "error";
		}

		if (joinRoom.isMember(sessionUser.getUserId())) {
			model.addAttribute("room", joinRoom);
			return "room";
		}

		model.addAttribute("room", joinRoom);
		return "join";
	}

	@RequestMapping("/rooms")
	@ResponseBody
	public List<Room> findRoomList() {
		List<Room> roomList = roomService.findRoomList();
		System.out.println(roomList);
		return roomList;
	}

	@RequestMapping("/relations")
	@ResponseBody
	public List<Relation> findRelationList() {
		List<Relation> relationList = relationService.findRelationList();
		System.out.println(relationList);
		return relationList;
	}

	@RequestMapping(value = "/rooms/{roomId}/join", method = RequestMethod.POST)
	public String joinRoom(@PathVariable Integer roomId, HttpSession session) {
		SessionUser sessionUser = (SessionUser)session.getAttribute("account");
		Room room = relationService.addRelation(roomId, sessionUser.getUserId());
		return "redirect:/rooms/" + room.getId();
	}
}
