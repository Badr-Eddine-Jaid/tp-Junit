package ticketmachine;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

class TicketMachineTest {
	private static final int PRICE = 50; // Une constante
	private TicketMachine machine; // l'objet à tester

	@BeforeEach
	public void setUp() {
		machine = new TicketMachine(PRICE); // On initialise l'objet à tester
	}

	@Test
	// On vérifie que le prix affiché correspond au paramètre passé lors de
	// l'initialisation
	// S1 : le prix affiché correspond à l’initialisation.
	void priceIsCorrectlyInitialized() {
		// Paramètres : valeur attendue, valeur effective, message si erreur
		assertEquals(PRICE, machine.getPrice(), "Initialisation incorrecte du prix");
	}

	@Test
	// S2 : la balance change quand on insère de l’argent
	void insertMoneyChangesBalance() {
		// GIVEN : une machine vierge (initialisée dans @BeforeEach)
		// WHEN On insère de l'argent
		machine.insertMoney(10);
		machine.insertMoney(20);
		// THEN La balance est mise à jour, les montants sont correctement additionnés
		assertEquals(10 + 20, machine.getBalance(), "La balance n'est pas correctement mise à jour");
	}

	@Test
	void s3() {
		machine.insertMoney(49);
		assertEquals(false, machine.printTicket());
	}

	@Test
	void s4() {
		machine.insertMoney(50);
		assertEquals(true, machine.printTicket());
	}

	@Test
	void s5() {
		machine.insertMoney(70);
		machine.printTicket();
		assertEquals(20, machine.getBalance());
	}

	@Test
	void s6(){
		machine.insertMoney(70);
		machine.printTicket();
		assertEquals(50, machine.getTotal());
	}

	@Test
	void s7(){
		machine.insertMoney(70);
		assertEquals(70, machine.refund());
	}

	@Test
	public void s8(){
		machine.insertMoney(70);
		machine.refund();
		assertEquals(0, machine.getBalance());
	}

	@Test
	public void s9(){
		assertThrows(IllegalArgumentException.class, () -> machine.insertMoney(-10));
	}

	@Test
	void s10(){
		assertThrows(IllegalArgumentException.class, () -> new TicketMachine(-10));
	}
	
	


}
