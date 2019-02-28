package com.ccbcfx.learn.service.impl;

import com.ccbcfx.learn.constant.ImgConstant;
import com.ccbcfx.learn.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class ProfileServiceImpl implements ProfileService {
    @Value("${profile.store-path:#{null}}")
    String profileStorePath;
    @Value("${profile.server-url:#{null}}")
    String profileServerUrl;

    @Autowired
    ResourceLoader resourceLoader;

    @Override
    public String setProfile(MultipartFile profile, int id) {
        String fileName = profile.getOriginalFilename();
        String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
        fileName = id + "." + suffix;
        File file = new File(profileStorePath);
        if (!file.exists()) {
            file.mkdirs();
        }
        File targetFile = new File(file, fileName);
        try {
            profile.transferTo(targetFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return profileServerUrl+fileName;
    }

    @Override
    public Resource getResource(String fileName) {
        return resourceLoader.getResource("file:"+ profileStorePath+"/"+fileName);
    }
}
