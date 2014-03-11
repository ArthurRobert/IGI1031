package testUnitaire;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import model.Chevalier;
import model.ChevalierJoueur;

import org.junit.Test;

public class TestChevalierJoueur {

	@Test
	public void testChevalierJoueur() {
		Chevalier joueur1 = new ChevalierJoueur("Arthur");
		assertNotNull(joueur1);
//        assertThat(joueur1, instanceOf(Chevalier.class));
	}

}
