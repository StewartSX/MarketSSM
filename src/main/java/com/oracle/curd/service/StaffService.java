package com.oracle.curd.service;

import com.oracle.curd.bean.Staff;
import com.oracle.curd.bean.StaffExample;
import com.oracle.curd.dao.StaffMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffService {

    @Autowired
    StaffMapper staffMapper;

    public Staff getStaffById(String staffid){
        return staffMapper.selectByPrimaryKey(staffid);
    }

    public List<Staff> getAllStaff(){
        return staffMapper.selectByExample(null);
    }

    public List<Staff> getStaffByExample(String staffid, String staffname){
        StaffExample example = new StaffExample();
        StaffExample.Criteria criteria = example.createCriteria();

        if ((staffid==null||staffid.equals("")) && (staffname==null || staffname.equals(""))){
            return staffMapper.selectByExample(null);
        } else {
            if (staffid!=null && !staffid.equals("")){
                criteria.andStaffidEqualTo(staffid);
            }
            if (staffname!=null && !staffname.equals("")){
                criteria.andStaffnameEqualTo(staffname);
            }
            return staffMapper.selectByExample(example);
        }
    }

    public void addStaff(String staffid, String staffname, String card, String sex, String tel, String stafftype, String pwd1, String pwd2){
        if (pwd1.equals(pwd2)){
            Staff staff = new Staff();
            staff.setStaffid(staffid);
            staff.setStaffname(staffname);
            staff.setCard(card);
            staff.setSex(sex);
            staff.setTel(tel);
            staff.setStafftype(stafftype);
            staff.setPwd(pwd1);

            staffMapper.insert(staff);
        }
    }

    public void editStaff(String staffid, String staffname, String card, String sex, String tel, String stafftype, String pwd1, String pwd2){
        if (pwd1.equals(pwd2)){
            Staff staff = new Staff();
            staff.setStaffid(staffid);
            staff.setStaffname(staffname);
            staff.setCard(card);
            staff.setSex(sex);
            staff.setTel(tel);
            staff.setStafftype(stafftype);
            staff.setPwd(pwd1);

            staffMapper.updateByPrimaryKey(staff);
        }
    }


    public void deleteStaffById(String staffid){
        staffMapper.deleteByPrimaryKey(staffid);
    }


















}
