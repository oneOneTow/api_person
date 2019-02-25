package com.ccbcfx.learn.service.impl;


import com.ccbcfx.learn.enums.DocumentType;
import com.ccbcfx.learn.service.StaffService;
import com.ccbcfx.learn.tables.pojos.Staff;
import com.ccbcfx.learn.vo.StaffVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Service
public class StaffServiceImpl implements StaffService {

    @Autowired
    com.ccbcfx.learn.remote.client.StaffService staffService;

    @Override
    public int addStaff(StaffVo staffVo,String createBy) {
        Staff staff=new Staff();
        staff.setName(staffVo.getName());
        LocalDateTime birthday=LocalDateTime.ofInstant(staffVo.getBirthday().toInstant(),ZoneId.systemDefault());
        staff.setBirthday(birthday);
        staff.setDocumentType(DocumentType.getEnumByDesc(staffVo.getDocumentType()).getOrder());
        staff.setDocumentNumber(staffVo.getDocumentNumber());
        staff.setCreateBy(createBy);
        staff.setCreateAt(LocalDateTime.now());
        return staffService.createStaff(staff);
    }
}
