package himedia.slivermate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import himedia.slivermate.service.SliverUserService;

@RestController
@RequestMapping("/api/user")
public class SliverUserController {
	@Autowired
	private SliverUserService sliverUserService;
	
//	GET : 
}
