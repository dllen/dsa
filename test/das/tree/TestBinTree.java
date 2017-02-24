package das.tree;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import das.list.Iterator;

public class TestBinTree {

	BinTreeNode nodeA, nodeB, nodeC, nodeD, nodeE, nodeF, nodeG, nodeH, nodeI, nodeJ, nodeK, nodeL, nodeM, nodeN, nodeO,
			nodeP;

	BinTreeLinkedList binTreeLinkedList;

	@Before
	public void init() {
		nodeA = new BinTreeNode("a");
		nodeB = new BinTreeNode("b");
		nodeC = new BinTreeNode("c");
		nodeD = new BinTreeNode("d");
		nodeE = new BinTreeNode("e");
		nodeF = new BinTreeNode("f");
		nodeG = new BinTreeNode("g");
		nodeH = new BinTreeNode("h");
		nodeI = new BinTreeNode("i");
		nodeJ = new BinTreeNode("j");
		nodeK = new BinTreeNode("k");
		nodeL = new BinTreeNode("l");
		nodeM = new BinTreeNode("m");
		nodeN = new BinTreeNode("n");
		nodeP = new BinTreeNode("p");

		nodeI.attachL(nodeD);
		nodeI.attachR(nodeL);
		nodeD.attachL(nodeB);
		nodeD.attachR(nodeH);
		nodeB.attachL(nodeA);
		nodeB.attachR(nodeC);
		nodeH.attachL(nodeF);
		nodeF.attachL(nodeE);
		nodeF.attachR(nodeG);

		nodeL.attachL(nodeK);
		nodeL.attachR(nodeN);
		nodeK.attachL(nodeJ);
		nodeN.attachL(nodeM);
		nodeN.attachR(nodeP);
		nodeP.attachL(nodeO);

		binTreeLinkedList = new BinTreeLinkedList(nodeI);
	}

	@Test
	public void testBinTree() {
		assertEquals(4, binTreeLinkedList.getHeight());
		assertEquals(0, binTreeLinkedList.getDepth());
		assertEquals(1, binTreeLinkedList.getRoot().getLChild().getDepth());
		assertEquals(15, binTreeLinkedList.getSize());
	}

	@Test
	public void testTraversal() {
		System.out.println("in order");
		Iterator iteratorInOrder = nodeI.elementsInorder();
		while (iteratorInOrder.hasNext()) {
			BinTreePosition treePosition = (BinTreePosition) iteratorInOrder.getNext();
			System.out.print(treePosition.getElem() + ",");
		}
		System.out.println();
		System.out.println("post order");
		Iterator iteratorPostOrder = nodeI.elementsPostorder();
		while (iteratorPostOrder.hasNext()) {
			BinTreePosition treePosition = (BinTreePosition) iteratorPostOrder.getNext();
			System.out.print(treePosition.getElem() + ",");
		}
		System.out.println();
		System.out.println("pre order");
		Iterator iteratorPreOrder = nodeI.elementsPreorder();
		while (iteratorPreOrder.hasNext()) {
			BinTreePosition treePosition = (BinTreePosition) iteratorPreOrder.getNext();
			System.out.print(treePosition.getElem() + ",");
		}
		System.out.println();
		System.out.println("level order");
		Iterator iteratorLevelOrder = nodeI.elementsLevelorder();
		while (iteratorLevelOrder.hasNext()) {
			BinTreePosition treePosition = (BinTreePosition) iteratorLevelOrder.getNext();
			System.out.print(treePosition.getElem() + ",");
		}
	}

}
