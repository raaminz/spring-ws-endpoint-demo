package fm.compilescreencast.demo.ws.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fm.compilescreencast.demo.ws.model.entity.Address;
import fm.compilescreencast.demo.ws.model.entity.Warehouse;
import fm.compilescreencast.demo.ws.model.ws.request.WarehouseSearchRequest;
import fm.compilescreencast.demo.ws.model.ws.response.AddressTypeResponse;
import fm.compilescreencast.demo.ws.model.ws.response.WarehouseSearchResponse;
import fm.compilescreencast.demo.ws.model.ws.response.WarehouseTypeResponse;
import fm.compilescreencast.demo.ws.service.repo.WarehouseRepository;


@Service
public class WarehouseWsService {
	private final WarehouseRepository warehouseRepository;

	@Autowired
	public WarehouseWsService(WarehouseRepository warehouseRepository) {
		this.warehouseRepository = warehouseRepository;
	}

	@Transactional(readOnly = true)
	public WarehouseSearchResponse searchWarehouse(WarehouseSearchRequest request) {
		Address address = Address.builder().address1(request.getAddress().getAddress1())
				.address2(request.getAddress().getAddress2()).city(request.getAddress().getCity())
				.countryId(request.getAddress().getCountry()).build();
		Warehouse example = Warehouse.builder().name(request.getName()).address(address).build();
		List<WarehouseTypeResponse> warehouseTypeResponse = StreamSupport
				.stream(warehouseRepository.findAll(Example.of(example)).spliterator(), false)
				.map(warehouse -> WarehouseTypeResponse.builder().name(warehouse.getName())
						.createdDate(warehouse.getCreationDate())
						.address(AddressTypeResponse.builder().address1(warehouse.getAddress().getAddress1())
								.address2(warehouse.getAddress().getAddress2()).city(warehouse.getAddress().getCity())
								.country(warehouse.getAddress().getCountryId())
								.province(warehouse.getAddress().getStateProvince())
								.longitude(warehouse.getAddress().getLongitude())
								.latitude(warehouse.getAddress().getLatitude()).build())
						.build())
				.collect(Collectors.toList());
		return new WarehouseSearchResponse(warehouseTypeResponse);
	}

}
