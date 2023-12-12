//package com.wsh.controller.actor;
//
//import com.wsh.domain.Actor;
//import com.wsh.service.ActorService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
///**
// *@author "Vladyslav Paun"
// */
//@RestController
//@RequestMapping("/api/actor")
//@RequiredArgsConstructor
//public class ActorRestController {
//
//    private final ActorService actorService;
//
//    @GetMapping("/list")
//    public ResponseEntity<List<Actor>> getAllActors(
//            @RequestParam(value = "page", required = false, defaultValue = "0") int page,
//            @RequestParam(value = "size", required = false, defaultValue = "10") int size,
//            @RequestParam(value = "sort", required = false, defaultValue = "actorId") String sort) {
//        Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
//        List<Actor> actors = actorService.findAll(pageable).getContent();
//        return ResponseEntity.ok(actors);
//    }
//}
