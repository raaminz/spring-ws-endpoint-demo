package fm.compilescreencast.demo.ws.service.repo;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

import fm.compilescreencast.demo.ws.model.entity.Warehouse;


@Repository
public interface WarehouseRepository
		extends PagingAndSortingRepository<Warehouse, Long>, QueryByExampleExecutor<Warehouse> {

}
