package pe.gob.reniec.expose.response;

import java.io.Serializable;
import lombok.Builder;
import lombok.Data;

/**
 * <b>Class</b>: SatisfactionSurveySaveResponse <br/>
 * <b>Copyright</b>: 2023 RENIEC.<br/>
 *
 * @author 2023 RENIEC<br/>
 *         <u>Service Provider</u>: SOAINT PERU SAC. <br/>
 *         <u>Developed by</u>: Nerio Baez <br/>
 *         <u>Changes:</u><br/>
 *         <ul>
 *         <li>mayo 08, 2023 Creación de Clase.</li>
 *         </ul>
 */

@Data
@Builder
public class SatisfactionSurveySaveResponse implements Serializable {

  private static final long serialVersionUID = 1L;

  private Long idEncuestaCitaResp;
}
