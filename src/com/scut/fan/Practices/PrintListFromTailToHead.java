package com.scut.fan.Practices;
import java.util.ArrayList;
import java.util.Stack;

/**
 ��Ŀ����

����һ��������β��ͷ��ӡ����ÿ���ڵ��ֵ�� 
��������:
����Ϊ����ı�ͷ

�������:
���Ϊ��Ҫ��ӡ�ġ��������ı�ͷ
 * @author FAN
 *
 */
public class PrintListFromTailToHead {
	public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		
		Stack<Integer> stacknode=new Stack<Integer>();
		while(listNode!=null){
			stacknode.push(listNode.val);
			listNode=listNode.next;
		}
		
		ArrayList<Integer> printlist=new ArrayList<Integer>();
		while(!stacknode.isEmpty()){
			printlist.add(stacknode.pop());
			
		}
		
		return printlist;
		
	}
	
	public static void main(String[] args) {
		//��������
		ListNode listnode=new ListNode(0);
		ListNode temp=listnode;
		for(int i=1;i<180;i++){
			ListNode temp2=new ListNode(i);
			temp.setNext(temp2);
			temp=temp2;
		}
		//����ʵ��
		ArrayList<Integer> ite=printListFromTailToHead(listnode);
		for(int i=0;i<ite.size();i++){
			System.out.println(ite.get(i));
		}
	}
}

/**
 * �Զ���������
 * @author FAN
 *
 */
class ListNode{
	int val;
	ListNode next;
	ListNode(int val) {
		this.val = val;
	}
	public int getVal() {
		return val;
	}
	public void setVal(int val) {
		this.val = val;
	}
	public ListNode getNext() {
		return next;
	}
	public void setNext(ListNode next) {
		this.next = next;
	}
	
}
