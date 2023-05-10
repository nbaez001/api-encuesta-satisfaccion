package pe.gob.reniec.expose.request;

import java.io.Serializable;
import java.util.List;
import lombok.Data;

/**
 * <b>Class</b>: SatisfactionSurveySaveRequest <br/>
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

@Data
public class SatisfactionSurveySaveRequest implements Serializable {
  private static final long serialVersionUID = 1L;

  private Long idEncuesta;
  
  private Long idCita;

  private List<SatisfactionSurveySaveDetailRequest> respuestas;

}
