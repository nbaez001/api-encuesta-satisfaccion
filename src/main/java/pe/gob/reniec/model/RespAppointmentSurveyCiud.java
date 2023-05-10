package pe.gob.reniec.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

/**
 * <b>Class</b>: RespAppointmentSurveyCiud <br/>
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
@Builder
@Entity
@Table(name = "GCTD_ENCUESTA_RESPUESTA_CIUD")
public class RespAppointmentSurveyCiud {

  @Id
  @Column(name = "ID_ENC_RESP_CIUDADANO")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_GCSE_ERC")
  @SequenceGenerator(name = "SQ_GCSE_ERC", sequenceName = "GCSE_ENCUESTA_RESPUESTA_CIUD", allocationSize = 1)
  private Long idEncRespCiudadano;

  @Column(name = "ID_ENCUESTA_CITA_RESP")
  private Long idEncuestaCitaResp;

  @Column(name = "DE_COMENTE_RESP")
  private String deComenteResp;

  @Column(name = "ID_ENCUESTA_OPCION_RESP")
  private Long idEncuestaOpcionResp;

  @Column(name = "FL_ACTIVO")
  private Integer flActivo;

  @Column(name = "US_CREA_AUDI")
  private String usCreaAudi;

  @Column(name = "FE_CREA_AUDI")
  private Date feCreaAudi;

  @Column(name = "US_MODI_AUDI")
  private String usModiAudi;

  @Column(name = "FE_MODI_AUDI")
  private Date feModiAudi;
}
