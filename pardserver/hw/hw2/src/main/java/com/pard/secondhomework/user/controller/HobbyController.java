package com.pard.secondhomework.user.controller;

import com.pard.secondhomework.user.dto.HobbyDto;
import com.pard.secondhomework.user.service.HobbyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/hobby")
public class HobbyController {
    private final HobbyService hobbyService;

    @PostMapping("/save")
    public void saveUser(@RequestBody HobbyDto hobbyDto){
        hobbyService.saveHobby(hobbyDto);
    }

    @GetMapping("/findAll")
    public List<HobbyDto> findAll(){
        return hobbyService.findAll();
    }

    @GetMapping("/find/{hobbyId}")
    public HobbyDto findById(@PathVariable Integer hobbyId){
        return hobbyService.findById(hobbyId);
    }

    @PatchMapping("/{hobbyId}")
    public void update(@PathVariable Integer hobbyId, @RequestBody HobbyDto hobbyDto){
        hobbyService.update(hobbyId, hobbyDto);
    }

    @DeleteMapping("/{hobbyId}")
    public void delete(@PathVariable Integer hobbyId){
        hobbyService.delete(hobbyId);
    }

}
