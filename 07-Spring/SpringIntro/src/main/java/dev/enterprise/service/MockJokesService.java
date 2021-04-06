package dev.enterprise.service;

import dev.enterprise.repository.MockJokesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * the annotations that tell spring that a class is going to be a spring bean is known
 * as a Stereotypes
 * <p>
 * Component is the generic parent of all the stereotypes
 *
 * @Repository
 * @Service
 * @Controller
 * @Configuration
 */

// @component tells spring that this class is to be a spring bean
//@Component
@Service
@Scope("singleton")
public class MockJokesService {

    MockJokesRepository repo;

    @Autowired
    // constructor arg child element of bean will use constructor injection
    public MockJokesService(MockJokesRepository repo) {
        System.out.println("in the all args constructor");
        this.repo = repo;
    }

    public MockJokesService() {
        System.out.println("in the no arg constructor");
    }

    //    @Autowired
    // property child element of bean will use setter injection
    public void setRepo(MockJokesRepository repo) {
        System.out.println("in the setter");
        this.repo = repo;
    }

    public Map<String, String> getAllJokes() {
        return repo.getAllJokes();
    }

}
