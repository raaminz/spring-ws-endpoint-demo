package fm.compilescreencast.demo.ws.model.ws.response;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
public class WarehouseTypeResponse{
	private String name;
	private Date createdDate;
	@XmlElement(name = "address")
	private AddressTypeResponse address;
}