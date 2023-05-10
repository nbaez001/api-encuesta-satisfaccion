package pe.gob.reniec.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pe.gob.reniec.expose.request.SatisfactionSurveySaveRequest;
import pe.gob.reniec.expose.response.SatisfactionSurveySaveResponse;
import pe.gob.reniec.expose.response.header.OutputResponse;
import pe.gob.reniec.service.SatisfactionSurveyService;
import reactor.core.publisher.Mono;

/**
 * <b>Class</b>: SatisfactionSurveyController <br/>
 * <b>Copyright</b>: 2023 RENIEC.<br/>
 *
 * @author 2023 RENIEC<br/>
 *         <u>Service Provider</u>: SOAINT PERU SAC. <br/>
 *         <u>Developed by</u>: Nerio Baez <br/>
 *         <u>Changes:</u><br/>
 *         <ul>
 *         <li>Mayo 08, 2023 Creación de Clase.</li>
 *         </ul>
 */

@RestController
@AllArgsConstructor
@RequestMapping("/encuesta-satisfaccion")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Slf4j
public class SatisfactionSurveyController {

  private final SatisfactionSurveyService satisfactionSurveyService;

  @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public Mono<OutputResponse<String>> saveSatisfactionSurvey(
      @RequestBody SatisfactionSurveySaveRequest req) {
    log.info(
        "SatisfactionSurveyController [saveSatisfactionSurvey][START][" + req.toString() + "]");
    return satisfactionSurveyService.saveSatisfactionSurvey(req)
        .doOnNext(p -> log.info("SatisfactionSurveyController [saveSatisfactionSurvey][END]"));
  }
}
