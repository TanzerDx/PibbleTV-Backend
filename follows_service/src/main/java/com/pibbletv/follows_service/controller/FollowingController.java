package com.pibbletv.follows_service.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/following")
@AllArgsConstructor
@CrossOrigin(origins = {"http://localhost:5173/" , "http://localhost:4173"})
public class FollowingController {
}
