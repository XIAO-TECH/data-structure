package cn.edu.bupt.sdmda.ds.linearlist;

public class LinkedQueue<T> extends MyLinkedList<T> implements MyQueue<T> {
	public LinkedQueue() {
		// TODO Auto-generated constructor stub
		super();
	}

	@Override
	public void offer(T t) {
		super.insert(super.getSize(), t);
	}

	@Override
	public T poll() {
		T t=super.get(0);
		super.deleteAt(0);
		return t;
	}

	@Override
	public T getHead() {
		return super.get(0);
	}

}
