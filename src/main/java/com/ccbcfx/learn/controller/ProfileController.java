package com.ccbcfx.learn.controller;

import com.ccbcfx.learn.service.ProfileService;
import com.ccbcfx.learn.service.StaffService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Api
@RestController
public class ProfileController {
    @Autowired
    private  ResourceLoader resourceLoader;

    @Autowired
    StaffService staffService;
    @Autowired
    ProfileService profileService;
    @ApiOperation("上传头像")
    @PutMapping(path = "/profile/{id}")
    public String setProfile(@RequestParam(required = true) MultipartFile profile,@PathVariable int id){
        return profileService.setProfile(profile,id);
    }
    @ApiOperation("获取头像")
    @GetMapping(path = "/profile")
    @ApiParam(name = "fileName", value = "员工头像唯一标识符", required = true)
    public ResponseEntity showProfile(@RequestParam String fileName){
        return ResponseEntity.ok(profileService.getResource(fileName));
    }



}
