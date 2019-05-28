package fm.compilescreencast.demo.ws.model.ws.response;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@XmlRootElement
@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WarehouseSearchResponse {
    @XmlElementWrapper(name = "warehouses")
    @XmlElement(name = "warehouse")
	private List<WarehouseTypeResponse> warehouses = new ArrayList<>();
}




