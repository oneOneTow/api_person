package com.ccbcfx.learn.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface ProfileService {
    String setProfile(MultipartFile profile, int id);
    Resource getResource(String source);
}
