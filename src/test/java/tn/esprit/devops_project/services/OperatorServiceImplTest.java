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
import tn.esprit.devops_project.entities.Operator;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
@TestExecutionListeners({
        DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class
})
@ActiveProfiles("test")
public class OperatorServiceImplTest {

    @Autowired
    private OperatorServiceImpl operatorService;

    @Test
    @DatabaseSetup("/data-set/operator-data.xml")
    void retrieveAllOperators() {
        List<Operator> operatorList = operatorService.retrieveAllOperators();

    }

    @Test
    @DatabaseSetup("/data-set/operator-data.xml")
    void addOperator() {
        Operator operator = new Operator();
        // Initialisez les propriétés de l'opérateur pour les besoins du test

        Operator addedOperator = operatorService.addOperator(operator);

    }

    @Test
    @DatabaseSetup("/data-set/operator-data.xml")
    void retrieveOperator() {
        Long operatorId = 2L;
        Operator operator = operatorService.retrieveOperator(operatorId);

        // Ajoutez des assertions pour vérifier les détails de l'opérateur récupéré
    }

    @Test
    @DatabaseSetup("/data-set/operator-data.xml")
    void updateOperator() {
        Long operatorId = 2L; // Remplacez par un ID existant dans vos données de test
        Operator operator = operatorService.retrieveOperator(operatorId);

        // Modifiez les propriétés de l'opérateur pour les besoins du test

        Operator updatedOperator = operatorService.updateOperator(operator);

        // Vérifiez que l'opérateur a été correctement mis à jour en vérifiant ses propriétés modifiées
    }

    @Test
    @DatabaseSetup("/data-set/operator-data.xml")
    void deleteOperator() {
        Long operatorId = 2L; // Remplacez par un ID existant dans vos données de test

        // Tentez de supprimer l'opérateur
        operatorService.deleteOperator(operatorId);

        // Essayez de récupérer l'opérateur
        try {
            operatorService.retrieveOperator(operatorId);
        } catch (NullPointerException e) {
            // L'exception a été levée, ce qui est attendu
            return;
        }

        fail("L'exception NullPointerException n'a pas été levée lors de la suppression de l'opérateur.");
    }
}
