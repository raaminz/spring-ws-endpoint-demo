package fm.compilescreencast.demo.ws.model.ws.request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import lombok.Data;
@XmlRootElement
@XmlType(name = "",  propOrder = {"name" , "address"})
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class WarehouseSearchRequest {
	@XmlElement(required = true)
	private String name;
	@XmlElement(name = "address", required = true )
	private AddressTypeRequest address;
}
