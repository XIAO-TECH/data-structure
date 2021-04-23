package cn.edu.bupt.sdmda.ds.linearlist;

import java.util.Queue;

public class SeqQueue<T> extends SeqList<T> implements MyQueue<T>{

	public SeqQueue() {
		// TODO Auto-generated constructor stub
		super();
	}

	@Override
	public void offer(T t) {
		// TODO Auto-generated method stub
		super.insert(super.getSize(), t);
	}

	@Override
	public T poll() {
		// TODO Auto-generated method stub
		T t=super.get(0);
		super.deleteAt(0);
		return t;
	}

	@Override
	public T getHead() {
		// TODO Auto-generated method stub
		
    return super.get(0);
	}

}
