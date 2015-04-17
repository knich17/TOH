package hanoiTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import hanoi.Disc;
import hanoi.GeneralException;
import hanoi.Tower;

import java.util.Stack;

import org.junit.Before;
import org.junit.Test;

public class TowerTests {
	public Tower t5;
	public Tower t0;

	@Before
	public void init() throws GeneralException {
		t5 = new Tower(5);
		t0 = new Tower(0);
	}

	@Test(expected = GeneralException.class)
	public void negInitialDisks() throws GeneralException {
		Tower t = new Tower(-1);
	}

	@Test(expected = GeneralException.class)
	public void takeOffTop_noDisks() throws GeneralException {
		Tower t = new Tower(0);
		t.takeOffTop();
	}

	@Test(expected = GeneralException.class)
	public void putOnTop_nullDisc() throws GeneralException {
		t0.putOnTop(null);
	}

	@Test(expected = GeneralException.class)
	public void putOnTop_LargerDisc() throws GeneralException {
		t0.putOnTop(new Disc(3));
		t0.putOnTop(new Disc(5));
	}

	@Test(expected = GeneralException.class)
	public void putOnTop_sameDisc() throws GeneralException {
		t0.putOnTop(new Disc(3));
		t0.putOnTop(new Disc(3));
	}

	@Test
	public void getTop() throws GeneralException {
		Tower t = new Tower(3);
		assertEquals("Top of tower is incorrect", t.takeOffTop().size(), 1);
	}

	@Test
	public void getTop2() throws GeneralException {
		assertEquals("Top of tower is incorrect", t5.takeOffTop().size(), 1);
	}

	@Test
	public void getTopTwice() throws GeneralException {
		t5.takeOffTop();
		t5.takeOffTop();
		assertEquals("Top of tower is incorrect", t5.takeOffTop().size(), 3);
	}

	@Test
	public void checkTop() throws GeneralException {
		assertEquals("Top of tower is incorrect", t5.takeOffTop().size(), 1);
	}

	@Test
	public void checkTop2() throws GeneralException {
		assertEquals("Top of tower is incorrect", t5.takeOffTop().size(), 1);
	}

	@Test
	public void putOnTop() throws GeneralException {
		t0.putOnTop(new Disc(3));
		t0.putOnTop(new Disc(2));
		assertTrue(t0.takeOffTop().size() == 2);
	}

	@Test
	public void putOnTop2() throws GeneralException {
		t0.putOnTop(new Disc(5));
		t0.putOnTop(new Disc(1));
		assertTrue(t0.takeOffTop().size() == 1);
	}

	@Test
	public void getDiscs() throws GeneralException {
		Stack<Disc> dStack = new Stack<Disc>();
		dStack.push(new Disc(5));
		dStack.push(new Disc(4));
		dStack.push(new Disc(3));
		dStack.push(new Disc(2));
		dStack.push(new Disc(1));
		assertEquals("", t5.getDiscs(), dStack);
	}
}
