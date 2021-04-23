package cn.edu.bupt.sdmda.ds.linearlist;

public class LinkedStack<T> extends MyLinkedList<T>  implements MyStack<T>{

	public LinkedStack(){
		super();
	}
	
	@Override
	public T pop() {
		int i=super.getSize();
		T re=super.get(i-1);
		super.deleteAt(i-1);
		return re;
	}

	@Override
	public void push(T t) {
		int i=super.getSize();
		super.insert(i, t);
	}

	@Override
	public T getTop(){
		return super.get(super.getSize()-1);
	}

	@Override
	public void insert(int i, T t) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public void delete(T t) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public T deleteAt(int i) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public T get(int i) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public void set(int i, T t) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public int find(T t) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public LinearList<T> sort() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}



}
