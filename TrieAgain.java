package Trie;

class TrieNode{
	char data;
	TrieNode children[];
	boolean isTerminating;
	int childCount;
	
	public TrieNode(char data) {
		this.data=data;
		children=new TrieNode[26];
		 childCount=0;
		 isTerminating=false;
	}
}


public class TrieAgain {
	TrieNode root;
	public TrieAgain(){
		root=new TrieNode('\0');
	}
public boolean add(TrieNode root,String word) {
	
	if(word.length()==0) {
		if(!root.isTerminating) {
		root.isTerminating=true;
		return true;
		}
		else {
			return false;
		}
	}
	
	int childIndex=word.charAt(0)-'a';
	TrieNode child=root.children[childIndex];
	if(child==null) {
		child=new TrieNode(word.charAt(0));
		root.children[childIndex]=child;
		root.childCount++;
	
	}
//	root.childCount++;
	return add(root,word.substring(1));
	
}
public boolean add(String word) {
	return add(root,word);
}
public boolean search(TrieNode root, String word) {
	if(word.length()==0) {
		return root.isTerminating;
	}
	int childIndex=word.charAt(0)-'a';
	TrieNode child=root.children[childIndex];
	if(child==null) {
		return false;
	}
	return search(root,word.substring(1));
	
	
}
public boolean search(String word) {
	return search(root,word);
}
public void remove(String word) {
	remove(root,word);
}
public void remove(TrieNode root,String word) {
	if(word.length()==0) {
		root.isTerminating=false;
		return;
	}
	int childIndex=word.charAt(0)-'a';
	TrieNode child=root.children[childIndex];
	if(child==null) {
		return ;
	}
	remove(root,word.substring(1));
}
public static void main(String [] args) {
	TrieAgain t=new TrieAgain();
	System.out.println(t.add("cat"));
	t.remove("ca");
	System.out.print(t.search("cat"));
	
//	TrieAgain p=new TrieAgain();
//
//	System.out.println(p.add("cattipiler"));
//	System.out.println(t.add("coat"));


}










}
