package pe.gob.reniec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.gob.reniec.model.RespAppointmentSurveyCiud;

/**
 * <b>Class</b>: RespAppointmentSurveyCiudRepository <br/>
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

public interface RespAppointmentSurveyCiudRepository
    extends JpaRepository<RespAppointmentSurveyCiud, Long> {

}
