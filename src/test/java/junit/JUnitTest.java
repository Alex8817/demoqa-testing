package junit;

import org.junit.jupiter.api.*;
public class JUnitTest {

    @BeforeAll
    static void beforeAll(){
        System.out.println("Method @BeforeAll");
    };

    @AfterAll
    static void afterAll(){
        System.out.println("Method @AfterAll");
    }


    @BeforeEach
    void beforeEach(){
        System.out.println("Method @Beforeeach");
    }
    @AfterEach
    void afterEach(){
        System.out.println("Method @Aftereach");
    }


    @Test
    void jUnitTest() {
        Assertions.assertTrue(3 > 2);

    }

}
