package das.tree;

import org.junit.Before;
import org.junit.Test;

import das.tree.IteratorTree;
import das.tree.TreeLinkedList;

public class TestTree {

	TreeLinkedList root, nodeB, nodeC, nodeD, nodeE, nodeF, nodeG, nodeH, nodeI, nodeJ, nodeK, nodeL, nodeM, nodeN,
			nodeO, nodeP;

	@Before
	public void init() {
		root = new TreeLinkedList("a", null, nodeB, null);
		
		nodeB = new TreeLinkedList("b", root, null, null);
		nodeC = new TreeLinkedList("c", root, null, null);
		nodeD = new TreeLinkedList("d", root, null, null);

		nodeE = new TreeLinkedList("e", nodeB, null, null);
		nodeF = new TreeLinkedList("f", nodeB, null, null);
		
		nodeG = new TreeLinkedList("g", nodeD, null, null);
		nodeH = new TreeLinkedList("h", nodeD, null, null);
		nodeI = new TreeLinkedList("i", nodeD, null, null);

		nodeJ = new TreeLinkedList("j", nodeE, null, null);
		nodeK = new TreeLinkedList("k", nodeE, null, null);
		
		nodeL = new TreeLinkedList("l", nodeF, null, null);
		
		nodeM = new TreeLinkedList("m", nodeG, null, null);
		
		nodeN = new TreeLinkedList("n", nodeH, null, null);
		
		nodeO = new TreeLinkedList("o", nodeH, null, null);

		nodeP = new TreeLinkedList("p", nodeL, null, null);

		root.setFirstChild(nodeB);
		
		nodeB.setFirstChild(nodeE);
		nodeB.setNextSibling(nodeC);
		
		nodeC.setNextSibling(nodeD);
		
		nodeD.setFirstChild(nodeG);
		
		nodeE.setFirstChild(nodeJ);
		
		nodeE.setNextSibling(nodeF);
		
		nodeF.setFirstChild(nodeL);
		
		nodeL.setFirstChild(nodeP);
		
		nodeG.setFirstChild(nodeM);
		
		nodeG.setNextSibling(nodeH);
		
		nodeH.setFirstChild(nodeN);
		
		nodeH.setNextSibling(nodeI);

		nodeJ.setNextSibling(nodeK);
		
		
		nodeL.setFirstChild(nodeP);
		nodeN.setNextSibling(nodeO);

	}

	@Test
	public void testPreOrderTraversalTree() {
		IteratorTree iteratorTree = new IteratorTree();
		iteratorTree.elementsPreorderIterator(root);
		iteratorTree.initIterator();
		while (iteratorTree.hasNext()) {
			TreeLinkedList treeLinkedList = (TreeLinkedList) iteratorTree.getNext();
			System.out.print(treeLinkedList.getElem() + ",");
		}
		System.out.println();
		System.out.println("pre order ------------------------------");
	}

	@Test
	public void testPostOrderTraversalTree() {
		IteratorTree iteratorTree = new IteratorTree();
		iteratorTree.elementsPostorderIterator(root);
		iteratorTree.initIterator();
		while (iteratorTree.hasNext()) {
			TreeLinkedList treeLinkedList = (TreeLinkedList) iteratorTree.getNext();
			System.out.print(treeLinkedList.getElem() + ",");
		}
		System.out.println();
		System.out.println("post order------------------------------");
	}
	
	@Test
	public void testLevelTraversalTree() {
		IteratorTree iteratorTree = new IteratorTree();
		iteratorTree.levelTraversalIterator(root);
		iteratorTree.initIterator();
		while (iteratorTree.hasNext()) {
			TreeLinkedList treeLinkedList = (TreeLinkedList) iteratorTree.getNext();
			System.out.print(treeLinkedList.getElem() + ",");
		}
		System.out.println();
		System.out.println("level------------------------------");
	}

}
