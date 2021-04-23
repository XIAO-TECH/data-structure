package cn.edu.bupt.sdmda.ds.linearlist;

public class MyLinkedList<T> implements LinearList<T>{

	class Node{
		public T _ele;
		public Node _next;
		public Node(){
			init(null, null);
		}
		public Node(T e){
			init(e, null);
		}
		public Node(T e, Node n){
			init(e, n);
		}
		private void init(T e, Node n){
			_ele = e;
			_next = n;
		}
	}

	Node _head;
	int _size;

	public MyLinkedList(int s, T init) {
		// TODO Auto-generated constructor stub
		init(s,init);
	}

	public MyLinkedList() {
		// TODO Auto-generated constructor stub
		init(0, null);
	}

	@Override
	public void init(int s, T init) {
		// TODO Auto-generated method stub
		_size=s;
		_head=new Node();
		Node _cur= _head;
		Node _tmp;
		for (int i = 0; i < s; ++i) {
			_tmp= new Node(init);
			_cur._next=_tmp;
			_cur=_tmp;
		}
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if (_size==0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return _size;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		_size = 0;
		Node cur = _head ;
		Node next = cur . _next ;
		while ( next != null ){
			cur . _next = null ;
			cur = next ;
			next = next . _next ;
		}
	}

	@Override
	public void insert(int i, T t) {
		// i=_size is OK!
		// TODO Auto-generated method stub
		if (!checkReadableRange(i)) {
			throw new IndexOutOfBoundsException();
		}
		_size++;
		Node cur = getNodeBefore (i) ;
		Node tmp = new Node (t) ;
		tmp._next = cur._next ;
		cur._next = tmp ;
	}
		
	@Override
	public void delete(T t) {
		// TODO Auto-generated method stub
		int i=find(t);
		deleteAt(i);
	}

	@Override
	public T deleteAt(int i) {
		// TODO Auto-generated method stub
		Node cur=getNodeBefore(i);
		_size--;
		T ret =cur._next._ele;
		Node tmp =cur._next._next;
		cur._next._next=null;
		cur._next=tmp;
		return ret;
	}

	@Override
	public T get(int i) {
		// TODO Auto-generated method stub
		Node cur=_head._next;
		for(int j=0;j<i;j++) {
			cur=cur._next;
		}
		return cur._ele;
	}

	@Override
	public void set(int i, T t) {
		// TODO Auto-generated method stub
		Node cur=_head._next;
		for(int j=0;j<i;j++) {
			cur=cur._next;
		}
		cur._ele=t;
	}

	@Override
	public int find(T t) {
		// TODO Auto-generated method stub
		Node cur = _head;
		Node tmp = cur._next;
		for(int i=1;i<_size;i++) {
			cur=tmp;
			if (cur._ele.equals(t)) {
				return i;
			}
			tmp=tmp._next;
		}
		return -1;
	}

	@Override
	public LinearList<T> sort() {
		// TODO Auto-generated method stub
		return null;
	}

	private Node getNodeBefore(int i){
		// assume i is a valid value
		Node cur=_head;
		for(int j=0;j<i;j++) {
			cur=cur._next;
		}
		return cur;
	}

	private boolean checkReadableRange(int i){
		if (i<=_size) {
			return true;
		} else {
			return false;
		}
	}

	private boolean checkWritableRange(int i){
	
		return true;
	}


}
