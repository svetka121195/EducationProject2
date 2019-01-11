package app.security.config;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;


/* регистрирует основной фильтр спринга, который отвечает за выполнение цепочки всех пользовательских фильтров**/
public class SecurityInitializer extends AbstractSecurityWebApplicationInitializer {
	//Registers the DelegatingFilterProxy to use the springSecurityFilterChain before any other registered Filter
}
