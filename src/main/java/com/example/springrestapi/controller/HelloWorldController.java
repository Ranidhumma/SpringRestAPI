package com.example.springrestapi.controller;

import com.example.springrestapi.entity.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")

public class HelloWorldController {
    /*
     * UC1 :
     * Create a Rest Controller to demonstrate
     * the various HTTP Methods and respond
     * hello messages to the User.
     * - Use GET Request Method
     * - Use CURL to demonstrate the REST API Call
     * - curl localhost:8080/hello -w "\n"
     *purpose : When the request mapping is done then all the statements  of sayHello gets executed
     * @return Hello World !!!
     */
    @GetMapping(value = {"", "/", "/home"})
    public String sayHello() {
        return "Hello World!!!";
    }

    /*UC2:
     * Make REST Call to show Hello
     * Mark from BridgeLabz
     * - Use GET Request Method and pass name as
     * query parameter
     * - Use CURL to demonstrate the REST API Call
     * - curl localhost:8080/hello/query?name=Rani
     * -w "\n"
     * @return Hello Rani from Bridgelabz !!
     */

    @RequestMapping(value = {"/query"}, method = RequestMethod.GET)
    public String sayHello(@RequestParam String name) {
        return "Hello " + name + " from Bridgelabz !!";
    }

    /*
     * @return Hello Rani !
     */
    @GetMapping({"/query1"})
    public String sayHelloQuery(@RequestParam String name) {
        return "Hello " + name + " !";
    }
    /*
     * @return Hello Rani from bridgelabz !
     */

    @GetMapping("/param/{name}")
    public String sayHelloParam(@PathVariable(value = "name") String name) {
        return "Hello " + name + " from bridgelabz";
    }

    /*
     * @return Hello Rani Dhumma! !
     */
    @GetMapping({"/query2"})
    public String sayHelloQuery(@RequestParam String fname, @RequestParam String lname) {
        return "Hello " + fname + " " + lname + "!";
    }
    /*
     * UC4
     * Make REST Call to show Hello Mark
     * Taylor from BridgeLabz
     * - Use POST Request Method and pass first name and
     * last name in the Body
     * - Create User DTO Bean with firstName and lastName as
     * attributes.
     * - Use CURL to demonstrate the REST API Call
     * - curl -X POST -H "Content-Type: application/json" -d
     * '{"firstName": ”Rani","lastName": ”Dhumma"}'
     * "http://localhost:8080/hello/create-user" -w "\n"
     * @return Hello Rani Dhumma !
     */

    @PostMapping(value = {"/create-user", "/post"})
    public String sayHello(@RequestBody User user) {
        return "Hello " + user.getFirstName() + " " + user.getLastName() + " !";
    }

    /*
     * UC5
     * Make REST Call to show Hello Mark
     * Taylor from BridgeLabz
     * - Use PUT Request Method and pass first name as
     * Path Variable and last name as Query Parameter
     * - Use CURL to demonstrate the REST API Call
     * - curl -X PUT
     * localhost:8080/hello/update/Rani/?lastName=Dhumma
     * -w "\n"
     * @return Hello Rani Dhumma :)
     */
    @PutMapping("/update/{firstName}")
    public String sayHelloTaylor(@PathVariable String firstName, @RequestParam String lastName, User user) {
        user.setFirstName(firstName);
        user.setLastName(lastName);
        return "Hello " + user.getFirstName() + " " + user.getLastName() + " :)";
    }
}


