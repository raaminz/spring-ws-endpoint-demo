package fm.compilescreencast.demo.ws.service.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import fm.compilescreencast.demo.ws.model.ws.request.WarehouseSearchRequest;
import fm.compilescreencast.demo.ws.model.ws.response.WarehouseSearchResponse;
import fm.compilescreencast.demo.ws.model.ws.response.WarehouseTypeResponse;
import fm.compilescreencast.demo.ws.service.WarehouseWsService;

@Endpoint
public class WarehouseEndpoint {
	private WarehouseWsService warehouseWsService;
	
	@Autowired
	public WarehouseEndpoint(WarehouseWsService warehouseWsService) {
		this.warehouseWsService = warehouseWsService;
	}
	@PayloadRoot(namespace = "http://www.compilepodcast.fm/schemas" , localPart = "warehouseSearchRequest")
	@ResponsePayload
	public WarehouseSearchResponse searchWarehouse(@RequestPayload WarehouseSearchRequest request) {
		return warehouseWsService.searchWarehouse(request);
	}
}
