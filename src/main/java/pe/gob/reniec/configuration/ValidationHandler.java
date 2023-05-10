package pe.gob.reniec.configuration;

import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.support.WebExchangeBindException;

import pe.gob.reniec.expose.response.header.OutputResponse;
import pe.gob.reniec.util.ConstantsUtil;

/**
 * <b>Class</b>: ValidationHandler <br/>
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

@ControllerAdvice
public class ValidationHandler {

  /**
   * <b>Method</b>: handleException <br/>
   * <b>Copyright</b>: 2023 RENIEC.<br/>
   *
   * @author 2023 RENIEC<br/>
   *         <u>Service Provider</u>: SOAINT PERU SAC. <br/>
   *         <u>Developed by</u>: Nerio Baez <br/>
   *         <u>Changes:</u><br/>
   *         <ul>
   *         <li>Mayo 08, 2023 Creación de metodo</li>
   *         </ul>
   */

  @ExceptionHandler(WebExchangeBindException.class)
  public ResponseEntity<OutputResponse<?>> handleException(WebExchangeBindException e) {
    var errors = e.getBindingResult().getAllErrors().stream()
        .map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.toList());

    OutputResponse<?> out = new OutputResponse<>();
    out.getAuditResponse().setCoRespuesta(ConstantsUtil.CODIGO_ERROR_VALIDATION);
    out.getAuditResponse().setDeRespuesta(StringUtils.join(errors, ", "));
    return ResponseEntity.ok(out);
  }
}