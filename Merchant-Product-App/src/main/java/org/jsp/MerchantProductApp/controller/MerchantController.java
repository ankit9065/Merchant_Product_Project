package org.jsp.MerchantProductApp.controller;

import java.util.Scanner;
import org.jsp.MerchantProductApp.dao.MerchantDao;
import org.jsp.MerchantProductApp.dto.Merchant;

public class MerchantController {
    public static void main(String[] args) {
        MerchantDao merchantDao = new MerchantDao();
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Save Merchant");
        System.out.println("2. Update Merchant");
        System.out.println("3. Find Merchant By Id");
        System.out.println("4. Verify Merchant By Phone and Password");
        System.out.println("5. Verify Merchant By Email and Password");
        System.out.println("============Enter the Choice============");
        int choice = sc.nextInt();
        switch(choice) {
            case 1:{
                Merchant merchant = new Merchant();
                System.out.println("Enter the details of Merchants: ");
                System.out.print("Enter name: ");
                merchant.setName(sc.next());
                System.out.print("Enter phoneNo: ");
                merchant.setPhone(sc.nextLong());
                System.out.print("Enter email: ");
                merchant.setEmail(sc.next());
                System.out.print("Enter gst_No: ");
                merchant.setGst_no(sc.next());
                System.out.print("Enter password: ");
                merchant.setPassword(sc.next());
                merchant = merchantDao.saveMerchant(merchant);
                System.out.println("Merchant saved with id: " + merchant.getId());
                break;
            }
            
            case 2:{
                System.out.print("Enter the Merchant ID to update: ");
                int id = sc.nextInt();
                Merchant merchant = merchantDao.findMerchantById(id);
                
                    System.out.println("Enter the updated details of Merchant: ");
                    System.out.print("Enter name: ");
                    merchant.setName(sc.next());
                    System.out.print("Enter phoneNo: ");
                    merchant.setPhone(sc.nextLong());
                    System.out.print("Enter email: ");
                    merchant.setEmail(sc.next());
                    System.out.print("Enter gst_No: ");
                    merchant.setGst_no(sc.next());
                    System.out.print("Enter password: ");
                    merchant.setPassword(sc.next());
                    
                    merchant = merchantDao.updateMerchant(merchant);
                    if (merchant != null)
        				System.out.println("Merchant  with id:" + merchant.getId() + " updated");
        			else
        				System.err.println("Cannot Update Merchant as Id is Invalid");
                break;
            }
            
            case 3:{
                System.out.print("Enter the ID of the Merchant to find: ");
                int merchant_id = sc.nextInt();
                Merchant merchant = merchantDao.findMerchantById(merchant_id);
                if (merchant != null) {
                    System.out.println("Merchant found: "+merchant_id);
                    System.out.println(merchant);
                } 
                else {
                    System.err.println("Merchant " + merchant_id + " not founds");
                }
                break;
            }
            
            case 4:{
            	System.out.println("Enter phoneNo and password to find merchant: ");
                System.out.print("Enter phone number: ");
                long phone = sc.nextLong();
                System.out.print("Enter password: ");
                String password = sc.next();
                
                Merchant merchant = merchantDao.verifyMerchant(phone, password);
                if (merchant != null) {
                    System.out.println("Merchant details: " + merchant);
                    System.out.println("Merchant verified successfully!");
                } 
                else {
                    System.err.println("Invalid phoneNo and password");
                }
                break;
            }
            
            case 5:{
            	System.out.println("Enter email and password to find merchant: ");
                System.out.print("Enter email: ");
                String email = sc.next();
                System.out.print("Enter password: ");
                String password = sc.next();
                
                Merchant merchant = merchantDao.verifyMerchant(email, password);
                if (merchant != null) {
                    System.out.println("Merchant details: " + merchant);
                    System.out.println("Merchant verified successfully!");
                } 
                else {
                    System.err.println("Invalid email and password");
                }
                break;
            }
            default:
                System.err.println("Invalid choice!!!");
        }
        sc.close();
    }
}
