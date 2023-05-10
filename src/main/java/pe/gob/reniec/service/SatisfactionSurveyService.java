package pe.gob.reniec.service;

import pe.gob.reniec.expose.request.SatisfactionSurveySaveRequest;
import pe.gob.reniec.expose.response.SatisfactionSurveySaveResponse;
import pe.gob.reniec.expose.response.header.OutputResponse;
import reactor.core.publisher.Mono;

/**
 * <b>Class</b>: SatisfactionSurveyService <br/>
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

public interface SatisfactionSurveyService {

  public Mono<OutputResponse<String>> saveSatisfactionSurvey(
      SatisfactionSurveySaveRequest req);
}
