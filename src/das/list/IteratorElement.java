package das.list;

import das.linkedlist.Position;

public class IteratorElement implements Iterator {

	private List list;

	private Position nextPosition;

	public IteratorElement() {

	}

	public IteratorElement(List l) {
		list = l;
		if (l.isEmpty())
			nextPosition = null;
		else
			nextPosition = list.first();
	}

	@Override
	public boolean hasNext() {
		return null != nextPosition;
	}

	@Override
	public Object getNext() {
		if (!hasNext())
			throw new ExceptionNoSuchElement("error");
		Position position = nextPosition;
		if (position == list.last())
			nextPosition = null;
		else
			nextPosition = list.getNext(position);
		return position.getElem();
	}

}
