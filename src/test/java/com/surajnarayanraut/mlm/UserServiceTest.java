package com.surajnarayanraut.mlm;


import com.surajnarayanraut.mlm.dto.UserRegDto;
import com.surajnarayanraut.mlm.entity.User;
import com.surajnarayanraut.mlm.enums.Role;
import com.surajnarayanraut.mlm.exception.ValidationException;
import com.surajnarayanraut.mlm.repository.UserRepo;
import com.surajnarayanraut.mlm.service.UserService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    UserRepo userRepo;


    @Mock
    ModelMapper mapper=new ModelMapper();

    @InjectMocks
    UserService userService;

    @Test
    public  void testUserRegistration()
    {
        UserRegDto demo=UserRegDto.builder().email("s@gmail.com").name("Suraj").password("12345").role(Role.USER).build();
        User userData=mapper.map(demo, User.class);
        when(userRepo.existsByEmail("s@gmail.com")).thenReturn(false);
        when(userRepo.save(userData)).thenReturn(userData);
        assertEquals(userData,userService.register(demo));


    }
    @Test
    public  void testUserRegistrationWithAlreadyExists()
    {
        UserRegDto demo=UserRegDto.builder().email("s@gmail.com").name("Suraj").password("12345").role(Role.USER).build();
        when(userRepo.existsByEmail("s@gmail.com")).thenReturn(true);
        Exception e=assertThrows(ValidationException.class,()->{userService.register(demo);});
        assertEquals("email exists", e.getMessage());
    }

}
