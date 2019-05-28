package fm.compilescreencast.demo.ws.model.ws.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressTypeResponse {
	private String country;
	private String city;
	private String address1;
	private String address2;
	private String province;
	private Integer longitude;
	private Integer latitude;
}