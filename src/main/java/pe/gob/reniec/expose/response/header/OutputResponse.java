package pe.gob.reniec.expose.response.header;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <b>Class</b>: OutputResponse <br/>
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

@Getter
@Setter
@ToString
@AllArgsConstructor
public class OutputResponse<T> implements Serializable {
  private static final long serialVersionUID = 1L;

  public OutputResponse() {
    this.auditResponse = new AuditResponse();
  }

  private AuditResponse auditResponse;
  private T resultado;

}
