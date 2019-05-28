package fm.compilescreencast.demo.ws.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ServerInfo {
	@Value("${server.port}")
	private String serverPort;

	@Value("${server.address}")
	private String serverAddress;

	public String getServerFullAddress() {
		String pattern = "http://%s:%s";
		return String.format(pattern, serverAddress, serverPort);
	}
}
