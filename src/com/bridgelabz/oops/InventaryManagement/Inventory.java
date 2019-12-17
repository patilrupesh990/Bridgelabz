package com.bridgelabz.oops.InventaryManagement;

import com.bridgelabz.util.Utility;

/**
 * @author Rupeshp007
 * date:6/12/2019
 * @version 1.0
 * Purpose:Contract for manage Inventory Program 
 * Operations:
 * 1.add inventory
 * 2.get price of value
 * 3.get total value of inventories 
 **********************************************************************************************************/

public interface Inventory 
{
    static Inventory inventary=new InventoryService();

    /**Unimplemented Contract Method For Inventory Management Service**/
    
	 public void displayInventory();
	 public void addInventory();
	 public void checkPrice();
	 
	 
	/** Main Menu For InventoryManagement Program We can use static method inside Interface JAVA 1.8 onwards 
	 * @return void
	 * @param no parameter
	 * 
	 * **/ 
	 public static void mainMenu()
		{
			int choice=0;
			while(true){
			System.out.println("1.Display File  2.Add Inventory 3.check price 4.Total values of Inventory 5 exit");
			try{
			choice=Utility.InputInt();
			}catch (NumberFormatException e) 
			{
				System.out.println("invalid input");
			}
			
			switch(choice)
			{
				case 1:
							inventary.displayInventory();
							break;
				case 2:
							inventary.addInventory();
							break;
				case 3:
							inventary.checkPrice();
							break;
				case 4:	
							System.out.println("1.Rice  2.Wheat 3.Pulses");
							int input=Utility.InputInt();
							InventoryManagerImplementation inventoryManager=new InventoryManagerImplementation();

							switch(input)
							{
								case 1:
									
										inventoryManager.totalValue("rice");
										break;
								case 2:
									
									inventoryManager.totalValue("wheat");
									break;
								case 3:
									
										inventoryManager.totalValue("pulses");
										break;
								default:
									
										System.out.println("Invalid Choice");
										mainMenu();		
							}
							break;
				case 5:
							System.exit(0);
				default :
							System.out.println("invalid choice");
			}
			}

		}

}
