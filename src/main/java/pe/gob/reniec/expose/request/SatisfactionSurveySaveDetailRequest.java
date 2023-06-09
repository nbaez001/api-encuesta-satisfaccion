package pe.gob.reniec.expose.request;

import java.io.Serializable;
import lombok.Data;

/**
 * <b>Class</b>: SatisfactionSurveySaveDetailRequest <br/>
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
public class SatisfactionSurveySaveDetailRequest implements Serializable {
  private static final long serialVersionUID = 1L;

  private String deComenteResp;

  private Long idEncuestaOpcionResp;

}
