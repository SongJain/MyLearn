
class BinaryTreeNode {
	BinaryTreeNode(){
		left = right = null;
	}
	BinaryTreeNode(int el){
		element = el;
		left = right = null;
	}
	int element;
	BinaryTreeNode left,right;
}

public class BinaryTree {
	//根节点
	BinaryTreeNode root;
	//树的大小
	int size = 0;
	//构造方法
	BinaryTree(){
		root = null;
	}
	BinaryTree(BinaryTreeNode root){
		this.root = root;
	}
	
	//插入节点
	public void insertTree(int key, BinaryTreeNode root) {
		BinaryTreeNode p = root, pre = null;
		//找到插入节点位置
		while(p != null) {
			pre = p;
			if(key < p.element) {
				p = p.left;
			}else p = p.right;
		}
		//1、如果是空树，就相当与创建新节点
		if(root == null) {
			root = new BinaryTreeNode(key);
		}
		//2、插入
		else if(key < pre.element) {
			pre.left = new BinaryTreeNode(key); 
		}
		else  pre.right = new BinaryTreeNode(key); 
	}
	
	//查找节点
	public BinaryTreeNode searchTree(int key,BinaryTreeNode root) {
		BinaryTreeNode p = root;
		while(p != null) {
			//等于直接返回p
			if(key == p.element) {
				return p;
			}
			//大于p向右走，小于p向左走
			else if(key < p.element) {
				p = p.left;
			}else p = p.right;
		}
		return null;
	}
	
	//遍历
	//visit函数访问节点
	public void visit(BinaryTreeNode node) {
		System.out.println(node.element);
	}
	//前序遍历
	public void preorder(BinaryTreeNode node) {
		if(node != null) {
			visit(node);
			preorder(node.left);
			preorder(node.right);		
		}
	}
	//中序遍历
	public void inorder(BinaryTreeNode node) {
		if(node != null) {
			inorder(node.left);
			visit(node);
			inorder(node.right);				
		}
	}
	//后序遍历
	public void postorder(BinaryTreeNode node) {
		 if(node != null) {
			 postorder(node.left);
			 postorder(node.right);
			 visit(node);			
		 }
	}
	
	//删除节点
	//合并删除 1
	public void deleteByMerging(BinaryTreeNode node) {
		BinaryTreeNode p = node;
		if(node != null) {
			if(node.right == null) {		//不含右子树，则把左子树接到父节点
				node = node.left;
			}
			else if(node.left == null) {
				node = node.right;
			}
			else {
				p = node.left;
				while(p.right != null) {
					p = p.right;
				}
				p.right = node.right;
				p = node;
				node = node.left;
			}
		}
	}
	//合并删除 2
	public void findAndDeleteByMerging(int key) {
		BinaryTreeNode p = root, pre = null;
		//先查找到节点位置
		while(p != null) {
			if(p.element == key) {
				break;
			}
			pre = p;
			if(p.element < key) {
				p = p.right;
			}else p = p.left;
		}
		//在进行讨论删除
		if(p != null && p.element == key) {
			if(p == root) {
				deleteByMerging(root);
			}
			else if(pre.left == p) {
				deleteByMerging(pre.left);
			}
			else if(pre.right == p) {
				deleteByMerging(pre.right);
			}
		}
		else if(root != null) {
			System.out.println("key = "+key+"is not in the tree");
		}
	}
	
	//复制删除
	public void deleteByCopying(BinaryTreeNode node) {
		BinaryTreeNode pre, tmp;
		if(node.right == null) {
			node = node.left;
		}
		else if(node.left == null) {
			node = node.right;
		}
		else {
			tmp = node.left;
			pre = node;
			while(tmp.right != null) {
				pre = tmp;
				tmp = tmp.right;
			}
			node.element = tmp.element;
			if(pre == node) {
				pre.left = tmp.left;
			}
			else pre.right = tmp.right;
		}
	}
}
