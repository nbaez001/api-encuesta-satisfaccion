package pe.gob.reniec.service.impl;

import java.net.InetAddress;
import java.util.Date;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import pe.gob.reniec.common.security.UserToken;
import pe.gob.reniec.expose.request.SatisfactionSurveySaveRequest;
import pe.gob.reniec.expose.response.SatisfactionSurveySaveResponse;
import pe.gob.reniec.expose.response.header.OutputResponse;
import pe.gob.reniec.model.RespAppointmentSurvey;
import pe.gob.reniec.model.RespAppointmentSurveyCiud;
import pe.gob.reniec.repository.RespAppointmentSurveyCiudRepository;
import pe.gob.reniec.repository.RespAppointmentSurveyRepository;
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
public class SatisfactionSurveyServiceImpl implements SatisfactionSurveyService {

  private final RespAppointmentSurveyRepository respAppointmentSurveyRepository;

  private final RespAppointmentSurveyCiudRepository respAppointmentSurveyCiudRepository;
  
  @Override
  @Transactional(rollbackFor = Exception.class)
  public Mono<OutputResponse<SatisfactionSurveySaveResponse>> saveSatisfactionSurvey(
      SatisfactionSurveySaveRequest req) {
    String session = InetAddress.getLoopbackAddress().getHostAddress() + "|"
        + InetAddress.getLoopbackAddress().getHostName() + "|"
        + (UserToken.getInstance().getNuDni() != null ? UserToken.getInstance().getNuDni()
            : ConstantsUtil.USER_CIUDADANO);
    RespAppointmentSurvey sur = RespAppointmentSurvey.builder()
        .idEncuesta(req.getIdEncuesta())
        .idCita(req.getIdCita())
        .idSessionEncuesta(session)
        .flActivo(ConstantsUtil.FL_ACTIVO)
        .usCreaAudi(UserToken.getInstance().getNuDni() != null ? UserToken.getInstance().getNuDni()
            : ConstantsUtil.USER_CIUDADANO)
        .feCreaAudi(new Date())
        .build();
    respAppointmentSurveyRepository.save(sur);
    
    req.getRespuestas().forEach(valDet->{
      RespAppointmentSurveyCiud surCiud = RespAppointmentSurveyCiud.builder()
          .idEncuestaCitaResp(sur.getIdEncuestaCitaResp())
          .deComenteResp(valDet.getDeComenteResp())
          .idEncuestaOpcionResp(valDet.getIdEncuestaOpcionResp())
          .flActivo(ConstantsUtil.FL_ACTIVO)
          .usCreaAudi(UserToken.getInstance().getNuDni() != null ? UserToken.getInstance().getNuDni()
              : ConstantsUtil.USER_CIUDADANO)
          .feCreaAudi(new Date())
          .build();
      respAppointmentSurveyCiudRepository.save(surCiud);
    });
    
    OutputResponse<SatisfactionSurveySaveResponse> out = new OutputResponse<>();
    SatisfactionSurveySaveResponse res = SatisfactionSurveySaveResponse.builder()
        .idEncuestaCitaResp(sur.getIdEncuestaCitaResp())
        .build();
    
    out.getAuditResponse().setCoRespuesta(ConstantsUtil.CODIGO_EXITO);
    out.getAuditResponse().setDeRespuesta(ConstantsUtil.MENSAJE_EXITO);
    out.setResultado(res);
    
    return Mono.just(out);
  }
}
