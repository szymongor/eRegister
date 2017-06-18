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

    @RequestMapping(value = "/myPartialGrades", method = RequestMethod.GET)
    public Serializable getMyPartialGrades(@RequestHeader(name = "Authorization") String token) {
        Serializable response;
        try {
            int idEregUser = TokenUtils.getIdEregUserFromToken(token);
            response = new GradesResponse("ok", gradesService.getAllUserPartialGrades(idEregUser));
        } catch (Exception e) {
            response = new Response("Error", "InternalError");
        }
        return response;
    }

    @RequestMapping(value = "/myPartialGrades/{idLesson}", method = RequestMethod.GET)
    public Serializable getMyPartialGradesFromLesson(@PathVariable("idLesson") int idLesson,
                                                     @RequestHeader(name = "Authorization") String token) {
        Serializable response;
        try {
            int idEregUser = TokenUtils.getIdEregUserFromToken(token);
            response = new GradesResponse("ok", gradesService.getAllUserPartialGradesFromLesson(idEregUser, idLesson));
        } catch (Exception e) {
            response = new Response("Error", "InternalError");
        }
        return response;
    }

    @RequestMapping(value = "/mySemifinalGrades", method = RequestMethod.GET)
    public Serializable getMySemifinalGrades(@RequestHeader(name = "Authorization") String token) {
        Serializable response;
        try {
            int idEregUser = TokenUtils.getIdEregUserFromToken(token);
            response = new GradesResponse("ok", gradesService.getAllUserSemifinalGrades(idEregUser));
        } catch (Exception e) {
            response = new Response("Error", "InternalError");
        }
        return response;
    }

    @RequestMapping(value = "/mySemifinalGrades/{idLesson}", method = RequestMethod.GET)
    public Serializable getMySemifinalGradesFromLesson(@PathVariable("idLesson") int idLesson,
                                                       @RequestHeader(name = "Authorization") String token) {
        Serializable response;
        try {
            int idEregUser = TokenUtils.getIdEregUserFromToken(token);
            response = new GradesResponse("ok", gradesService.getAllUserSemifinalGradesFromLesson(idEregUser, idLesson));
        } catch (Exception e) {
            response = new Response("Error", "InternalError");
        }
        return response;
    }

    @RequestMapping(value = "/myFinalGrades", method = RequestMethod.GET)
    public Serializable getMyFinalGrades(@RequestHeader(name = "Authorization") String token) {
        Serializable response;
        try {
            int idEregUser = TokenUtils.getIdEregUserFromToken(token);
            response = new GradesResponse("ok", gradesService.getAllUserFinalGrades(idEregUser));
        } catch (Exception e) {
            response = new Response("Error", "InternalError");
        }
        return response;
    }

    @RequestMapping(value = "/myFinalGrades/{idLesson}", method = RequestMethod.GET)
    public Serializable getMyFinalGradesFromLesson(@PathVariable("idLesson") int idLesson,
                                                   @RequestHeader(name = "Authorization") String token) {
        Serializable response;
        try {
            int idEregUser = TokenUtils.getIdEregUserFromToken(token);
            response = new GradesResponse("ok", gradesService.getAllUserFinalGradesFromLesson(idEregUser, idLesson));
        } catch (Exception e) {
            response = new Response("Error", "InternalError");
        }
        return response;
    }

    @RequestMapping(value = "/userPartialGrades/{idUser}", method = RequestMethod.GET)
    public Serializable getUserPartialGrades(@PathVariable("idUser") int idUser,
                                             @RequestHeader(name = "Authorization") String token) {
        Serializable response;
        try {
            response = new GradesResponse("ok", gradesService.getAllUserPartialGrades(idUser));
        } catch (Exception e) {
            response = new Response("Error", "InternalError");
        }
        return response;
    }

    @RequestMapping(value = "/userPartialGrades/{idUser}/lesson/{idLesson}", method = RequestMethod.GET)
    public Serializable getUserPartialGrades(@PathVariable("idUser") int idUser, @PathVariable("idLesson") int idLesson,
                                             @RequestHeader(name = "Authorization") String token) {
        Serializable response;
        try {
            response = new GradesResponse("ok", gradesService.getAllUserPartialGradesFromLesson(idUser, idLesson));
        } catch (Exception e) {
            response = new Response("Error", "InternalError");
        }
        return response;
    }

    @RequestMapping(value = "/userSemifinalGrades/{idUser}", method = RequestMethod.GET)
    public Serializable getUserSemifinalGrades(@PathVariable("idUser") int idUser,
                                               @RequestHeader(name = "Authorization") String token) {
        Serializable response;
        try {
            response = new GradesResponse("ok", gradesService.getAllUserSemifinalGrades(idUser));
        } catch (Exception e) {
            response = new Response("Error", "InternalError");
        }
        return response;
    }

    @RequestMapping(value = "/userSemifinalGrades/{idUser}/lesson/{idLesson}", method = RequestMethod.GET)
    public Serializable getUserSemifinalGrades(@PathVariable("idUser") int idUser, @PathVariable("idLesson") int idLesson,
                                               @RequestHeader(name = "Authorization") String token) {
        Serializable response;
        try {
            response = new GradesResponse("ok", gradesService.getAllUserSemifinalGradesFromLesson(idUser, idLesson));
        } catch (Exception e) {
            response = new Response("Error", "InternalError");
        }
        return response;
    }

    @RequestMapping(value = "/userFinalGrades/{idUser}", method = RequestMethod.GET)
    public Serializable getUserFinalGrades(@PathVariable("idUser") int idUser,
                                           @RequestHeader(name = "Authorization") String token) {
        Serializable response;
        try {
            response = new GradesResponse("ok", gradesService.getAllUserFinalGrades(idUser));
        } catch (Exception e) {
            response = new Response("Error", "InternalError");
        }
        return response;
    }

    @RequestMapping(value = "/userFinalGrades/{idUser}/lesson/{idLesson}", method = RequestMethod.GET)
    public Serializable getUserFinalGrades(@PathVariable("idUser") int idUser, @PathVariable("idLesson") int idLesson,
                                           @RequestHeader(name = "Authorization") String token) {
        Serializable response;
        try {
            response = new GradesResponse("ok", gradesService.getAllUserFinalGradesFromLesson(idUser, idLesson));
        } catch (Exception e) {
            response = new Response("Error", "InternalError");
        }
        return response;
    }
}
