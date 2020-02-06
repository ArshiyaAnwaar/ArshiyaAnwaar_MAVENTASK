package com.arshiya;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    private static Scanner in;

	public static void main( String[] args )
    {

    	in = new Scanner(System.in);
    	LinkedList<sweet> sweets=new LinkedList<sweet>();
        sweets.add(new Candy("candie1",15,5));
        sweets.add(new Chocolate("chocolate1",35,40));
        sweets.add(new sweet("candie2",20,10) {   //showing polymorphism
        	@Override	protected String getType() {return "candy";}});
        sweets.add(new sweet("chocolate2",15,20) {   //showing polymorphism
        	@Override	protected String getType() {return "chocolate";}});
        sweets.add(new Candy("candie3",30,15));
        sweets.add(new Chocolate("chocolate3",45,60));
        Gift newyear=new Gift(sweets);
        Integer totweight=newyear.Weightssum();
        System.out.println("sum of weights is:"+totweight);
        newyear.sortChocolates("cost");  //sorting chocolates by weights
        System.out.println("sorting the chocolates in gift by cost");
        for (sweet s : newyear.sweets) {
        	if(s.getType()=="chocolate") {
			System.out.println(s.name);  //will give gift with choc in sorted by weight here,choc2<choc1<choc3
		}
      	}
        int lowlimit,highlimit;
        System.out.println("enter the lower limit/boundary for cost of gifts (available costs of candies here: 5,10,15)");
        lowlimit=in.nextInt();
        System.out.println("enter the high limit/boundary for cost of gifts (available costs of candies here: 5,10,15)");
        highlimit=in.nextInt();
        for (sweet s : newyear.sweets) {
        	if(s.getType()=="candy" && s.cost>lowlimit && s.cost<highlimit) {
			System.out.println(s.name);
        	}
        }
    }
}
