package pe.gob.reniec.configuration;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

/**
 * <b>Class</b>: MessageConfiguration <br/>
 * <b>Copyright</b>: 2023 RENIEC.<br/>
 *
 * @author 2023 RENIEC<br/>
 *         <u>Service Provider</u>: SOAINT PERU SAC. <br/>
 *         <u>Developed by</u>: Nerio Baez <br/>
 *         <u>Changes:</u><br/>
 *         <ul>
 *         <li>February 10, 2023 Creación de Clase.</li>
 *         </ul>
 */

@Configuration
public class MessageConfiguration {

  /**
   * <b>Class</b>: MessageSource <br/>
   * <b>Copyright</b>: 2023 RENIEC.<br/>
   *
   * @author 2023 RENIEC<br/>
   *         <u>Service Provider</u>: SOAINT PERU SAC. <br/>
   *         <u>Developed by</u>: Nerio Baez <br/>
   *         <u>Changes:</u><br/>
   *         <ul>
   *         <li>February 10, 2023 Creación de bean.</li>
   *         </ul>
   */

  @Bean
  public MessageSource messageSource() {
    ReloadableResourceBundleMessageSource messageSource = 
        new ReloadableResourceBundleMessageSource();
    messageSource.setBasenames("classpath:validation/messages");
    messageSource.setDefaultEncoding("UTF-8");
    return messageSource;
  }

  /**
   * <b>Class</b>: LocalValidatorFactoryBean <br/>
   * <b>Copyright</b>: 2023 RENIEC.<br/>
   *
   * @author 2023 RENIEC<br/>
   *         <u>Service Provider</u>: SOAINT PERU SAC. <br/>
   *         <u>Developed by</u>: Nerio Baez <br/>
   *         <u>Changes:</u><br/>
   *         <ul>
   *         <li>February 10, 2023 Creación de bean.</li>
   *         </ul>
   */

  @Bean
  public LocalValidatorFactoryBean validatorFactoryBean(MessageSource messageSource) {
    LocalValidatorFactoryBean localValidatorFactoryBean = new LocalValidatorFactoryBean();
    localValidatorFactoryBean.setValidationMessageSource(messageSource);
    return localValidatorFactoryBean;
  }
}
