package com.eregister.PeopleService;

import com.eregister.PeopleService.Entity.Address;
import com.eregister.PeopleService.Entity.Person;
import com.eregister.PeopleService.Model.*;
import com.eregister.PeopleService.Service.PeopleService;
import com.eregister.SecurityService.Model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

/**
 * Created by Karo2 on 2017-05-07.
 */

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/People")
public class PeopleController {
    @Autowired
    PeopleService peopleService;

    @RequestMapping(method = RequestMethod.GET)
    public Serializable getAllPeople(@RequestHeader(name = "Authorization") String token) {
        Serializable response;
        try {
            response = new PeopleResponse("ok", peopleService.getAllPeople());
        } catch (Exception e) {
            response = new Response("Error", "Internal error");
        }
        return response;
    }

    @RequestMapping(value = "/Child/id={idPerson}", method = RequestMethod.GET)
    public Serializable getAllChild(@PathVariable("idPerson") int idPerson,
                                    @RequestHeader(name = "Authorization") String token) {
        Serializable response;
        try {
            response = new PeopleResponse("ok", peopleService.getAllChild(idPerson));
        } catch (Exception e) {
            response = new Response("Error", "Internal error");
        }
        return response;
    }

    @RequestMapping(value = "/Person/id={idPerson}", method = RequestMethod.GET)
    public Serializable getPersonById(@PathVariable("idPerson") int idPerson,
                                      @RequestHeader(name = "Authorization") String token) {
        Serializable response;
        try {
            response = new PersonResponse("ok", peopleService.getPersonById(idPerson));
        } catch (Exception e) {
            response = new Response("Error", "Internal error");
        }
        return response;
    }

    @RequestMapping(value = "/Address/id={idAddress}", method = RequestMethod.GET)
    public Serializable getAddressById(@PathVariable("idAddress") int idAddress,
                                       @RequestHeader(name = "Authorization") String token) {
        Serializable response;
        try {
            response = new AddressResponse("ok", peopleService.getAddressById(idAddress));
        } catch (Exception e) {
            response = new Response("Error", "Internal error");
        }
        return response;
    }

    @RequestMapping(value = "/Person/id={idPerson}", method = RequestMethod.DELETE)
    public Serializable removePersonById(@PathVariable("idPerson") int idPerson,
                                         @RequestHeader(name = "Authorization") String token) {
        Serializable response;
        try {
            peopleService.removePersonById(idPerson);
            response = new Response("ok", "Removed person id: " + idPerson);
        } catch (Exception e) {
            response = new Response("Error", "Internal error");
        }
        return response;
    }

    @RequestMapping(value = "/Address/id={idAddress}", method = RequestMethod.DELETE)
    public Serializable removeAddressById(@PathVariable("idAddress") int idAddress,
                                          @RequestHeader(name = "Authorization") String token) {
        Serializable response;
        try {
            peopleService.removeAddressById(idAddress);
            response = new Response("ok", "Removed address id: " + idAddress);
        } catch (Exception e) {
            response = new Response("Error", "Internal error");
        }
        return response;
    }

    @RequestMapping(value = "/updatePhone", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Serializable updatePhone(@RequestBody UpdatePhoneRequest updatePhoneRequest,
                                    @RequestHeader(name = "Authorization") String token) {
        Serializable response;
        try {
            peopleService.updatePhone(updatePhoneRequest);
            response = new Response("ok", "Updated phone.");
        } catch (Exception e) {
            response = new Response("Error", "Internal error");
        }
        return response;
    }

    @RequestMapping(value = "/updateMail", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Serializable updateMail(@RequestBody UpdateMailRequest updateMailRequest,
                                   @RequestHeader(name = "Authorization") String token) {
        Serializable response;
        try {
            peopleService.updateMail(updateMailRequest);
            response = new Response("ok", "Updated mail.");
        } catch (Exception e) {
            response = new Response("Error", "Internal error");
        }
        return response;
    }

    @RequestMapping(value = "/updateExpirationDate", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Serializable updateExpirationDate(@RequestBody UpdateExpirationDateRequest updateExpirationDateRequest,
                                             @RequestHeader(name = "Authorization") String token) {
        Serializable response;
        try {
            peopleService.updateExpirationDate(updateExpirationDateRequest);
            response = new Response("ok", "Updated expiration date.");
        } catch (Exception e) {
            response = new Response("Error", "Internal error");
        }
        return response;
    }

    @RequestMapping(value = "/updateIdAddress", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Serializable updateIdAddress(@RequestBody UpdateIdAddressRequest updateIdAddressRequest,
                                        @RequestHeader(name = "Authorization") String token) {
        Serializable response;
        try {
            peopleService.updateIdAddress(updateIdAddressRequest);
            response = new Response("ok", "Updated id address.");
        } catch (Exception e) {
            response = new Response("Error", "Internal error");
        }
        return response;
    }

    @RequestMapping(value = "/updateAddress", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Serializable updateAddress(@RequestBody UpdateAddressRequest updateAddressRequest,
                                      @RequestHeader(name = "Authorization") String token) {
        Serializable response;
        try {
            peopleService.updateAddress(updateAddressRequest);
            response = new Response("ok", "Updated address.");
        } catch (Exception e) {
            response = new Response("Error", "Internal error");
        }
        return response;
    }

    @RequestMapping(value = "/newAddress", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Serializable insertAddress(@RequestBody Address address,
                                      @RequestHeader(name = "Authorization") String token) {
        Serializable response;
        try {
            peopleService.insertAddress(address);
            response = new Response("ok", "Inserted address.");
        } catch (Exception e) {
            response = new Response("Error", "Internal error.");
        }
        return response;
    }

    @RequestMapping(value = "/newPersonWithAddress", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Serializable insertPersonWithAddress(@RequestBody InsertPersonWithAddress insertPersonWithAddress,
                                                @RequestHeader(name = "Authorization") String token) {
        Serializable response;
        try {
            peopleService.insertPerson(insertPersonWithAddress);
            response = new Response("ok", "Inserted person with address.");
        } catch (Exception e) {
            response = new Response("Error", e.getMessage());
        }
        return response;
    }
//    {
//        "address":
//        {
//            "idAddress":1,
//                "street":"Dolnych Wałów",
//                "houseNumber":"22b",
//                "flatNumber":5,
//                "postalCode":"44-100",
//                "city":"Gliwice",
//                "country":"Polska"
//        },
//        "person":
//        {
//            "id": 1,
//                "name": "Bartłomiej",
//                "surname": "Kaczkowski",
//                "dateOfBirth": "1982-04-28",
//                "sex": "kobieta",
//                "phone": "511511511",
//                "mail": "dwdwdwd",
//                "expirationDate": "2019-12-12",
//                "idAddress": 4
//        }
//    }

    @RequestMapping(value = "/newPerson", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Serializable insertPerson(@RequestBody Person person,
                                     @RequestHeader(name = "Authorization") String token) {
        Serializable response;
        try {
            peopleService.insertPerson(person);
            response = new Response("ok", "Inserted person.");
        } catch (Exception e) {
            response = new Response("Error", e.getMessage());
        }
        return response;
    }
    // PRZYKłAD ----> {
    //	"id": 1,
    //  "name": "Bartłomiej",
    //  "surname": "Kaczkowski",
    //  "dateOfBirth": "1982-04-28",
    //  "sex": "kobieta",
    //  "phone": "511511511",
    //  "mail": "dwdwdwd",
    //  "expirationDate": "2019-12-12",
    //  "idAddress": 4
    //}
}
