package org.jsp.MerchantProductApp.controller;

import java.util.List;
import java.util.Scanner;
import org.jsp.MerchantProductApp.dao.ProductDao;
import org.jsp.MerchantProductApp.dto.Product;

public class ProductController {
    public static void main(String[] args) {
        ProductDao productDao = new ProductDao();
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Add Product");
        System.out.println("2. Update Product");
        System.out.println("3. Find Products by Merchant Id");
        System.out.println("4. Find Products by Brand");
        System.out.println("5. Find Products by Category");
        System.out.println("===========Enter the Choice==========");
        int choice = sc.nextInt();
        switch (choice) {
            case 1: {
                System.out.print("Enter Merchant Id to add Product: ");
                int merchant_id = sc.nextInt();
                Product product = new Product();
	                System.out.println("Enter the details of Product: ");
	                System.out.print("Enter Product name: ");
	                product.setName(sc.next());
	                System.out.print("Enter Brand name: ");
	                product.setBrand(sc.next());
	                System.out.print("Enter Category: ");
	                product.setCategory(sc.next());
	                System.out.print("Enter Product Description: ");
	                product.setDescription(sc.next());
	                System.out.print("Enter Img_url of Product: ");
	                product.setImage_url(sc.next());
	                System.out.print("Enter Cost of Product: ");
	                product.setCost(sc.nextDouble());
	                
                product = productDao.saveProduct(product, merchant_id);
                	if(product != null) {
                		System.out.println("Product added with Id:" + product.getId());
                	} 
                	else {
                		System.err.println("Cannot add product as Merchant Id is invalid");
                	}
                	break;
            }
            
            case 2: {
                System.out.println("Updates the details: ");
                Product product = new Product();
                
	                System.out.println("Enter Product Id to update: ");
	                product.setId(sc.nextInt());
	                System.out.print("Enter name: ");
	                product.setName(sc.next());
	                System.out.print("Enter Brand: ");
	                product.setBrand(sc.next());
	                System.out.print("Enter Category:");
	                product.setCategory(sc.next());
	                System.out.print("Enter Description: ");
	                product.setDescription(sc.next());
	                System.out.print("Enter Cost: ");
	                product.setCost(sc.nextDouble());
	                System.out.print("Enter Img-Url: ");
	                product.setImage_url(sc.next());
	                
                product = productDao.updateProduct(product);
	                if (product != null) {
	                    System.out.println("Product  with Id:" + product.getId() + " updated");
	                } 
	                else {
	                    System.err.println("Cannot update product as Id is Invalid");
	                }
	                break;
            }
            
            case 3: {
                System.out.println("Enter the Merchant Id to display products: ");
                int merchant_id = sc.nextInt();
                List<Product> products = productDao.findProductsByMerchantId(merchant_id);
	                if(products.isEmpty())
	                    System.err.println("Product merchantId " + merchant_id + " not found");
	                else {
	                    for(Product product : products)
	                        System.out.println(product);
	                }
	                break;
            }
            
            case 4: {
                System.out.print("Enter the brand to display products: ");
                String brand = sc.next();
                List<Product> products = productDao.findByBrand(brand);
	                if (products.isEmpty())
	                    System.err.println("No Products found for entered brand");
	                else {
	                    for (Product product : products)
	                        System.out.println(product);
	                }
	                break;
            }
            
            case 5: {
                System.out.print("Enter the Category to display products: ");
                String category = sc.next();
                List<Product> products = productDao.findByCategory(category);
	                if (products.isEmpty())
	                    System.err.println("No Products found for entered Category");
	                else {
	                    for (Product product : products)
	                        System.out.println(product);
	                }
	                break;
            }
            
            default: {
                System.out.println("Invalid choice");
            }
        }
        sc.close();
    }
}
