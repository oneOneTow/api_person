package com.ccbcfx.learn.service.impl;


import com.ccbcfx.learn.enums.DocumentType;
import com.ccbcfx.learn.enums.GenderType;
import com.ccbcfx.learn.enums.StaffStatusType;
import com.ccbcfx.learn.remote.dto.StaffDto;
import com.ccbcfx.learn.service.StaffService;
import com.ccbcfx.learn.vo.request.StaffVo;
import ma.glasnost.orika.MapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

@Service
public class StaffServiceImpl implements StaffService {

    @Autowired
    com.ccbcfx.learn.remote.client.StaffService staffService;

    @Autowired
    MapperFactory mapperFactory;

    @Override
    public int addStaff(StaffVo staffVo,String createBy) {
        StaffDto staff=new StaffDto();
        staff.setName(staffVo.getName());
        LocalDateTime birthday=LocalDateTime.ofInstant(staffVo.getBirthday().toInstant(),ZoneId.systemDefault());
        staff.setBirthday(birthday);
        staff.setDocumentType(DocumentType.getEnumByDesc(staffVo.getDocumentType()).getOrder());
        staff.setDocumentNumber(staffVo.getDocumentNumber());
        staff.setCreateBy(createBy);
        staff.setGender(GenderType.getEnumByDesc(staffVo.getGender()).getOrder());
        staff.setCreateAt(LocalDateTime.now());
        staff.setStatus(StaffStatusType.working.getOrder());
        return staffService.createStaff(staff);
    }

    @Override
    public List<StaffVo> getStaffs() {
        List<StaffVo> staffVos=new ArrayList<>();
        List<StaffDto> staffDtos =  staffService.getStaffs();
        for(StaffDto staffDto:staffDtos){
            StaffVo staffVo = mapperFactory.getMapperFacade().map(staffDto,StaffVo.class);
            staffVos.add(staffVo);
        }
        return staffVos;
    }


    @Override
    public boolean delete(int id) {
        return staffService.delete(id);
    }
}

