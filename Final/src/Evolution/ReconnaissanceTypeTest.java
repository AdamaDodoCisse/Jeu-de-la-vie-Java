package Evolution;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import code_du_jeu.Grille;
public class ReconnaissanceTypeTest {
protected ReconnaissanceType reconnaissance;
	@Before
	public void setUp() throws Exception {
		reconnaissance=new ReconnaissanceType(1, 10, "html/jeu1.LIF", new Grille()
		);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testReconnaissanceType() {
		assertTrue(reconnaissance.isOscillation());
		assertTrue(reconnaissance.isVaisceau());
		}

	@Test
	public void testGetPeriodeFinal() {
		assertTrue(reconnaissance.getPeriodeFinal()==2);
	}

	@Test
	public void testGetTailleQueue() {
		assertTrue(reconnaissance.getTailleQueue()==8);
	}

	@Test
	public void testIsOscillation() {
	assertTrue(reconnaissance.isOscillation());
	}

	@Test
	public void testIsStabilite() {
	assertTrue(reconnaissance.isStabilite());
	}

	@Test
	public void testIsMort() {
	assertTrue(reconnaissance.isMort());
	}

	@Test
	public void testIsVaisceau() {
		assertTrue(reconnaissance.isVaisceau());
	}

	@Test
	public void testIsInconnu() {
	assertTrue(reconnaissance.isInconnu());
	}

}
