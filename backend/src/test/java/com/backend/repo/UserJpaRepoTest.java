package com.backend.repo;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Collections;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import com.backend.entity.User;
 
@RunWith(SpringRunner.class)
@DataJpaTest
public class UserJpaRepoTest {
 
    @Autowired
    private UserJpaRepo userJpaRepo;
 
    @Autowired
    private PasswordEncoder passwordEncoder;
 
    @Test
    public void whenFindByUid_thenReturnUser() {
        String uid = "angrydaddy@gmail.com";
        String name = "angrydaddy";
        // given
        userJpaRepo.save(User.builder()
                .email(uid)
                .password(passwordEncoder.encode("1234"))
                .name(name)
                .roles(Collections.singletonList("ROLE_USER"))
                .build());
        // when
        Optional<User> user = userJpaRepo.findByEmail(uid);
        // then
        assertNotNull(user);// user객체가 null이 아닌지 체크
        assertTrue(user.isPresent()); // user객체가 존재여부 true/false 체크
        assertEquals(user.get().getName(), name); // user객체의 name과 name변수 값이 같은지 체크
        assertThat(user.get().getName(), is(name)); // user객체의 name과 name변수 값이 같은지 체크
    }
}