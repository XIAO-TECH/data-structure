package cn.edu.bupt.sdmda.ds.hash;

import java.util.LinkedList;

public class MyHash<K, V> implements IHashTable<K, V> {

	private LinkedList<Node>[] _tables;
	private final int INIT_CAP = 1 << 4;
	// capacity of this hash table
	private int _capacity;
	// number of stored elements in the hash table
	private int _eleNum;
	// a factor less than 1
	// if _eleNum >= factor*_capasity, we should resize
	private double _factor;

	public MyHash() {
		// init _table

		_capacity = INIT_CAP;
		_eleNum = 0;
		_factor = 0.75f;
		_tables = new LinkedList[_capacity];
		for (int i = 0; i < _capacity; i++) {
			_tables[i] = new LinkedList<Node>();
		}
	}

	@Override
	public void put(K key, V val) {
		// get index of key
		// construct a node of K,V
		// find a linkedList in _tables
		// find if a node with the same key is contained in the linkedList
		// if contained, replace it with new value
		// if not, insert it to the linkedlist
		// REMEMBER the element number is increased
		// REMEMBER to check if resize is necessary
		Node node = new Node(key, val);
		LinkedList<Node> link = _tables[getIdx(key)];
		boolean b = false;
		for (Node node2 : link) {
			if (node2.equals(node)) {
				node2._val = val;
				b = true;
				break;
			}
		}
		if (!b) {
			link.add(node);
			_eleNum += 1;
		}

		if (_eleNum >= _factor * _capacity) {
			resize();
		}

	}

	public void resize() {
		int oldcap = _capacity;
		_capacity *= 2;
		LinkedList<Node>[] oldc = _tables;
		LinkedList<Node>[] newt = new LinkedList[_capacity];
		_tables = newt;
		for (int i = 0; i < _capacity; i++) {
			newt[i] = new LinkedList<Node>();
		}
		for (int i = 0; i < oldcap; i++) {
			LinkedList<Node> list = oldc[i];
			for (Node node : list) {
				put(node._key, node._val);
			}
		}

	}

	@Override
	public V get(K key) {
		// get the value of key
		// if not found, return null
		int pos = getIdx(key);
		LinkedList<Node> list = _tables[pos];
		for (Node node : list) {
			if (node._key.equals(key)) {
				return node._val;
			}
		}

		return null;
	}

	@Override
	public V remove(K key) {
		int pos = getIdx(key);
		LinkedList<Node> list = _tables[pos];
		for (Node node : list) {
			if (node._key.equals(key)) {
				V val = node._val;
				list.remove(node);
				return val;
			}
		}
		_eleNum--;
		return null;
	}

	@Override
	public int getIdx(K key) {
		// design a method to get index from key
		int h = key.hashCode();
		int hash = h ^ (h >>> 16);
		int index = hash & (_capacity - 1);
		// System.out.println(key + ":" + index);

		return index;
	}

	// Node represent a K,V pair
	class Node {
		K _key;
		V _val;

		Node(K key, V val) {
			_key = key;
			_val = val;
		}

		// override this method to make
		// node1.equals(node2) return true
		// when node1.key == node2._key
		// node1.val and node2.val is NOT CONSIDERATE HERE!
		public boolean equals(Node obj) {
			if (obj._key.equals(this._key)) {
				return true;
			}
			return false;
		}
	}
}
