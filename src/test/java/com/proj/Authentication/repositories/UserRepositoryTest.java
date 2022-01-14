package com.proj.Authentication.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.TestPropertySource;

import com.proj.Authentication.models.User;

@DataJpaTest 
@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
@TestPropertySource(locations="classpath:application-test.properties")
class UserRepositoryTest {

	@Autowired
	UserRepository userRepository;
	
	
	@Test
	public void getUserTest() {
		User user = new User(
				1L,
				"Tyler",
				"Tyler1",
				"Administrator"
				);
		userRepository.save(user);
		System.out.println("getUserTest: ");
		System.out.println(userRepository.findById(1L).get());
		User newest = userRepository.findById(1L).get();
		assertEquals(1L, newest.getId());
		assertEquals("Administrator", newest.getRole());
		
		
	}
	
	@Test
    void testFindAllEmployees()
    {
        List<User> list = new ArrayList<User>();
        User empOne = new User(1L, "Tyler", "Tyler1", "Administrator");
        User empTwo = new User(2L, "Tyler", "Tyler2", "Manager");
        User empThree = new User(3L, "Tyler", "Tyler3", "User");
        list.add(empOne);
        list.add(empTwo);
        list.add(empThree);
        userRepository.saveAll(list);
        System.out.println(list);
         
        //test
        List<User> empList = userRepository.findAll();
        System.out.println("empList: ");
        System.out.println(empList);
        assertEquals(3, empList.size());
        
        
    }
}
