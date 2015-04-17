package hanoiTests;

import static org.junit.Assert.assertEquals;
import hanoi.Disc;
import hanoi.GeneralException;

import org.junit.Test;

public class DiscTests {

	@Test(expected = GeneralException.class)
	public void negSize() throws GeneralException {
		Disc d = new Disc(-1);
	}

	@Test(expected = GeneralException.class)
	public void sizeZero() throws GeneralException {
		Disc d = new Disc(0);
	}

	@Test
	public void getSize() throws GeneralException {
		Disc d = new Disc(3);
		assertEquals("Disc size incorrect", 3, d.size());
	}
}
