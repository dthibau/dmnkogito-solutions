package org.formation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.formation.model.Conducteur;
import org.formation.model.TypeCarburant;
import org.formation.model.Vehicule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieRuntimeFactory;
import org.kie.dmn.api.core.DMNContext;
import org.kie.dmn.api.core.DMNDecisionResult;
import org.kie.dmn.api.core.DMNModel;
import org.kie.dmn.api.core.DMNResult;
import org.kie.dmn.api.core.DMNRuntime;
import org.kie.dmn.api.core.ast.DecisionNode;

public class AssuranceTest {

	ObjectMapper objectMapper = new ObjectMapper();
	DMNRuntime dmnRuntime;
	DMNModel dmnModel;
	DMNContext dmnContext;

	public static String MODEL="assurance";
	public static String NAMESPACE="https://kiegroup.org/dmn/_28077627-2BC9-4821-BFA9-9AAF77F3010C";

	public static String INPUT_NODE="Conducteur";

	@BeforeEach
	public void setUp() {
		KieServices ks = KieServices.Factory.get();
	       KieContainer kContainer = ks.getKieClasspathContainer();   
	       dmnRuntime = KieRuntimeFactory.of(kContainer.getKieBase()).get(DMNRuntime.class);

	       dmnModel = dmnRuntime.getModel(NAMESPACE, MODEL);
	       dmnContext = dmnRuntime.newContext();  
	}
	
	@Test
	public void test20() throws JsonProcessingException {
		Vehicule vehicule = new Vehicule(20000,4, 1, "2020-11-11");
		Conducteur conducteur = new Conducteur(20, 0, 0, vehicule);

		dmnContext.set(INPUT_NODE, conducteur);
		System.out.println("Données d'entrée : " + dmnContext.get(INPUT_NODE));
		// System.out.println(objectMapper.writeValueAsString(dmnContext.get(INPUT_NODE)));
        DMNResult dmnResult =
            dmnRuntime.evaluateAll(dmnModel, dmnContext);

		DMNDecisionResult result = dmnResult.getDecisionResultByName("Coefficient Vehicule");
		DMNContext resultContext = dmnResult.getContext();
		System.out.println(resultContext);


        for (DMNDecisionResult dr : dmnResult.getDecisionResults()) {  
            System.out.println("Conducteur: " + conducteur + ", " +
                    "Decision: '" + dr.getDecisionName() + "', " +
                    "Result: " + dr.getResult());
        }
        assertEquals(680d, ((BigDecimal)dmnResult.getDecisionResultByName("Final Price").getResult()).doubleValue(), 0.001d);
	}	
	
	@Test
	public void test23_5_10(){
		Vehicule vehicule = new Vehicule(100000,200, 2, "2010-10-10");
		Conducteur driver = new Conducteur(23, 5, 10, vehicule);
		
		dmnContext.set(INPUT_NODE, driver);
		dmnContext.get(INPUT_NODE);
        DMNResult dmnResult =
            dmnRuntime.evaluateAll(dmnModel, dmnContext);


        for (DMNDecisionResult dr : dmnResult.getDecisionResults()) {  
            System.out.println("Driver: " + driver + ", " +
                    "Decision: '" + dr.getDecisionName() + "', " +
                    "Result: " + dr.getResult());
        }

		assertEquals(1013.6d, ((BigDecimal)dmnResult.getDecisionResultByName("Final Price").getResult()).doubleValue(), 0.001d);
	}
}
