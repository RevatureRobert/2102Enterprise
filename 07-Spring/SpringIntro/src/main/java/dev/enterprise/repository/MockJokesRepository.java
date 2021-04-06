package dev.enterprise.repository;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.TreeMap;

//@Component
@Repository("mockRepo")
public class MockJokesRepository {

    private Map<String, String> jokes;

    {
        jokes = new TreeMap<>();
        jokes.put("knock knock", "noone");
        jokes.put("What do you call it when someone tries to sell you phony Real Estate when you are both moving downwards in an elevator?", "A condescending");
        jokes.put("doesnt matter", "cool");
    }

    public Map<String, String> getAllJokes(){
        return jokes;
    }
}
