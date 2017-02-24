package das.tree;

import org.junit.Before;
import org.junit.Test;

import das.list.Iterator;
import dsa.sequence.Sequence;
import dsa.sequence.SequenceDLNode;

public class TestComplBinTree {

	ComplBinTreeVector complBinTreeVector;


	@Before
	public void init() {

		Sequence sequence = new SequenceDLNode();
		sequence.insertLast("a");
		sequence.insertLast("b");
		sequence.insertLast("c");
		sequence.insertLast("d");
		sequence.insertLast("e");
		sequence.insertLast("f");
		sequence.insertLast("g");
		sequence.insertLast("h");
		sequence.insertLast("i");
		sequence.insertLast("j");
		sequence.insertLast("k");
		sequence.insertLast("l");
		sequence.insertLast("m");
		sequence.insertLast("n");
		sequence.insertLast("p");

		complBinTreeVector = new ComplBinTreeVector(sequence);

	}

	@Test
	public void testTraversal() {
		System.out.println("in order");
		Iterator iteratorInOrder = complBinTreeVector.getRoot().elementsInorder();
		while (iteratorInOrder.hasNext()) {
			ComplBinTreeNodeRank treePosition = (ComplBinTreeNodeRank) iteratorInOrder.getNext();
			System.out.print(treePosition.getElem() + ",");
		}
		
		System.out.println();
		System.out.println("post order");
		Iterator iteratorPostOrder = complBinTreeVector.getRoot().elementsPostorder();
		while (iteratorPostOrder.hasNext()) {
			ComplBinTreeNodeRank treePosition = (ComplBinTreeNodeRank) iteratorPostOrder.getNext();
			System.out.print(treePosition.getElem() + ",");
		}
		
		System.out.println();
		System.out.println("pre order");
		Iterator iteratorPreOrder = complBinTreeVector.getRoot().elementsPreorder();
		while (iteratorPreOrder.hasNext()) {
			ComplBinTreeNodeRank treePosition = (ComplBinTreeNodeRank) iteratorPreOrder.getNext();
			System.out.print(treePosition.getElem() + ",");
		}
		
		System.out.println();
		System.out.println("level order");
		Iterator iteratorLevelOrder = complBinTreeVector.getRoot().elementsLevelorder();
		while (iteratorLevelOrder.hasNext()) {
			ComplBinTreeNodeRank treePosition = (ComplBinTreeNodeRank) iteratorLevelOrder.getNext();
			System.out.print(treePosition.getElem() + ",");
		}
	}
	

}
