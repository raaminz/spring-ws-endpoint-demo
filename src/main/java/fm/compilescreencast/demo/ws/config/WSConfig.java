package fm.compilescreencast.demo.ws.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@Configuration
@EnableWs
public class WSConfig {

	private final ServerInfo serverInfo;
	private static final String WS_PATH = "/ws";

	@Autowired
	public WSConfig(ServerInfo serverInfo) {
		this.serverInfo = serverInfo;
	}

	@Bean
	public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(
			ApplicationContext applicationContext) {
		MessageDispatcherServlet servlet = new MessageDispatcherServlet();
		servlet.setApplicationContext(applicationContext);
		servlet.setTransformWsdlLocations(true);
		return new ServletRegistrationBean<>(servlet, WS_PATH + "/*");
	}

	@Bean(name = "warehouse")
	public DefaultWsdl11Definition warehouseWsdl(XsdSchema warehousrSchema) {
		DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
		definition.setPortTypeName("warehouseAction");
		definition.setTargetNamespace("http://www.compilepodcast.fm/schemas");
		definition.setSchema(warehousrSchema);
		definition.setLocationUri(serverInfo.getServerFullAddress() + WS_PATH);
		return definition;
	}

	@Bean
	public XsdSchema warehousrSchema() {
		return new SimpleXsdSchema(new ClassPathResource("static/xsd/warehouse_schema.xsd"));
	}
}
