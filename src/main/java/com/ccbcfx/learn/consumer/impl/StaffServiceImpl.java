package com.ccbcfx.learn.consumer.impl;


import com.ccbcfx.learn.enums.StaffStatusType;
import com.ccbcfx.learn.remote.dto.ConditionsDto;
import com.ccbcfx.learn.remote.dto.StaffDto;
import com.ccbcfx.learn.consumer.PersonService;
import com.ccbcfx.learn.vo.request.ConditionsVo;
import com.ccbcfx.learn.vo.request.PersonLeaveVo;
import com.ccbcfx.learn.vo.request.PersonVo;
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

import java.util.List;

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
    public int addPerson(PersonVo staffVo, int createBy) {
        StaffDto staff = new StaffDto();
        staff.setName(staffVo.getName());
        LocalDate birthday = staffVo.getBirthday();
        staff.setBirthday(birthday);
        staff.setDocumentType(staffVo.getDocumentType());
        staff.setDocumentNumber(staffVo.getDocumentNumber());
        staff.setCreateBy(createBy);
        staff.setGender(staffVo.getGender());
        staff.setCreateAt(LocalDateTime.now());
        staff.setStatus(StaffStatusType.working);
        return staffService.createStaff(staff);
    }

    @Override
    public boolean delete(int id, int deleteBy) {
        return staffService.delete(id, deleteBy);
    }

    @Override
    public PersonInfoVo updatePerson(int id, PersonVo staffVo, int updateBy) {
        StaffDto staffDto = mapperFactory.getMapperFacade().map(staffVo, StaffDto.class);
        staffDto.setUpdateBy(updateBy);
        staffDto.setUpdateAt(LocalDateTime.now());
        StaffDto result = staffService.updateStaff(id, staffDto);
        return mapperFactory.getMapperFacade().map(result, PersonInfoVo.class);
    }

    @Override
    public PersonInfoVo getPerson(int id) {
        StaffDto staffDto = staffService.getStaff(id);
        return mapperFactory.getMapperFacade().map(staffDto, PersonInfoVo.class);
    }

    @Override
    public List<PersonInfoVo> getPersons(ConditionsVo conditionsVo) {
        ConditionsDto conditionsDto = mapperFactory.getMapperFacade().map(conditionsVo.getConditions(), ConditionsDto.class);
        int offset = conditionsVo.getOffset();
        int size = conditionsVo.getSize();
        List<StaffDto> staffDtoList = staffService.getStaffs(conditionsDto, offset, size);
        List<PersonInfoVo> staffInfoVoList = mapperFactory.getMapperFacade().mapAsList(staffDtoList, PersonInfoVo.class);
        return staffInfoVoList;
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

