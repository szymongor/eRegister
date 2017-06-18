package com.eregister.GradesService;

import com.eregister.GradesService.Model.*;
import com.eregister.GradesService.Service.GradesService;
import com.eregister.SecurityService.Model.Response;
import com.eregister.SecurityService.Token.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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

    @RequestMapping(value = "/partialGradeId={idGrade}", method = RequestMethod.DELETE)
    public Serializable removePartialGradeById(@PathVariable("idGrade") int idGrade,
                                               @RequestHeader(name = "Authorization") String token) {
        Serializable response;
        //TODO: role = teacher and admin only
        try {
            gradesService.removePartialGradeById(idGrade);
            response = new Response("ok", "Deleted partial grades: " + idGrade);
        } catch (Exception e) {
            response = new Response("Error", "Internal error");
        }
        return response;
    }

    @RequestMapping(value = "/semifinalGradeId={idGrade}", method = RequestMethod.DELETE)
    public Serializable removeSemifinalGradeById(@PathVariable("idGrade") int idGrade,
                                                 @RequestHeader(name = "Authorization") String token) {
        Serializable response;
        //TODO: role = teacher and admin only
        try {
            gradesService.removeSemifinalGradeById(idGrade);
            response = new Response("ok", "Deleted semifinal grades: " + idGrade);
        } catch (Exception e) {
            response = new Response("Error", "Internal error");
        }
        return response;
    }

    @RequestMapping(value = "/finalGradeId={idGrade}", method = RequestMethod.DELETE)
    public Serializable removeFinalGradeById(@PathVariable("idGrade") int idGrade,
                                             @RequestHeader(name = "Authorization") String token) {
        Serializable response;
        //TODO: role = teacher and admin only
        try {
            gradesService.removeFinalGradeById(idGrade);
            response = new Response("ok", "Deleted final grades: " + idGrade);
        } catch (Exception e) {
            response = new Response("Error", "Internal error");
        }
        return response;
    }

    @RequestMapping(value = "/updatePartialGrade/{idGrade}", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Serializable updatePartialGrade(@PathVariable("idGrade") int idGrade,
                                           @RequestBody UpdatePartialGrade updatePartialGrade,
                                           @RequestHeader(value = "Authorization") String token) {
        Serializable response;
        //TODO: role = teacher and admin only
        //TODO 2: add checking are values from enum('1','2','3','4','5','6')
        try {
            gradesService.updatePartialGrade(idGrade, updatePartialGrade);
            response = new Response("Ok", "Updated");
        } catch (Exception e) {
            response = new Response("Error", e.getMessage());
        }
        return response;
    }

    @RequestMapping(value = "/updateSemifinalGrade/{idGrade}", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Serializable updateSemifinalGrade(@PathVariable("idGrade") int idGrade,
                                             @RequestBody UpdateFinalGrade updateFinalGrade,
                                             @RequestHeader(value = "Authorization") String token) {
        Serializable response;
        //TODO: role = teacher and admin only
        //TODO 2: add checking are values from enum('niedostateczny','dopuszczający','dostateczny','dobry','bardzo dobry','celujący')
        try {
            gradesService.updateSemifinalGrade(idGrade, updateFinalGrade);
            response = new Response("Ok", "Updated");
        } catch (Exception e) {
            response = new Response("Error", "Internal error");
        }
        return response;
    }

    @RequestMapping(value = "/updateFinalGrade/{idGrade}", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Serializable updateFinalGrade(@PathVariable("idGrade") int idGrade,
                                         @RequestBody UpdateFinalGrade updateFinalGrade,
                                         @RequestHeader(value = "Authorization") String token) {
        Serializable response;
        //TODO: role = teacher and admin only
        //TODO 2: add checking are values from enum('niedostateczny','dopuszczający','dostateczny','dobry','bardzo dobry','celujący')
        try {
            gradesService.updateFinalGrade(idGrade, updateFinalGrade);
            response = new Response("Ok", "Updated");
        } catch (Exception e) {
            response = new Response("Error", "Internal error");
        }
        return response;
    }

    @RequestMapping(value = "/newPartialGrade", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Serializable insertPartialGrade(@RequestBody InsertPartialGrade insertPartialGrade,
                                           @RequestHeader(name = "Authorization") String token) {
        Serializable response;
        //TODO: role = teacher and admin only
        try {
            gradesService.insertPartialGrade(insertPartialGrade);
            response = new Response("Ok", "Inserted partial grade");
        } catch (Exception e) {
            response = new Response("Error", e.getMessage());
        }
        return response;
    }

    @RequestMapping(value = "/newSemifinalGrade", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Serializable  insertSemifinalGrade(@RequestBody InsertFinalGrade insertFinalGrade,
                                              @RequestHeader(name = "Authorization") String token) {
        Serializable response;
        //TODO: role = teacher and admin only
        try {
            gradesService.insertSemifinalGrade(insertFinalGrade);
            response = new Response("Ok", "Inserted semifinal grade");
        } catch (Exception e) {
            response = new Response("Error", "Internal error");
        }
        return response;
    }

    @RequestMapping(value = "/newFinalGrade", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Serializable  insertFinalGrade(@RequestBody InsertFinalGrade insertFinalGrade,
                                          @RequestHeader(name = "Authorization") String token) {
        Serializable response;
        //TODO: role = teacher and admin only
        try {
            gradesService.insertFinalGrade(insertFinalGrade);
            response = new Response("Ok", "Inserted final grade");
        } catch (Exception e) {
            response = new Response("Error", "Internal error");
        }
        return response;
    }
}
