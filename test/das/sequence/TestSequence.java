package das.sequence;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import dsa.sequence.Sequence;
import dsa.sequence.SequenceDLNode;

public class TestSequence {

	Sequence sequence;

	@Before
	public void init() {
		sequence = new SequenceDLNode();
		sequence.insertFirst(0);
		sequence.insertLast(10);
		sequence.insertAtRank(1, 1);
		sequence.insertAtRank(2, 2);
		sequence.insertAtRank(3, 3);
		sequence.insertAtRank(4, 4);
	}

	@Test
	public void testRank2Position() {
		assertEquals(0, sequence.rank2Pos(0).getElem());
		assertEquals(1, sequence.rank2Pos(1).getElem());
		assertEquals(2, sequence.rank2Pos(2).getElem());
		assertEquals(4, sequence.rank2Pos(4).getElem());
		sequence.insertAtRank(0, 100);
		assertEquals(100, sequence.first().getElem());
		assertEquals(0, sequence.getAtRank(1));
	}

	@Test
	public void testPosition2Rank() {
		assertEquals(0, sequence.pos2Rank(sequence.first()));
		assertEquals(0, sequence.replaceAtRank(0, 100));
		assertEquals(100, sequence.first().getElem());
	}

}
