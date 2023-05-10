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
 * <b>Class</b>: RespAppointmentSurvey <br/>
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
@Table(name = "GCTD_ENCUESTA_CITA_RESP")
public class RespAppointmentSurvey {

  @Id
  @Column(name = "ID_ENCUESTA_CITA_RESP")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_GCSE_ECR")
  @SequenceGenerator(name = "SQ_GCSE_ECR", sequenceName = "GCSE_ENCUESTA_CITA_RESP", allocationSize = 1)
  private Long idEncuestaCitaResp;

  @Column(name = "ID_ENCUESTA")
  private Long idEncuesta;

  @Column(name = "ID_CITA")
  private Long idCita;

  @Column(name = "ID_SESSION_ENCUESTA")
  private String idSessionEncuesta;

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
