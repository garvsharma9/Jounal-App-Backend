package com.journal.journalApp.Services;

import com.journal.journalApp.Repository.UserRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
public class UserServiceTests {
    @Autowired
    private UserRepository userRepository;
    @Disabled
    @Test
    public void testFindByUserName()
    {
        assertNotNull(userRepository.findByUsername("ram"));
    }
    @Disabled
    @ParameterizedTest
    @CsvSource({
            "1,1,2",
            "10,1,9",
            "2,1,3"
    })
    public void test(int a, int b, int expected)
    {
        assertEquals(expected, a+b);
    }
}
