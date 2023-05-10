package pe.gob.reniec.service.impl;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;

import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pe.gob.reniec.common.security.UserToken;
import pe.gob.reniec.expose.request.SatisfactionSurveySaveRequest;
import pe.gob.reniec.expose.response.SatisfactionSurveySaveResponse;
import pe.gob.reniec.expose.response.header.OutputResponse;
import pe.gob.reniec.service.SatisfactionSurveyService;
import pe.gob.reniec.util.ConstantsUtil;
import reactor.core.publisher.Mono;

/**
 * <b>Class</b>: SatisfactionSurveyServiceImpl <br/>
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

@Service
@AllArgsConstructor
@Slf4j
public class SatisfactionSurveyServiceImpl implements SatisfactionSurveyService {

  @Override
  public Mono<OutputResponse<String>> saveSatisfactionSurvey(
      SatisfactionSurveySaveRequest req) {
    String session;
    try {
      session = InetAddress.getLocalHost().getHostAddress() + "|"
          + InetAddress.getLocalHost().getHostName() + "|"
          + (UserToken.getInstance().getNuDni() != null ? UserToken.getInstance().getNuDni()
              : ConstantsUtil.USER_CIUDADANO);
    } catch (UnknownHostException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      session="";
    }
    log.info("SESSION");
    log.info(session);
    
    OutputResponse<String> out = new OutputResponse<>();
    
    out.getAuditResponse().setCoRespuesta(ConstantsUtil.CODIGO_EXITO);
    out.getAuditResponse().setDeRespuesta(ConstantsUtil.MENSAJE_EXITO);
    out.setResultado(session);
    
    return Mono.just(out);
  }
}
