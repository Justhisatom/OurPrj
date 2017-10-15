package stackTest;

import java.util.Scanner;

class Stack 
{
	//상태 정보 : 변수
	//일반적으로 접근지시자는 
	private int[] stack;
	private int top;
	//일반적으로 초기화는 생성잦에서 해주는게 일반적
	//동작 정보 : 메소드
	
	//생성자: constructor (초기화 메소드 , 리턴 타입이 없음(젤 중요))
	public Stack(int size) 
	{
		//왼쪽이 데이터 영역, 오른쪽이 heap 영역
		stack = new int[size];
		top = -1;
	}
	
	public void push (int value) 
	{
		if( isFull() == true ) 
		{
			printError("Stack is full \\");
		} else 
		{
			//넣기.. 
			{
				stack[++top] = value;
			}
		}
	}
	
	//예외 처리
	private void printError(String msg)
	{
		System.out.println(msg);
	}
	
	public boolean isFull()
	{
		if(top >= (stack.length -1 )) 
		{
			return true;
		}
		//else 에 넣지 않아도 full인 상태에서는 
		return false;
	}
	
	public boolean isEmpty()
	{
		if(top == -1) 
		{
			return true;
		}
		return false;
	}
	
	public void pop () 
	{
		if(isEmpty() == true) 
		{
			printError("stack is Empty |||");
		} else 
		{
			top --;
		}
	}
	//전부 다 출력해 = dump
	public void dump () 
	{
		System.out.println("=== stack ===");
		for (int i=top; i>=0; i--) 
		{
			System.out.println(stack[i]);
		} 
	}
	
}


public class StackTest 
{

	public static void main(String[] args) {

		System.out.println("하하");
		Scanner scan = new Scanner(System.in);
		int stackSize;
		
		System.out.println("Insert Stack Size!");
		stackSize = scan.nextInt();
		Stack stack = new Stack(stackSize);
		
		int cmd;
		
		while(true) 
		{
			System.out.print("[1]Push [2]Pop [3]Dump [4]Exit");
			cmd = scan.nextInt();
			if(cmd == 1) 
			{
				int rand = (int)(Math.random() * 100) +1;
				stack.push(rand);
			}else if(cmd == 2)
			{
				stack.pop();
			}else if(cmd == 3) 
			{
				stack.dump();
			}else if(cmd == 4) 
			{
				System.out.println("GoodBye");
				break;
			} else 
			{
				System.out.println("Unknown Command");
			}
		}
		scan.close();

	}

}
