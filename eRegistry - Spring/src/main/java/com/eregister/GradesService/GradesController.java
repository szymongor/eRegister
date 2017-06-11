package com.eregister.GradesService;

import com.eregister.GradesService.Model.GradesResponse;
import com.eregister.GradesService.Service.GradesService;
import com.eregister.SecurityService.Model.Response;
import com.eregister.SecurityService.Token.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

/**
 * Created by Karo2 on 2017-05-17.
 */

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/Grades")
public class GradesController {

    @Autowired
    GradesService gradesService;

    @RequestMapping(value = "/myGrades", method = RequestMethod.GET)
    public Serializable getMyGrades(@RequestHeader(name = "Authorization") String token) {
        Serializable response;
        try {
            int idEregUser = TokenUtils.getIdEregUserFromToken(token);
            response = new GradesResponse("ok", gradesService.getAllUserGrades(idEregUser));
        } catch (Exception e) {
            response = new Response("Error", "InternalError");
        }
        return response;
    }

    @RequestMapping(value = "/myGrades/{idLesson}", method = RequestMethod.GET)
    public Serializable getMyGradesFromLesson(@PathVariable("idLesson") int idLesson,
                                              @RequestHeader(name = "Authorization") String token) {
        Serializable response;
        try {
            int idEregUser = TokenUtils.getIdEregUserFromToken(token);
            response = new GradesResponse("ok", gradesService.getAllUserGradesFromLesson(idEregUser, idLesson));
        } catch (Exception e) {
            response = new Response("Error", "InternalError");
        }
        return response;
    }

    @RequestMapping(value = "/userGrades/{idUser}", method = RequestMethod.GET)
    public Serializable getUserGrades(@PathVariable("idUser") int idUser,
                                      @RequestHeader(name = "Authorization") String token) {
        Serializable response;
        try {
            response = new GradesResponse("ok", gradesService.getAllUserGrades(idUser));
        } catch (Exception e) {
            response = new Response("Error", "InternalError");
        }
        return response;
    }

    @RequestMapping(value = "/userGrades/{idUser}/lesson/{idLesson}", method = RequestMethod.GET)
    public Serializable getUserGrades(@PathVariable("idUser") int idUser, @PathVariable("idLesson") int idLesson,
                                      @RequestHeader(name = "Authorization") String token) {
        Serializable response;
        try {
            response = new GradesResponse("ok", gradesService.getAllUserGradesFromLesson(idUser, idLesson));
        } catch (Exception e) {
            response = new Response("Error", "InternalError");
        }
        return response;
    }
}
