Problem Scenario 88 : You have been given below three Files 

product.csv (Create this File in hdfs) 

productID,productCode,name,quantity,price,supplierid 

1001,PEN,pen Red,5000,1.23,501 
1002,PEN,pen blue,8000,1.25,501
1003,PEN,pen Black,2000,1.25,501
1004,PEC,pencil 2B,10000,0.48,502
1005,PEC,pencil 2H,8000,0.49,502
1006,PEC,pencil 2B,10000,0.48,502
2001,PEC,pencil 3B,5000,0.52,501
2002,PEC,pencil 4B,200,0.62,501
2003,PEC,pencil 5B,100,0.73,501
2004,PEC,pencil 6B,500,0.47,502

supplier.csv 

supplierid,name,phone 

501,XYZ company,88882222 
503,QQ corp,88883333 

products_suppliers.csv 

productID,supplierID

2001,501 
2002, 501 
2003, 501 
2004, 502 
2001 ,503 

Now accomplish all the queries given in solution. 
1. It is possible that, same product can be supplied by multiple supplier. Now find each product, its price according to each supplier. 
2. Find all the supllier name, who are supplying 'Pencil 3B' 
3. Find all the products, which are supplied by ABC Traders. 

Solution : 

Step 1 : It is possible that, same product can be supplied by multiple supplier. Now find each product , its price according to each supplier. 
val results = sqlContext.sql("SELECT products.name AS 'Product Name', price, suppliers.name AS 'supplier Name' 
FROM products_suppliers 
JOIN products ON products_suppliers.productID = products.productID 
JOIN suppliers ON products_suppliers.supplierID = suppliers.supplierID ")
results. show() 

Step 2 : Find all the supllier name, who are supplying 'Pencil 3B' 
val results = sqlContext.sql( "SELECT p.name AS 'Product Name', s.name AS 'Supplier Name'
FROM products_suppliers AS ps 
JOIN products AS p ON ps.productID = p.productID 
JOIN suppliers AS s ON ps.supplierID = s.supplierID 
WHERE p.name = 'Pencil 3B' ") 
results.show() 

Step 3 : Find all the products , which are supplied by ABC Traders. 
val results = sqlContext.sql( "SELECT p.name AS 'Product Name', s.name AS 'Supplier Name' 
FROM products AS p, products_suppliers AS ps, suppliers AS s 
WHERE p.pr0ductlD = ps.productID 
AND ps.supplierID = s.supplierID 
AND s.name = 'ABC Traders' ") 

results.show() 
