package com.ccbcfx.learn.service.impl;


import com.ccbcfx.learn.enums.StaffStatusType;
import com.ccbcfx.learn.remote.dto.ConditionsDTO;
import com.ccbcfx.learn.remote.dto.PageStaffDTO;
import com.ccbcfx.learn.remote.dto.StaffDTO;
import com.ccbcfx.learn.service.PersonService;
import com.ccbcfx.learn.vo.request.ConditionsVo;
import com.ccbcfx.learn.vo.request.PersonLeaveVo;
import com.ccbcfx.learn.vo.request.PersonVo;
import com.ccbcfx.learn.vo.response.PagePersonInfoVo;
import com.ccbcfx.learn.vo.response.PersonInfoVo;
import ma.glasnost.orika.MapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static com.ccbcfx.learn.util.UserUtil.*;

@Service
public class StaffServiceImpl implements PersonService {

    @Value("${profile.store-path:#{null}}")
    String profileStorePath;
    @Value("${profile.server-url:#{null}}")
    String profileServerUrl;

    @Autowired
    ResourceLoader resourceLoader;

    @Autowired
    com.ccbcfx.learn.remote.client.StaffService staffService;

    @Autowired
    MapperFactory mapperFactory;


    @Override
    public int addPerson(PersonVo staffVo) {
        StaffDTO staff = new StaffDTO();
        staff.setName(staffVo.getName());
        LocalDate birthday = staffVo.getBirthday();
        staff.setBirthday(birthday);
        staff.setDocumentType(staffVo.getDocumentType());
        staff.setDocumentNumber(staffVo.getDocumentNumber());
        staff.setCreateBy(getUser());
        staff.setGender(staffVo.getGender());
        staff.setCreateAt(LocalDateTime.now());
        staff.setStatus(StaffStatusType.working);
        return staffService.createStaff(staff);
    }

    @Override
    public boolean delete(int id) {
        Integer userId= getUser();
        return staffService.delete(id, userId);
    }

    @Override
    public boolean updatePerson(int id, PersonVo staffVo) {
        StaffDTO staffDto = mapperFactory.getMapperFacade().map(staffVo, StaffDTO.class);
        staffDto.setUpdateBy(getUser());
        staffDto.setUpdateAt(LocalDateTime.now());

        return staffService.updateStaff(id, staffDto);
    }

    @Override
    public PersonInfoVo getPerson(int id) {
        StaffDTO staffDto = staffService.getStaff(id);
        return mapperFactory.getMapperFacade().map(staffDto, PersonInfoVo.class);
    }

    @Override
    public PagePersonInfoVo getPersonList(int offset, int size) {
        PageStaffDTO pageStaffDTO = staffService.getStaffList(offset,size);
        PagePersonInfoVo staffInfoVo = mapperFactory.getMapperFacade().map(pageStaffDTO, PagePersonInfoVo.class);
        return staffInfoVo;
    }

    @Override
    public PagePersonInfoVo getPersons(ConditionsVo conditionsVo) {
        ConditionsDTO conditionsDto = mapperFactory.getMapperFacade().map(conditionsVo.getConditions(), ConditionsDTO.class);
        int offset = conditionsVo.getOffset();
        int size = conditionsVo.getSize();
        PageStaffDTO staffDto = staffService.getStaffs(conditionsDto, offset, size);
        PagePersonInfoVo staffInfoVo = mapperFactory.getMapperFacade().map(staffDto, PagePersonInfoVo.class);
        return staffInfoVo;
    }

    @Override
    public boolean leave(PersonLeaveVo personLeaveVo) {
        return staffService.leave(personLeaveVo.getId(),
                personLeaveVo.getName(),
                personLeaveVo.getLeaveTime(),
                personLeaveVo.getLeaveReason());
    }

    @Override
    public String uploadPortrait(MultipartFile profile, int id) {
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
        String imgUrl=profileServerUrl+fileName;
        staffService.updateStaffPortrait(id,imgUrl);
        return imgUrl;
    }

    @Override
    public Resource getPortrait(String fileName) {
        return resourceLoader.getResource("file:"+ profileStorePath+"/"+fileName);
    }
}

