package com.poly.springboot.controller;

import com.poly.springboot.dto.requestDto.ColorRequestDto;
import com.poly.springboot.dto.requestDto.ImageRequestDto;
import com.poly.springboot.dto.responseDto.ImageResponseDto;
import com.poly.springboot.entity.Color;
import com.poly.springboot.entity.Image;
import com.poly.springboot.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @GetMapping("image")
    public ResponseEntity<List<ImageResponseDto>> getAll(){
        List<ImageResponseDto> responseDtoList = imageService.getImages();
        return new ResponseEntity<>(responseDtoList, HttpStatus.OK);
    }

    @GetMapping("image/{id}")
    public ResponseEntity<Image> findById(@PathVariable Long id){
        Image image = imageService.findById(id);
        return ResponseEntity.ok(image);
    }

    @PostMapping("create-image")
    public ResponseEntity<Image>crate(@RequestBody ImageRequestDto imageRequestDto){
        Image image = imageService.save(imageRequestDto);
        return ResponseEntity.ok(image);
    }

    @PutMapping("update-image/{id}")
    public ResponseEntity<Image> update(@RequestBody ImageRequestDto imageRequestDto,@PathVariable Long id){
        Image image = imageService.update(imageRequestDto,id);
        return ResponseEntity.ok(image);
    }

    @DeleteMapping("delete-image/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        String mes = imageService.delete(id);
        return ResponseEntity.ok(mes);
    }
}
