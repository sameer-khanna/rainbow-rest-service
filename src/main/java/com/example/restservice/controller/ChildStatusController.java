package com.example.restservice.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restservice.NotificationService;
import com.example.restservice.crud.Child;
import com.example.restservice.crud.ChildAddress;
import com.example.restservice.crud.ChildLeavingReason;
import com.example.restservice.crud.ChildLeftPlace;
import com.example.restservice.crud.ChildMap;
import com.example.restservice.crud.ChildStatus;
import com.example.restservice.crud.ClosedChildActionList;
import com.example.restservice.crud.GeneralHealth;
import com.example.restservice.repository.ChildLeavingReasonRepository;
import com.example.restservice.repository.ChildLeftPlaceRepository;
import com.example.restservice.repository.ChildMapRepository;
import com.example.restservice.repository.ChildRepository;
import com.example.restservice.repository.ClosedChildActionListRepository;

@RestController
@RequestMapping("/api/v1")
public class ChildStatusController {

	@Autowired
	private ChildLeavingReasonRepository childLeavingReasonRepository;

	@Autowired
	private ChildLeftPlaceRepository childLeftPlaceRepository;

	@Autowired
	private ClosedChildActionListRepository closedChildActionListRepository;

	@Autowired
	private ChildRepository childRepository;

	@Autowired
	private ChildMapRepository childMapRepository;

	@Autowired
	private NotificationService notificationService;

	@GetMapping("/child-leaving-reasons")
	public ResponseEntity<List<ChildLeavingReason>> getChildLeavingReasons() {
		List<ChildLeavingReason> childLeavingReasons = childLeavingReasonRepository.findAll();
		return ResponseEntity.ok().body(childLeavingReasons);
	}

	@GetMapping("/child-left-places")
	public ResponseEntity<List<ChildLeftPlace>> getChildLeftplaces() {
		List<ChildLeftPlace> childLeftPlaces = childLeftPlaceRepository.findAll();
		return ResponseEntity.ok().body(childLeftPlaces);
	}

	@GetMapping("/action-taken-list")
	public ResponseEntity<List<ClosedChildActionList>> getActionsTaken() {
		List<ClosedChildActionList> closedChildActionLists = closedChildActionListRepository.findAll();
		return ResponseEntity.ok().body(closedChildActionLists);
	}

	@PutMapping(path = "/child-status/{childNo}")
	@CacheEvict(value = "Child", allEntries = true)
	public ChildMap updateChild(@PathVariable Long childNo, @Valid @RequestBody ChildMap childMap) throws Exception {
		Child child = new Child();
		child.setChildNo(childNo);
		childMap.setChildNo(childNo);
		if (null != childMap.getChildStatusID()) {
			Integer childStatus = childMap.getChildStatusID();
			if (childMap.getChildStatusID().equals(5)) {
				childStatus = 3;
			}

			childRepository.saveChildStatus(childStatus, childNo);
			if(4 == childStatus) {
				Child ch = childRepository.getOne(childNo);
				notificationService.sendAddChildNotification(ch, ch.getRainbowHomeNumber());	
			}
			
			return childMapRepository.save(childMap);
		} else {
			throw new Exception("Status should not be null");
		}

	}

	@GetMapping(path = "/child-comm/{childNo}")
	@CacheEvict(value = "Child", allEntries = true)
	public boolean testNot(@PathVariable Long childNo) throws Exception {
		Child ch = childRepository.getOne(childNo);
		return notificationService.sendAddChildNotification(ch, ch.getRainbowHomeNumber());

	}

}