package com.example.loginandregistration.service;

import com.example.loginandregistration.ApiResponse;
import com.example.loginandregistration.model.LoginDto;
import com.example.loginandregistration.model.SignUpDto;
import com.example.loginandregistration.model.User;
import com.example.loginandregistration.repository.UserDao;
import com.example.loginandregistration.repository.UserDaoImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.transaction.Transactional;

@Transactional
@Service

public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserDao userDaoImpl;

    @Override
    public ApiResponse signUp(SignUpDto signUpDto) {
        validateSignUp(signUpDto);
        User user = new User();
        //can use Bcrypt
        BeanUtils.copyProperties(signUpDto, user);
        userDaoImpl.save(user);
        return new ApiResponse(200, "success", user);
    }

    @Override
    public ApiResponse login(LoginDto loginDto) {
        User user = userDao.findByUsername(loginDto.getUsername());
        if (user == null) {
            return setValueInResponse(HttpStatus.BAD_REQUEST, "User does not exist.", loginDto);
        }
        if (user.getPassword().equalsIgnoreCase(loginDto.getPassword())) {
            return setValueInResponse(HttpStatus.OK, "Login Successfully", loginDto);
        } else return setValueInResponse(HttpStatus.BAD_REQUEST, "Password mismatch", loginDto);

    }

    private ApiResponse setValueInResponse(HttpStatus status, String message, LoginDto loginDto) {
        ApiResponse response = new ApiResponse();
        response.setStatus(status.value());
        response.setMessage(message);
        response.setResult(loginDto.getUsername());
        return response;
    }

    public void validateSignUp(SignUpDto signUpDto) {
    }

}
