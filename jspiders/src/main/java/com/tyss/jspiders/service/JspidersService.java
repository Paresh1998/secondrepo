package com.tyss.jspiders.service;

import com.tyss.jspiders.dto.EmployeeRegisterDTO;
import com.tyss.jspiders.dto.LoginDTO;
import com.tyss.jspiders.dto.StudentRegisterDTO;
import com.tyss.jspiders.dto.TrainerRegisterDTO;

public interface JspidersService {
    String registerEmployee(EmployeeRegisterDTO dto);

    String registerTrainer(TrainerRegisterDTO dto);

    String registerStudent(StudentRegisterDTO dto);

}
