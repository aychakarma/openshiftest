package tn.esprit.devops_project.services;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.devops_project.entities.Supplier;
import tn.esprit.devops_project.entities.SupplierCategory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class})
@ActiveProfiles("test")
class SupplierServiceImplTest {

    @Autowired
    private SupplierServiceImpl supplierService;

    @Test
    @DatabaseSetup("/data-set/supplier-data.xml")
    void addSupplier() {
        final Supplier supplier = new Supplier();
        supplier.setIdSupplier(2L);
        supplier.setCode("Supplier1Code");
        supplier.setLabel("Supplier1Label");
        supplier.setSupplierCategory(SupplierCategory.ORDINAIRE);

        this.supplierService.addSupplier(supplier);
    }


    @Test
    @DatabaseSetup("/data-set/supplier-data.xml")
    void updateSupplier() {
        Supplier supplier = this.supplierService.retrieveSupplier(2L);
        supplier.setLabel("New Supplier Label");
        this.supplierService.updateSupplier(supplier);
        assertEquals(this.supplierService.retrieveSupplier(2L).getLabel(), "New Supplier Label");
    }

  @Test
  @DatabaseSetup("/data-set/supplier-data.xml")
   void deleteSupplier() {
      Supplier supplier = this.supplierService.retrieveSupplier(2L);
      this.supplierService.deleteSupplier(supplier.getIdSupplier());
 }

    @Test
    @DatabaseSetup("/data-set/supplier-data.xml")
    void retrieveAllSuppliers() {
        final List<Supplier> allSuppliers = this.supplierService.retrieveAllSuppliers();
        assertEquals(allSuppliers.size(), 1);
    }

}
