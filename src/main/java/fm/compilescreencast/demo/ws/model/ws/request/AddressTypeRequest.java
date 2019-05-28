package fm.compilescreencast.demo.ws.model.ws.request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import lombok.Data;

@XmlType(propOrder = {} )
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class AddressTypeRequest {
	@XmlElement(required = true)
	private String country;
	@XmlElement(required = true)
	private String city;
	private String address1;
	private String address2;
}
