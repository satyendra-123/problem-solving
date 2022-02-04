import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution  implements Runnable {
	private int x=0; 
	private int y=0; 
	

	public static void main(String[] args) {
		//SpringApplication.run(EmpProbApplication.class, args);
		//testPlayerVillain();
		//testSubArray(new int[] {2,3,4,5,6,1,7});
		//interChangeVowel("Gulabjamun");
		//prepareCircularList();
		//head -> Node -> Node -> Node ->head
		//testPriorityQueue();
		//testStringCon();
		//long score = 16*100/120;
		//byte[] descose = Base64.getDecoder().decode("YXBpdXNlcg==");
		//System.out.println( new String(Base64.getDecoder().decode("YXBpdXNlcg==")));
		/*
		String test = "bustSbx,test,nok,rest";
		StringJoiner  joinere = new StringJoiner(",");
		String val = "roouet,test";
		
		System.out.println(joinere.add(test).add(val));*/
		
	/*	String server = "TLV";
		String appPrefix = "GULABJAMUN";
		
		List<String> filteredList = Stream.of("AUSTLVRBQXXX").filter(c->  c.contains(server.toUpperCase())).map(d-> d.toUpperCase().replace("XXX", appPrefix)).collect(Collectors.toList()) ;
		
		filteredList.forEach(c->{
			System.out.println("---- "+c); 
		});
		*/
		/*StringBuilder clusterMembers = new StringBuilder("");
		String vmInstanceNmae = "AUSDLVRBQTEST";
		DecimalFormat df = new DecimalFormat("00");
		int nodeSize = 2;
		Integer multiStart = 12;
		for(int i=0; i<nodeSize; i++) {			
			clusterMembers.append(vmInstanceNmae).append(df.format(multiStart));			
			if(i != nodeSize-1) {
				clusterMembers.append(",");
			}
			multiStart++;
		}
		System.out.println(clusterMembers.toString());*/
		
		//System.out.println(new String(Base64.getDecoder().decode("WkhNVEU1WktJUFFDTiMka1dFeEFZ")));
			
		/*Solution obj = new Solution();
		Thread t = new Thread(obj);
		t.start();
		t.start();
		(new Thread(obj)).start(); 
		(new Thread(obj)).start(); */
		
		
		/*System.out.print("1 ");
        synchronized(args)
        {
            System.out.print("2 ");
            try 
            {
                    args.wait();  Line 11 
            }	
            catch(InterruptedException e){ }
        }
        System.out.print("3 ");*/
		
	/*	Pattern p = Pattern.compile("\\D+");
        Matcher m = p.matcher("AUSDLVRBQJUNT2");
        while(m.find()) {
            System.out.println(m.find() + m.group());
        }
        DecimalFormat df = new DecimalFormat("00");
        System.out.println(df.format(m.group()));*/
        
/*        Scanner s = new Scanner( "AUSDLVRBQPCFQ3" );
        s.useDelimiter( "\\D+" );
        int st = s.nextInt();
        System.out.println(st);	
        DecimalFormat df = new DecimalFormat("00");
        System.out.println(df.format(st));*/
        
		/*  Boolean[] prim = new Boolean[26]; 
	        Arrays.fill(prim, new Boolean(true)); 
	        
	        System.out.println(prim['f' - 'a'] );*/
			
		//findCommonChars(new String[]{"geeksforgeeks", "facebook", "netflix"});
		/*int [] arr = new int[] {2,4,3,7,5,6,9};
		TreeNode tree = null;
		for(int i = 0; i<arr.length; i++) {		
			tree = addToBst(tree, arr[i]);
		}
		traverseInOrder(tree);
		System.out.println("\n \t Depth of BST "+maxLevelBst(tree));*/
		/*Employee e1 = new Employee("satyen", 1, "ramamruthy nagar");
		Employee e4 = new Employee("naren", 2, "marathailli");
		Employee e5 = new Employee("vish", 5, "whitefiled");
		Employee e2 = new Employee("amar", 4, "marathailli");
		Employee e3 = new Employee("shweta", 3, "indranagnar");		
		List<Employee> personList = Stream.of(e1,e2,e3,e4,e5).collect(Collectors.toList());
		boolean test = true;
		System.out.println(Arrays.toString(	personList.toArray()));
		
		Collections.sort(personList, (p1, p2) -> test ? p1.getName().compareTo(p2.getName()) :
						Integer.valueOf(p1.getId()).compareTo(p2.getId()));
		
		System.out.println(Arrays.toString(personList.toArray()));*/
		/*String str= "aabcccabb";
		String myString = str.substring(str.length()/2)+str.substring(0,str.length()/2); 
		recursiveCheck(myString);
		//System.out.println(myString);
		
		String userName = new String(Base64.getEncoder().encode("svc_prdrmqadprd01".getBytes())) ;
		String password = new String(Base64.getEncoder().encode("K:LpjCXUv*;24m93DHwbG8~=".getBytes()));
		
		System.out.println(userName + " :: "+password);
		System.out.println(new String(Base64.getDecoder().decode(userName))+" :: "+
						new String(Base64.getDecoder().decode(password)));
		
		System.out.println("DC=amer".substring("DC=amer".lastIndexOf("=")+1)+"\\"+"test");*/
		
		/*Solution emp = new Solution();
		testPassBy(emp);
		System.out.println(emp);*/
		
		/*Employee e1 = new Employee("satyen", 1, "ramamruthy nagar");
		Employee e4 = new Employee("naren", 2, "marathailli");
		Employee e5 = new Employee("vish", 5, "whitefiled");
		
		Employee e2 = new Employee("amar", 4, "marathailli");
		Employee e3 = new Employee("shweta", 3, "indranagnar");	
		
		Employee e6 = new Employee("nok", 6, "indranagnar");	
		Employee e7 = new Employee("seetee", 7, "indranagnar");	
		Employee e8 = new Employee("nampo", 8, "indranagnar");	
		
		
		//standard list - > satyen,amar,shweta,vish
		List<Employee> personList = Stream.of(e1,e2,e3,e5).collect(Collectors.toList());
		// amar,shweta,naren (satyen,vish removed) naren added 
		List<Employee> anotherPersonList = Stream.of(e2,e3,e4,e6,e7,e8).collect(Collectors.toList());
		
		Set<String> set = anotherPersonList.stream().map(c-> c.getName()).collect(Collectors.toSet());
		*/
		//Filter the employees which are no longer in new employee list
		
	/*	personList.forEach(c->{			
			if(anotherPersonList.stream().filter(anp->{
					return	anp.getName().equalsIgnoreCase(c.getName());
			}).findFirst().orElse(null) == null)
			{
				System.out.println(c.getName());
			}
		});*/
		
		/*personList.forEach(c->{	
				if(!set.contains(c.getName())) {
					System.out.println(c);
				}
		});*/
		
		/*String str= "aabcccabba";
		String myString = str.substring(str.length()/2)+str.substring(0,str.length()/2); 
		recursiveCheck(myString);
		System.out.println(myString);*/
		
		testGc();
		
	}
	
	private static <T> Predicate<T> not(Predicate<T> predicate) {
	    return predicate.negate();
	}
	
	static <T> void testPassBy(T emp) {
		try {
			Method emp1 = emp.getClass().getDeclaredMethod("recursiveCheck", String.class) ;
			
		} catch (NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	  static void recursiveCheck(String result){
	        if(null == checkIfConsecString(result)){
	           System.out.println(result);
	        }else{
	            //condition to eleminate the consecutive characters
	        	System.out.println(result);
	        	String[] strarr = checkIfConsecString(result).split(",");
	            result = result.substring(0,Integer.parseInt(strarr[0])-1)+result.substring(Integer.parseInt(strarr[1]));
	            recursiveCheck(result);
	        }
	    }
	    
	   static String checkIfConsecString(String str){
	        int centerIndex = str.length()/2;
	        int beginIndex = -1;
	        int lastIndex = 0;
	        
	        if(centerIndex != str.length()-2 && (str.charAt(centerIndex) == str.charAt(centerIndex+1))){
	                //checkright    
	                char i = str.charAt(centerIndex);
	                int count = centerIndex;
	                while(str.charAt(count) == i && count < str.length()-1){
	                    count++;
	                }
	                lastIndex = count;
	        }else if(str.charAt(centerIndex) == str.charAt(centerIndex-1)){
	            //check left
	        	char i = str.charAt(centerIndex);
                int count = centerIndex;
                while(str.charAt(count) == i && count > 0){
                    count--;
                }
                beginIndex = count;
	        }
	        
	        if(beginIndex == -1) {
	        	beginIndex = centerIndex;
	        }
	        if(lastIndex == 0) {
	        	lastIndex = centerIndex;
	        }
	        if(beginIndex != lastIndex ) {
	        	//System.out.println(beginIndex+","+lastIndex);
	            return beginIndex+","+lastIndex;
	        }
	        return null;
	    }
	
	private static void traverseInOrder(TreeNode node) {
	    if (node != null) {
	        traverseInOrder(node.left);
	        System.out.print(" - " + node.data);
	        traverseInOrder(node.right);
	    }
	}
	
	/*private static void printBst(TreeNode tree, int count) {
		int arr[] = new int[10];
		if(tree == null) {
				return;
		}else {
			if(tree.left != null) {
				for(int a=0; a <arr.length-count; a++) {					
					System.out.print(" ");
				}
				System.out.print(tree.data);
				for(int a=0; a <arr.length-count; a++ ) {					
					System.out.print(" ");
				}
				count++;
				printBst(tree.left, count);
			}
			if(tree.right != null) {
				printBst(tree.right, count);
			}
			if(tree.left == null && tree.right == null) {				
				
				System.out.print(tree.data);
			}
			printBst(tree.left,count);
			printBst(tree.right,count);
		}
	}*/
	
	//["google", "facebook", "netflix"]//doesnt work
	private static void findCommonChars(String[] orgs) {
	     Boolean[] prim = new Boolean[26]; 
	        Arrays.fill(prim, Boolean.TRUE);
			for(int i=0; i<orgs.length; i++) {
			     	Boolean[] sec = new Boolean[26]; 
			        Arrays.fill(sec, Boolean.FALSE);
				for(int j=0; j < orgs[i].length(); j++) {
					
					if(prim[orgs[i].charAt(j) - 'a']) 						
						sec[orgs[i].charAt(j) - 'a'] = true; 
														
					System.arraycopy(sec, 0, prim, 0, 26); 					
				}
			}
			
			 for (int i = 0; i < 26; i++) 		         
				 if (prim[i]){ 
		                System.out.print(Character.toChars(i  
		                                               + 97)); 
		                System.out.print(" "+prim[i]); 
		            }
			
			//System.out.println(Arrays.asList(prim).toString());
	}
	
	private static TreeNode addToBst(TreeNode n, int data) {
		if(n == null) {
				n = new TreeNode(data, null, null);
				return n;
		}else {
			if(n.data > data) {
				n.left = addToBst(n.left, data);
			}
			else if(n.data < data ){
				n.right = addToBst(n.right, data);
			}
			return n;			
		}
	}
	
	private static int maxLevelBst(TreeNode n) {
		if(n == null) {
			return 0;
		}
		return Math.max(maxLevelBst(n.left), maxLevelBst(n.right))+1;
	}
	
	/*private int testsum(float[] ar) {
		return Arrays.stream(ar).boxed().reduce(0, (a,b)-> a + b);
	}*/

	private static void testStringCon() {
		// TODO Auto-generated method stub
			String cont = null;
			
			if(true) {
					cont.concat("222");
			}
			System.out.println(cont);
				
	}

	static void testPriorityQueue(){
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.add(12);
		pq.add(2);
		pq.add(5);
		System.out.println(pq.element());
	}
	
	private static void prepareCircularList() {
		Node head = null;
		head = push(head, 1);
		
		head = push(head, 2);
		head = push(head, 3);
		head = push(head, 4);
		
		while(head.next != head) {
			//System.out.println(head.data);
		}
		
	}
	
	static Node push(Node node, int data){
		
		Node tempNode = node;
		Node fNode = new Node(data, node);		
		if(node != null) {			
			while(tempNode.next.data != node.data) {
				System.out.println(""+node.data+node.next.data);			
				
				tempNode = tempNode.next;
			}
			fNode.next = tempNode;
				
		}else {
			fNode.next = fNode;
		}	
		return fNode;
	}
		
	static class Node{
		int data;
		Node next;
		
		Node(int data, Node next){
			this.data = data;
			this.next = next;
		}
	}
	
	static class TreeNode{
		int data;
		TreeNode left;
		TreeNode right;
		
		TreeNode(int data, TreeNode right, TreeNode left){
			this.data = data;
			this.right = right;
			this.left = left;
			
		}
	}
	
	private static void interChangeVowel(String str) {
		 String [] strArr = str.split("");
		 
		 int tempIndex = -1;
		 //String tempChar = "";

		 for(int i=0; i<strArr.length; i++) {
			 
			 if(strArr[i].equalsIgnoreCase("a") || strArr[i].equalsIgnoreCase("e") || strArr[i].equalsIgnoreCase("i") || strArr[i].equalsIgnoreCase("o") || strArr[i].equalsIgnoreCase("u") ) {
				 if(tempIndex != -1) {
					 String tempChar = strArr[i];
					 strArr[i] = strArr[tempIndex];
					 strArr[tempIndex] = tempChar;
					 tempIndex = -1;
				 }else {
					 tempIndex = i;
				 }					
			 }
		 }
		 System.out.println("After <> "+Arrays.toString(strArr));
	}

	//find subarry [1,2,3,6,7,4]
	private static void testSubArray(int[] arr) {
		int count = 1;
		for(int i=0; i< arr.length; i++) {
			
				for(int j=i+1; j<arr.length; j++) {
					
					for(int k=i; k<j; k++) {
							System.out.print(arr[k]);
							if(k == j-1) {
								System.out.print(" -- size -- "+j);
							}
					}
					
					System.out.println();
					//t5555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555System.out.println("--------------"+count++);				
				}
		}
	}
	
	private static void testPlayerVillain(){
			Scanner sc = new Scanner(System.in);
			 int numOfTestCase = sc.nextInt();
			 
			 for(int i =0; i<numOfTestCase; i++) {
				 int sizeOfPlayerVillainArray = sc.nextInt();
				 
				 String villainStrengh = sc.nextLine();
				 String playerStrengh = sc.nextLine();
				 
				 String villainStrenght[] = villainStrengh.split("\\s+");
				 
				 String playerStrenght[] = playerStrengh.split("\\s+");
				 				 
				 
				 TreeSet<Integer> villainTree = new TreeSet<>();
				 TreeSet<Integer> playerTree = new TreeSet<>();
				 
				 for(int j=0; j< sizeOfPlayerVillainArray; j++) {
					
					 villainTree.add(Integer.parseInt(villainStrenght[j]));
					 playerTree.add(Integer.parseInt(playerStrenght[j]));
				 }
				 
				 if(villainTree.first() > playerTree.first()) {
					 System.out.println("LOSE");
				 }else {
					 System.out.println("WIN");
				 }
				 
			 }		
			 sc.close();
			 
	}

	//@Override
	public synchronized void run () /*Line 11*/
	{
		for (int i=0;i<10;i++) /*Line 13*/
		{
		  x++;
		  y++;
		 System.out.println("x ="  +x+";"  +y +"= +y");
		}
	}
	
	
	
	private int count = 0;
	static Solution gc;
	
	static class User {
		
		String name;
		
		User(String name){
			this.name = name;
		}
		
		@Override
		public int hashCode() {
			return 1;
		}
	}
	
	private static void testGc() {
		String s1 = "abc";
		String s2 = new String(s1);
		System.out.println(s2==s1);
		
		Map<User, Integer> m = new HashMap<>();
		m.put(new User("a"), 1);
		m.put(new User("b"), 2);
		m.put(new User("a"), 3);
		
		System.out.println(m.size());
		System.out.println(m.get(new User("a")));
		
		
		Map<String, Integer> map =new HashMap<>();
		

		Collections.unmodifiableMap(map);
		map.put("s", 1); //here map is not returned hence still allows the changes
		
		System.out.println(map);
		
		test t = new test() {
			
			int count = 25;

			@Override
			public int getValue() {
				// TODO Auto-generated method stub
				return count;
			}
			
			public int getData() {
				return count;
			}
			
		};
		
		System.out.println(t.getValue());
		
		 Solution s = new Solution();
		 s = null;
		 System.gc();
		 try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// gc = null;
			System.gc();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		//	System.out.println(count);
			
			
			
	}
	@Override
	public void finalize() {
		System.out.println("call");
			count++;
			
	}
}

interface test{
	int getValue();
}
