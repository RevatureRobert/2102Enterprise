package dev.enterprise.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.enterprise.service.MockJokesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * Spring MVC Architecture
 *
 *      DispatcherServlet -> HandlerMapping
 *          HandlerMapping will provide the DispatcherServlet with the correct
 *              Controller information so the DispatcherServlet can call the
 *              correct method in the next step. We Register our controller methods
 *              to the HandlerMapping with the RequestMapping annotations.
 *      DispatcherServlet -> Controller
 *          The DispatcherServlet will send the request to the controller and
 *              will then run our business logic. The result of our logic will
 *              be sent back to the DispatcherServlet. We can create an entire
 *              Response object and have full control over the response object
 *              inside of our controllers.
 *      DispatcherServlet -> ViewResolver [optional]
            The DispatcherServlet will send the request to the ViewResolver if the
                Controller sends the DispatcherServlet information about a view
                to resolve. The ViewResolver will perform whatever is needed for
                the view to be ready for the client and send the DispatcherServlet
                information about what to send back for that view.
        DispatcherServlet -> view
           The DispatcherServlet takes the view either referenced or given from
                the ViewResolver and sends the contents of the view inside the
                response body back to the client.
 */


@Controller
public class JokeController {

    private MockJokesService service;

    public MockJokesService getService() {
        return service;
    }

    @Autowired
    public void setService(MockJokesService service) {
        this.service = service;
    }

    // This annotation tells Spring to map get requests for hello.json to this method
    @RequestMapping(method = RequestMethod.GET, value="/hello.json")
    public ResponseEntity<String> helloWorld(){
        ResponseEntity<String> responseEntity = new ResponseEntity<>("Hello World", HttpStatus.ACCEPTED);
//        responseEntity.getHeaders().add("Content-Type","text/plain");
        return responseEntity;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/jokes.json")
    public ResponseEntity<String> getAllJokes() throws JsonProcessingException {
        return new ResponseEntity<>(new ObjectMapper().writeValueAsString(service.getAllJokes()), HttpStatus.ACCEPTED);
    }
}
