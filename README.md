# vkart
Shopping Site
--------------------------------------
Description
-------------------------------------------------
A shopping site that lets you buy 1000s of product. All products are categorised to make your experience better.

Technology
------------------
This app is developed is java Spring framework(Spring MVC) using maven.
This app is dependent on another project "product".

Test Vkart
--------------
1. Install eclipse or spring tool suite.
2. Download this project in your system.
3. Import this project as maven project in eclipse/sts.
4. Import another project "product" in my same github account as maven project.
5. Run "product" project as spring boot app.
6. Run current project "vkart" on server.
7. you can go to http://localhost:8080/vkart/ and navigate yourself to check various functionalities.

Admin interface
-------------------------------------
1. http://localhost:8080/vkart/admin is url to add deals, products
2. admin username:vikash ,password:780606

Admin privileges script
----------------------------------------------------
1. you can change admin credentials in below file
 https://github.com/vikashnitp26/vkart/blob/master/src/main/webapp/WEB-INF/spring-security.xml

<authentication-manager>
		<authentication-provider>
		  <user-service>
			<user name="vikash" password="780606" authorities="ROLE_ADMIN" />
		  </user-service>
		</authentication-provider>
	</authentication-manager>
	
	
